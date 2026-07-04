package com.makingbigger.portafoliojmc.repository;

import com.makingbigger.portafoliojmc.domain.informacionersonal.InformacionPersonal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InformacionPersonalRepository extends JpaRepository<InformacionPersonal, UUID> {
}
