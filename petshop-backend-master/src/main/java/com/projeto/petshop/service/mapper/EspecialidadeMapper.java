package com.projeto.petshop.service.mapper;

import com.projeto.petshop.domain.Especialidade;
import com.projeto.petshop.service.dto.EspecialidadeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EspecialidadeMapper extends EntityMapper<EspecialidadeDTO, Especialidade>{
}
