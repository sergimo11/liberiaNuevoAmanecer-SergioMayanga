package com.example.libreria;

public class libroverse {
    private String  codigo,libro,pais,paginas,genero,director,editorial;


    public libroverse() {
    }

    public libroverse(String codigo, String libro, String pais, String paginas, String genero, String director, String editorial) {
        this.codigo = codigo;
        this.libro = libro;
        this.pais = pais;
        this.paginas= paginas;
        this.genero= genero;
        this.director = director;
        this.editorial= editorial;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
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

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
