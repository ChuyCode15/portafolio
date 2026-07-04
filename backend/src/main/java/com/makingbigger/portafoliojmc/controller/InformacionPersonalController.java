package com.makingbigger.portafoliojmc.controller;

import com.makingbigger.portafoliojmc.domain.informacionpersonal.dto.DatosDetalleInformacionPersonal;
import com.makingbigger.portafoliojmc.services.InformacionPersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor

public class InformacionPersonalController {

    private final InformacionPersonalService informacionPersonalService;

    @GetMapping
    public ResponseEntity<DatosDetalleInformacionPersonal> getInformacionPersonal(){
        var datosInformacionPersonal = informacionPersonalService.buscarInformacionPersonal();
        return ResponseEntity.ok(datosInformacionPersonal);
    }

}
