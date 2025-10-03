package com.pet.model;

import jakarta.persistence.*;

import java.sql.Blob;
import java.time.LocalDate;

@Entity
@Table(name = "casos")
public class casosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private String titulo;
    private String mascota;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String detalle;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] fotoi;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] fotof;
    @Column(columnDefinition = "DATE")
    private LocalDate fecha;
    private int idmiembro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public byte[] getFotoi() {
        return fotoi;
    }

    public void setFotoi(byte[] fotoi) {
        this.fotoi = fotoi;
    }

    public byte[] getFotof() {
        return fotof;
    }

    public void setFotof(byte[] fotof) {
        this.fotof = fotof;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdmiembro() {
        return idmiembro;
    }

    public void setIdmiembro(int idmiembro) {
        this.idmiembro = idmiembro;
    }
}
