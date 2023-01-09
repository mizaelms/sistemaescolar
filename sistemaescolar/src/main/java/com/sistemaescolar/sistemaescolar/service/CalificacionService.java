package com.sistemaescolar.sistemaescolar.service;

import java.util.List;

import com.sistemaescolar.sistemaescolar.model.entity.Alumno;
import com.sistemaescolar.sistemaescolar.model.entity.Calificacion;
import com.sistemaescolar.sistemaescolar.model.entity.Materia;
import com.sistemaescolar.sistemaescolar.model.request.registrarCalificacionRequest;
import com.sistemaescolar.sistemaescolar.model.response.CalificacionAlumnoResponse;
import com.sistemaescolar.sistemaescolar.model.response.CalificacionResponse;

public interface CalificacionService {

    CalificacionResponse registrarCalificacion(Calificacion calificacion);

    CalificacionResponse registrarCalificacion(registrarCalificacionRequest calificacion);

    CalificacionResponse updateCalificacion(registrarCalificacionRequest calificacion);

    CalificacionResponse deleteCalificacion(registrarCalificacionRequest calificacion);

    List<CalificacionAlumnoResponse> getCalificacionesAlumno(Alumno alumno);

    List<CalificacionAlumnoResponse> getCalificacionesAlumnoMateria(Alumno alumno, Materia materia);

    List<CalificacionAlumnoResponse> getCalificacionesAlumnoMateria(Long idAlumno, Long idMateria);

    List<CalificacionAlumnoResponse> getCalificacionesAlumno(Long idAlumno);

}
