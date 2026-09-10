package com.makingbigger.portafoliojmc.domain.socialmedia.socialmediamapper;

import com.makingbigger.portafoliojmc.domain.socialmedia.SocialMedia;
import com.makingbigger.portafoliojmc.domain.socialmedia.dto.SocialMediaDetailDto;
import com.makingbigger.portafoliojmc.domain.socialmedia.dto.SocialMediaRegisterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SocialMediaMapper {


    SocialMediaDetailDto toDto(SocialMedia socialMedia);

    SocialMedia toNewEntity(SocialMediaRegisterDto datos);

    @Mapping(target = "platform", source = "platform")
    SocialMedia toNewEntityPlatformN(SocialMediaRegisterDto datos, String platform);

    @Mapping(target = "personalInfo", ignore = true)
    SocialMedia toEntity(SocialMediaDetailDto dto);

}
