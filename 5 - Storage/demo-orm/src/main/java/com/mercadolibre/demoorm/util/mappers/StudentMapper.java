package com.mercadolibre.demoorm.util.mappers;

import com.mercadolibre.demoorm.dtos.StudentDTO;
import com.mercadolibre.demoorm.entities.Student;

public class StudentMapper {
    public static StudentDTO convertToDTO (Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setDni(student.getDni());
        studentDTO.setName(student.getName());
        studentDTO.setLastName(student.getLastName());
        return studentDTO;
    }
    public static Student convertToEntity (StudentDTO studentDTO){
        Student student =  new Student();
        student.setId(studentDTO.getId());
        student.setDni(studentDTO.getDni());
        student.setName(studentDTO.getName());
        student.setLastName(studentDTO.getLastName());
        return student;
    }
}
