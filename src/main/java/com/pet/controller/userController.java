package com.pet.controller;

import com.pet.model.userModel;
import com.pet.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    userService userService;

    @GetMapping
    public ArrayList<userModel> alluser(){
        return this.userService.alluser();
    }
    @GetMapping(path = "/{iduser}")
    public Optional<userModel> obteneruserporId(@PathVariable("iduser") String id){
        return this.userService.userbyid(id);
    }
    @GetMapping(path = "/valida")
    public Optional<userModel> validarUser(@RequestParam("usuario") String usuario, @RequestParam("pass") String pass){
        return this.userService.validaUser(usuario, pass);
    }
    @PostMapping
    public Optional<userModel> saveuser(@RequestBody userModel user){
        return this.userService.saveuser(user);
    }
    @PutMapping
    public Optional<userModel> updateuser(@RequestBody userModel user){
        return this.userService.updateuser(user);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteuser(@PathVariable("id") int id){
        boolean ok = this.userService.deleteuser(id);
        if (ok) {
            return "Se elimino el servicios con id " + id;
        } else {
            return "No pudo eliminar el servicios con id" + id;
        }
    }

}

