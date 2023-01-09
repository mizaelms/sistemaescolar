package com.sistemaescolar.sistemaescolar.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_materias")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_materias")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "activo")
    private Boolean activo;
}
