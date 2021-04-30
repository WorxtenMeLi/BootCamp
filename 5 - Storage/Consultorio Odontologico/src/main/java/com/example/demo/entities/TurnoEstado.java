package com.example.demo.entities;

import javax.persistence.*;

@Entity
public class TurnoEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String estado;

    @OneToOne(mappedBy = "turnoEstado")
    private Turno turno;
}
