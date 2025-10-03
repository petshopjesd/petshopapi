package com.pet.controller;

import com.pet.model.citasModel;
import com.pet.model.comblogModel;
import com.pet.services.comblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/comblog")
public class comblogController {
    @Autowired
    comblogService comblogService;

    @GetMapping()
    public ArrayList<comblogModel> obtenerComentario(){
        return comblogService.obtenerComentarios();
    }
    @PostMapping
    public comblogModel guardarComentario(@RequestBody comblogModel comentario){
        return this.comblogService.guardarComentario(comentario);
    }
    @GetMapping(path = "/{idblog}")
    public ArrayList<comblogModel> obtenerPorIdblog(@PathVariable("idblog") int idblog){
        return this.comblogService.obtenerComentariosBlog(idblog);

    }

}
