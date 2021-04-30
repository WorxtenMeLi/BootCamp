package com.example.demo.repositories;

import java.util.List;

import com.example.demo.entities.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DentistaRepository extends JpaRepository<Dentista, Long>
{
    Dentista findByNameAndLastName(String name, String lastName);

    @Query("select d from Dentista d " +
            "join Agenda a on d.agenda.id = a.id " +
            "join Turno t on a.id = t.agenda.id " +
            "group by d.id, t.day " +
            "having count(d) > 2")
    List<Dentista> findDentistaMultipleTurns();
}
