package com.sistemaescolar.sistemaescolar.model.request;

import lombok.Data;

@Data
public class registrarCalificacionRequest {

    private Long idCalificacion;
    private Long idMateria;
    private Long calificacion;
    private Long idAlumno;
}
