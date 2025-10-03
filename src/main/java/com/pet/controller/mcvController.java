package com.pet.controller;

import com.pet.model.mcvModel;
import com.pet.services.mcvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/mcv")
public class mcvController {
    @Autowired
    mcvService mcvService;

    @GetMapping(path = "/{idm}")
    public ArrayList<mcvModel> allmcbyIdm(@PathVariable("idm") int idm){
        return mcvService.allmcbyIdm(idm);
    }
}
