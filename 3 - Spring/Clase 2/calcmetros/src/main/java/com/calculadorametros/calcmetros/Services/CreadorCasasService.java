package com.calculadorametros.calcmetros.Services;

import com.calculadorametros.calcmetros.DTO.CasaDto;
import com.calculadorametros.calcmetros.DTO.HabitacionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CreadorCasasService{
    public CasaDto calcularAreaValor(CasaDto casa){
        setArea(casa);
        setValor(casa);
        return casa;
    }
    public CasaDto getCasaGenerica(){
        List<HabitacionDto> habitaciones = new ArrayList<>();
        habitaciones.add(new HabitacionDto("Habitacion Principal",5,4));
        habitaciones.add(new HabitacionDto("Estudio",3,3));
        habitaciones.add(new HabitacionDto("Habitacion Huesped",3,4));
        CasaDto casa = new CasaDto("CasaMia","Cra81 F #15A -24",habitaciones);
        return casa;
    }
    private void setArea(CasaDto casa){
        float area=0;
        for (HabitacionDto habitacion: casa.getHabitaciones()){
            area+=habitacion.getArea();
        }
        casa.setArea(area);
    }
    private void setValor(CasaDto casa){
        setArea(casa);
        float valor=0;
        valor = casa.getArea()*800;
        casa.setValor(valor);
    }
    public HabitacionDto getCasaMasGrande(CasaDto casa){
        float areaMayor=0;
        HabitacionDto habGrande=null;
        for (HabitacionDto habitacion: casa.getHabitaciones()){
            if(habitacion.getArea()>areaMayor){
                areaMayor=habitacion.getArea();
                habGrande=habitacion;
            }
        }
        return habGrande;
    }
}
