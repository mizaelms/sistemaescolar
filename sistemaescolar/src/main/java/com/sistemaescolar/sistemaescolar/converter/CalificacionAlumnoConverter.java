package com.sistemaescolar.sistemaescolar.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.sistemaescolar.sistemaescolar.model.entity.Calificacion;
import com.sistemaescolar.sistemaescolar.model.response.CalificacionAlumnoResponse;

@Component
public class CalificacionAlumnoConverter implements Function<Calificacion, CalificacionAlumnoResponse> {

    @Override
    public CalificacionAlumnoResponse apply(Calificacion calificacion) {
        CalificacionAlumnoResponse calificacionAlumnoResponse = new CalificacionAlumnoResponse();
        calificacionAlumnoResponse.setApellidoPaterno(calificacion.getAlumno().getApPaterno());
        calificacionAlumnoResponse.setNombre(calificacion.getAlumno().getNombre());
        calificacionAlumnoResponse.setMateria(calificacion.getMateria().getNombre());
        calificacionAlumnoResponse.setCalificacion(calificacion.getCalificacion());
        calificacionAlumnoResponse.setFechaRegistro(calificacion.getFechaRegistro());
        calificacionAlumnoResponse.setIdUsuario(calificacion.getAlumno().getId());
        calificacionAlumnoResponse.setId(calificacion.getId());
        return calificacionAlumnoResponse;
    }
}
