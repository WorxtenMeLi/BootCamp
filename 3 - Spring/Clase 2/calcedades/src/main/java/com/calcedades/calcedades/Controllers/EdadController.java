package com.calcedades.calcedades.Controllers;

import com.calcedades.calcedades.Services.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {
    @GetMapping("/{day}/{month}/{year}")
    public int getEdad(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){
        return EdadService.getEdad(day,month,year);
    }
}
