package com.makingbigger.portafoliojmc.domain.informacionpersonal.informacionpersonalmapper;

import com.makingbigger.portafoliojmc.domain.informacionpersonal.InformacionPersonal;
import com.makingbigger.portafoliojmc.domain.informacionpersonal.dto.DatosDetalleInformacionPersonal;
import com.makingbigger.portafoliojmc.domain.redessociales.mapstruct.RedesSocialesMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RedesSocialesMapper.class})
public interface InformacionPersonalMapper {


    DatosDetalleInformacionPersonal toDto(InformacionPersonal informacionPersonal);


    InformacionPersonal toEntity(DatosDetalleInformacionPersonal datosDetalleInformacionPersonal);

}
