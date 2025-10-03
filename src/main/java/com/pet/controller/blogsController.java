package com.pet.controller;

import com.pet.model.blogsModel;
import com.pet.services.blogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class blogsController {
    @Autowired
    blogsService blogsService;

    @GetMapping()
    public ArrayList<blogsModel> allblogs(){
        return blogsService.allblogs();
    }
    @PostMapping
    public blogsModel saveblog(@RequestBody blogsModel blog){
        return this.blogsService.saveblog(blog);
    }

    @GetMapping(path = "/{id}")
    public Optional<blogsModel> obtenerblogPorId(@PathVariable("id") int id){
        return this.blogsService.obtenerblogPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarblogPorId(@PathVariable("id") int id) {
        boolean ok = this.blogsService.eliminarblog(id);
        if (ok) {
            return "Se elimino el blog con id " + id;
        } else {
            return "No pudo eliminar el blog con id" + id;
        }
    }

}
