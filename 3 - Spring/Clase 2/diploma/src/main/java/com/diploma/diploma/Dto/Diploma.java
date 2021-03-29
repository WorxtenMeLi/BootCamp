package com.diploma.diploma.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Diploma {
    private String mensaje;
    private Alumno alumno;

    public Diploma(String mensaje, Alumno alumno) {
        this.mensaje = mensaje;
        this.alumno = alumno;
        if(alumno.getPromedio()>9) {
            this.mensaje+="\n El alumno obtubo un promedio meritorio. Felicitaciones!!";
        }

    }
}
