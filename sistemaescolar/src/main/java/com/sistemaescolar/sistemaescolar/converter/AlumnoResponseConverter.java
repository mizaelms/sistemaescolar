package com.sistemaescolar.sistemaescolar.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.sistemaescolar.sistemaescolar.model.entity.Alumno;
import com.sistemaescolar.sistemaescolar.model.response.AlumnoResponse;

@Component
public class AlumnoResponseConverter implements Function<Alumno, AlumnoResponse> {

    @Override
    public AlumnoResponse apply(Alumno alumno) {
        AlumnoResponse alumnoResponse = new AlumnoResponse();
        alumnoResponse.setNombre(alumno.getNombre());
        alumnoResponse.setApPaterno(alumno.getApPaterno());
        alumnoResponse.setApMaterno(alumno.getApMaterno());
        alumnoResponse.setActivo(alumno.getActivo());
        alumnoResponse.setId(alumno.getId());
        return alumnoResponse;
    }

}
