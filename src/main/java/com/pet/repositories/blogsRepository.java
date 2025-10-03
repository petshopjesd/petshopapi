package com.pet.repositories;

import com.pet.model.blogsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface blogsRepository extends CrudRepository<blogsModel, Integer> {
}
