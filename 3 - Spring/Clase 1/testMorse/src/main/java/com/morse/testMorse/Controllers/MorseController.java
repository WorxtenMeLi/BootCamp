package com.morse.testMorse.Controllers;

import com.morse.testMorse.Entities.Morse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convertir")
public class MorseController {
    @RequestMapping("/morse/{frase}")
    public Morse convertirDecimal(@PathVariable String frase){
        return new Morse(frase);
    }
}
