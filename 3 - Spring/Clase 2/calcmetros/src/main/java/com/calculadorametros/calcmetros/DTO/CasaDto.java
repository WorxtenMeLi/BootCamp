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

    public float getArea(){
        area=0;
        for (HabitacionDto habitacion: habitaciones){
            area+=habitacion.getArea();
        }
        return area;
    }
    public float getValor(){
        getArea();
        valor=0;
        valor = area*800;
        return valor;
    }
    public HabitacionDto getCasaMasGrande(){
        float areaMayor=0;
        HabitacionDto habGrande=null;
        for (HabitacionDto habitacion: habitaciones){
            if(habitacion.getArea()>areaMayor){
                areaMayor=habitacion.getArea();
                habGrande=habitacion;
            }
        }
        return habGrande;
    }
}
