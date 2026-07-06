package com.makingbigger.portafoliojmc.domain.redessociales.mapstruct;

import com.makingbigger.portafoliojmc.domain.redessociales.RedesSociales;
import com.makingbigger.portafoliojmc.domain.redessociales.dto.DatosDetalleRedesSociales;
import com.makingbigger.portafoliojmc.domain.redessociales.dto.DatosRegistroRedesSociales;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RedesSocialesMapper {


    DatosDetalleRedesSociales toDto(RedesSociales redesSociales);

    RedesSociales toNewEntity(DatosRegistroRedesSociales datos);

    @Mapping(target = "perfil", ignore = true)
    RedesSociales toEntity(DatosDetalleRedesSociales dto);

}
