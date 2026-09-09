package com.makingbigger.portafoliojmc.domain.techskills.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record TechSkillRegisterDto(
        @NotBlank(message = "Skill name is required")
        String name,

        @Min(value = 1, message = "Level must be at least 1")
        @Max(value = 100, message = "Level cannot exceed 100")
        Integer level,

        String icon,
        String color,

        @Min(value = 0, message = "Years of experience cannot be negative")
        Integer yearsOfExperience
) {
}
