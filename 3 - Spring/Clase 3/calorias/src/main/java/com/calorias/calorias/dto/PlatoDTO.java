package com.calorias.calorias.dto;

import lombok.Data;

import java.util.List;
@Data
public class PlatoDTO {
    private String nombre;
    private List<IngredienteDTO> ingredientes;
    public PlatoDTO() {
    }
}
