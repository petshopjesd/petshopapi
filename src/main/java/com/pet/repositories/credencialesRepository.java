package com.pet.repositories;

import com.pet.model.credencialesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface credencialesRepository extends JpaRepository<credencialesModel, Integer> {
}
