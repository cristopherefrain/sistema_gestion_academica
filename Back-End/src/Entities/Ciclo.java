package Entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author wizard
 */
public final class Ciclo implements Serializable {

    private String no_ciclo;
    private String anio;
    private String numero;
    private String fecha_inicio;
    private String fecha_fin;

    public Ciclo() {
        no_ciclo = new String();
        anio = new String();
        numero = new String();
        fecha_inicio = new String();
        fecha_fin = new String();
    }

    public Ciclo(final String no_ciclo, final String anio, final String numero, final String fecha_inicio, final String fecha_fin) {
        this.no_ciclo = no_ciclo;
        this.anio = anio;
        this.numero = numero;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public String getNo_ciclo() {
        return no_ciclo;
    }

    public void setNo_ciclo(final String no_ciclo) {
        this.no_ciclo = no_ciclo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(final String anio) {
        this.anio = anio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(final String numero) {
        this.numero = numero;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(final String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(final String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    @Override
    public String toString() {
        return "Ciclo{" + "no_ciclo=" + no_ciclo + ", anio=" + anio + ", numero=" + numero + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.no_ciclo);
        hash = 29 * hash + Objects.hashCode(this.anio);
        hash = 29 * hash + Objects.hashCode(this.numero);
        hash = 29 * hash + Objects.hashCode(this.fecha_inicio);
        hash = 29 * hash + Objects.hashCode(this.fecha_fin);
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
        final Ciclo other = (Ciclo) obj;
        if (!Objects.equals(this.no_ciclo, other.no_ciclo)) {
            return false;
        }
        if (!Objects.equals(this.anio, other.anio)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.fecha_inicio, other.fecha_inicio)) {
            return false;
        }
        if (!Objects.equals(this.fecha_fin, other.fecha_fin)) {
            return false;
        }
        return true;
    }

}
