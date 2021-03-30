package com.starwars.demo.repositories;

import com.starwars.demo.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {
    List<CharacterDTO> findAllCharacters(String name);
}
