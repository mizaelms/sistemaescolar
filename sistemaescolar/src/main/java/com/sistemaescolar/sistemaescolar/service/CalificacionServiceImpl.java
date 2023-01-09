package com.sistemaescolar.sistemaescolar.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.sistemaescolar.sistemaescolar.converter.CalificacionAlumnoConverter;
import com.sistemaescolar.sistemaescolar.model.entity.Alumno;
import com.sistemaescolar.sistemaescolar.model.entity.Calificacion;
import com.sistemaescolar.sistemaescolar.model.entity.Materia;
import com.sistemaescolar.sistemaescolar.model.request.registrarCalificacionRequest;
import com.sistemaescolar.sistemaescolar.model.response.CalificacionAlumnoResponse;
import com.sistemaescolar.sistemaescolar.model.response.CalificacionResponse;
import com.sistemaescolar.sistemaescolar.repository.CalificacionRepository;

@Service
public class CalificacionServiceImpl implements CalificacionService {

    private final CalificacionRepository calificacionRepository;
    private final CalificacionAlumnoConverter calificacionResponseConverter;

    @Autowired
    public CalificacionServiceImpl(CalificacionRepository calificacionRepository,
            CalificacionAlumnoConverter calificacionResponseConverter) {
        this.calificacionRepository = calificacionRepository;
        this.calificacionResponseConverter = calificacionResponseConverter;

    }

    @Override
    public CalificacionResponse registrarCalificacion(Calificacion calificacion) {
        CalificacionResponse response = new CalificacionResponse();
        try {
            this.calificacionRepository.save(calificacion);
            response.setSucces("OK");
            response.setMsg("Calificacion registrada");
        } catch (Exception e) {
            response.setSucces("ERROR");
            response.setMsg("Error al registrar calificacion");
            throw new ResourceNotFoundException("Error al registrar calificacion");
        }
        return response;
    }

    @Override
    public CalificacionResponse registrarCalificacion(registrarCalificacionRequest calificacion) {
        Alumno alumno = new Alumno();
        alumno.setId(calificacion.getIdAlumno());
        Materia materia = new Materia();
        materia.setId(calificacion.getIdMateria());
        Calificacion calificacionEntity = new Calificacion();
        calificacionEntity.setAlumno(alumno);
        calificacionEntity.setMateria(materia);
        if (calificacion.getCalificacion() < 0 || calificacion.getCalificacion() > 10)
            throw new ResourceNotFoundException("La calificacion debe estar entre 0 y 10");
        calificacionEntity.setCalificacion(calificacion.getCalificacion());
        calificacionEntity.setFechaRegistro(new Date());
        return this.registrarCalificacion(calificacionEntity);
    }

    @Override
    public List<CalificacionAlumnoResponse> getCalificacionesAlumno(Alumno alumno) {
        List<Calificacion> calificaciones = this.calificacionRepository.findAllByAlumno(alumno);
        if (calificaciones.isEmpty())
            throw new ResourceNotFoundException("No se encontraron calificaciones para el alumno");
        return calificaciones.stream().map(calificacionResponseConverter).collect(Collectors.toList());
    }

    @Override
    public List<CalificacionAlumnoResponse> getCalificacionesAlumno(Long idAlumno) {
        Alumno alumno = new Alumno();
        if (Objects.isNull(idAlumno))
            throw new ResourceNotFoundException("El id del alumno no puede ser nulo");
        if (idAlumno < 0)
            throw new ResourceNotFoundException("El id del alumno no puede ser negativo");
        alumno.setId(idAlumno);
        return this.getCalificacionesAlumno(alumno);
    }

    @Override
    public CalificacionResponse updateCalificacion(registrarCalificacionRequest calificacion) {
        CalificacionResponse response = new CalificacionResponse();
        try {
            Calificacion calificacionEntity = this.calificacionRepository
                    .findById(calificacion.getIdCalificacion())
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontro la calificacion"));
            calificacionEntity.setCalificacion(calificacion.getCalificacion());
            this.calificacionRepository.save(calificacionEntity);
            response.setSucces("OK");
            response.setMsg("Calificacion actualizada");
        } catch (Exception e) {
            response.setSucces("ERROR");
            response.setMsg("Error al actualizar calificacion");
            throw new ResourceNotFoundException("Error al actualizar calificacion");
        }
        return response;
    }

    @Override
    public CalificacionResponse deleteCalificacion(registrarCalificacionRequest calificacion) {
        CalificacionResponse response = new CalificacionResponse();
        try {
            Calificacion calificacionEntity = this.calificacionRepository.findById(calificacion.getIdCalificacion())
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontro la calificacion"));
            this.calificacionRepository.delete(calificacionEntity);
            response.setSucces("OK");
            response.setMsg("Calificacion eliminada");
        } catch (Exception e) {
            response.setSucces("ERROR");
            response.setMsg("Error al eliminar calificacion");
            throw new ResourceNotFoundException("Error al eliminar calificacion");
        }
        return response;
    }

    @Override
    public List<CalificacionAlumnoResponse> getCalificacionesAlumnoMateria(Alumno alumno, Materia materia) {
        List<Calificacion> calificaciones = this.calificacionRepository.findAllByAlumnoAndMateria(alumno, materia);
        if (calificaciones.isEmpty())
            throw new ResourceNotFoundException("No se encontraron calificaciones para el alumno");
        return calificaciones.stream().map(calificacionResponseConverter).collect(Collectors.toList());
    }

    @Override
    public List<CalificacionAlumnoResponse> getCalificacionesAlumnoMateria(Long idAlumno, Long idMateria) {
        Alumno alumno = new Alumno();
        Materia materia = new Materia();
        if (Objects.isNull(idAlumno))
            throw new ResourceNotFoundException("El id del alumno no puede ser nulo");
        if (idAlumno < 0)
            throw new ResourceNotFoundException("El id del alumno no puede ser negativo");
        if (Objects.isNull(idMateria))
            throw new ResourceNotFoundException("El id de la materia no puede ser nulo");
        if (idMateria < 0)
            throw new ResourceNotFoundException("El id de la materia no puede ser negativo");
        alumno.setId(idAlumno);
        materia.setId(idMateria);
        return this.getCalificacionesAlumnoMateria(alumno, materia);
    }
}
