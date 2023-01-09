package com.sistemaescolar.sistemaescolar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.sistemaescolar.model.entity.Alumno;
import com.sistemaescolar.sistemaescolar.model.entity.Calificacion;
import com.sistemaescolar.sistemaescolar.model.entity.Materia;

@Repository
public interface CalificacionRepository extends CrudRepository<Calificacion, Long> {

    List<Calificacion> findAllByAlumno(Alumno alumno);

    List<Calificacion> findAllByAlumnoAndMateria(Alumno alumno, Materia materia);

}