package com.makingbigger.portafoliojmc.services;

import com.makingbigger.portafoliojmc.domain.socialmedia.SocialMedia;
import com.makingbigger.portafoliojmc.domain.socialmedia.dto.SocialMediaDetailDto;
import com.makingbigger.portafoliojmc.domain.socialmedia.socialmediamapper.SocialMediaMapper;
import com.makingbigger.portafoliojmc.infrastructure.helpers.SocialMediaHelper;
import com.makingbigger.portafoliojmc.repository.PersonalInfoRepository;
import com.makingbigger.portafoliojmc.repository.SocialMediaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SocialMediaServiceTest {

    @Mock
    private PersonalInfoRepository personalInfoRepository;

    @Mock
    private SocialMediaRepository socialMediaRepository;

    @Mock
    private SocialMediaMapper socialMediaMapper;

    @Mock
    private SocialMediaHelper socialMediaHelper;

    @InjectMocks
    private SocialMediaService socialMediaService;

    @Test
    @DisplayName("getAllSocialMedia returns list when records exist")
    void getAllSocialMedia_whenRecordsExist_returnsList() {
        var socialMedia = new SocialMedia();
        socialMedia.setPlatform("GITHUB");

        var listMock = List.of(socialMedia);
        var expectedDto = new SocialMediaDetailDto(
                UUID.randomUUID(),
                "GITHUB",
                "https://github.com/jmcastillo",
                "fab fa-github",
                "GitHub",
                true
        );

        given(socialMediaRepository.findAll()).willReturn(listMock);
        given(socialMediaMapper.toDto(socialMedia)).willReturn(expectedDto);

        var result = socialMediaService.getAllSocialMedia();

        assertThat(result)
                .isNotEmpty()
                .hasSize(1);
        assertThat(result.get(0).platform()).isEqualTo("GITHUB");
        assertThat(result.get(0).url()).isEqualTo("https://github.com/jmcastillo");
    }

    @Test
    @DisplayName("getAllSocialMedia returns empty list when no records exist")
    void getAllSocialMedia_whenNoRecordsExist_returnsEmptyList() {
        given(socialMediaRepository.findAll()).willReturn(Collections.emptyList());

        var result = socialMediaService.getAllSocialMedia();

        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("getSocialMediaByPlatform returns record when platform exists")
    void getSocialMediaByPlatform_whenPlatformExists_returnsRecord() {
        var socialMedia = new SocialMedia();
        socialMedia.setPlatform("GITHUB");

        var expectedDto = new SocialMediaDetailDto(
                UUID.randomUUID(),
                "GITHUB",
                "https://github.com/jmcastillo",
                "fab fa-github",
                "GitHub",
                true
        );

        given(socialMediaHelper.findSocialMediaByPlatform("GITHUB"))
                .willReturn(socialMedia);
        given(socialMediaMapper.toDto(socialMedia)).willReturn(expectedDto);

        var result = socialMediaService.getSocialMediaByPlatform("GITHUB");

        assertThat(result.platform()).isEqualTo("GITHUB");
        assertThat(result.url()).isEqualTo("https://github.com/jmcastillo");
    }
}