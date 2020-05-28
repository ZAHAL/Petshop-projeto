package com.projeto.petshop.service.mapper;

import com.projeto.petshop.domain.TipoAgendamento;
import com.projeto.petshop.service.dto.TipoAgendamentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TipoAgendamentoMapper extends EntityMapper<TipoAgendamentoDTO, TipoAgendamento>{

}
