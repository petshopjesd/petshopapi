package com.pet.repositories;

import com.pet.model.citasModel;
import com.pet.model.mcvModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface mcvRepository extends JpaRepository<mcvModel, Integer> {

    //Lista de credenciales por id miembro
    List<mcvModel> findByidm(int idm);
}
