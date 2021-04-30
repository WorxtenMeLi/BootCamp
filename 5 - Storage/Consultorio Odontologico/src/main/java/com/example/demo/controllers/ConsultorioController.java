package com.example.demo.controllers;

import com.example.demo.dtos.AgendaDTO;
import com.example.demo.dtos.DentistaDTO;
import com.example.demo.dtos.PacienteDTO;
import com.example.demo.dtos.TurnoDTO;
import com.example.demo.entities.Agenda;
import com.example.demo.entities.Student;
import com.example.demo.entities.Turno;
import com.example.demo.services.ConsultorioService;
import com.example.demo.services.ConsultorioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/consultorio")

public class ConsultorioController
{

    @Autowired
    ConsultorioServiceImpl consultorioService;

    @PostMapping("/save")
    private String saveTurno(@RequestBody Turno turno)
    {
        consultorioService.saveTurno(turno);
        return "Turno guardado con exito";
    }

    @GetMapping("/find/{id}")
    private Paciente getPaciente(@PathVariable Long id)
    {
        return consultorioService.getPaciente(id);
    }

    @GetMapping("/all")
    private List<Turno> getTurnos()
    {
        return consultorioService.getTurnos();
    }

    @DeleteMapping("/delete/{id}")
    private String deleteTurno(@PathVariable Long id)
    {
        consultorioService.deleteTurno(id);

        return "Turno eliminado";
    }

    @GetMapping("/pacientes/dia")
    public List<PacienteDTO> pacientesHoy(@RequestParam(name = "day", defaultValue = "") String day) {
        return consultorioService.getPacientesHoy(day);
    }

    @GetMapping("/dentistas/multiples")
    public List<DentistaDTO> dentitasMultiplesTurnos() {
        return consultorioService.getDentistasMultiplesTurnos();
    }

    @GetMapping("/turnos/finalizados")
    public List<TurnoDTO> turnosFinalizados() {
        return consultorioService.getTurnosEstado("Finalizado");
    }

    @GetMapping("/turnos/pendientes")
    public List<TurnoDTO> turnosPendientes(@RequestParam(name = "day", defaultValue = "") String day) {
        return consultorioService.getTurnosPendientes(day);
    }

    @GetMapping("/agendas/dentista")
    public AgendaDTO agendaDentista(@RequestBody DentistaDTO dentista) {
        return consultorioService.getAgendaDentista(dentista);
    }

    @GetMapping("/turnos/reprogramadosDentista")
    public List<TurnoDTO> turnosReprogramadosDentista(@RequestBody DentistaDTO dentista) {
        return consultorioService.getTurnosReprogramadosDentista(dentista);
    }

    @GetMapping("/turnos/reprogramados")
    public List<TurnoDTO> turnosReprogramados() {
        return consultorioService.getTurnosEstado("Reprogramado");
    }
}