package com.calculadorametros.calcmetros.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HabitacionDto {
    private String nombre;
    private float ancho;
    private float largo;

    public float getArea(){
        return ancho*largo;
    }
}
