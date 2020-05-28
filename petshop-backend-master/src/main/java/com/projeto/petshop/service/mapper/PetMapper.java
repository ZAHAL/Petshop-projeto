package com.projeto.petshop.service.mapper;

import com.projeto.petshop.domain.Pet;
import com.projeto.petshop.domain.Veterinario;
import com.projeto.petshop.service.dto.PetDTO;
import com.projeto.petshop.service.dto.VeterinarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetMapper extends EntityMapper<PetDTO, Pet>{

/*
    */
/**
     * {@inheritDoc}
     *//*

    @Override
    @Mapping(source = "petId", target = "pet.id")
    @Mapping(source = "id", target = "id")
    Pet toEntity(PetDTO petDTO);

    */
/**
     * {@inheritDoc}
     *//*

    @Override
    @Mapping(source = "pet.id", target = "petId")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "pet.raca", target = "racapet")
    PetDTO toDto(Pet pet);
*/

}
