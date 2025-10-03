package com.pet.controller;

import com.pet.model.credencialesModel;
import com.pet.services.credencialesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/credenciales")
public class credencialesController {
    @Autowired
    credencialesService credencialesService;

    @GetMapping
    public ArrayList<credencialesModel> allcredenciales(){
        return credencialesService.allcredenciales();
    }
    @PostMapping
    public credencialesModel savecredencial(@RequestParam(value = "img", required = false) MultipartFile img,
                                            @RequestParam("nombre") String nombre,
                                            @RequestParam("descripcion") String descripcion) {
        try{
            credencialesModel credencial= new credencialesModel();
            credencial.setNombre(nombre);
            credencial.setDescripcion(descripcion);
            if(img != null && !img.isEmpty()) {
                credencial.setImg(img.getBytes());

            }
            return credencialesService.savecredencial(credencial);
            }catch(IOException e){
                throw new RuntimeException("Error al procesar los archivos subidos de credenciales.", e);
            }
    }
    @PutMapping
    public Optional<credencialesModel> updatecredencial(@RequestParam(value = "img", required = false) MultipartFile img,
                                                        @RequestParam("id") int id,
                                                        @RequestParam("nombre") String nombre,
                                                        @RequestParam("descripcion") String descripcion){
        try{
            credencialesModel credencial= new credencialesModel();
            credencial.setId(id);
            credencial.setNombre(nombre);
            credencial.setDescripcion(descripcion);
            if(img != null && !img.isEmpty()){
                credencial.setImg(img.getBytes());
            }
            return credencialesService.updatecredencial(credencial);

        }catch(IOException e){
            throw new RuntimeException("Error al procesar los archivos subidos de credenciales.", e);
        }
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletecredencial(@PathVariable("id") int id) {
        boolean ok = this.credencialesService.deletecredencial(id);
        if (ok) {
            return ResponseEntity.ok("Se eliminó la credencial con id " + id);
        } else {
            return ResponseEntity.status(404).body("No se encontró o no se pudo eliminar la credencial con id " + id);
        }
    }

}
