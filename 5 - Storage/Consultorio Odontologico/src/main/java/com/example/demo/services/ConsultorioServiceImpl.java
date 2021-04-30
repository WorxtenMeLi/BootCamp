package com.example.demo.services;

import com.example.demo.dtos.AgendaDTO;
import com.example.demo.dtos.DentistaDTO;
import com.example.demo.dtos.PacienteDTO;
import com.example.demo.dtos.TurnoDTO;
import com.example.demo.entities.*;
import com.example.demo.repositories.AgendaRepository;
import com.example.demo.repositories.DentistaRepository;
import com.example.demo.repositories.PacienteRepository;
import com.example.demo.repositories.TurnoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.stream.Collectors;

@Service
public class ConsultorioServiceImpl implements ConsultorioService
{
    public static String DATE_FORMAT = "dd/MM/yyyy";

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    DentistaRepository dentistaRepository;

    @Autowired
    AgendaRepository agendaRepository;

    @Autowired
    ModelMapper mapper;

    public void saveTurno(Turno turno)
    {
        turnoRepository.save(turno);
    }

    public Paciente getPaciente(Long id)
    {
        return pacienteRepository.findById(id).orElse(null);
    }

    public List<Turno> getTurnos()
    {
        return turnoRepository.findAll();
    }

    public void deleteTurno(Long id)
    {
        turnoRepository.deleteById(id);
    }

    @Override
    public List<PacienteDTO> getPacientesHoy(String day)
    {
        if (day.isEmpty()) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            day = dtf.format(now).toString();
        }

        LocalDate daySelected = getDateFromString(day);

        if (daySelected == null)
            return null;

        List<Turno> turnos = turnoRepository.findByDayBetween(daySelected, daySelected.plusDays(1));

        List<Paciente> pacientesHoy = new ArrayList<>();

        turnos.forEach(turno -> pacientesHoy.add(turno.getPaciente()));

        return pacientesHoy.stream().map(paciente -> mapper.map(paciente, PacienteDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<DentistaDTO> getDentistasMultiplesTurnos()
    {
        List<Dentista> dentistas = dentistaRepository.findDentistaMultipleTurns();

        return dentistas.stream().map(dentista -> mapper.map(dentista, DentistaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<TurnoDTO> getTurnosEstado(String estado)
    {
        List<Turno> turnos = turnoRepository.findByTurnoEstado(estado);

        return turnos.stream().map(turno -> mapper.map(turno, TurnoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<TurnoDTO> getTurnosPendientes(String day)
    {
        if (day.isEmpty()) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            day = dtf.format(now).toString();
        }

        LocalDate daySelected = getDateFromString(day);

        List<Turno> turnos = turnoRepository.findPendientes(daySelected);

        return turnos.stream().map(turno -> mapper.map(turno, TurnoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public AgendaDTO getAgendaDentista(DentistaDTO dentistaDTO)
    {
        Dentista dentista = dentistaRepository.findByNameAndLastName(dentistaDTO.getName(), dentistaDTO.getLastName());

        Agenda agenda = agendaRepository.findByDentista(dentista);

        return mapper.map(agenda, AgendaDTO.class);
    }

    @Override
    public List<TurnoDTO> getTurnosReprogramadosDentista(DentistaDTO dentistaDTO)
    {
        Dentista dentista = dentistaRepository.findByNameAndLastName(dentistaDTO.getName(), dentistaDTO.getLastName());

        List<Turno> turnos = turnoRepository.findTurnosReprogramadosByDentista(dentista.getId());

        return turnos.stream().map(turno -> mapper.map(turno, TurnoDTO.class)).collect(Collectors.toList());
    }

    private LocalDate getDateFromString(String date)
    {
        DateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);
        try
        {
            return LocalDate.ofEpochDay(sdf.parse(date).toInstant().getEpochSecond() / 86400);
        } catch (ParseException e)
        {
            return null;
        }
    }
}
