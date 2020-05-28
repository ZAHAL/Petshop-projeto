package com.projeto.petshop.domain;

import javax.persistence.*;

@Entity
@Table(name = "PET")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 60)
    private String nome;

    @Column(name = "ESPECIE", length = 10, nullable = false)
    private String especie;

    @Column(name = "GENERO", nullable = false, length = 1)
    private String genero;

    @Column(name = "RACA", nullable = false, length = 60)
    private String raca;

    @Column(name = "IDADE", nullable = false, length = 14)
    private Integer idade;

    @Column(name = "NOME_CLIENTE", nullable = false, length = 60)
    private String nomeCliente;


    public Pet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", genero='" + genero + '\'' +
                ", raca='" + raca + '\'' +
                ", idade=" + idade +
                ", nomeCliente='" + nomeCliente + '\'' +
                '}';
    }
}
