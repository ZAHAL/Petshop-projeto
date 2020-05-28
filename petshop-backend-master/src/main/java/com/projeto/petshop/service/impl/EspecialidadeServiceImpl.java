package com.projeto.petshop.service.impl;

import com.projeto.petshop.repository.EspecialidadeRepository;
import com.projeto.petshop.service.EspecialidadeService;
import com.projeto.petshop.service.dto.EspecialidadeDTO;
import com.projeto.petshop.service.mapper.EspecialidadeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeServiceImpl implements EspecialidadeService {
    
    private final EspecialidadeRepository especialidadeRepository;
    private final EspecialidadeMapper especialidadeMapper;

    public EspecialidadeServiceImpl(EspecialidadeRepository especialidadeRepository, EspecialidadeMapper especialidadeMapper) {
        this.especialidadeRepository = especialidadeRepository;
        this.especialidadeMapper = especialidadeMapper;
    }

    public List<EspecialidadeDTO> findAll() {
        return especialidadeMapper.toDto(especialidadeRepository.findAll());
    }
}
