package com.pet.services;

import com.pet.model.mcvModel;
import com.pet.repositories.mcvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class mcvService {
    @Autowired
    mcvRepository mcvRepository;

    public ArrayList<mcvModel> allmcbyIdm(int idm){
        return (ArrayList<mcvModel>) mcvRepository.findByidm(idm);
    }
}
