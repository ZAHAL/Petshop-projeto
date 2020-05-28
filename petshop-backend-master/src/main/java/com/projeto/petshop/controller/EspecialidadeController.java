package com.projeto.petshop.controller;

import com.projeto.petshop.service.EspecialidadeService;
import com.projeto.petshop.service.dto.EspecialidadeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @GetMapping("/especialidades")
    public List<EspecialidadeDTO> get(){
        return especialidadeService.findAll();
    }
}
