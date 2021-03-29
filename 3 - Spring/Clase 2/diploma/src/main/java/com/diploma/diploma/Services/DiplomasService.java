package com.diploma.diploma.Services;

import com.diploma.diploma.Dto.Alumno;
import com.diploma.diploma.Dto.Diploma;
import com.diploma.diploma.Dto.Materia;

import java.util.ArrayList;
import java.util.List;

public class DiplomasService {
    public static Diploma diplomaPredeterminado(){
        List<Materia> materias = new ArrayList<>();
        materias.add(new Materia("Calculo Diferencial",7));
        materias.add(new Materia("Programacion Avanzad",10));
        materias.add(new Materia("Fisica I",8));
        Alumno alumno = new Alumno("Sebastian Pulido", materias);
        Diploma diploma = new Diploma("Se certifica que el alumno "+alumno.getNombre()+" completo la carrera de Ingenieria de Sistemas",alumno);
        return diploma;
    }
    public static Diploma getDiploma(Alumno alumno){
        return new Diploma("Se certifica que el alumno "+alumno.getNombre()+" completo lo propuesto",alumno);
    }
}
