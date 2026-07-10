package com.makingbigger.portafoliojmc.services;

import com.makingbigger.portafoliojmc.domain.redessociales.RedesSociales;
import com.makingbigger.portafoliojmc.domain.redessociales.dto.DatosDetalleRedesSociales;
import com.makingbigger.portafoliojmc.domain.redessociales.redessocialesmapper.RedesSocialesMapper;
import com.makingbigger.portafoliojmc.infrastructure.helpers.RedesSocialesHelper;
import com.makingbigger.portafoliojmc.repository.InformacionPersonalRepository;
import com.makingbigger.portafoliojmc.repository.RedesSocialesRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class RedesSocialesSeviceTest {

    @Mock
    private InformacionPersonalRepository informacionPersonalRepository;

    @Mock
    private RedesSocialesRepository redesSocialesRepository;

    @Mock
    private RedesSocialesMapper redesSocialesMapper;

    @Mock
    private RedesSocialesHelper redesSocialesHelper;

    @InjectMocks
    private RedesSocialesSevice redesSocialesSevice;

    @Test
    void listarRedes_cuandoExisten_retornaLista() {
        var redSocial = new RedesSociales();
        redSocial.setPlataforma("GITHUB");

        var dtoEsperado = new DatosDetalleRedesSociales(
                "GITHUB", "https://github.com/jmcastillo",
                "fab fa-github", "GitHub"
        );


    }


    @Test
    void listarRedes() {


    }

    @Test
    void buscarRedPorPlataforma() {
    }

    @Test
    void registrarNuevaRed() {
    }

    @Test
    void actulizarRedSocial() {
    }

    @Test
    void eliminarRedSocial() {
    }
}