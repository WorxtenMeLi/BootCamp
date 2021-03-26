package com.numeroRomano.testRomano.Controllers;

import com.numeroRomano.testRomano.Entities.Numero;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convertir")
public class ConversorController {
    @RequestMapping("/decimal/{numero}")
    public Numero convertirDecimal(@PathVariable int numero){
        return new Numero(numero);
    }
}
