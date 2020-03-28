package Controllers;

import Entities.Profesor;
import Views.ProfesorView;
import Application.ApplicationDesktop;
import static Application.ApplicationDesktop.PROFESOR_LISTADO_CONTROLLER;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import Models.ObjetoModel;

public final class ProfesorController {

    private final ProfesorView view;
    private final ObjetoModel<Profesor, String> model;

    public ProfesorController(ProfesorView view, ObjetoModel model) {
        model.init(null, null);

        this.view = view;
        this.model = model;

        view.setController(this);
        view.setModel(model);
    }

    public void guardar() {
        model.clearErrors();
        Profesor nuevo_profesor = createObject();
        checkErrors();
        if (model.getErrores().isEmpty()) {
            try {
                switch (model.getModo()) {
                    case ApplicationDesktop.MODO_AGREGAR:
                        model.getModelTemplate().insertar_objeto(nuevo_profesor);
                        model.setMensaje("Nueva profesor agregado");
                        break;
                    case ApplicationDesktop.MODO_EDITAR:
                        model.getModelTemplate().modificar_objeto(nuevo_profesor);
                        model.setMensaje("Profesor modificado");
                        break;
                }
                PROFESOR_LISTADO_CONTROLLER.buscar();
            } catch (GlobalException | NoDataException e) {
                model.setCurrent(nuevo_profesor);
            }
        } else {
            model.setMensaje("Error!");
            model.setCurrent(nuevo_profesor);
        }
    }

    public Profesor createObject() {
        Profesor profesor = new Profesor();
        profesor.setCedula_profesor(view.cedulaFld.getText());
        profesor.setNombre(view.nombreFld.getText());
        profesor.setTelefono(view.telefonoFld.getText());
        profesor.setEmail(view.emailFld.getText());
        return profesor;
    }

    public void checkErrors() {
        if (view.cedulaFld.getText().length() == 0) {
            model.getErrores().put("Cedula", "Cedula requerida");
        }
        if (view.nombreFld.getText().length() == 0) {
            model.getErrores().put("Nombre", "Nombre requerido");
        }
        if (view.telefonoFld.getText().length() == 0) {
            model.getErrores().put("Telefono", "Telefono requerido");
        }
        if (view.emailFld.getText().length() == 0) {
            model.getErrores().put("Email", "Email requerido");
        }
    }

}
