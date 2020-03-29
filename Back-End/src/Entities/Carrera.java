package Entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author wizard
 */
public final class Carrera implements Serializable {

    private String codigo_carrera;
    private String nombre;
    private String titulo;

    public Carrera() {
        codigo_carrera = new String();
        nombre = new String();
        titulo = new String();
    }

    public Carrera(final String codigo_carrera, final String nombre, final String titulo) {
        this.codigo_carrera = codigo_carrera;
        this.nombre = nombre;
        this.titulo = titulo;
    }

    public String getCodigo_carrera() {
        return codigo_carrera;
    }

    public void setCodigo_carrera(final String codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Carrera{" + "codigo_carrera=" + codigo_carrera + ", nombre=" + nombre + ", titulo=" + titulo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.codigo_carrera);
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.titulo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carrera other = (Carrera) obj;
        if (!Objects.equals(this.codigo_carrera, other.codigo_carrera)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }

}
