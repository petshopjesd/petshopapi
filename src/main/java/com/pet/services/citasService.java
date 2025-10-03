package com.pet.services;

import com.pet.model.citasModel;
import com.pet.model.comblogModel;
import com.pet.repositories.citasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class citasService {
    @Autowired
    citasRepository citasRepository;

    public ArrayList<citasModel> obtenerCitas(){
        return (ArrayList<citasModel>)citasRepository.findAll();
    }
    public List<citasModel> obtenerCitasDisponibles(LocalDate fecha){
        return citasRepository.findByFechaOrderByHoraAsc(fecha);
    }
    public List<citasModel> obtenerCitasDesdeHoy() {
        return citasRepository.findAllByFechaGreaterThanEqualOrderByFechaAscHoraAsc(LocalDate.now());
    }

    public citasModel guardarCita(citasModel cita) throws GeneralSecurityException, IOException {

        //agendarEnGoogleCalendar(cita);
        return citasRepository.save(cita);
    }
    public Optional<citasModel> obtenerPorId(int id){
        return citasRepository.findById(id);
    }
    public boolean eliminarCita(int id){
        try{
            citasRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
