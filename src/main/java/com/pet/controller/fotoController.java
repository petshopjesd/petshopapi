package com.pet.controller;

import com.pet.model.fotoModel;
import com.pet.model.miembrosModel;
import com.pet.services.fotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/foto")
public class fotoController {
    @Autowired
    fotoService fotoService;
    @GetMapping()
    public ArrayList<fotoModel> allfoto(){
        return fotoService.allfoto();
    }
    @GetMapping(path = "/{idgaleria}")
    public ArrayList<fotoModel> allfotoidgaleria(@PathVariable("idgaleria") int idgaleria){
        return fotoService.allfotobygalery(idgaleria);
    }
    @PostMapping()
    public fotoModel savefoto(@RequestParam(value = "foto", required = false) MultipartFile foto,
                              @RequestParam("nombre") String nombre,
                              @RequestParam("idgaleria") int idgaleria){

        try {
            fotoModel mifoto = new fotoModel();
            mifoto.setIdgaleria(idgaleria);
            mifoto.setNombre(nombre);
            // Convertimos los MultipartFile a byte[]
            if (foto != null && !foto.isEmpty()) {
                mifoto.setFoto(foto.getBytes());
            }

            return this.fotoService.savefoto(mifoto);
        } catch (IOException e) {
            // Es una buena práctica manejar la excepción
            // Aquí podrías lanzar una excepción personalizada que resulte en un error 400 o 500
            throw new RuntimeException("Error al procesar los archivos subidos.", e);
        }
    }
    @DeleteMapping(path = "/{id}")
    public String deletefoto(@PathVariable("id") int id){
        boolean ok = this.fotoService.deletefoto(id);
        if (ok) {
            return "Se elimino el blog con id " + id;
        } else {
            return "No pudo eliminar el blog con id" + id;
        }
    }
    @PutMapping()
    public Optional<fotoModel> updatefoto(@RequestParam(value = "foto", required = false) MultipartFile foto,
                                          @RequestParam("nombre") String nombre,
                                          @RequestParam("idgaleria") int idgaleria,
                                          @RequestParam("id") int id){


        try {
            fotoModel mifoto = new fotoModel();
            mifoto.setId(id);
            mifoto.setIdgaleria(idgaleria);
            mifoto.setNombre(nombre);
            // Convertimos los MultipartFile a byte[]
            if (foto != null && !foto.isEmpty()) {
                mifoto.setFoto(foto.getBytes());
            }

            return this.fotoService.updatefoto(mifoto);
        } catch (IOException e) {
            // Es una buena práctica manejar la excepción
            // Aquí podrías lanzar una excepción personalizada que resulte en un error 400 o 500
            throw new RuntimeException("Error al procesar los archivos subidos.", e);
        }
    }
}
