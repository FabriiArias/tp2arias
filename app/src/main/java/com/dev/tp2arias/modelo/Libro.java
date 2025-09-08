package com.dev.tp2arias.modelo;

import java.io.Serializable;

public class Libro implements Serializable {
    private int portada;
    private String nombre, descripcion, categoriaUno, categoriaDos, autor, anio, cantPaginas;

    public Libro(int portada, String nombre, String descripcion, String categoriaUno, String categoriaDos, String autor, String anio, String cantPaginas) {
        this.portada = portada;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoriaUno = categoriaUno;
        this.categoriaDos = categoriaDos;
        this.autor = autor;
        this.anio = anio;
        this.cantPaginas = cantPaginas;
    }

    public int getPortada() {
        return portada;
    }

    public void setPortada(int portada) {
        this.portada = portada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoriaUno() {
        return categoriaUno;
    }

    public void setCategoriaUno(String categoriaUno) {
        this.categoriaUno = categoriaUno;
    }

    public String getCategoriaDos() {
        return categoriaDos;
    }

    public void setCategoriaDos(String categoriaDos) {
        this.categoriaDos = categoriaDos;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(String cantPaginas) {
        this.cantPaginas = cantPaginas;
    }
}
