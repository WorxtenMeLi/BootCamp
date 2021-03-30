package com.calorias.calorias.dto;

import lombok.Data;

@Data
public class PlatoResponseDTO extends PlatoDTO{
    private float caloriasTotales;
    private IngredienteDTO ingredienteMayor;

    public PlatoResponseDTO() {
    }
    public PlatoResponseDTO(PlatoDTO plato){
        setNombre(plato.getNombre());
        setIngredientes(plato.getIngredientes());
    }
}
