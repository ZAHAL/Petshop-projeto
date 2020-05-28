package com.projeto.petshop.controller;

import com.projeto.petshop.service.PetService;
import com.projeto.petshop.service.VeterinarioService;
import com.projeto.petshop.service.dto.PetDTO;
import com.projeto.petshop.service.dto.VeterinarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/pets")
    public List<PetDTO> get(){
        return petService.findAll();
    }

   @GetMapping("/pet/{id}")
    public PetDTO show(@PathVariable Long id){
        return petService.findById(id);
    }

    @PostMapping("/pet")
    public PetDTO create(@RequestBody PetDTO body){
        return petService.save(body);
    }

    @PutMapping("/pet/editar")
    public PetDTO update(@RequestBody PetDTO body){
        return petService.save(body);
    }

    @DeleteMapping("pet/{id}")
    public boolean delete(@PathVariable Long id){
        petService.deleteById(id);
        return true;
    }


}
