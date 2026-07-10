package com.makingbigger.portafoliojmc.controller;

import com.makingbigger.portafoliojmc.domain.habilidadestecnicas.dto.DatosDetalleHabilidadesTecnicasCategoria;
import com.makingbigger.portafoliojmc.services.HabilidadesTecnicasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
@RequiredArgsConstructor
public class HabilidadesTecnicasController {

    private final HabilidadesTecnicasService habilidadesTecnicasService;

    @GetMapping
    public ResponseEntity<List<DatosDetalleHabilidadesTecnicasCategoria>> getHabilidades() {
        return ResponseEntity.ok(habilidadesTecnicasService.listarHabilidades());
    }

}
