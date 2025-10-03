package com.pet.services;

import com.pet.model.galeriaModel;
import com.pet.repositories.galeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class galeriaService {
    @Autowired
    galeriaRepository galeriaRepository;

    public ArrayList<galeriaModel> allgaleria(){
        return (ArrayList<galeriaModel>) galeriaRepository.findAll();
    }
    public Optional<galeriaModel> galeriabyId(int id){
        return galeriaRepository.findById(id);
    }
    public galeriaModel savegaleria(galeriaModel galeria){
        return galeriaRepository.save(galeria);
    }
    public Optional<galeriaModel> updategaleria(galeriaModel galeria){
        Optional<galeriaModel> galeriaAux = galeriaRepository.findById(galeria.getId());
        if(galeriaAux.isEmpty()){
            return null;
        }
        galeriaModel galeriaExistente = galeriaAux.get();
        galeriaExistente.setNombre(galeria.getNombre());
        galeriaExistente.setDetalle(galeria.getDetalle());
        galeriaExistente.setFecha(galeria.getFecha());

        return Optional.of(galeriaRepository.save(galeriaExistente));
    }
    public boolean deleteGaleria(int id){
        try{
            galeriaRepository.deleteById(id);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
