package com.diploma.diploma.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Alumno {
    private String nombre;
    private List<Materia> materias;
    private float promedio;

    public Alumno(String nombre, List<Materia> materias) {
        this.nombre = nombre;
        this.materias = materias;
    }

    public float getPromedio(){
        float suma=0;
        for (Materia materia: materias) {
            suma+=materia.getNota();
        }
        promedio=suma/materias.size();
        return promedio;
    }
}
