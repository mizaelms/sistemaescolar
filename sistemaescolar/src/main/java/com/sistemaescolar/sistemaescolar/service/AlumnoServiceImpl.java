package com.sistemaescolar.sistemaescolar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.sistemaescolar.sistemaescolar.converter.AlumnoResponseConverter;
import com.sistemaescolar.sistemaescolar.model.entity.Alumno;
import com.sistemaescolar.sistemaescolar.model.response.AlumnoResponse;
import com.sistemaescolar.sistemaescolar.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final AlumnoResponseConverter alumnoResponseConverter;

    @Autowired
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, AlumnoResponseConverter alumnoResponseConverter) {
        this.alumnoRepository = alumnoRepository;
        this.alumnoResponseConverter = alumnoResponseConverter;
    }

    @Override
    public List<AlumnoResponse> getAlumnos() {
        List<Alumno> alumnos = this.alumnoRepository.findAllByActivoOrderByNombreAsc(true);
        if (alumnos.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron alumnos activos");
        }
        return alumnos.stream().map(alumnoResponseConverter).collect(Collectors.toList());
    }

}
