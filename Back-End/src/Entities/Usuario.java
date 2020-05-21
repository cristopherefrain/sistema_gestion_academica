package Entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author wizard
 */
public final class Usuario implements Serializable {

    private String cedula;
    private String clave;
    private String tipo_usuario;

    public Usuario() {
        cedula = new String();
        clave = new String();
        tipo_usuario = new String();
    }

    public Usuario(final String cedula, final String clave, final String tipo_usuario) {
        this.cedula = cedula;
        this.clave = clave;
        this.tipo_usuario = tipo_usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(final String cedula) {
        this.cedula = cedula;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(final String clave) {
        this.clave = clave;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(final String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    @Override
    public String toString() {
        return "{" + "\"cedula\":\"" + cedula + "\", \"clave\":\"" + clave + "\", \"tipo_usuario\":\"" + tipo_usuario + "\"}";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.cedula);
        hash = 79 * hash + Objects.hashCode(this.clave);
        hash = 79 * hash + Objects.hashCode(this.tipo_usuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        if (!Objects.equals(this.tipo_usuario, other.tipo_usuario)) {
            return false;
        }
        return true;
    }

}
