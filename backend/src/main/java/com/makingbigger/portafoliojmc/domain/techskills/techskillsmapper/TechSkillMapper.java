package com.makingbigger.portafoliojmc.domain.techskills.techskillsmapper;

import com.makingbigger.portafoliojmc.domain.techskills.TechSkill;
import com.makingbigger.portafoliojmc.domain.techskills.TechSkillCategory;
import com.makingbigger.portafoliojmc.domain.techskills.dto.TechSkillCategoryDetailDto;
import com.makingbigger.portafoliojmc.domain.techskills.dto.TechSkillRegisterDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechSkillMapper {

    TechSkillCategory toEntity(TechSkillRegisterDto dto);

    TechSkillCategoryDetailDto toDto(TechSkill entity);

}
