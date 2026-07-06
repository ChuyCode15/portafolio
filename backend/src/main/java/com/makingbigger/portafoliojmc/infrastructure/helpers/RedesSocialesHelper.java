package com.makingbigger.portafoliojmc.infrastructure.helpers;

import com.makingbigger.portafoliojmc.domain.redessociales.RedesSociales;
import com.makingbigger.portafoliojmc.infrastructure.exception.ResourceNotFoundException;
import com.makingbigger.portafoliojmc.repository.RedesSocialesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedesSocialesHelper {

    private final RedesSocialesRepository redesSocialesRepository;

    public RedesSociales buscarRedSocialPlataforma(String plataforma) {
        var redSocial = redesSocialesRepository.findByPlataformaAndActivoTrue(plataforma)
                .orElseThrow(() -> new ResourceNotFoundException(plataforma + ": en RedesSociales no encontrado"));
        return redSocial;
    }
}
