package com.makingbigger.portafoliojmc.controller.admin;

import com.makingbigger.portafoliojmc.domain.redessociales.dto.DatosActulizarRedesSociales;
import com.makingbigger.portafoliojmc.domain.redessociales.dto.DatosDetalleRedesSociales;
import com.makingbigger.portafoliojmc.domain.redessociales.dto.DatosRegistroRedesSociales;
import com.makingbigger.portafoliojmc.services.RedesSocialesSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/admin/socialLinks")
@RequiredArgsConstructor
public class RedesSocialesController {

    private final RedesSocialesSevice redesSocialesSevice;

    @GetMapping
    public ResponseEntity<List<DatosDetalleRedesSociales>> listarRedesSociales() {
        var listaRedesSociales = redesSocialesSevice.listarRedes();
        return ResponseEntity.ok(listaRedesSociales);
    }

    @PostMapping
    public ResponseEntity<DatosDetalleRedesSociales> registrarRedSocial(@RequestBody DatosRegistroRedesSociales datos, UriComponentsBuilder builder){
        var nuevaRed = redesSocialesSevice.registrarNuevaRed(datos);
        var uri = builder.path("/admin/socialLinks/{id}").buildAndExpand(nuevaRed).toUri();
        return ResponseEntity.created(uri).body(nuevaRed);
    }

    @PatchMapping(path = "/{plataforma}")
    public ResponseEntity<DatosDetalleRedesSociales> actulizarRedSocial(@PathVariable String plataforma, @RequestBody DatosActulizarRedesSociales datos) {
        var redActualizadad = redesSocialesSevice.actulizarRedSocial(plataforma, datos);
        return  ResponseEntity.ok(redActualizadad);
    }


}
