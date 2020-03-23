package Models;

import Entities.Usuario;

/**
 *
 * @author wizard
 */
public class InicioSesionModel {

    private final Model domainModel;
    protected Usuario current;

    public InicioSesionModel() {
        domainModel = Model.instance();
        current = null;
    }

    public InicioSesionModel(final Model domainModel, Usuario current) {
        this.domainModel = domainModel;
        this.current = current;
    }

    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }

    public Boolean iniciarSesion(final Usuario usuario) {
        return domainModel.iniciarSesion(usuario);
    }

}
