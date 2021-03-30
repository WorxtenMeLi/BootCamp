package com.starwars.demo.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.demo.dto.CharacterDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class CharacterRepositoryImpl implements CharacterRepository{

    @Override
    public List<CharacterDTO> findAllCharacters(String name) {
        List<CharacterDTO> characters = loadDataBase();
        if(characters == null)
            return null;
        List<CharacterDTO>  result = characters.stream()
                .filter(CharacterDTO -> CharacterDTO.getName().contains(name)).collect(Collectors.toList());

        return result;
    }

    private List<CharacterDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        }catch (Exception e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<List<CharacterDTO>>() {};
        List<CharacterDTO> priceDTOS = null;

        try {
            priceDTOS = objectMapper.readValue(file, typeRef);

        }catch (Exception e){
            e.printStackTrace();
        }

        return priceDTOS;

    }
}
