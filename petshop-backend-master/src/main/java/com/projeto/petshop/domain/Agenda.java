package com.projeto.petshop.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AGENDA")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DATA_REGISTRO", nullable = false)
    private Date dataRegistro;

    @Column(name = "DATA_AGENDAMENTO", nullable = false)
    private Date dataAgendamento;

    @JoinColumn(name = "VETERINARIO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Veterinario veterinario;

    @JoinColumn(name = "TIPO_AGENDAMENTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoAgendamento tipoAgendamento;

    @JoinColumn(name = "PET_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pet pet;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public TipoAgendamento getTipoAgendamento() {
        return tipoAgendamento;
    }

    public void setTipoAgendamento(TipoAgendamento tipoAgendamento) {
        this.tipoAgendamento = tipoAgendamento;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id=" + id +
                ", dataRegistro=" + dataRegistro +
                ", dataAgendamento=" + dataAgendamento +
                ", veterinario=" + veterinario +
                ", tipoAgendamento=" + tipoAgendamento +
                ", pet=" + pet +
                '}';
    }
}

