package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate startTime;
    private LocalDate endTime;

    @OneToOne(mappedBy = "agenda")
    private Dentista dentista;

    @OneToMany(mappedBy = "agenda")
    private Set<Turno> turnos;

}
