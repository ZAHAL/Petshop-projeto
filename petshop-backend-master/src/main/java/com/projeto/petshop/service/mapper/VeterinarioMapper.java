package com.projeto.petshop.service.mapper;

import com.projeto.petshop.domain.Veterinario;
import com.projeto.petshop.service.dto.VeterinarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VeterinarioMapper extends EntityMapper<VeterinarioDTO, Veterinario>{

    /**
     * {@inheritDoc}
     */
    @Override
    @Mapping(source = "especialidadeId", target = "especialidade.id")
    @Mapping(source = "cpf", target = "cpf")
    Veterinario toEntity(VeterinarioDTO veterinarioDTO);

    /**
     * {@inheritDoc}
     */
    @Override
    @Mapping(source = "especialidade.id", target = "especialidadeId")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "especialidade.tipo", target = "tipoEspecialidade")
    VeterinarioDTO toDto(Veterinario veterinario);

}
