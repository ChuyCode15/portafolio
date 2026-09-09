package com.makingbigger.portafoliojmc.domain.personalinfo.personalinfomapper;

import com.makingbigger.portafoliojmc.domain.personalinfo.PersonalInfo;
import com.makingbigger.portafoliojmc.domain.personalinfo.dto.PersonalInfoDetailDto;
import com.makingbigger.portafoliojmc.domain.socialmedia.socialmediamapper.SocialMediaMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SocialMediaMapper.class})
public interface PersonalInfoMapper {


    PersonalInfoDetailDto toDto(PersonalInfo personalInfo);


    PersonalInfo toEntity(PersonalInfoDetailDto personalInfoDetailDto);

}
