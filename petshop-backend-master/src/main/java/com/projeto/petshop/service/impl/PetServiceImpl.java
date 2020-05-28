package com.projeto.petshop.service.impl;

import com.projeto.petshop.domain.Pet;
import com.projeto.petshop.domain.Veterinario;
import com.projeto.petshop.repository.PetRepository;
import com.projeto.petshop.repository.VeterinarioRepository;
import com.projeto.petshop.service.PetService;
import com.projeto.petshop.service.VeterinarioService;
import com.projeto.petshop.service.dto.PetDTO;
import com.projeto.petshop.service.dto.VeterinarioDTO;
import com.projeto.petshop.service.mapper.PetMapper;
import com.projeto.petshop.service.mapper.VeterinarioMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    private final PetMapper petMapper;

    public PetServiceImpl(PetRepository petRepository,
                          PetMapper petMapper) {
        this.petRepository = petRepository;
        this.petMapper = petMapper;
    }

    public List<PetDTO> findAll() {
        return petMapper.toDto(petRepository.findAll());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PetDTO save(PetDTO petDTO) {
        Pet pet = this.petMapper.toEntity(petDTO);
        this.petRepository.save(pet);
        PetDTO petSalvar = petMapper.toDto(pet);
        return petSalvar;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PetDTO findById(Long id) {
        Optional<Pet> pet = this.petRepository.findById(id);
        PetDTO petDto = this.petMapper.toDto(pet.get());
        return petDto;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        this.petRepository.deleteById(id);
    }




}
