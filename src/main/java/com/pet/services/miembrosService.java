package com.pet.services;

import com.pet.model.miembrosModel;
import com.pet.repositories.miembrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class miembrosService {
    @Autowired
    miembrosRepository miembrosRepository;
    public ArrayList<miembrosModel> miembrosall(){
        return (ArrayList<miembrosModel>) miembrosRepository.findAll();
    }
    public miembrosModel saveMiembros(miembrosModel miembro){
        return miembrosRepository.save(miembro);
    }
    public Optional<miembrosModel> obtenerMiembroPorId(int id){
        return miembrosRepository.findById(id);
    }
    public boolean eliminarMiembro(int id){
        try{
            miembrosRepository.deleteById(id);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Optional<miembrosModel> updateMiembro(miembrosModel miembro){
        Optional<miembrosModel> miembroexistenteOpt = miembrosRepository.findById(miembro.getId());
        if(miembroexistenteOpt.isEmpty()){
            return Optional.empty();
        }
        miembrosModel miembroExiste =  miembroexistenteOpt.get();
        miembroExiste.setNombre(miembro.getNombre());
        miembroExiste.setTitulo(miembro.getTitulo());
        miembroExiste.setDetalle(miembro.getDetalle());
        if(miembro.getFoto() != null){
            miembroExiste.setFoto(miembro.getFoto());
        }
        return Optional.of(miembrosRepository.save(miembroExiste));
    }
}
