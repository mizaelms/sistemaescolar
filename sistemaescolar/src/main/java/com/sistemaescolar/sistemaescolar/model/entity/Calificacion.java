package com.sistemaescolar.sistemaescolar.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_calificaciones")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_calificaciones")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_t_materias")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "id_t_usuarios")
    private Alumno alumno;

    @Column(name = "calificacion")
    private Long calificacion;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;
}
