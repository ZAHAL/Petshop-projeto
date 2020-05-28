package com.projeto.petshop.service.impl;

import com.projeto.petshop.domain.Especialidade;
import com.projeto.petshop.domain.Veterinario;
import com.projeto.petshop.repository.EspecialidadeRepository;
import com.projeto.petshop.repository.VeterinarioRepository;
import com.projeto.petshop.service.VeterinarioService;
import com.projeto.petshop.service.dto.VeterinarioDTO;
import com.projeto.petshop.service.mapper.VeterinarioMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    private final VeterinarioMapper veterinarioMapper;

    private final EspecialidadeRepository especialidadeRepository;

    public VeterinarioServiceImpl(VeterinarioRepository veterinarioRepository,
                                  VeterinarioMapper veterinarioMapper,
                                  EspecialidadeRepository especialidadeRepository) {
        this.veterinarioRepository = veterinarioRepository;
        this.veterinarioMapper = veterinarioMapper;
        this.especialidadeRepository = especialidadeRepository;
    }

    public List<VeterinarioDTO> findAll() {
        return veterinarioMapper.toDto(veterinarioRepository.findAll());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VeterinarioDTO save(VeterinarioDTO veterinarioDTO) throws ParseException {
        Veterinario veterinario = this.veterinarioMapper.toEntity(veterinarioDTO);
        especialidade(veterinarioDTO, veterinario);
        //formatarDataBack(veterinario, veterinarioDTO.getDataNascimento());
        this.veterinarioRepository.save(veterinario);
        VeterinarioDTO veterinarioDTOSalva = veterinarioMapper.toDto(veterinario);
        //formatarDataFront(veterinario, veterinarioDTOSalva);
        return veterinarioDTOSalva;
    }

    private void especialidade(VeterinarioDTO veterinarioDTO, Veterinario veterinario) {
        Especialidade especialidade = this.especialidadeRepository.findById(veterinarioDTO.getEspecialidadeId()).get();
        veterinario.setEspecialidade(especialidade);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VeterinarioDTO findById(Long id) {
       Veterinario veterinario = this.veterinarioRepository.findById(id).get();
        VeterinarioDTO veterinarioDTO = this.veterinarioMapper.toDto(veterinario);
        //formatarDataFront(veterinario, veterinarioDTO);
        return veterinarioDTO;
    }

    private void formatarDataFront(Veterinario veterinario, VeterinarioDTO veterinarioDTO) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String data = formatador.format(veterinario.getDataNascimento());
        veterinarioDTO.setDataFormatada(data);
    }

    private void formatarDataBack(Veterinario veterinario, String dataNascimento) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse(dataNascimento);
        veterinario.setDataNascimento(data);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        this.veterinarioRepository.deleteById(id);
    }




}
