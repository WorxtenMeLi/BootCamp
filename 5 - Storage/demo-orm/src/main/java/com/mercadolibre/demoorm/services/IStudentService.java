package com.mercadolibre.demoorm.services;

import com.mercadolibre.demoorm.dtos.StudentDTO;
import com.mercadolibre.demoorm.entities.Student;

import java.util.List;

public interface IStudentService {
    void saveStudent(StudentDTO student);
    void deleteStudent(Integer id);
    StudentDTO findStudent(Integer id);
    List<StudentDTO> getStudents();
    //void updateStudent(Student student);
}
