package com.makingbigger.portafoliojmc.domain.socialmedia.dto;

public record SocialMediaDetailDto(
        String platform,
        String url,
        String icon,
        String label
) {
}