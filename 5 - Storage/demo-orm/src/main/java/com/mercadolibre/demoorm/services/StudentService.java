package com.mercadolibre.demoorm.services;

import com.mercadolibre.demoorm.dtos.StudentDTO;
import com.mercadolibre.demoorm.entities.Student;
import com.mercadolibre.demoorm.repository.IStudentRepository;
import com.mercadolibre.demoorm.util.mappers.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService implements IStudentService{

    private IStudentRepository studentRepository;

    public  StudentService(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public void saveStudent(StudentDTO student) {
        studentRepository.save(StudentMapper.convertToEntity(student));
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDTO findStudent(Integer id) {
        return StudentMapper.convertToDTO(studentRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> getStudents() {
        List<StudentDTO> studentsDTO = new ArrayList<>();
        for (Student student: studentRepository.findAll()) {
            studentsDTO.add(StudentMapper.convertToDTO(student));
        }
        return studentsDTO;
    }
}
