package com.pet.services;

import com.pet.model.citasModel;
import com.pet.model.comblogModel;
import com.pet.repositories.comblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class comblogService {
    @Autowired
    comblogRepository comblogRepository;

    public ArrayList<comblogModel> obtenerComentarios(){
        return (ArrayList<comblogModel>)comblogRepository.findAll();
    }
    public comblogModel guardarComentario(comblogModel comentario){
        return comblogRepository.save(comentario);
    }
    public ArrayList<comblogModel> obtenerComentariosBlog(int idBlog){
        System.out.println("Consulta del servicio con id: "+idBlog);
        return comblogRepository.findByBlog(idBlog);
    }
    public boolean actualizarComentario(comblogModel comentariou){
        try{
            comblogRepository.save(comentariou);
            return true;
        }catch(Exception e){
            System.out.println("Error al actualizar el comentario: "+e.getMessage());
            return false;
        }
    }
    public boolean eliminarComentario(int idcom){
        try{
            comblogRepository.deleteById(idcom);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
