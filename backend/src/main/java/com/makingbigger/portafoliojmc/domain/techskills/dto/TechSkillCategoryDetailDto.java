package com.makingbigger.portafoliojmc.domain.techskills.dto;

import java.util.List;
import java.util.UUID;

public record TechSkillCategoryDetailDto(

        UUID id,
        String categoryName,
        Integer categoryOrder,
        List<TechSkillDetailDto> skills
) {
}
