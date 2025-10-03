package com.pet.repositories;

import com.pet.model.citasModel;
import org.springframework.data.jpa.repository.JpaRepository; // 1. Usa JpaRepository
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List; // 2. Usa la interfaz List

@Repository
public interface citasRepository extends JpaRepository<citasModel, Integer> { // 1.

    // El método ahora acepta LocalDate y devuelve una List (más limpio)
    List<citasModel> findByFechaOrderByHoraAsc(LocalDate fecha);

    // Este método ya estaba bien, ahora funcionará correctamente con el modelo actualizado
    List<citasModel> findAllByFechaGreaterThanEqualOrderByFechaAscHoraAsc(LocalDate date);
}