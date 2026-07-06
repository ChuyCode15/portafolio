package com.makingbigger.portafoliojmc.domain.habilidadestecnicas;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public class HabilidadesTecnicas {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nombre;
    private Integer nivel;
    private String icono;
    private String color;

    @Column(name = "years_of_experience")
    private Integer anosDeExperiecia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_category_id")
    private HabilidadesTecnicasCategoria categoriDeHabilidades;

    private Boolean activo = true;

}
