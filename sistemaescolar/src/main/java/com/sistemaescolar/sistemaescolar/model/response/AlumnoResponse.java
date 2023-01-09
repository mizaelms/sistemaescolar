package com.sistemaescolar.sistemaescolar.model.response;

import lombok.Data;

@Data
public class AlumnoResponse {

    private Long id;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private Boolean activo;
}
