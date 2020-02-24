/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Moviles
 */
public class Carrera {

    private String codigo_carrera;
    private String nombre;
    private String titulo;

    public Carrera() {
        codigo_carrera = new String();
        nombre = new String();
        titulo = new String();
    }

    public Carrera(String codigo_carrera, String nombre, String titulo) {
        this.codigo_carrera = codigo_carrera;
        this.nombre = nombre;
        this.titulo = titulo;
    }

    public String getCodigo_carrera() {
        return codigo_carrera;
    }

    public void setCodigo_carrera(String codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Carrera{" + "codigo_carrera=" + codigo_carrera + ", nombre=" + nombre + ", titulo=" + titulo + '}';
    }
}
