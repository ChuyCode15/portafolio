package com.makingbigger.portafoliojmc.domain.redessociales.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DatosRegistroRedesSociales(

        @JsonProperty("platform") String plataforma,
        @JsonProperty("url") String url,
        @JsonProperty("icon") String icono,
        @JsonProperty("label") String etiqueta

) {

}
