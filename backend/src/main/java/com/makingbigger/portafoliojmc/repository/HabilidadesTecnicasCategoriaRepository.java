package com.makingbigger.portafoliojmc.repository;

import com.makingbigger.portafoliojmc.domain.habilidadestecnicas.HabilidadesTecnicasCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface HabilidadesTecnicasCategoriaRepository extends JpaRepository<HabilidadesTecnicasCategoria, UUID> {


    @Query("""
                SELECT DISTINCT c FROM HabilidadesTecnicasCategoria c 
                JOIN FETCH c.items i 
                WHERE c.activo = true AND i.activo = true
                ORDER BY c.categoryOrder ASC
                                """)
    List<HabilidadesTecnicasCategoria> findAllWhitHabilidadesTecnicasAndActivoTrue();
}
