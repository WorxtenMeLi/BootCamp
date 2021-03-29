package com.diploma.diploma.Controllers;

import com.diploma.diploma.Dto.Alumno;
import com.diploma.diploma.Dto.Diploma;
import com.diploma.diploma.Services.DiplomasService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiplomaController {
    @GetMapping("/diploma")
    public ResponseEntity getDiplomaPredeterminado(){
        return new ResponseEntity(DiplomasService.diplomaPredeterminado(),HttpStatus.OK);
    }
    @PostMapping("/diploma")
    public ResponseEntity getDiploma(@RequestBody Alumno alumno){
        return new ResponseEntity(DiplomasService.getDiploma(alumno), HttpStatus.OK);
    }
}
