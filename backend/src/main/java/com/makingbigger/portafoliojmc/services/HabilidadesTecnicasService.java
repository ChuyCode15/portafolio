package com.makingbigger.portafoliojmc.services;

import com.makingbigger.portafoliojmc.domain.habilidadestecnicas.HabilidadesTecnicasMapper.HabilidadesTecnicasCategoriaMapper;
import com.makingbigger.portafoliojmc.domain.habilidadestecnicas.HabilidadesTecnicasMapper.HabilidadesTecnicasMapper;
import com.makingbigger.portafoliojmc.domain.habilidadestecnicas.dto.DatosDetalleHabilidadesTecnicasCategoria;
import com.makingbigger.portafoliojmc.repository.HabilidadesTecnicasCategoriaRepository;
import com.makingbigger.portafoliojmc.repository.HabilidadesTecnicasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabilidadesTecnicasService {

    private final HabilidadesTecnicasRepository habilidadesTecnicasRepository;

    private final HabilidadesTecnicasCategoriaRepository habilidadesTecnicasCategoriaRepository;

    private final HabilidadesTecnicasCategoriaMapper habilidadesTecnicasCategoriaMapper;

    private final HabilidadesTecnicasMapper habilidadesTecnicasMapper;

    public List<DatosDetalleHabilidadesTecnicasCategoria> listarHabilidades() {

        return habilidadesTecnicasCategoriaRepository.findAllWhitHabilidadesTecnicasAndActivoTrue()
                .stream()
                .map(habilidadesTecnicasCategoriaMapper::toDto)
                .toList();
            }

}
