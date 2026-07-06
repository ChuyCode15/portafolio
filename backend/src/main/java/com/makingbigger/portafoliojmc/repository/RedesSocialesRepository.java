package com.makingbigger.portafoliojmc.repository;

import com.makingbigger.portafoliojmc.domain.redessociales.RedesSociales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RedesSocialesRepository extends JpaRepository<RedesSociales, UUID> {
    Optional<RedesSociales> findByPlataformaAndActivoTrue(String plataforma);
}
