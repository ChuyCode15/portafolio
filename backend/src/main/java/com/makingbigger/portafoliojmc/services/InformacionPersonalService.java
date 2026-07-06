package com.makingbigger.portafoliojmc.services;

import com.makingbigger.portafoliojmc.domain.informacionpersonal.dto.DatosDetalleInformacionPersonal;
import com.makingbigger.portafoliojmc.domain.informacionpersonal.informacionpersonalmapper.InformacionPersonalMapper;
import com.makingbigger.portafoliojmc.repository.InformacionPersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InformacionPersonalService {

    private final InformacionPersonalRepository informacionPersonalRepository;

    private final InformacionPersonalMapper informacionPersonalMapper;

    public DatosDetalleInformacionPersonal buscarInformacionPersonal() {
        return informacionPersonalRepository.findAllWithRedes()
                .stream()
                .findFirst()
                .map(informacionPersonalMapper::toDto)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
    }
}
