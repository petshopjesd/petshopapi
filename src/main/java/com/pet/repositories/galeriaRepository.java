package com.pet.repositories;

import com.pet.model.galeriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface galeriaRepository extends JpaRepository<galeriaModel, Integer> {
}
