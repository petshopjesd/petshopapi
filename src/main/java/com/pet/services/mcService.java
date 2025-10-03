package com.pet.services;

import com.pet.model.mcModel;
import com.pet.repositories.mcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class mcService {
    @Autowired
    mcRepository mcRepository;

    public mcModel savemc(mcModel mc){
        return mcRepository.save(mc);
    }
    public Optional<mcModel> updatemc(mcModel mcu){
        Optional<mcModel> mcExistenteOpt = mcRepository.findById(mcu.getId());
        if(mcExistenteOpt.isEmpty()){
            return null;
        }
        mcModel mcExistente = mcExistenteOpt.get();
        mcExistente.setIdm(mcu.getIdm());
        mcExistente.setIdc(mcu.getIdc());
        return Optional.of(mcRepository.save(mcExistente));

    }
    public boolean deletemc(int id) {
        try {
            mcRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
