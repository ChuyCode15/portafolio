package com.makingbigger.portafoliojmc.domain.techskills.dto;

import java.util.UUID;

public record TechSkillDetailDto(

        UUID id,
        String name,
        Integer level,
        String icon,
        String color,
        Integer yearsOfExperience,
        Boolean active

) {
}
