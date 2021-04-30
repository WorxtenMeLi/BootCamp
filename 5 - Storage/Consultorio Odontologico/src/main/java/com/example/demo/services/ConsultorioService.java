package com.example.demo.services;

import com.example.demo.dtos.AgendaDTO;
import com.example.demo.dtos.DentistaDTO;
import com.example.demo.dtos.PacienteDTO;
import com.example.demo.dtos.TurnoDTO;
import com.example.demo.entities.*;

import java.util.List;

public interface ConsultorioService
{
    void saveTurno(Turno turno);

    Paciente getPaciente(Long id);

    List<Turno> getTurnos();

    void deleteTurno(Long id);

    List<PacienteDTO> getPacientesHoy(String day);

    List<DentistaDTO> getDentistasMultiplesTurnos();

    List<TurnoDTO> getTurnosEstado(String estado);

    List<TurnoDTO> getTurnosPendientes(String day);

    AgendaDTO getAgendaDentista(DentistaDTO dentistaDTO);

    List<TurnoDTO> getTurnosReprogramadosDentista(DentistaDTO dentistaDTO);
}
