package com.projeto.petshop.service.mapper;

import com.projeto.petshop.domain.TipoAgendamento;
import com.projeto.petshop.service.dto.TipoAgendamentoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-27T23:11:58-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.5 (Private Build)"
)
@Component
public class TipoAgendamentoMapperImpl implements TipoAgendamentoMapper {

    @Override
    public TipoAgendamento toEntity(TipoAgendamentoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipoAgendamento tipoAgendamento = new TipoAgendamento();

        tipoAgendamento.setId( dto.getId() );
        tipoAgendamento.setTipo( dto.getTipo() );

        return tipoAgendamento;
    }

    @Override
    public TipoAgendamentoDTO toDto(TipoAgendamento entity) {
        if ( entity == null ) {
            return null;
        }

        TipoAgendamentoDTO tipoAgendamentoDTO = new TipoAgendamentoDTO();

        tipoAgendamentoDTO.setId( entity.getId() );
        tipoAgendamentoDTO.setTipo( entity.getTipo() );

        return tipoAgendamentoDTO;
    }

    @Override
    public List<TipoAgendamento> toEntity(List<TipoAgendamentoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TipoAgendamento> list = new ArrayList<TipoAgendamento>( dtoList.size() );
        for ( TipoAgendamentoDTO tipoAgendamentoDTO : dtoList ) {
            list.add( toEntity( tipoAgendamentoDTO ) );
        }

        return list;
    }

    @Override
    public List<TipoAgendamentoDTO> toDto(List<TipoAgendamento> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TipoAgendamentoDTO> list = new ArrayList<TipoAgendamentoDTO>( entityList.size() );
        for ( TipoAgendamento tipoAgendamento : entityList ) {
            list.add( toDto( tipoAgendamento ) );
        }

        return list;
    }
}
