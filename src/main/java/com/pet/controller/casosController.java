package com.pet.controller;

import com.pet.model.casosModel;
import com.pet.services.casosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/casos")
public class casosController {
    @Autowired
    casosService casosService;

    @GetMapping()
    public ArrayList<casosModel> allcasos(){
        return casosService.allcasos();
    }
    @GetMapping(path = "/time")
    public List<casosModel> allcasosbytime(){
        return casosService.allcasosbytime();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<casosModel> obtenercasoPorId(@PathVariable("id") int id){
        Optional<casosModel> caso = this.casosService.casoPorId(id);
        // Es mejor práctica devolver un 404 si no se encuentra
        return caso.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping()
    public casosModel savecaso(@RequestParam(value = "fotoi", required = false) MultipartFile fotoi,
                               @RequestParam(value = "fotof", required = false) MultipartFile fotof,
                               @RequestParam("titulo") String titulo,
                               @RequestParam("mascota") String mascota,
                               @RequestParam("detalle") String detalle,
                               @RequestParam("fecha") LocalDate fecha,
                               @RequestParam("idmiembro") int idmiembro) {
        try {
            casosModel caso = new casosModel();
            caso.setTitulo(titulo);
            caso.setMascota(mascota);
            caso.setDetalle(detalle);
            caso.setFecha(fecha);
            caso.setIdmiembro(idmiembro);

            // Convertimos los MultipartFile a byte[]
            if (fotoi != null && !fotoi.isEmpty()) {
                caso.setFotoi(fotoi.getBytes());
            }
            if (fotof != null && !fotof.isEmpty()) {
                caso.setFotof(fotof.getBytes());
            }

            return this.casosService.savecaso(caso);
        } catch (IOException e) {
            // Es una buena práctica manejar la excepción
            // Aquí podrías lanzar una excepción personalizada que resulte en un error 400 o 500
            throw new RuntimeException("Error al procesar los archivos subidos.", e);
        }
    }
    @PutMapping
    public Optional<casosModel> updatecaso(@RequestParam(value = "fotoi", required = false) MultipartFile fotoi,
                               @RequestParam(value = "fotof", required = false) MultipartFile fotof,
                               @RequestParam("titulo") String titulo,
                               @RequestParam("mascota") String mascota,
                               @RequestParam("detalle") String detalle,
                               @RequestParam("fecha") LocalDate fecha,
                               @RequestParam("idmiembro") int idmiembro,
                                 @RequestParam("id") String id)
    {
        try {
            casosModel caso = new casosModel();
            caso.setId(Integer.parseInt(id));
            caso.setTitulo(titulo);
            caso.setMascota(mascota);
            caso.setDetalle(detalle);
            caso.setFecha(fecha);
            caso.setIdmiembro(idmiembro);

            // Convertimos los MultipartFile a byte[]
            if (fotoi != null && !fotoi.isEmpty()) {
                caso.setFotoi(fotoi.getBytes());
            }
            if (fotof != null && !fotof.isEmpty()) {
                caso.setFotof(fotof.getBytes());
            }

            return this.casosService.updatecaso(caso);
        } catch (IOException e) {
            // Es una buena práctica manejar la excepción
            // Aquí podrías lanzar una excepción personalizada que resulte en un error 400 o 500
            throw new RuntimeException("Error al procesar los archivos subidos.", e);
        }
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity eliminarcasoPorId(@PathVariable("id") int id) {
        boolean ok = this.casosService.eliminarcaso(id);
        if (ok) {
            return ResponseEntity.ok("Se eliminó el caso con id " + id);
        } else {
            return ResponseEntity.status(404).body("No se encontró o no se pudo eliminar el caso con id " + id);
        }
    }


}
