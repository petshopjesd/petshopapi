package com.pet.controller;

import com.pet.model.mcModel;
import com.pet.services.mcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/miembrocred")
public class mcController {
    @Autowired
    mcService mcService;

    @PostMapping()
    public mcModel savemc(@RequestBody mcModel mc){
            return this.mcService.savemc(mc);
    }
    @PutMapping()
    public Optional<mcModel> updatemc(@RequestBody mcModel mcu){
        return this.mcService.updatemc(mcu);
    }
    @DeleteMapping(path = "/{id}")
    public boolean deletemc(@PathVariable("id") int id){
        return this.mcService.deletemc(id);
    }

}
