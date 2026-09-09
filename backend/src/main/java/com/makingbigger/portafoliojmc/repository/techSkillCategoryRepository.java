package com.makingbigger.portafoliojmc.repository;

import com.makingbigger.portafoliojmc.domain.techskills.TechSkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface techSkillCategoryRepository extends JpaRepository<TechSkillCategory, UUID> {

    @Query("" +
            "SELECT DISTINCT c " +
            "FROM TechSkillCategory c " +
            "LEFT JOIN FETCH c.skills s " +
            "WHERE c.active = true " +
            "AND (s IS NULL OR s.active = true) " +
            "ORDER BY c.categoryOrder ASC")
    List<TechSkillCategory> findAllWithActiveSkills();


}
