package com.makingbigger.portafoliojmc.controller;

import com.makingbigger.portafoliojmc.domain.techskills.dto.TechSkillCategoryDetailDto;
import com.makingbigger.portafoliojmc.services.TechSkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
@RequiredArgsConstructor
public class TechSkillController {

    private final TechSkillService techSkillService;

    @GetMapping
    public ResponseEntity<List<TechSkillCategoryDetailDto>> getAllTechSkills() {
        return ResponseEntity.ok(techSkillService.findAllTechSkills());
    }

}
