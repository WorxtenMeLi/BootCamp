package com.calorias.calorias.repositories;

public interface IngredienteRepository {
    int findCaloriesByIngredient(String ingredient);
}
