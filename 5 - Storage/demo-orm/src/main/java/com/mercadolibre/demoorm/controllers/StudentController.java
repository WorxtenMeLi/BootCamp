package com.mercadolibre.demoorm.controllers;

import com.mercadolibre.demoorm.dtos.StudentDTO;
import com.mercadolibre.demoorm.entities.Student;
import com.mercadolibre.demoorm.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    private String saveStudent(@RequestBody StudentDTO student){
        studentService.saveStudent(student);
        return "Guardado con exito";
    }

    @GetMapping("/get")
    private ResponseEntity getStudents(){
        return new ResponseEntity(studentService.getStudents(), HttpStatus.OK);
    }
}
