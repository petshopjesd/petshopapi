package com.pet.services;

import com.pet.model.citasModel;
import com.pet.model.datosblogModel;
import com.pet.repositories.datosblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class datosblogService {
    @Autowired
    datosblogRepository datosblogRepository;

    public ArrayList<datosblogModel> obtenerblogs(){
        return (ArrayList<datosblogModel>)datosblogRepository.findAll();
    }
    public Optional<datosblogModel> obtenerPorId(int idmyblog){
        return datosblogRepository.findById(idmyblog);
    }
}
