package com.makingbigger.portafoliojmc.repository;

import com.makingbigger.portafoliojmc.domain.habilidadestecnicas.HabilidadesTecnicas;
import com.makingbigger.portafoliojmc.domain.habilidadestecnicas.HabilidadesTecnicasCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface HabilidadesTecnicasRepository extends JpaRepository<HabilidadesTecnicas, UUID> {

    Optional<HabilidadesTecnicasCategoria> findAllAndActivoTrue();

}
