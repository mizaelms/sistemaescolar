package com.sistemaescolar.sistemaescolar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.sistemaescolar.model.entity.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

    List<Alumno> findAllByActivoOrderByNombreAsc(boolean activo);

}
