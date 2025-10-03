package com.pet.repositories;

import com.pet.model.userModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends CrudRepository<userModel, Integer> {

    @Query(value = "SELECT u FROM userModel u WHERE u.usuario =:usuario AND u.pass =:pass")
    Optional<userModel> findByUsuarioAndPass(String usuario, String pass);
}
