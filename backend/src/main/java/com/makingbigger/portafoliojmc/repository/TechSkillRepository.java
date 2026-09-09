package com.makingbigger.portafoliojmc.repository;

import com.makingbigger.portafoliojmc.domain.techskills.TechSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TechSkillRepository extends JpaRepository<TechSkill, UUID> {


}
