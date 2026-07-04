package com.makingbigger.portafoliojmc.domain.redessociales.mapstruct;

import com.makingbigger.portafoliojmc.domain.redessociales.RedesSociales;
import com.makingbigger.portafoliojmc.domain.redessociales.dto.DatosDetalleRedesSociales;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RedesSocialesMapper.class})
public interface RedesSocialesMapper {

    @Mapping(source = "redesSociales", target = "socialLinks")
    DatosDetalleRedesSociales toDto(RedesSociales redesSociales);

    @Mapping(source = "redesSociales", target = "socialLinks")
    RedesSociales toEntity(RedesSociales redesSociales);

}
