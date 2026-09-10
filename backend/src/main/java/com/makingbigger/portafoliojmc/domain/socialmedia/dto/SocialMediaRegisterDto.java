package com.makingbigger.portafoliojmc.domain.socialmedia.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record SocialMediaRegisterDto(

        @NotBlank(message = "Platform is required")
        @NotBlank(message = "La plataforma es obligatoria")
        String platform,

        @NotBlank(message = "La URL es obligatoria")
        @URL(message = "Debe proporcionar una URL válida")
        String url,

        @NotBlank(message = "El icono es obligatorio")
        String icon,

        @NotBlank(message = "El label es obligatorio")
        String label
) {
}