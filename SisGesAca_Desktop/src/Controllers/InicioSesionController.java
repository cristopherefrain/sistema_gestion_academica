package Controllers;

import Application.ApplicationDesktop;
import Entities.Usuario;
import Models.ObjetoModel;
import Views.InicioSesionView;

/**
 *
 * @author wizard
 */
public class InicioSesionController {

    private final InicioSesionView view;
    private final ObjetoModel<Usuario, String> model;

    public InicioSesionController(InicioSesionView view, ObjetoModel model) {
        model.init(null, null);

        this.view = view;
        this.model = model;

        view.setController(this);
        view.setModel(model);
    }

    public Boolean iniciarSesion() {
        model.clearErrors();
        Usuario usuario_ingreso = createObject();
        checkErrors();
        if (model.getErrores().isEmpty()) {
            if (model.getModelTemplate().iniciarSesion(usuario_ingreso.getCedula(), usuario_ingreso.getClave())) {
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

    public Usuario createObject() {
        Usuario usuario = new Usuario();
        usuario.setCedula(view.cedulaTxtFld.getText());
        usuario.setClave(view.clavetxtFld.getText());
        return usuario;
    }

    public void checkErrors() {
        if (view.cedulaTxtFld.getText().length() == 0) {
            model.getErrores().put("Cedula", "Cedula Requerida");
        }
        if (view.clavetxtFld.getText().length() == 0) {
            model.getErrores().put("Clave", "Clave Requerida");
        }
    }

}
