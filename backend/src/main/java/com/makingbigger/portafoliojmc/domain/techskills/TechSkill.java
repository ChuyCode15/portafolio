package com.makingbigger.portafoliojmc.domain.techskills;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tech_skills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TechSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    private Integer level;

    private String icon;

    private String color;

    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_category_id")
    private TechSkillCategory category;

    private Boolean active = true;
}