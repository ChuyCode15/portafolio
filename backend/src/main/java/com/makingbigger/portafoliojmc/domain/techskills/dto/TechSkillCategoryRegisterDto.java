package com.makingbigger.portafoliojmc.domain.techskills.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record TechSkillCategoryRegisterDto(

        @NotBlank(message = "Category name is required")
        String categoryName,

        Integer categoryOrder,

        List<TechSkillRegisterDto> skills
) {
}
