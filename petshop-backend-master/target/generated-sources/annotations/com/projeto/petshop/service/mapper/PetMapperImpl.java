package com.projeto.petshop.service.mapper;

import com.projeto.petshop.domain.Pet;
import com.projeto.petshop.service.dto.PetDTO;
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
public class PetMapperImpl implements PetMapper {

    @Override
    public Pet toEntity(PetDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Pet pet = new Pet();

        pet.setId( dto.getId() );
        pet.setEspecie( dto.getEspecie() );
        pet.setGenero( dto.getGenero() );
        pet.setRaca( dto.getRaca() );
        pet.setIdade( dto.getIdade() );
        pet.setNome( dto.getNome() );

        return pet;
    }

    @Override
    public PetDTO toDto(Pet entity) {
        if ( entity == null ) {
            return null;
        }

        PetDTO petDTO = new PetDTO();

        petDTO.setId( entity.getId() );
        petDTO.setNome( entity.getNome() );
        petDTO.setEspecie( entity.getEspecie() );
        petDTO.setGenero( entity.getGenero() );
        petDTO.setRaca( entity.getRaca() );
        petDTO.setIdade( entity.getIdade() );

        return petDTO;
    }

    @Override
    public List<Pet> toEntity(List<PetDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Pet> list = new ArrayList<Pet>( dtoList.size() );
        for ( PetDTO petDTO : dtoList ) {
            list.add( toEntity( petDTO ) );
        }

        return list;
    }

    @Override
    public List<PetDTO> toDto(List<Pet> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PetDTO> list = new ArrayList<PetDTO>( entityList.size() );
        for ( Pet pet : entityList ) {
            list.add( toDto( pet ) );
        }

        return list;
    }
}
