package com.makingbigger.portafoliojmc.domain.redessociales.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DatosActulizarRedesSociales(
        @JsonProperty("url") String url,
        @JsonProperty("icon") String icono,
        @JsonProperty("label") String etiqueta
) {
}

