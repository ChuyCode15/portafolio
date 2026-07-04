package com.makingbigger.portafoliojmc.domain.informacionersonal.informacionpersonalmapper;

import com.makingbigger.portafoliojmc.domain.informacionersonal.InformacionPersonal;
import com.makingbigger.portafoliojmc.domain.informacionersonal.dto.DatosDetalleInformacionPersonal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InformacionPersonalMapper {

    @Mapping(target = "perfil", ignore = true)
    DatosDetalleInformacionPersonal toDto(InformacionPersonal informacionPersonal);

    InformacionPersonal toEntity(DatosDetalleInformacionPersonal datosDetalleInformacionPersonal);

}
