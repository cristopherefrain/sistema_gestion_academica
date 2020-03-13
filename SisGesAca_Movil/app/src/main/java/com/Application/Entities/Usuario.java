package com.Application.Entities;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String cedula;
    private String clave;
    private String tipo_usuario;

    public Usuario() {
        cedula = new String();
        clave = new String();
        tipo_usuario = new String();
    }

    public Usuario(String cedula, String clave, String tipo_usuario) {
        this.cedula = cedula;
        this.clave = clave;
        this.tipo_usuario = tipo_usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", clave=" + clave + ", tipo_usuario=" + tipo_usuario + '}';
    }
}
