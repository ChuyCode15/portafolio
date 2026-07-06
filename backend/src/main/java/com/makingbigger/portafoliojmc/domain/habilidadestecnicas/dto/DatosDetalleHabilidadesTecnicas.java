package com.makingbigger.portafoliojmc.domain.habilidadestecnicas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DatosDetalleHabilidadesTecnicas(

        @JsonProperty("name") String nombre,
        @JsonProperty("level") Integer nivel,
        @JsonProperty("icon") String icono,
        @JsonProperty("color") String color,
        @JsonProperty("yearsOfExperience") Integer anosDeExperiecia

) {
}
