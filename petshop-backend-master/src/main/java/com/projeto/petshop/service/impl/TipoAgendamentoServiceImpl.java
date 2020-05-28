package com.projeto.petshop.service.impl;

import com.projeto.petshop.repository.TipoAgendamentoRepository;
import com.projeto.petshop.service.TipoAgendamentoService;
import com.projeto.petshop.service.dto.TipoAgendamentoDTO;
import com.projeto.petshop.service.mapper.TipoAgendamentoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAgendamentoServiceImpl implements TipoAgendamentoService {
    
    private final TipoAgendamentoRepository tipoAgendamentoRepository;
    private final TipoAgendamentoMapper tipoAgendamentoMapper;

    public TipoAgendamentoServiceImpl(TipoAgendamentoRepository tipoAgendamentoRepository, TipoAgendamentoMapper tipoAgendamentoMapper) {
        this.tipoAgendamentoRepository = tipoAgendamentoRepository;
        this.tipoAgendamentoMapper = tipoAgendamentoMapper;
    }

    public List<TipoAgendamentoDTO> findAll() {
        return tipoAgendamentoMapper.toDto(tipoAgendamentoRepository.findAll());
    }
}
