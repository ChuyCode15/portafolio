package com.makingbigger.portafoliojmc.controller;

import com.makingbigger.portafoliojmc.domain.personalinfo.dto.PersonalInfoDetailDto;
import com.makingbigger.portafoliojmc.services.PersonalInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor

public class InformacionPersonalController {

    private final PersonalInfoService personalInfoService;

    @GetMapping
    public ResponseEntity<PersonalInfoDetailDto> getInformacionPersonal(){
        var datosInformacionPersonal = personalInfoService.findPersonalInfo();
        return ResponseEntity.ok(datosInformacionPersonal);
    }

}
