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
public class Curso {
    
    private String codigo_curso;
    private String codigo_carrera;
    private String no_ciclo;
    private String nombre;
    private String creditos;
    private String horas_semanales;

    public Curso() {
        codigo_curso = new String();
        codigo_carrera = new String();
        no_ciclo = new String(); 
        nombre = new String();
        creditos = new String();
        horas_semanales = new String();
    }

    public Curso(String codigo_curso, String codigo_carrera, String no_ciclo, String nombre, String creditos, String horas_semanales) {
        this.codigo_curso = codigo_curso;
        this.codigo_carrera = codigo_carrera;
        this.no_ciclo = no_ciclo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horas_semanales = horas_semanales;
    }

    public String getCodigo_curso() {
        return codigo_curso;
    }

    public void setCodigo_curso(String codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public String getCodigo_carrera() {
        return codigo_carrera;
    }

    public void setCodigo_carrera(String codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public String getNo_ciclo() {
        return no_ciclo;
    }

    public void setNo_ciclo(String no_ciclo) {
        this.no_ciclo = no_ciclo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public String getHoras_semanales() {
        return horas_semanales;
    }

    public void setHoras_semanales(String horas_semanales) {
        this.horas_semanales = horas_semanales;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo_curso=" + codigo_curso + ", codigo_carrera=" + codigo_carrera + ", no_ciclo=" + no_ciclo + ", nombre=" + nombre + ", creditos=" + creditos + ", horas_semanales=" + horas_semanales + '}';
    }   
}
