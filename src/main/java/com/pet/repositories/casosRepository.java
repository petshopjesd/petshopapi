package com.pet.repositories;

import com.pet.model.casosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface casosRepository extends JpaRepository<casosModel, Integer> {

}
