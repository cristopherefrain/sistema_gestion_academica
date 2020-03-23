package Controllers;

import Entities.Profesor;
import Models.Model;
import Views.ProfesorView;
import Application.ApplicationDesktop;
import Models.ProfesoresModels.ProfesorModelMain;

public class ProfesorController {

    Model domainModel;
    ProfesorView view;
    ProfesorModelMain model;

    public ProfesorController(ProfesorView view, ProfesorModelMain model, Model domainModel) {
        this.domainModel = domainModel;
        this.view = view;
        this.model = model;
        this.model.setCurrent(new Profesor());
        this.model.clearErrors();
        view.setController(this);
        view.setModel(model);
    }

    public void guardar() {

        Profesor nuevo_profesor = new Profesor();
        model.clearErrors();

        nuevo_profesor.setCedula_profesor(view.cedulaFld.getText());
        if (view.cedulaFld.getText().length() == 0) {
            model.getErrores().put("Cedula", "Cedula requerida");
        }

        nuevo_profesor.setNombre(view.nombreFld.getText());
        if (view.nombreFld.getText().length() == 0) {
            model.getErrores().put("Nombre", "Nombre requerido");
        }

        nuevo_profesor.setTelefono(view.telefonoFld.getText());
        if (view.telefonoFld.getText().length() == 0) {
            model.getErrores().put("Telefono", "Telefono requerido");
        }
        
        nuevo_profesor.setEmail(view.emailFld.getText());
        if (view.emailFld.getText().length() == 0) {
            model.getErrores().put("Email", "Email requerido");
        }

        if (model.getErrores().isEmpty()) {

            try {
                switch (model.getModo()) {

                    case ApplicationDesktop.MODO_AGREGAR:

                        domainModel.insertar_profesor(nuevo_profesor);
                        model.setMensaje("Nueva profesor agregado");

                        break;

                    case ApplicationDesktop.MODO_EDITAR:

                        domainModel.modificar_profesor(nuevo_profesor);
                        model.setMensaje("Profesor modificado");

                        break;
                }
            } catch (Exception e) {
                model.setCurrent(nuevo_profesor);
            }
        } else {
            model.setMensaje("Error!");
            model.setCurrent(nuevo_profesor);
        }
    }

}
