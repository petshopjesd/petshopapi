package com.pet.services;

import com.pet.model.blogsModel;
import com.pet.model.citasModel;
import com.pet.repositories.blogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class blogsService {
    @Autowired
    blogsRepository blogsRepository;

    public ArrayList<blogsModel> allblogs(){
        return (ArrayList<blogsModel>)blogsRepository.findAll();
    }
    public Optional<blogsModel> obtenerblogPorId(int id){
        return blogsRepository.findById(id);
    }
    public blogsModel saveblog(blogsModel blog){
        return blogsRepository.save(blog);
    }
    public boolean eliminarblog(int id){
        try{
            blogsRepository.deleteById(id);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;

        }
    }
}
