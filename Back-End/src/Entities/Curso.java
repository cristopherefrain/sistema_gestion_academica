package Entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author wizard
 */
public final class Curso implements Serializable {

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

    public Curso(final String codigo_curso, final String codigo_carrera, final String no_ciclo, final String nombre, final String creditos, final String horas_semanales) {
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

    public void setCodigo_curso(final String codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public String getCodigo_carrera() {
        return codigo_carrera;
    }

    public void setCodigo_carrera(final String codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public String getNo_ciclo() {
        return no_ciclo;
    }

    public void setNo_ciclo(final String no_ciclo) {
        this.no_ciclo = no_ciclo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(final String creditos) {
        this.creditos = creditos;
    }

    public String getHoras_semanales() {
        return horas_semanales;
    }

    public void setHoras_semanales(final String horas_semanales) {
        this.horas_semanales = horas_semanales;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo_curso=" + codigo_curso + ", codigo_carrera=" + codigo_carrera + ", no_ciclo=" + no_ciclo + ", nombre=" + nombre + ", creditos=" + creditos + ", horas_semanales=" + horas_semanales + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codigo_curso);
        hash = 97 * hash + Objects.hashCode(this.codigo_carrera);
        hash = 97 * hash + Objects.hashCode(this.no_ciclo);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.creditos);
        hash = 97 * hash + Objects.hashCode(this.horas_semanales);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.codigo_curso, other.codigo_curso)) {
            return false;
        }
        if (!Objects.equals(this.codigo_carrera, other.codigo_carrera)) {
            return false;
        }
        if (!Objects.equals(this.no_ciclo, other.no_ciclo)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.creditos, other.creditos)) {
            return false;
        }
        if (!Objects.equals(this.horas_semanales, other.horas_semanales)) {
            return false;
        }
        return true;
    }

}
