package com.projeto.petshop.service.mapper;

import com.projeto.petshop.domain.Agenda;
import com.projeto.petshop.domain.Pet;
import com.projeto.petshop.domain.TipoAgendamento;
import com.projeto.petshop.domain.Veterinario;
import com.projeto.petshop.service.dto.AgendaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-27T23:11:58-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.5 (Private Build)"
)
@Component
public class AgendaMapperImpl implements AgendaMapper {

    @Override
    public List<Agenda> toEntity(List<AgendaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Agenda> list = new ArrayList<Agenda>( dtoList.size() );
        for ( AgendaDTO agendaDTO : dtoList ) {
            list.add( toEntity( agendaDTO ) );
        }

        return list;
    }

    @Override
    public List<AgendaDTO> toDto(List<Agenda> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AgendaDTO> list = new ArrayList<AgendaDTO>( entityList.size() );
        for ( Agenda agenda : entityList ) {
            list.add( toDto( agenda ) );
        }

        return list;
    }

    @Override
    public Agenda toEntity(AgendaDTO agendaDTO) {
        if ( agendaDTO == null ) {
            return null;
        }

        Agenda agenda = new Agenda();

        agenda.setTipoAgendamento( agendaDTOToTipoAgendamento( agendaDTO ) );
        agenda.setVeterinario( agendaDTOToVeterinario( agendaDTO ) );
        agenda.setPet( agendaDTOToPet( agendaDTO ) );
        agenda.setId( agendaDTO.getId() );
        agenda.setDataRegistro( agendaDTO.getDataRegistro() );
        agenda.setDataAgendamento( agendaDTO.getDataAgendamento() );

        return agenda;
    }

    @Override
    public AgendaDTO toDto(Agenda agenda) {
        if ( agenda == null ) {
            return null;
        }

        AgendaDTO agendaDTO = new AgendaDTO();

        agendaDTO.setTipoAgendamentoId( agendaTipoAgendamentoId( agenda ) );
        agendaDTO.setPetId( agendaPetId( agenda ) );
        agendaDTO.setPetNome( agendaPetNome( agenda ) );
        agendaDTO.setVeterinarioNome( agendaVeterinarioNome( agenda ) );
        agendaDTO.setTipoAgendamentoNome( agendaTipoAgendamentoTipo( agenda ) );
        agendaDTO.setVeterinarioId( agendaVeterinarioId( agenda ) );
        agendaDTO.setId( agenda.getId() );
        agendaDTO.setDataRegistro( agenda.getDataRegistro() );
        agendaDTO.setDataAgendamento( agenda.getDataAgendamento() );

        return agendaDTO;
    }

    protected TipoAgendamento agendaDTOToTipoAgendamento(AgendaDTO agendaDTO) {
        if ( agendaDTO == null ) {
            return null;
        }

        TipoAgendamento tipoAgendamento = new TipoAgendamento();

        tipoAgendamento.setId( agendaDTO.getTipoAgendamentoId() );
        tipoAgendamento.setTipo( agendaDTO.getTipoAgendamentoNome() );

        return tipoAgendamento;
    }

    protected Veterinario agendaDTOToVeterinario(AgendaDTO agendaDTO) {
        if ( agendaDTO == null ) {
            return null;
        }

        Veterinario veterinario = new Veterinario();

        veterinario.setNome( agendaDTO.getVeterinarioNome() );
        veterinario.setId( agendaDTO.getVeterinarioId() );

        return veterinario;
    }

    protected Pet agendaDTOToPet(AgendaDTO agendaDTO) {
        if ( agendaDTO == null ) {
            return null;
        }

        Pet pet = new Pet();

        pet.setId( agendaDTO.getPetId() );
        pet.setNome( agendaDTO.getPetNome() );

        return pet;
    }

    private Long agendaTipoAgendamentoId(Agenda agenda) {
        if ( agenda == null ) {
            return null;
        }
        TipoAgendamento tipoAgendamento = agenda.getTipoAgendamento();
        if ( tipoAgendamento == null ) {
            return null;
        }
        Long id = tipoAgendamento.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long agendaPetId(Agenda agenda) {
        if ( agenda == null ) {
            return null;
        }
        Pet pet = agenda.getPet();
        if ( pet == null ) {
            return null;
        }
        Long id = pet.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String agendaPetNome(Agenda agenda) {
        if ( agenda == null ) {
            return null;
        }
        Pet pet = agenda.getPet();
        if ( pet == null ) {
            return null;
        }
        String nome = pet.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private String agendaVeterinarioNome(Agenda agenda) {
        if ( agenda == null ) {
            return null;
        }
        Veterinario veterinario = agenda.getVeterinario();
        if ( veterinario == null ) {
            return null;
        }
        String nome = veterinario.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private String agendaTipoAgendamentoTipo(Agenda agenda) {
        if ( agenda == null ) {
            return null;
        }
        TipoAgendamento tipoAgendamento = agenda.getTipoAgendamento();
        if ( tipoAgendamento == null ) {
            return null;
        }
        String tipo = tipoAgendamento.getTipo();
        if ( tipo == null ) {
            return null;
        }
        return tipo;
    }

    private Long agendaVeterinarioId(Agenda agenda) {
        if ( agenda == null ) {
            return null;
        }
        Veterinario veterinario = agenda.getVeterinario();
        if ( veterinario == null ) {
            return null;
        }
        Long id = veterinario.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
