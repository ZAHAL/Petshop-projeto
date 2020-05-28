package com.projeto.petshop.controller;

import com.projeto.petshop.service.AgendaService;
import com.projeto.petshop.service.dto.AgendaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping("/agenda")
    public AgendaDTO create(@RequestBody AgendaDTO body) {
        return agendaService.save(body);
    }

    @GetMapping("/agenda/json")
    public ResponseEntity<List<AgendaDTO>> getUserById() {
        List<AgendaDTO> response = this.agendaService.getJson();
        return ResponseEntity.ok().body(response);
    }

}
