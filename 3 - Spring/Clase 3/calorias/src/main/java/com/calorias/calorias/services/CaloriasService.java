package com.calorias.calorias.services;

import com.calorias.calorias.dto.IngredienteDTO;
import com.calorias.calorias.dto.PlatoDTO;
import com.calorias.calorias.dto.PlatoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.calorias.calorias.repositories.IngredientesRepositoryImpl;

@Service
public class CaloriasService {
    @Autowired
    private IngredientesRepositoryImpl repositorio;
    public PlatoResponseDTO calcular(PlatoDTO plato){
        PlatoResponseDTO response = new PlatoResponseDTO(plato);
        calcularCaloriasXIngrediente(response);
        calcularCaloriasTotales(response);
        calcularIngredienteMayor(response);
        return response;
    }
    private void calcularCaloriasTotales(PlatoResponseDTO platoResponse){
        int sumaIngredientes=0;
        int caloriaXGramo=0;
        for (IngredienteDTO ingrediente:platoResponse.getIngredientes()) {
            sumaIngredientes+=ingrediente.getCaloriasTotales();
        }
        platoResponse.setCaloriasTotales(sumaIngredientes);
    }
    private void calcularCaloriasXIngrediente(PlatoResponseDTO platoResponse){
        int caloriaXGramo=0;
        for (IngredienteDTO ingrediente:platoResponse.getIngredientes()) {
            ingrediente.setCaloriaXGramo(repositorio.findCaloriesByIngredient(ingrediente.getNombre()));
        }
    }
    private void calcularIngredienteMayor(PlatoResponseDTO platoResponse){
        float mayorCalorias=0;
        IngredienteDTO ingredienteMayor=null;
        for (IngredienteDTO ingrediente: platoResponse.getIngredientes()) {
            if(ingrediente.getCaloriasTotales()>mayorCalorias) {
                mayorCalorias=ingrediente.getCaloriasTotales();
                ingredienteMayor=ingrediente;
            }
        }
        platoResponse.setIngredienteMayor(ingredienteMayor);
    }
}
