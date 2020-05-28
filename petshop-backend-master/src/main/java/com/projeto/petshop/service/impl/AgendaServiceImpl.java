package com.projeto.petshop.service.impl;

import com.projeto.petshop.domain.Agenda;
import com.projeto.petshop.repository.EspecialidadeRepository;
import com.projeto.petshop.repository.AgendaRepository;
import com.projeto.petshop.service.AgendaService;
import com.projeto.petshop.service.dto.AgendaDTO;
import com.projeto.petshop.service.mapper.AgendaMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;

    private final AgendaMapper agendaMapper;

    public AgendaServiceImpl(AgendaRepository agendaRepository, AgendaMapper agendaMapper) {
        this.agendaRepository = agendaRepository;
        this.agendaMapper = agendaMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AgendaDTO save(AgendaDTO agendaDTO) {
        Agenda agenda = this.agendaMapper.toEntity(agendaDTO);
        this.agendaRepository.save(agenda);
        AgendaDTO agendaDTOSalva = agendaMapper.toDto(agenda);
        return agendaDTOSalva;
    }

    @Override
    public List<AgendaDTO> getJson() {
        List<AgendaDTO> res = this.agendaMapper.toDto(this.agendaRepository.findAll());
        for(int i=0; i < res.size(); i++) {
            res.get(i).setTitle("Agendamento de "+ res.get(i).getTipoAgendamentoNome() + " para o Pet "+ res.get(i).getPetNome()+ " com o/a Dr. " + res.get(i).getVeterinarioNome());
            res.get(i).setStart(res.get(i).getDataAgendamento().toString());
        }
        return res;
    }
}
