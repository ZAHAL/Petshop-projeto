package com.projeto.petshop.repository;

import com.projeto.petshop.domain.Pet;
import com.projeto.petshop.domain.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
