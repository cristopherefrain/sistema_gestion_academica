package com.Application.Models;

import com.Application.Entities.Usuario;
import com.Application.Models.Model;

/**
 *
 * @author wizard
 */
public class InicioSesionModel {

    private Model domainModel;
    private Usuario current;

    public InicioSesionModel() {
        domainModel = Model.instance();
        current = null;
    }

    public InicioSesionModel(Model domainModel, Usuario current) {
        this.domainModel = domainModel;
        this.current = current;
    }

    public Boolean iniciarSesion(Usuario usuario) {
        return domainModel.iniciarSesion(usuario);
    }

}
