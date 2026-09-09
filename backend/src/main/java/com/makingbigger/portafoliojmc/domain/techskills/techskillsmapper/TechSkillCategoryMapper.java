package com.makingbigger.portafoliojmc.domain.techskills.techskillsmapper;

import com.makingbigger.portafoliojmc.domain.techskills.TechSkillCategory;
import com.makingbigger.portafoliojmc.domain.techskills.dto.TechSkillCategoryDetailDto;
import com.makingbigger.portafoliojmc.domain.techskills.dto.TechSkillCategoryRegisterDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TechSkillMapper.class})
public interface TechSkillCategoryMapper {

    TechSkillCategory toEntity(TechSkillCategoryRegisterDto dto);

    TechSkillCategoryDetailDto toDto(TechSkillCategory entity);

}
