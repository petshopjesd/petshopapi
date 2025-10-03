package com.pet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class userModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int iduser;
    private String name;
    private String apellido;
    private int idestatus;
    private String fechaalta;
    private String fechaupdate;
    private String usuario;
    private String pass;
    private String email;
    private int pcasos;
    private int pcitas;
    private int pcredenciales;
    private int pgaleria;
    private int pmiembros;
    private int pservicios;
    private int pusuarios;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(int idstatus) {
        this.idestatus = idstatus;
    }

    public String getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(String fechaalta) {
        this.fechaalta = fechaalta;
    }

    public String getFechaupdate() {
        return fechaupdate;
    }

    public void setFechaupdate(String fechaupdate) {
        this.fechaupdate = fechaupdate;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPcasos() {
        return pcasos;
    }

    public void setPcasos(int pcasos) {
        this.pcasos = pcasos;
    }

    public int getPcitas() {
        return pcitas;
    }

    public void setPcitas(int pcitas) {
        this.pcitas = pcitas;
    }

    public int getPcredenciales() {
        return pcredenciales;
    }

    public void setPcredenciales(int pcredenciales) {
        this.pcredenciales = pcredenciales;
    }

    public int getPgaleria() {
        return pgaleria;
    }

    public void setPgaleria(int pgaleria) {
        this.pgaleria = pgaleria;
    }

    public int getPmiembros() {
        return pmiembros;
    }

    public void setPmiembros(int pmiembros) {
        this.pmiembros = pmiembros;
    }

    public int getPservicios() {
        return pservicios;
    }

    public void setPservicios(int pservicios) {
        this.pservicios = pservicios;
    }

    public int getPusuarios() {
        return pusuarios;
    }

    public void setPusuarios(int pusuarios) {
        this.pusuarios = pusuarios;
    }
}
