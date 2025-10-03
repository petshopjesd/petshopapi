package com.pet.repositories;

import com.pet.model.serviciosModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface serviciosRepository extends CrudRepository<serviciosModel, Integer> {
    List<serviciosModel> findByEstatus(int estatus);
}
