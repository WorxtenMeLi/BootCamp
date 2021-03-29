package com.calcedades.calcedades.Services;

import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
public class EdadService {
    public static int getEdad(int day,int month, int year){
        Period periodo = Period.between(LocalDate.of(year,month,day),LocalDate.now());
        return periodo.getYears();
    }
}
