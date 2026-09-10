package com.makingbigger.portafoliojmc.infrastructure.helpers;

import com.makingbigger.portafoliojmc.domain.socialmedia.SocialMedia;
import com.makingbigger.portafoliojmc.infrastructure.exception.ResourceAlreadyExistsException;
import com.makingbigger.portafoliojmc.infrastructure.exception.ResourceNotFoundException;
import com.makingbigger.portafoliojmc.repository.SocialMediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SocialMediaHelper {

    private final SocialMediaRepository socialMediaRepository;

    public SocialMedia findSocialMediaByPlatform(String plataforma) {
        var platformN = normizedString(plataforma);
        var redSocial = socialMediaRepository.findByPlatformAndActiveTrue(platformN)
                .orElseThrow(() -> new ResourceNotFoundException(plataforma + ": en RedesSociales no encontrado"));
        return redSocial;
    }

    public String socialMediaNormalized(String platform) {
        var platformN = normizedString(platform);
        if (socialMediaRepository.findByPlatformAndActiveTrue(platformN).isPresent()) {
            throw new ResourceAlreadyExistsException("La plataforma '" + platformN + "' ya está registrada.");
        }
        return platformN;
    }

    private String normizedString(String string) {
        return string.trim().toUpperCase();
    }
}
