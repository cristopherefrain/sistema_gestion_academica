package Controllers;

import Application.ApplicationDesktop;
import Entities.Usuario;
import Models.InicioSesionModels.InicioSesionModelMain;
import Models.Model;
import Views.InicioSesionView;

/**
 *
 * @author wizard
 */
public class InicioSesionController {

    Model domainModel;
    InicioSesionView view;
    InicioSesionModelMain model;

    public InicioSesionController(InicioSesionView view, InicioSesionModelMain model, Model domainModel) {
        this.domainModel = domainModel;
        this.view = view;
        this.model = model;
        this.model.setCurrent(new Usuario());
        this.model.clearErrors();
        view.setController(this);
        view.setModel(model);
    }

    public Boolean iniciarSesion() {
        Usuario usuario_ingreso = new Usuario();
        model.clearErrors();

        usuario_ingreso.setCedula(view.getCedulaTxtFld());
        if (view.getCedulaTxtFld().length() == 0) {
            model.getErrores().put("Cedula", "Cedula Requerida");
        }

        usuario_ingreso.setClave(view.getClavetxtFld());
        if (view.getClavetxtFld().length() == 0) {
            model.getErrores().put("Clave", "Clave Requerida");
        }

        if (model.getErrores().isEmpty()) {
            if (domainModel.iniciarSesion(usuario_ingreso)) {
                model.setMensaje("");
//                model.setMensaje("Bienvenido a SisGesAca (:");
                ApplicationDesktop.APP_VIEW.setVisible(true);
                view.setVisible(false);
                return true;
            } else {
                model.getErrores().put("Cedula", "Cedula Invalida");
                model.getErrores().put("Clave", "Clave Invalida");

                model.setMensaje("Error!");
                model.setCurrent(usuario_ingreso);
            }
        } else {
            model.setMensaje("Error!");
            model.setCurrent(usuario_ingreso);
        }
        return false;
    }

    public void cerrarSesion() {
        model.setMensaje("");
//        model.setMensaje("Hasta Luego :(");
        model.setCurrent(new Usuario());
        view.setVisible(true);
    }

    public void exit() {
        System.exit(0);
    }

}
