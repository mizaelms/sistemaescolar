package com.sistemaescolar.sistemaescolar.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sistemaescolar.sistemaescolar.model.entity.Materia;

@Repository
public interface MateriaRepository extends PagingAndSortingRepository<Materia, Long> {

    List<Materia> findAllByActivoOrderByNombreAsc(boolean activo);

}
