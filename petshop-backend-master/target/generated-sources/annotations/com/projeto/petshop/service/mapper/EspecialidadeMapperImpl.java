package com.projeto.petshop.service.mapper;

import com.projeto.petshop.domain.Especialidade;
import com.projeto.petshop.service.dto.EspecialidadeDTO;
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
public class EspecialidadeMapperImpl implements EspecialidadeMapper {

    @Override
    public Especialidade toEntity(EspecialidadeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Especialidade especialidade = new Especialidade();

        especialidade.setId( dto.getId() );
        especialidade.setTipo( dto.getTipo() );

        return especialidade;
    }

    @Override
    public EspecialidadeDTO toDto(Especialidade entity) {
        if ( entity == null ) {
            return null;
        }

        EspecialidadeDTO especialidadeDTO = new EspecialidadeDTO();

        especialidadeDTO.setId( entity.getId() );
        especialidadeDTO.setTipo( entity.getTipo() );

        return especialidadeDTO;
    }

    @Override
    public List<Especialidade> toEntity(List<EspecialidadeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Especialidade> list = new ArrayList<Especialidade>( dtoList.size() );
        for ( EspecialidadeDTO especialidadeDTO : dtoList ) {
            list.add( toEntity( especialidadeDTO ) );
        }

        return list;
    }

    @Override
    public List<EspecialidadeDTO> toDto(List<Especialidade> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EspecialidadeDTO> list = new ArrayList<EspecialidadeDTO>( entityList.size() );
        for ( Especialidade especialidade : entityList ) {
            list.add( toDto( especialidade ) );
        }

        return list;
    }
}
