package com.calorias.calorias.controllers;

import com.calorias.calorias.dto.ErrorDTO;
import com.calorias.calorias.dto.PlatoDTO;
import com.calorias.calorias.dto.PlatoResponseDTO;
import com.calorias.calorias.exceptions.IngredienteNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.calorias.calorias.services.CaloriasService;

@RestController
public class CaloriasController {
    @Autowired
    private CaloriasService caloriasService;

    @PostMapping("/plato")
    public ResponseEntity<PlatoResponseDTO> calcular(@RequestBody PlatoDTO plato) throws IngredienteNotFound {
        return new ResponseEntity<>(caloriasService.calcular(plato),HttpStatus.OK);
    }
    @GetMapping("/plato")
    public String calcular(){
        return "Hola";
    }

    @ExceptionHandler(IngredienteNotFound.class)
    public ResponseEntity<ErrorDTO> handledException(IngredienteNotFound errorException){
        ErrorDTO errorDTO= new ErrorDTO();
        errorDTO.setNombre("Ingrediente invalido.");
        errorDTO.setMensaje("El ingrediente " + errorException.getMessage()+" es invalido.");
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
