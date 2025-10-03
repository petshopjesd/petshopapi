package com.pet.controller;

import com.pet.model.citasModel;
import com.pet.services.citasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/citas")
public class citasController {
    @Autowired
    citasService citasService;

    /**
     * GET /citas
     * Obtiene todas las citas. Devuelve una lista, que puede estar vacía.
     */
    @GetMapping()
    public ResponseEntity<List<citasModel>> obtenerCitas(){
        List<citasModel> citas = citasService.obtenerCitas();
        return ResponseEntity.ok(citas);
    }

    /**
     * GET /citas/buscar?fecha=YYYY-MM-DD
     * Busca citas para una fecha específica.
     */
    @GetMapping(path = "/buscar")
    public ResponseEntity<List<citasModel>> obtenerCitasPorFecha(@RequestParam("fecha") String fecha){
        // Convierte el string a LocalDate para pasarlo al servicio
        LocalDate fechaBusqueda = LocalDate.parse(fecha);
        List<citasModel> citas = this.citasService.obtenerCitasDisponibles(fechaBusqueda);
        return ResponseEntity.ok(citas);
    }

    /**
     * GET /citas/proximas
     * Obtiene las citas desde hoy en adelante.
     */
    @GetMapping(path = "/proximas")
    public ResponseEntity<List<citasModel>> obtenerCitasDesdeHoy(){
        List<citasModel> citas = this.citasService.obtenerCitasDesdeHoy();
        return ResponseEntity.ok(citas);
    }

    /**
     * POST /citas
     * Guarda una nueva cita. Devuelve 201 Created con la ubicación del nuevo recurso.
     */
    @PostMapping
    public ResponseEntity<citasModel> guardarCita(@RequestBody citasModel cita) throws GeneralSecurityException, IOException {
        citasModel citaGuardada = this.citasService.guardarCita(cita);

        // Construye la URL del nuevo recurso creado
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(citaGuardada.getId())
                .toUri();

        return ResponseEntity.created(location).body(citaGuardada);
    }

    /**
     * GET /citas/{id}
     * Obtiene una cita por su ID. Devuelve 404 Not Found si no existe.
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<citasModel> obtenerPorId(@PathVariable("id") int id){
        return this.citasService.obtenerPorId(id)
                .map(ResponseEntity::ok) // Si existe, devuelve 200 OK con el objeto
                .orElse(ResponseEntity.notFound().build()); // Si no, devuelve 404
    }

    /**
     * DELETE /citas/{id}
     * Elimina una cita. Devuelve 204 No Content si tiene éxito.
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable("id") int id) {
        boolean ok = this.citasService.eliminarCita(id);
        if (ok) {
            return ResponseEntity.noContent().build(); // 204 No Content: Éxito, sin cuerpo de respuesta
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found: No se encontró para eliminar
        }
    }
}