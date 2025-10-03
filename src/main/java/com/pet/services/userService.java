package com.pet.services;

import com.pet.model.serviciosModel;
import com.pet.model.userModel;
import com.pet.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class userService {
    @Autowired
    userRepository userRepository;
    public ArrayList<userModel> alluser(){
        return (ArrayList<userModel>)userRepository.findAll();
    }
    public Optional<userModel> userbyid(String id){
        return userRepository.findById(Integer.parseInt(id));
    }
    public Optional<userModel> validaUser(String usuario, String pass) {
        return userRepository.findByUsuarioAndPass(usuario, pass);
    }
    public Optional<userModel> saveuser(userModel user){
         return Optional.of(userRepository.save(user));
    }
    public Optional<userModel> updateuser(userModel user){
        Optional<userModel> userAux = userRepository.findById(user.getIduser());
        if(userAux.isEmpty()) {
            return null;
        }
        userModel userExistente = userAux.get();
        userExistente.setName(user.getName());
        userExistente.setApellido(user.getApellido());
        userExistente.setUsuario(user.getUsuario());
        userExistente.setPass(user.getPass());
        userExistente.setEmail(user.getEmail());
        userExistente.setPcasos(user.getPcasos());
        userExistente.setPcitas(user.getPcitas());
        userExistente.setPcredenciales(user.getPcredenciales());
        userExistente.setPgaleria(user.getPgaleria());
        userExistente.setPmiembros(user.getPmiembros());
        userExistente.setPservicios(user.getPservicios());
        userExistente.setPusuarios(user.getPusuarios());
        userExistente.setFechaupdate(user.getFechaupdate());

        return Optional.of(userRepository.save(userExistente));

    }
    public boolean deleteuser(int id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
