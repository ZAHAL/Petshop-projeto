package com.projeto.petshop.service;

import com.projeto.petshop.service.dto.VeterinarioDTO;

import java.text.ParseException;
import java.util.List;

public interface VeterinarioService {

    List<VeterinarioDTO> findAll();

    VeterinarioDTO save(VeterinarioDTO veterinarioDTO) throws ParseException;

    VeterinarioDTO findById(Long id);

    void deleteById(Long id);
}
