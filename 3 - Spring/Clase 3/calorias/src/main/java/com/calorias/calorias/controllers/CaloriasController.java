package com.calorias.calorias.controllers;

import com.calorias.calorias.dto.PlatoDTO;
import com.calorias.calorias.dto.PlatoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.calorias.calorias.services.CaloriasService;

@RestController
public class CaloriasController {
    @Autowired
    private CaloriasService caloriasService;

    @PostMapping("/plato")
    public PlatoResponseDTO calcular(@RequestBody PlatoDTO plato){
        return caloriasService.calcular(plato);
    }
    @GetMapping("/plato")
    public String calcular(){
        return "Hola";
    }
}
