package com.makingbigger.portafoliojmc.services;

import com.makingbigger.portafoliojmc.domain.techskills.techskillsmapper.TechSkillCategoryMapper;
import com.makingbigger.portafoliojmc.domain.techskills.dto.TechSkillCategoryDetailDto;
import com.makingbigger.portafoliojmc.repository.techSkillCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechSkillService {

    private final techSkillCategoryRepository techSkillCategoryRepository;

    private final TechSkillCategoryMapper techSkillCategoryMapper;

    @Transactional(readOnly = true)
    public List<TechSkillCategoryDetailDto> findAllTechSkills() {

        return techSkillCategoryRepository.findAllWithActiveSkills()
                .stream()
                .map(techSkillCategoryMapper::toDto)
                .toList();
    }

}

