package com.projeto.petshop.repository;

import com.projeto.petshop.domain.TipoAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAgendamentoRepository extends JpaRepository<TipoAgendamento, Long> {
}
