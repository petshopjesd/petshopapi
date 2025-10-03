package com.pet.model;

import jakarta.persistence.*;

@Entity
@Table(name="myblog")
public class blogsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idmyblog;
    private String titulo;
    private String subtitulo;
    private String contenido;
    private String iduser;
    private String fechacreacion;
    private String fechaupdate;
    private String imgurl;

    public int getIdmyblog() {
        return idmyblog;
    }

    public void setIdmyblog(int idmyblog) {
        this.idmyblog = idmyblog;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getFechaupdate() {
        return fechaupdate;
    }

    public void setFechaupdate(String fechaupdate) {
        this.fechaupdate = fechaupdate;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
