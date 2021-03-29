package com.calculadorametros.calcmetros.Services;

import com.calculadorametros.calcmetros.DTO.CasaDto;
import com.calculadorametros.calcmetros.DTO.HabitacionDto;

import java.util.ArrayList;
import java.util.List;

public class CreadorCasasService{
    public static CasaDto getCasa(CasaDto casa){
        casa.getArea();
        casa.getValor();
        return casa;
    }
    public static CasaDto getCasaGenerica(){
        List<HabitacionDto> habitaciones = new ArrayList<>();
        habitaciones.add(new HabitacionDto("Habitacion Principal",5,4));
        habitaciones.add(new HabitacionDto("Estudio",3,3));
        habitaciones.add(new HabitacionDto("Habitacion Huesped",3,4));
        CasaDto casa = new CasaDto("CasaMia","Cra81 F #15A -24",habitaciones);
        return casa;
    }
}
