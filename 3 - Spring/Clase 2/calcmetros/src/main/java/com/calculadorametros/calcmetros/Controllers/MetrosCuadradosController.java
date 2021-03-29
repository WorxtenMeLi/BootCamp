package com.calculadorametros.calcmetros.Controllers;

import com.calculadorametros.calcmetros.DTO.CasaDto;
import com.calculadorametros.calcmetros.Services.CreadorCasasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MetrosCuadradosController {
    @PostMapping("/casa")
    public ResponseEntity getCasa(@RequestBody CasaDto casa){
        return new ResponseEntity(CreadorCasasService.getCasa(casa), HttpStatus.OK);
    }
    @PostMapping("/habGrande")
    public ResponseEntity getHabGrande(@RequestBody CasaDto casa){
        return new ResponseEntity(casa.getCasaMasGrande(), HttpStatus.OK);
    }
    @PostMapping("/valor")
    public ResponseEntity getValor(@RequestBody CasaDto casa){
        return new ResponseEntity(casa.getValor(), HttpStatus.OK);
    }
    @PostMapping("/area")
    public ResponseEntity getArea(@RequestBody CasaDto casa){
        return new ResponseEntity(casa.getArea(), HttpStatus.OK);
    }
    @GetMapping("/casa")
    public CasaDto casa(){
       return CreadorCasasService.getCasaGenerica();
   }
}
