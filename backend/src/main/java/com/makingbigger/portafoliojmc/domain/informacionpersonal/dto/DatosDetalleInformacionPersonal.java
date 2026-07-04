package com.makingbigger.portafoliojmc.domain.informacionpersonal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.makingbigger.portafoliojmc.domain.redessociales.dto.DatosDetalleRedesSociales;

import java.util.List;

public record DatosDetalleInformacionPersonal(

        @JsonProperty("firstName") String nombre,
        @JsonProperty("lastName") String apellido,
        @JsonProperty("title") String titulo,
        @JsonProperty("subtitle") String subtitulo,
        @JsonProperty("summary") String resumen,
        @JsonProperty("email") String correoElectronico,
        @JsonProperty("phone") String telefono,
        @JsonProperty("location") String ubicacion,
        @JsonProperty("photoUrl") String urlFoto,
        @JsonProperty("resumeUrl") String urlCv,
        @JsonProperty("availableFor") String disponibilidad,
        @JsonProperty("socialLinks") List<DatosDetalleRedesSociales> redesSociales

) {


}
