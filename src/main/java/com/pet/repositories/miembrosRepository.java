package com.pet.repositories;

import com.pet.model.miembrosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface miembrosRepository extends JpaRepository<miembrosModel, Integer> {
}
