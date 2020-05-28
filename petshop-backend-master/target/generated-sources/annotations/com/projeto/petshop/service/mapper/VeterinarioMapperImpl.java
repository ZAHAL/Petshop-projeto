package com.projeto.petshop.service.mapper;

import com.projeto.petshop.domain.Especialidade;
import com.projeto.petshop.domain.Veterinario;
import com.projeto.petshop.service.dto.VeterinarioDTO;
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
public class VeterinarioMapperImpl implements VeterinarioMapper {

    @Override
    public List<Veterinario> toEntity(List<VeterinarioDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Veterinario> list = new ArrayList<Veterinario>( dtoList.size() );
        for ( VeterinarioDTO veterinarioDTO : dtoList ) {
            list.add( toEntity( veterinarioDTO ) );
        }

        return list;
    }

    @Override
    public List<VeterinarioDTO> toDto(List<Veterinario> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<VeterinarioDTO> list = new ArrayList<VeterinarioDTO>( entityList.size() );
        for ( Veterinario veterinario : entityList ) {
            list.add( toDto( veterinario ) );
        }

        return list;
    }

    @Override
    public Veterinario toEntity(VeterinarioDTO veterinarioDTO) {
        if ( veterinarioDTO == null ) {
            return null;
        }

        Veterinario veterinario = new Veterinario();

        veterinario.setEspecialidade( veterinarioDTOToEspecialidade( veterinarioDTO ) );
        veterinario.setCpf( veterinarioDTO.getCpf() );
        veterinario.setId( veterinarioDTO.getId() );
        veterinario.setNome( veterinarioDTO.getNome() );
        veterinario.setDataNascimento( veterinarioDTO.getDataNascimento() );
        veterinario.setSexo( veterinarioDTO.getSexo() );

        return veterinario;
    }

    @Override
    public VeterinarioDTO toDto(Veterinario veterinario) {
        if ( veterinario == null ) {
            return null;
        }

        VeterinarioDTO veterinarioDTO = new VeterinarioDTO();

        veterinarioDTO.setCpf( veterinario.getCpf() );
        veterinarioDTO.setTipoEspecialidade( veterinarioEspecialidadeTipo( veterinario ) );
        veterinarioDTO.setEspecialidadeId( veterinarioEspecialidadeId( veterinario ) );
        veterinarioDTO.setId( veterinario.getId() );
        veterinarioDTO.setNome( veterinario.getNome() );
        veterinarioDTO.setDataNascimento( veterinario.getDataNascimento() );
        veterinarioDTO.setSexo( veterinario.getSexo() );

        return veterinarioDTO;
    }

    protected Especialidade veterinarioDTOToEspecialidade(VeterinarioDTO veterinarioDTO) {
        if ( veterinarioDTO == null ) {
            return null;
        }

        Especialidade especialidade = new Especialidade();

        especialidade.setId( veterinarioDTO.getEspecialidadeId() );

        return especialidade;
    }

    private String veterinarioEspecialidadeTipo(Veterinario veterinario) {
        if ( veterinario == null ) {
            return null;
        }
        Especialidade especialidade = veterinario.getEspecialidade();
        if ( especialidade == null ) {
            return null;
        }
        String tipo = especialidade.getTipo();
        if ( tipo == null ) {
            return null;
        }
        return tipo;
    }

    private Long veterinarioEspecialidadeId(Veterinario veterinario) {
        if ( veterinario == null ) {
            return null;
        }
        Especialidade especialidade = veterinario.getEspecialidade();
        if ( especialidade == null ) {
            return null;
        }
        Long id = especialidade.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
