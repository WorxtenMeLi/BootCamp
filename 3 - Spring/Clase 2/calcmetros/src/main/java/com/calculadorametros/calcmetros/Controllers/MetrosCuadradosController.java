package com.calculadorametros.calcmetros.Controllers;

import com.calculadorametros.calcmetros.DTO.CasaDto;
import com.calculadorametros.calcmetros.Services.CreadorCasasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MetrosCuadradosController {
    @Autowired
    private CreadorCasasService casaServicio;

    @PostMapping("/casa")
    public ResponseEntity getCasa(@RequestBody CasaDto casa){
        return new ResponseEntity(casaServicio.calcularAreaValor(casa), HttpStatus.OK);
    }

    @GetMapping("/casa")
    public CasaDto casa(){
        return casaServicio.getCasaGenerica();
    }

    @PostMapping("/habGrande")
    public ResponseEntity getHabGrande(@RequestBody CasaDto casa){
        return new ResponseEntity(casaServicio.getCasaMasGrande(casa), HttpStatus.OK);
    }
    @PostMapping("/valor")
    public ResponseEntity getValor(@RequestBody CasaDto casa){
        return new ResponseEntity(casa.getValor(), HttpStatus.OK);
    }
    @PostMapping("/area")
    public ResponseEntity getArea(@RequestBody CasaDto casa){
        return new ResponseEntity(casa.getArea(), HttpStatus.OK);
    }

}
