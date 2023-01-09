package com.sistemaescolar.sistemaescolar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.sistemaescolar.sistemaescolar.converter.MateriaResponseConverter;
import com.sistemaescolar.sistemaescolar.model.entity.Materia;
import com.sistemaescolar.sistemaescolar.model.response.MateriaResponse;
import com.sistemaescolar.sistemaescolar.repository.MateriaRepository;

@Service
public class MateriaServiceImpl implements MateriaService {

    private final MateriaRepository materiaRepository;
    private final MateriaResponseConverter materiaResponseConverter;

    @Autowired
    public MateriaServiceImpl(MateriaRepository materiaRepository, MateriaResponseConverter materiaResponseConverter) {
        this.materiaRepository = materiaRepository;
        this.materiaResponseConverter = materiaResponseConverter;
    }

    @Override
    public List<MateriaResponse> getMaterias() {
        List<Materia> materias = this.materiaRepository.findAllByActivoOrderByNombreAsc(true);
        if (materias.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron materias activas");
        }
        return materias.stream().map(materiaResponseConverter).collect(Collectors.toList());
    }

}
