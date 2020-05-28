package com.projeto.petshop.domain;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * TipoDominioFixo.
 */
@MappedSuperclass
public class TipoDominioFixo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tipo;

    @Id
    private Long id;


    /**
     * Atribui id.
     *
     * @param id Atribui o valor do parâmetro no atributo id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna tipo.
     *
     * @return Retorna o atributo tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Retorna id.
     *
     * @return Retorna o atributo id
     */
    public Long getId() {
        return id;
    }

    /**
     * Atribui tipo.
     *
     * @param tipo Atribui o valor do parâmetro no atributo tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
