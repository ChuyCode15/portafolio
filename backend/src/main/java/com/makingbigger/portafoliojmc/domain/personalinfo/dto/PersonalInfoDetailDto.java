package com.makingbigger.portafoliojmc.domain.personalinfo.dto;

import com.makingbigger.portafoliojmc.domain.socialmedia.dto.SocialMediaDetailDto;

import java.util.List;
import java.util.UUID;

public record PersonalInfoDetailDto(

        UUID id,
        String firstName,
        String lastName,
        String title,
        String subtitle,
        String summary,
        String email,
        String phone,
        String location,
        String photoUrl,
        String cvUrl,
        String availability,
        List<SocialMediaDetailDto> socialMediaLinks

) {


}
