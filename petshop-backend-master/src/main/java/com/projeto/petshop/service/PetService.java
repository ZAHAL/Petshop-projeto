package com.projeto.petshop.service;

import com.projeto.petshop.service.dto.PetDTO;

import java.util.List;

public interface PetService {

    List<PetDTO> findAll();

    PetDTO save(PetDTO PetDTO);

    PetDTO findById(Long id);

    void deleteById(Long id);
}
