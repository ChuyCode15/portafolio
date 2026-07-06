package com.makingbigger.portafoliojmc.domain.habilidadestecnicas;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

public class HabilidadesTecnicasCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String category;

    @Column(name = "category_order")
    private Integer categoryOrder;

    @OneToMany(mappedBy = "categoriDeHabilidades", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HabilidadesTecnicas> items;

}
