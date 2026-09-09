package com.makingbigger.portafoliojmc.domain.techskills;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tech_skill_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TechSkillCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_order")
    private Integer categoryOrder;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @SQLRestriction("active = true")
    private List<TechSkill> skills;

    private Boolean active = true;
}