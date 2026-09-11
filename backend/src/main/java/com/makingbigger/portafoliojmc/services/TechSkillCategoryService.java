package com.makingbigger.portafoliojmc.services;

import com.makingbigger.portafoliojmc.domain.techskills.dto.TechSkillCategoryDetailDto;
import com.makingbigger.portafoliojmc.domain.techskills.techskillsmapper.TechSkillCategoryMapper;
import com.makingbigger.portafoliojmc.repository.TechSkillCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechSkillCategoryService {

    private  final TechSkillCategoryRepository techSkillCategoryRepository;

    private final  TechSkillCategoryMapper techSkillCategoryMapper;

    @Transactional(readOnly = true)
    public List<TechSkillCategoryDetailDto> getListTechSkillCategory() {
        return techSkillCategoryRepository.findAllWithActiveSkills()
                .stream()
                .map(techSkillCategoryMapper::toDto)
                .toList();
    }
}
