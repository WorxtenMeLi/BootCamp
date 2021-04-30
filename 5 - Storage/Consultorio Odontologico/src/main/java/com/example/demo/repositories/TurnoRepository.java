package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TurnoRepository extends JpaRepository<Turno, Long>
{
    List<Turno> findByDayBetween(LocalDate start, LocalDate end);

    @Query("select t from Turno t " +
            "join TurnoEstado te on t.turnoEstado.id = te.id " +
            "where te.estado = :turnoEstado")
    List<Turno> findByTurnoEstado(@Param("turnoEstado") String turnoEstado);

    @Query("select t from Turno t " +
            "join TurnoEstado te on t.turnoEstado.id = te.id " +
            "where te.estado = 'Pendiente' and t.day = :day")
    List<Turno> findPendientes(@Param("day") LocalDate day);

    @Query("select t from Turno t " +
            "join TurnoEstado te on t.turnoEstado.id = te.id " +
            "join Agenda a on t.agenda.id = a.id " +
            "join Dentista d on a.id = d.agenda.id " +
            "where te.estado = 'Reprogramado' and d.id = :idDentista")
    List<Turno> findTurnosReprogramadosByDentista(@Param("idDentista") Long idDentista);
}
