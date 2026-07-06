package com.makingbigger.portafoliojmc.repository;

import com.makingbigger.portafoliojmc.domain.habilidadestecnicas.HabilidadesTecnicasCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface HabilidadesTecnicasCategoriaRepository extends JpaRepository<HabilidadesTecnicasCategoria, UUID> {


    @Query("")
    List<HabilidadesTecnicasCategoria> findAllWhitHabilidadesTecnicasAndActivoTrue();
}
