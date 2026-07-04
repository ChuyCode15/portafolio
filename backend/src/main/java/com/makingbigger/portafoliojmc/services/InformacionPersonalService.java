package com.makingbigger.portafoliojmc.services;

import com.makingbigger.portafoliojmc.domain.informacionersonal.dto.DatosDetalleInformacionPersonal;
import com.makingbigger.portafoliojmc.repository.InformacionPersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InformacionPersonalService {

    private final InformacionPersonalRepository informacionPersonalRepository;

    public DatosDetalleInformacionPersonal buscarInformacionPersonal() {

        var informacionP = informacionPersonalRepository.findAll()
                .stream()
                .findFirst()
                .map(DatosDetalleInformacionPersonal::new)
                .orElseThrow(() -> new RuntimeException("No encontrado"));

        return informacionP;
    }
}
