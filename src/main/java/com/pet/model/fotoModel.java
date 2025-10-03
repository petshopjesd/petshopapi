package com.pet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fotos")
public class fotoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private int idgaleria;
    private String nombre;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] foto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdgaleria() {
        return idgaleria;
    }

    public void setIdgaleria(int idgaleria) {
        this.idgaleria = idgaleria;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
