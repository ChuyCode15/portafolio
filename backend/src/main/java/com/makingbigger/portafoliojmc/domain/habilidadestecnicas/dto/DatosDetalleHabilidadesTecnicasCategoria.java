package com.makingbigger.portafoliojmc.domain.habilidadestecnicas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record DatosDetalleHabilidadesTecnicasCategoria(

        @JsonProperty("id") Long id,
        @JsonProperty("category") String categoria,
        @JsonProperty("categoryOrder") Integer categoriaOrden,
        @JsonProperty("items") List<DatosDetalleHabilidadesTecnicas> objetos

) {
}
