package com.sistemaescolar.sistemaescolar.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.sistemaescolar.sistemaescolar.model.entity.Materia;
import com.sistemaescolar.sistemaescolar.model.response.MateriaResponse;

@Component
public class MateriaResponseConverter implements Function<Materia, MateriaResponse> {

    @Override
    public MateriaResponse apply(Materia materia) {
        MateriaResponse materiaResponse = new MateriaResponse();
        materiaResponse.setId(materia.getId());
        materiaResponse.setNombre(materia.getNombre());
        materiaResponse.setActivo(materia.getActivo());
        return materiaResponse;
    }

}
