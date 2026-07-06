package com.makingbigger.portafoliojmc.domain.habilidadestecnicas.dto;

import java.util.List;

public record DatosRegistroHabilidadesTecnicasCategoria(

        String categoria,
        Integer categoriaOrden,
        List<DatosDetalleHabilidadesTecnicas> objetos
) {
}
