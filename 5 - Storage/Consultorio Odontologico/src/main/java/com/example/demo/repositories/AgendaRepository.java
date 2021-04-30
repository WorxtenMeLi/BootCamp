package com.example.demo.repositories;

import com.example.demo.entities.Agenda;
import com.example.demo.entities.Dentista;
import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long>{
    Agenda findByDentista(Dentista dentista);
}