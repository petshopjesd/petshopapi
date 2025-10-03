package com.pet.repositories;

import com.pet.model.datosblogModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface datosblogRepository extends CrudRepository<datosblogModel, Integer> {
}
