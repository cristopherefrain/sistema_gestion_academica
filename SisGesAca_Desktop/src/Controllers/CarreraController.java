package Controllers;

import Entities.Carrera;
import Models.Model;
import Views.CarreraView;
import Application.ApplicationDesktop;
import Models.CarrerasModels.CarreraModelMain;

public class CarreraController {

    Model domainModel;
    CarreraView view;
    CarreraModelMain model;

    public CarreraController(CarreraView view, CarreraModelMain model, Model domainModel) {
        this.domainModel = domainModel;
        this.view = view;
        this.model = model;
        this.model.setCurrent(new Carrera());
        this.model.clearErrors();
        view.setController(this);
        view.setModel(model);
    }

    public void guardar() {

        Carrera nueva_carrera = new Carrera();
        model.clearErrors();

        nueva_carrera.setCodigo_carrera(view.codigoFld.getText());
        if (view.codigoFld.getText().length() == 0) {
            model.getErrores().put("Carrera", "Carrera requerida");
        }

        nueva_carrera.setNombre(view.nombreFld.getText());
        if (view.nombreFld.getText().length() == 0) {
            model.getErrores().put("Nombre", "Nombre requerida");
        }

        nueva_carrera.setTitulo(view.tituloFld.getText());
        if (view.tituloFld.getText().length() == 0) {
            model.getErrores().put("Titulo", "Titulo requerido");
        }

        if (model.getErrores().isEmpty()) {

            try {
                switch (model.getModo()) {

                    case ApplicationDesktop.MODO_AGREGAR:

                        domainModel.insertar_carrera(nueva_carrera);
                        model.setMensaje("Nueva carrera agregada");

                        break;

                    case ApplicationDesktop.MODO_EDITAR:

                        domainModel.modificar_carrera(nueva_carrera);
                        model.setMensaje("Carrera modificada");

                        break;
                }
            } catch (Exception e) {
                //System.out.println(e.getMessage());
                //model.getErrores().put("Carrera", "Carrera ya existe");
                //model.setMensaje("Esta carrera ya existe");
                model.setCurrent(nueva_carrera);
            }
        } else {
            model.setMensaje("Error!");
            model.setCurrent(nueva_carrera);
        }
    }

}
