package com.starwars.demo.services;

import com.starwars.demo.dto.CharacterDTO;
import com.starwars.demo.repositories.CharacterRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CharacterService {
    @Autowired
    private CharacterRepositoryImpl characterRepository;

    public List<CharacterDTO> findAll(String name){
        return characterRepository.findAllCharacters(name);
    }
}
