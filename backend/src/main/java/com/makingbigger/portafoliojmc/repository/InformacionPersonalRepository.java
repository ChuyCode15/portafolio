package com.makingbigger.portafoliojmc.repository;

import com.makingbigger.portafoliojmc.domain.informacionpersonal.InformacionPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InformacionPersonalRepository extends JpaRepository<InformacionPersonal, UUID> {

    @Query("SELECT i FROM InformacionPersonal i LEFT JOIN i.redesSociales r ON r.activo = true")
    List<InformacionPersonal> findAllWithRedes();

    Optional<InformacionPersonal> findFirstBy();

}
