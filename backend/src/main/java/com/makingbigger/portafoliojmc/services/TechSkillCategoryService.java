package com.makingbigger.portafoliojmc.services;

import com.makingbigger.portafoliojmc.domain.techskills.dto.TechSkillCategoryDetailDto;
import com.makingbigger.portafoliojmc.domain.techskills.techskillsmapper.TechSkillCategoryMapper;
import com.makingbigger.portafoliojmc.repository.TechSkillCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechSkillCategoryService {

    private  final TechSkillCategoryRepository techSkillCategoryRepository;

    public List<TechSkillCategoryDetailDto> getListTechSkillCategory() {
        var list = techSkillCategoryRepository.findAllWithActiveSkills().stream()
                .map(techSkillCategory -> TechSkillCategoryMapper);
    }
}
