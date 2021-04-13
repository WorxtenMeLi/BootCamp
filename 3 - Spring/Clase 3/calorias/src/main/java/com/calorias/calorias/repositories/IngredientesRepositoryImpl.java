package com.calorias.calorias.repositories;
import com.calorias.calorias.exceptions.IngredienteNotFound;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.core.type.*;
import com.calorias.calorias.dto.IngredienteDTO;
import java.io.File;
import java.util.List;
import java.util.Optional;
@Repository
public class IngredientesRepositoryImpl implements IngredienteRepository{
    @Override
    public int findCaloriesByIngredient(String ingredient) throws IngredienteNotFound {
        List<IngredienteDTO> ingredientes = loadDataBase();
        if(ingredientes==null)
            return 0;
        IngredienteDTO result = null;

            Optional<IngredienteDTO> item = ingredientes.stream()
                    .filter(IngredienteDTO -> IngredienteDTO.getNombre().equals(ingredient))
                    .findFirst();
            if (item.isPresent())
                result = item.get();
            else
                throw new IngredienteNotFound(ingredient);
        return result.getCaloriaXGramo();
    }
    private List<IngredienteDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        }catch (Exception e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteDTO>> typeRef = new TypeReference<List<IngredienteDTO>>() {};
        List<IngredienteDTO> priceDTOS = null;

        try {
            priceDTOS = objectMapper.readValue(file, typeRef);

        }catch (Exception e){
            e.printStackTrace();
        }
        return priceDTOS;
    }
}
