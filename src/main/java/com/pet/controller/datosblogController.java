package com.pet.controller;

import com.pet.model.citasModel;
import com.pet.model.datosblogModel;
import com.pet.services.datosblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/datosblog")

public class datosblogController {
    @Autowired
    datosblogService datosblogService;

    @GetMapping()
    public ArrayList<datosblogModel> obtenerBlogs(){
        return datosblogService.obtenerblogs();
    }

    @GetMapping(path = "/{idmyblog}")
    public Optional<datosblogModel> obtenerPorId(@PathVariable("idmyblog") int idmyblog){
        return  this.datosblogService.obtenerPorId(idmyblog);

    }
}
