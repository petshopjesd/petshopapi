package com.pet.repositories;

import com.pet.model.mcModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mcRepository  extends JpaRepository<mcModel, Integer> {

}
