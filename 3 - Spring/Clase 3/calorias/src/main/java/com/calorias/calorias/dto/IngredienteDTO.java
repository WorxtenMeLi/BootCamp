package com.calorias.calorias.dto;

import lombok.Data;

@Data
public class IngredienteDTO {
    private String nombre;
    private float peso;
    private int caloriaXGramo;
    public IngredienteDTO() {
    }
    public IngredienteDTO(String nombre, float peso){
        this.nombre=nombre;
        this.peso=peso;
    }
    public IngredienteDTO(String nombre, int caloriaXGramo){
        this.nombre=nombre;
        this.caloriaXGramo=caloriaXGramo;
    }
    public float getCaloriasTotales(){
        return this.caloriaXGramo*peso;
    }
}
