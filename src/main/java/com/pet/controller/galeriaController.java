package com.pet.controller;

import com.pet.model.galeriaModel;
import com.pet.services.galeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/galeria")
public class galeriaController {
    @Autowired
    galeriaService galeriaService;

    @GetMapping()
    public ArrayList<galeriaModel> allgaleria(){
        return galeriaService.allgaleria();
    }
    @GetMapping(path = "/{id}")
    public Optional<galeriaModel> galeriabyId(@PathVariable("id") int id){
        return this.galeriaService.galeriabyId(id);
    }
    @PostMapping()
    public galeriaModel savegaleria(@RequestBody galeriaModel galeria){
        return this.galeriaService.savegaleria(galeria);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteGaleria(@PathVariable("id") int id){
        boolean ok = this.galeriaService.deleteGaleria(id);
        if (ok) {
            return "Se elimino el blog con id " + id;
        } else {
            return "No pudo eliminar el blog con id" + id;
        }
    }
    @PutMapping()
    public Optional<galeriaModel> updateGaleria(@RequestBody galeriaModel galeria){
        return this.galeriaService.updategaleria(galeria);
    }

}
