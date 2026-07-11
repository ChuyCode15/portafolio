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

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


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

        var listMock = List.of(redSocial);
        var dtoEsperado = new DatosDetalleRedesSociales(
                "GITHUB", "https://github.com/jmcastillo",
                "fab fa-github", "GitHub"
        );

        given(redesSocialesRepository.findAll()).willReturn(listMock);
        given(redesSocialesMapper.toDto(redSocial)).willReturn(dtoEsperado);

        var resultado = redesSocialesSevice.listarRedes();
        assertThat(resultado)
                .isNotEmpty()
                .hasSize(1);

        assertThat(resultado.get(0).plataforma()).isEqualTo("GITHUB");
        assertThat(resultado.get(0).url()).isEqualTo("https://github.com/jmcastillo");
    }

    @Test
    void listarRedes_cuandoNoExisten_retornaListaVacia() {
        given(redesSocialesRepository.findAll()).willReturn(Collections.emptyList());
        var resultado = redesSocialesSevice.listarRedes();
        assertThat(resultado).isEmpty();
    }

    @Test
    void buscarRedPorPlataforma_cuandoExiste_retornaRed() {
        var redSocial = new RedesSociales();
        redSocial.setPlataforma("GITHUB");

        var dtoEsperado = new DatosDetalleRedesSociales(
                "GITHUB", "https://github.com/jmcastillo",
                "fab fa-github", "GitHub"
        );

        given(redesSocialesHelper.buscarRedSocialPlataforma("GITHUB"))
                .willReturn(redSocial);
        given(redesSocialesMapper.toDto(redSocial)).willReturn(dtoEsperado);

        var resultado = redesSocialesSevice.BuscarRedPorPlataforma("GITHUB");

        assertThat(resultado.plataforma()).isEqualTo("GITHUB");
        assertThat(resultado.url()).isEqualTo("https://github.com/jmcastillo");
    }
    
}