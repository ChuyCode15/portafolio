package com.makingbigger.portafoliojmc.domain.habilidadestecnicas.HabilidadesTecnicasMapper;

import com.makingbigger.portafoliojmc.domain.habilidadestecnicas.HabilidadesTecnicasCategoria;
import com.makingbigger.portafoliojmc.domain.habilidadestecnicas.dto.DatosDetalleHabilidadesTecnicasCategoria;
import com.makingbigger.portafoliojmc.domain.habilidadestecnicas.dto.DatosRegistroHabilidadesTecnicasCategoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {HabilidadesTecnicasMapper.class})
public interface HabilidadesTecnicasCategoriaMapper {

    HabilidadesTecnicasCategoria toEntity(DatosRegistroHabilidadesTecnicasCategoria dto);

    DatosDetalleHabilidadesTecnicasCategoria toDto(HabilidadesTecnicasCategoria entity);

}
