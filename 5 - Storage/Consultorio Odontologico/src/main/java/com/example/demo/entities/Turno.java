package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Turno
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate day;

    @ManyToOne
    @JoinColumn(name = "agenda_id", referencedColumnName = "id", nullable = false)
    private Agenda agenda;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id", nullable = false)
    private Paciente paciente;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "turnoEstado_id", referencedColumnName = "id", nullable = false)
    private TurnoEstado turnoEstado;
}
