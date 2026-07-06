package com.makingbigger.portafoliojmc.domain.habilidadestecnicas.HabilidadesTecnicasMapper;

import com.makingbigger.portafoliojmc.domain.habilidadestecnicas.HabilidadesTecnicasCategoria;
import com.makingbigger.portafoliojmc.domain.habilidadestecnicas.dto.DatosRegistroHabilidadesTecnicasCategoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HabilidadesTecnicasMapper {

    HabilidadesTecnicasCategoria toEntity(DatosRegistroHabilidadesTecnicasCategoria dto);

}
