package com.pet.services;

import com.pet.model.casosModel;
import com.pet.repositories.casosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class casosService {
    @Autowired
    casosRepository casosRepository;


    public Optional<casosModel> casoPorId(int id){
        return casosRepository.findById(id);
    }
    public ArrayList<casosModel> allcasos(){
        return (ArrayList<casosModel>) casosRepository.findAll();
    }
    public List<casosModel> allcasosbytime(){
        return  casosRepository.findAll(Sort.by(Sort.Direction.DESC, "fecha"));
    }
    public casosModel savecaso(casosModel caso){
        return casosRepository.save(caso);
    }
    public Optional<casosModel> updatecaso(casosModel casou){


        Optional<casosModel> casoExistenteOpt = casosRepository.findById(casou.getId());

        // 2. Si no existe, devolvemos un Optional vacío
        if (casoExistenteOpt.isEmpty()) {
            return Optional.empty();
        }

        // 3. Si existe, actualizamos sus campos
        casosModel casoExistente = casoExistenteOpt.get();

        casoExistente.setTitulo(casou.getTitulo());
        casoExistente.setMascota(casou.getMascota());
        casoExistente.setDetalle(casou.getDetalle());
        casoExistente.setFecha(casou.getFecha());
         if (casou.getFotoi() != null) {
             casoExistente.setFotoi(casou.getFotoi());
         }
         if (casou.getFotof() != null) {
             casoExistente.setFotof(casou.getFotof());
         }

        return Optional.of(casosRepository.save(casoExistente));
    }
    public boolean eliminarcaso(int id){
        try{
            casosRepository.deleteById(id);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
