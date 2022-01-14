package com.example.libreria;

public class Cineverse {
    private String  codigo,pelicula,pais,duracion,fecha,genero,director;


    public Cineverse() {
    }

    public Cineverse(String codigo, String pelicula, String pais, String duracion, String fecha, String genero, String director) {
        this.codigo = codigo;
        this.pelicula = pelicula;
        this.pais = pais;
        this.duracion = duracion;
        this.fecha = fecha;
        this.genero = genero;
        this.director = director;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
