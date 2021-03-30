package com.calculadorametros.calcmetros.DTO;

import lombok.Data;

import java.util.List;
@Data
public class CasaDto {
    private String nombre;
    private String direccion;
    private List<HabitacionDto> habitaciones;
    private float valor;
    private float area;

    public CasaDto(String nombre, String direccion, List<HabitacionDto> habitaciones) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.habitaciones = habitaciones;
    }
}
