package com.projeto.petshop.service;

import com.projeto.petshop.service.dto.AgendaDTO;

import java.util.List;

public interface AgendaService {

    AgendaDTO save(AgendaDTO agendaDTO);
    List<AgendaDTO> getJson();
}
