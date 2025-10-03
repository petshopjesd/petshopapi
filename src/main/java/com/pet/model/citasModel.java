package com.pet.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate; // Para fechas (YYYY-MM-DD)
import java.time.LocalTime; // Para horas (HH:MM:SS)
import java.time.Instant;   // Para marcas de tiempo (fecha y hora UTC)

@Entity
@Table(name = "citas")
public class citasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private String nombre;
    private String telefono;
    private String servicio;
    private String email;
    private String mensaje;

    // --- CAMPOS CORREGIDOS ---
    @Column(columnDefinition = "DATE")
    private LocalDate fecha; // Antes: String

    @Column(columnDefinition = "TIME")
    private LocalTime hora;  // Antes: String

    @CreationTimestamp // Hibernate asignará la fecha y hora de creación automáticamente
    @Column(nullable = false, updatable = false)
    private Instant fechap; // Antes: String

    // --- GETTERS Y SETTERS ---
    // Asegúrate de actualizar los getters y setters para que coincidan con los nuevos tipos

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Instant getfechap() {
        return fechap;
    }

    public void setfechap(Instant fecha_publicacion) {
        this.fechap = fecha_publicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}