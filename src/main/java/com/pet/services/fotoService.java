package com.pet.services;

import com.pet.model.fotoModel;
import com.pet.repositories.fotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class fotoService {
    @Autowired
    fotoRepository fotoRepository;
    public ArrayList<fotoModel> allfoto(){
        return (ArrayList<fotoModel>) fotoRepository.findAll();
    }
    public ArrayList<fotoModel> allfotobygalery(int idgaleria){
        return (ArrayList<fotoModel>) fotoRepository.fotofindbyidgaleria(idgaleria);
    }
    public fotoModel savefoto(fotoModel foto){
        return fotoRepository.save(foto);
    }
    public boolean deletefoto(int id){
        try{
            fotoRepository.deleteById(id);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Optional<fotoModel> updatefoto(fotoModel foto){
        Optional<fotoModel> fotoexistenteOpt = fotoRepository.findById(foto.getId());
        if(fotoexistenteOpt.isEmpty()){
            return Optional.empty();
        }
        fotoModel fotoExiste =  fotoexistenteOpt.get();
        fotoExiste.setIdgaleria(foto.getIdgaleria());
        fotoExiste.setNombre(foto.getNombre());
        if(foto.getFoto() != null){
            fotoExiste.setFoto(foto.getFoto());
        }
        return Optional.of(fotoRepository.save(fotoExiste));
    }

}
