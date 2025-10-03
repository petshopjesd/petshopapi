package com.pet.controller;

import com.pet.model.serviciosModel;
import com.pet.services.serviciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/servicios")
public class serviciosController {
    @Autowired
    serviciosService serviciosService;

    @GetMapping()
    public ArrayList<serviciosModel> allservicioss(){
        return serviciosService.allservicios();
    }
    @GetMapping(path = "/estatus/{estatus}")
    public ArrayList<serviciosModel> serviciosPorEstatus(@PathVariable("estatus") int estatus){
        return (ArrayList<serviciosModel>) this.serviciosService.serviciosPorEstatus(estatus);
    }
    @PostMapping
    public serviciosModel saveservicios(@RequestBody serviciosModel servicios){
        return this.serviciosService.saveservicio(servicios);
    }
    @PutMapping()
    public serviciosModel updateservicios(@RequestBody serviciosModel servicios){
        return this.serviciosService.updateservicio(servicios);
    }

    @GetMapping(path = "/{id}")
    public Optional<serviciosModel> obtenerserviciosPorId(@PathVariable("id") int id){
        return this.serviciosService.servicioPorId(id);

    }

    @DeleteMapping(path = "/{id}")
    public String eliminarserviciosPorId(@PathVariable("id") int id) {
        boolean ok = this.serviciosService.eliminarservicio(id);
        if (ok) {
            return "Se elimino el servicios con id " + id;
        } else {
            return "No pudo eliminar el servicios con id" + id;
        }
    }
}
