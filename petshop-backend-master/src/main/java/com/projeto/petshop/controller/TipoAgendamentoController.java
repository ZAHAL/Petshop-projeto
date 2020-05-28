package com.projeto.petshop.controller;

import com.projeto.petshop.service.TipoAgendamentoService;
import com.projeto.petshop.service.dto.EspecialidadeDTO;
import com.projeto.petshop.service.dto.TipoAgendamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TipoAgendamentoController {


    @Autowired
    private TipoAgendamentoService tipoAgendamentoService;

    @GetMapping("/tipoagendamento")
    public List<TipoAgendamentoDTO> get(){
        return tipoAgendamentoService.findAll();
    }
}
