package com.pet.services;

import com.pet.model.credencialesModel;
import com.pet.repositories.credencialesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class credencialesService {
    @Autowired
    credencialesRepository credencialesRepository;

    public ArrayList<credencialesModel> allcredenciales(){
        return (ArrayList<credencialesModel>) credencialesRepository.findAll();
    }
    public credencialesModel savecredencial(credencialesModel credenciales){
        return credencialesRepository.save(credenciales);
    }
    public boolean deletecredencial(int id){
        try{
            credencialesRepository.deleteById(id);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Optional<credencialesModel> updatecredencial (credencialesModel credencialu){
        Optional<credencialesModel> credencialExistenteAux = credencialesRepository.findById(credencialu.getId());
        if(credencialExistenteAux.isEmpty()){
            return Optional.empty();
        }
        credencialesModel credencialExistente =credencialExistenteAux.get();
        credencialExistente.setNombre(credencialu.getNombre());
        credencialExistente.setDescripcion(credencialu.getDescripcion());
        if(credencialu.getImg() != null){
            credencialExistente.setImg(credencialu.getImg());

        }
        return Optional.of(credencialesRepository.save(credencialExistente));
    }
}
