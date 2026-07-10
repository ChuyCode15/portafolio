package com.makingbigger.portafoliojmc.services;

import com.makingbigger.portafoliojmc.domain.redessociales.dto.DatosActulizarRedesSociales;
import com.makingbigger.portafoliojmc.domain.redessociales.dto.DatosDetalleRedesSociales;
import com.makingbigger.portafoliojmc.domain.redessociales.dto.DatosRegistroRedesSociales;
import com.makingbigger.portafoliojmc.domain.redessociales.redessocialesmapper.RedesSocialesMapper;
import com.makingbigger.portafoliojmc.infrastructure.exception.ResourceNotFoundException;
import com.makingbigger.portafoliojmc.infrastructure.helpers.RedesSocialesHelper;
import com.makingbigger.portafoliojmc.repository.InformacionPersonalRepository;
import com.makingbigger.portafoliojmc.repository.RedesSocialesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RedesSocialesSevice {

    private final RedesSocialesRepository redesSocialesRepository;

    private final InformacionPersonalRepository informacionPersonalRepository;

    private final RedesSocialesMapper redesSocialesMapper;

    private final RedesSocialesHelper redesSocialesHelper;

    public List<DatosDetalleRedesSociales> listarRedes() {
        var listaRedes = redesSocialesRepository.findAll();
        if (listaRedes.isEmpty()) {
            return Collections.emptyList();
        }
        return  listaRedes.stream()
                .map(redesSocialesMapper::toDto)
                .toList();
    }

    public DatosDetalleRedesSociales BuscarRedPorPlataforma(String plataforma) {
        var plataformaEncontrada = redesSocialesHelper.buscarRedSocialPlataforma(plataforma);
        return redesSocialesMapper.toDto(plataformaEncontrada);
    }

    public DatosDetalleRedesSociales registrarNuevaRed(DatosRegistroRedesSociales datos) {
        var nuevaRed = redesSocialesMapper.toNewEntity(datos);
        var perfil = informacionPersonalRepository.findFirstBy()
                .orElseThrow(() -> new  ResourceNotFoundException("Perfil no encontrado"));
        nuevaRed.setPerfil(perfil);
        redesSocialesRepository.save(nuevaRed);
        return  redesSocialesMapper.toDto(nuevaRed);
    }

    @Transactional
    public DatosDetalleRedesSociales actulizarRedSocial(String plataforma, DatosActulizarRedesSociales datos) {
        var redSocial = redesSocialesHelper.buscarRedSocialPlataforma(plataforma);
        if (datos.url() != null &&!datos.url().isBlank()) {
            redSocial.setUrl(datos.url());
        }
        if (datos.icono() != null && !datos.icono().isBlank()) {
            redSocial.setIcono(datos.icono());
        }
        if (datos.etiqueta() != null &&!datos.etiqueta().isBlank()) {
            redSocial.setEtiqueta(datos.etiqueta());
        }
        redesSocialesRepository.save(redSocial);
        return  redesSocialesMapper.toDto(redSocial);
    }

    @Transactional
    public String eliminarRedSocial(String plataforma) {
        var redSocial = redesSocialesHelper.buscarRedSocialPlataforma(plataforma);
        redSocial.setActivo(false);
        var respuesta = "La Red Social para la plataforma: "+ redSocial.getPlataforma().toString() + " fue eliminada con exito.";
        redesSocialesRepository.save(redSocial);
        return respuesta;
    }
}
