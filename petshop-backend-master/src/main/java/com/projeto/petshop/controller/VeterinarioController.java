package com.projeto.petshop.controller;

import com.projeto.petshop.service.VeterinarioService;
import com.projeto.petshop.service.dto.VeterinarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping("/veterinarios")
    public List<VeterinarioDTO> get(){
        return veterinarioService.findAll();
    }

   @GetMapping("/veterinario/{id}")
    public VeterinarioDTO show(@PathVariable Long id){
        return veterinarioService.findById(id);
    }

    @PostMapping("/veterinario")
    public VeterinarioDTO create(@RequestBody VeterinarioDTO body) throws ParseException {
        return veterinarioService.save(body);
    }

    @PutMapping("/veterinario/editar")
    public VeterinarioDTO update(@RequestBody VeterinarioDTO body) throws ParseException {
        return veterinarioService.save(body);
    }

    @DeleteMapping("veterinario/{id}")
    public boolean delete(@PathVariable Long id){
        veterinarioService.deleteById(id);
        return true;
    }


}
