package com.makingbigger.portafoliojmc.repository;

import com.makingbigger.portafoliojmc.domain.habilidadestecnicas.HabilidadesTecnicas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HabilidadesTecnicasRepository extends JpaRepository<HabilidadesTecnicas, UUID> {


}
