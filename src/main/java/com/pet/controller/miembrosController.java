package com.pet.controller;

import com.pet.model.miembrosModel;
import com.pet.services.miembrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/miembros")
public class miembrosController {
    @Autowired
    miembrosService miembrosService;
    @GetMapping()
    public ArrayList<miembrosModel> allmiembros(){
        return (ArrayList<miembrosModel>) miembrosService.miembrosall();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<miembrosModel> miembroId(@PathVariable("id") int id){
        Optional<miembrosModel> miembro = this.miembrosService.obtenerMiembroPorId(id);
        return miembro.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PostMapping()
    public miembrosModel savemiembro(@RequestParam(value = "foto", required = false) MultipartFile foto,
                               @RequestParam("nombre") String nombre,
                               @RequestParam("titulo") String titulo,
                               @RequestParam("detalle") String detalle){
        try {
            miembrosModel miembro = new miembrosModel();
            miembro.setNombre(nombre);
            miembro.setTitulo(titulo);
            miembro.setDetalle(detalle);
            // Convertimos los MultipartFile a byte[]
            if (foto != null && !foto.isEmpty()) {
                miembro.setFoto(foto.getBytes());
            }

            return this.miembrosService.saveMiembros(miembro);
        } catch (IOException e) {
            // Es una buena práctica manejar la excepción
            // Aquí podrías lanzar una excepción personalizada que resulte en un error 400 o 500
            throw new RuntimeException("Error al procesar los archivos subidos.", e);
        }
    }
    @PutMapping()
    public Optional<miembrosModel> updatemiembro(@RequestParam(value = "foto", required = false) MultipartFile foto,
                                                 @RequestParam("nombre") String nombre,
                                                 @RequestParam("titulo") String titulo,
                                                 @RequestParam("detalle") String detalle,
                                                 @RequestParam("id") int id)
    {

        try {
            miembrosModel miembro = new miembrosModel();
            miembro.setId(id);
            miembro.setNombre(nombre);
            miembro.setTitulo(titulo);
            miembro.setDetalle(detalle);
            // Convertimos los MultipartFile a byte[]
            if (foto != null && !foto.isEmpty()) {
                miembro.setFoto(foto.getBytes());
            }

            return this.miembrosService.updateMiembro(miembro);
        } catch (IOException e) {
            // Es una buena práctica manejar la excepción
            // Aquí podrías lanzar una excepción personalizada que resulte en un error 400 o 500
            throw new RuntimeException("Error al procesar los archivos subidos.", e);
        }
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity eliminarmiembroPorId(@PathVariable("id") int id) {
        boolean ok = this.miembrosService.eliminarMiembro(id);
        if (ok) {
            return ResponseEntity.ok("Se eliminó el miembro con id " + id);
        } else {
            return ResponseEntity.status(404).body("No se encontró o no se pudo eliminar el miembro con id " + id);
        }
    }
}
