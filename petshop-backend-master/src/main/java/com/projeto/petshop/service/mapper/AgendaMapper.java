package com.projeto.petshop.service.mapper;

import com.projeto.petshop.domain.Agenda;
import com.projeto.petshop.service.dto.AgendaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AgendaMapper extends EntityMapper<AgendaDTO, Agenda>{

    /**
     * {@inheritDoc}
     */
    @Override
    @Mapping(source = "veterinarioId", target = "veterinario.id")
    @Mapping(source = "tipoAgendamentoId", target = "tipoAgendamento.id")
    @Mapping(source = "veterinarioNome", target = "veterinario.nome")
    @Mapping(source = "tipoAgendamentoNome", target = "tipoAgendamento.tipo")
    @Mapping(source = "petId", target = "pet.id")
    @Mapping(source = "petNome", target = "pet.nome")
    Agenda toEntity(AgendaDTO agendaDTO);

    /**
     * {@inheritDoc}
     */
    @Override
    @Mapping(source = "veterinario.id", target = "veterinarioId")
    @Mapping(source = "tipoAgendamento.id", target = "tipoAgendamentoId")
    @Mapping(source = "veterinario.nome", target = "veterinarioNome")
    @Mapping(source = "tipoAgendamento.tipo", target = "tipoAgendamentoNome")
    @Mapping(source = "pet.id", target = "petId")
    @Mapping(source = "pet.nome", target = "petNome")
    AgendaDTO toDto(Agenda agenda);

}
