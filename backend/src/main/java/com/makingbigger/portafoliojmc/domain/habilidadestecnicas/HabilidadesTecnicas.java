package com.makingbigger.portafoliojmc.domain.habilidadestecnicas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table
@Entity()

@NoArgsConstructor
@AllArgsConstructor
@Data

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
