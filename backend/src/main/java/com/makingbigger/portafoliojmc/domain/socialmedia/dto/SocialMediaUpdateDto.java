package com.makingbigger.portafoliojmc.domain.socialmedia.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record SocialMediaUpdateDto(

        @NotBlank(message = "URL is required")
        @URL(message = "Must be a valid URL")
        String url,
        String icon,
        String label
) {
}

