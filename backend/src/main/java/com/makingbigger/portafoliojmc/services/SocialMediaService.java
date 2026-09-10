package com.makingbigger.portafoliojmc.services;

import com.makingbigger.portafoliojmc.domain.socialmedia.dto.SocialMediaRegisterDto;
import com.makingbigger.portafoliojmc.domain.socialmedia.dto.SocialMediaDetailDto;
import com.makingbigger.portafoliojmc.domain.socialmedia.dto.SocialMediaUpdateDto;
import com.makingbigger.portafoliojmc.domain.socialmedia.socialmediamapper.SocialMediaMapper;
import com.makingbigger.portafoliojmc.infrastructure.exception.ResourceNotFoundException;
import com.makingbigger.portafoliojmc.infrastructure.helpers.SocialMediaHelper;
import com.makingbigger.portafoliojmc.repository.PersonalInfoRepository;
import com.makingbigger.portafoliojmc.repository.SocialMediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialMediaService {

    private final SocialMediaRepository socialMediaRepository;

    private final PersonalInfoRepository personalInfoRepository;

    private final SocialMediaMapper socialMediaMapper;

    private final SocialMediaHelper socialMediaHelper;

    public List<SocialMediaDetailDto> getAllSocialMedia() {
        var socialMediaList = socialMediaRepository.findAll();
        if (socialMediaList.isEmpty()) {
            return Collections.emptyList();
        }
        return socialMediaList.stream()
                .map(socialMediaMapper::toDto)
                .toList();
    }

    public SocialMediaDetailDto getSocialMediaByPlatform(String platform) {
        var foundSocialMedia = socialMediaHelper.findSocialMediaByPlatform(platform);
        return socialMediaMapper.toDto(foundSocialMedia);
    }

    public SocialMediaDetailDto registerSocialMedia(SocialMediaRegisterDto dto) {
        var socialMediaNormalized = socialMediaHelper.socialMediaNormalized(dto.platform());

        var newSocialMedia = socialMediaMapper.toNewEntityPlatformN(dto, socialMediaNormalized);
        var personalInfo = personalInfoRepository.findFirstBy()
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
        newSocialMedia.setPersonalInfo(personalInfo);
        socialMediaRepository.save(newSocialMedia);
        return socialMediaMapper.toDto(newSocialMedia);
    }

    @Transactional
    public SocialMediaDetailDto updateSocialMedia(String platform, SocialMediaUpdateDto dto) {
        var socialMedia = socialMediaHelper.findSocialMediaByPlatform(platform);
        if (dto.url() != null && !dto.url().isBlank()) {
            socialMedia.setUrl(dto.url());
        }
        if (dto.icon() != null && !dto.icon().isBlank()) {
            socialMedia.setIcon(dto.icon());
        }
        if (dto.label() != null && !dto.label().isBlank()) {
            socialMedia.setLabel(dto.label());
        }
        socialMediaRepository.save(socialMedia);
        return socialMediaMapper.toDto(socialMedia);
    }

    @Transactional
    public String deleteSocialMedia(String platform) {
        var socialMedia = socialMediaHelper.findSocialMediaByPlatform(platform);
        socialMedia.setActive(false);
        var response = "Social media platform " + socialMedia.getPlatform() + " was successfully deleted.";
        socialMediaRepository.save(socialMedia);
        return response;
    }
}