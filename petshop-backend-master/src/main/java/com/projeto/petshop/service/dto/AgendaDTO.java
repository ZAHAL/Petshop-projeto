package com.projeto.petshop.service.dto;

import java.util.Date;

public class AgendaDTO {

    private Long id;
    private Date dataRegistro;
    private Date dataAgendamento;
    private Long veterinarioId;
    private Long tipoAgendamentoId;
    private String veterinarioNome;
    private String tipoAgendamentoNome;
    private String petNome;
    private Long petId;
    private String title;
    private String start;


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

    public Long getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(Long veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    public Long getTipoAgendamentoId() {
        return tipoAgendamentoId;
    }

    public void setTipoAgendamentoId(Long tipoAgendamentoId) {
        this.tipoAgendamentoId = tipoAgendamentoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getVeterinarioNome() {
        return veterinarioNome;
    }

    public void setVeterinarioNome(String veterinarioNome) {
        this.veterinarioNome = veterinarioNome;
    }

    public String getTipoAgendamentoNome() {
        return tipoAgendamentoNome;
    }

    public void setTipoAgendamentoNome(String tipoAgendamentoNome) {
        this.tipoAgendamentoNome = tipoAgendamentoNome;
    }

    public String getPetNome() {
        return petNome;
    }

    public void setPetNome(String petNome) {
        this.petNome = petNome;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }
}
