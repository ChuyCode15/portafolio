package com.makingbigger.portafoliojmc.services;

import com.makingbigger.portafoliojmc.domain.personalinfo.dto.PersonalInfoDetailDto;
import com.makingbigger.portafoliojmc.domain.personalinfo.personalinfomapper.PersonalInfoMapper;
import com.makingbigger.portafoliojmc.repository.PersonalInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonalInfoService {

    private final PersonalInfoRepository personalInfoRepository;

    private final PersonalInfoMapper personalInfoMapper;

    @Transactional(readOnly = true)
    public PersonalInfoDetailDto findPersonalInfo() {
        return personalInfoRepository.findFirstWithActiveSocialMedia()
                .map(personalInfoMapper::toDto)
                .orElseThrow(() -> new RuntimeException(
                        "Personal information not found / No se encontró la información personal"
                ));
    }

}
