package com.pet.repositories;

import com.pet.model.fotoModel;
import com.pet.model.userModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface fotoRepository extends JpaRepository<fotoModel, Integer> {

    @Query(value = "SELECT f FROM fotoModel f WHERE f.idgaleria =:idgaleria")
    ArrayList<fotoModel> fotofindbyidgaleria(int idgaleria);
}
