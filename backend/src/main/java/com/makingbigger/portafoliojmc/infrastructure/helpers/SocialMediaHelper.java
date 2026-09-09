package com.makingbigger.portafoliojmc.infrastructure.helpers;

import com.makingbigger.portafoliojmc.domain.socialmedia.SocialMedia;
import com.makingbigger.portafoliojmc.infrastructure.exception.ResourceNotFoundException;
import com.makingbigger.portafoliojmc.repository.SocialMediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SocialMediaHelper {

    private final SocialMediaRepository socialMediaRepository;

    public SocialMedia findSocialMediaByPlatform(String plataforma) {
        var redSocial = socialMediaRepository.findByPlatformAndActiveTrue(plataforma)
                .orElseThrow(() -> new ResourceNotFoundException(plataforma + ": en RedesSociales no encontrado"));
        return redSocial;
    }
}
