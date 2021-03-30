package com.starwars.demo.controllers;

import com.starwars.demo.dto.CharacterDTO;
import com.starwars.demo.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/getCharacters/{name}")
    public List<CharacterDTO> findAllCharacterByName(@PathVariable String name){
        return characterService.findAll(name);

    }
}
