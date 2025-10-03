package com.pet.services;

import com.pet.model.serviciosModel;
import com.pet.repositories.serviciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class serviciosService {
    @Autowired
    serviciosRepository serviciosRepository;
    public ArrayList<serviciosModel> allservicios(){
        return (ArrayList<serviciosModel>)serviciosRepository.findAll();
    }
    public Optional<serviciosModel> servicioPorId(int id){
        return serviciosRepository.findById(id);
    }
    public List<serviciosModel> serviciosPorEstatus(int estatus){
        return serviciosRepository.findByEstatus(estatus);
    }
    public serviciosModel saveservicio(serviciosModel servicios){
        return serviciosRepository.save(servicios);
    }
    public serviciosModel updateservicio(serviciosModel servicios){
        Optional<serviciosModel> serviciosexistenteOpt = serviciosRepository.findById(servicios.getId());
        if(serviciosexistenteOpt.isEmpty()){
            return null;
        }
        serviciosModel servicioExiste =  serviciosexistenteOpt.get();
        servicioExiste.setNombre(servicios.getNombre());
        servicioExiste.setIcono(servicios.getIcono());
        servicioExiste.setEstatus(servicios.getEstatus());
        servicioExiste.setDescripcion(servicios.getDescripcion());
        return serviciosRepository.save(servicioExiste);
    }
    public boolean eliminarservicio(int id){
        try{
            serviciosRepository.deleteById(id);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;

        }
    }
}
