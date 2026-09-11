package com.makingbigger.portafoliojmc.controller;

import com.makingbigger.portafoliojmc.domain.techskills.TechSkillCategory;
import com.makingbigger.portafoliojmc.domain.techskills.dto.TechSkillCategoryDetailDto;
import com.makingbigger.portafoliojmc.services.TechSkillCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TechSkillCategoryController {

    private final TechSkillCategoryService techSkillCategoryService;

    public ResponseEntity<List<TechSkillCategoryDetailDto>> getAllTechSkillCategory() {
        var listCategory = techSkillCategoryService.getListTechSkillCategory();
        return ResponseEntity.ok().body(listCategory);
    }

}
