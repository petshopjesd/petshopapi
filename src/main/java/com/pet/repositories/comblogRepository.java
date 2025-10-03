package com.pet.repositories;

import com.pet.model.comblogModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface comblogRepository extends CrudRepository<comblogModel, Integer> {

    @Query(value = "SELECT c FROM comblogModel c WHERE c.idblog =:idblog")
    ArrayList<comblogModel> findByBlog(int idblog);
}
