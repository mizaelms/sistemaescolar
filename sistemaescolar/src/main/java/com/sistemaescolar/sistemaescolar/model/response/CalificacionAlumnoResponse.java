package com.sistemaescolar.sistemaescolar.model.response;

import java.util.Date;

import lombok.Data;

@Data
public class CalificacionAlumnoResponse {

    private Long id;
    private Long idUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String materia;
    private Long calificacion;
    private Date fechaRegistro;

}
