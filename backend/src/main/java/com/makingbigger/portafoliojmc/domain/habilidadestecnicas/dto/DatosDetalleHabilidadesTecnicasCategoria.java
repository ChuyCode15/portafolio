package com.makingbigger.portafoliojmc.domain.habilidadestecnicas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public record DatosDetalleHabilidadesTecnicasCategoria(

        @JsonProperty("id") UUID id,
        @JsonProperty("category") String categoria,
        @JsonProperty("categoryOrder") Integer categoriaOrden,
        @JsonProperty("items") List<DatosDetalleHabilidadesTecnicas> objetos

) {
}
