package com.calorias.calorias.repositories;

import com.calorias.calorias.exceptions.IngredienteNotFound;

public interface IngredienteRepository {
    int findCaloriesByIngredient(String ingredient) throws IngredienteNotFound;
}
