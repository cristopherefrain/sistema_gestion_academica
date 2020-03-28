package Controllers;

import Entities.Carrera;
import Views.CarreraView;
import Application.ApplicationDesktop;
import static Application.ApplicationDesktop.CARRERA_LISTADO_CONTROLLER;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import Models.ObjetoModel;

public final class CarreraController {

    private final CarreraView view;
    private final ObjetoModel<Carrera, String> model;

    public CarreraController(CarreraView view, ObjetoModel model) {
        model.init(null, null);

        this.view = view;
        this.model = model;

        view.setController(this);
        view.setModel(model);
    }

    public void guardar() {
        model.clearErrors();
        Carrera nueva_carrera = createObject();
        checkErrors();
        if (model.getErrores().isEmpty()) {
            try {
                switch (model.getModo()) {
                    case ApplicationDesktop.MODO_AGREGAR:
                        model.getModelTemplate().insertar_objeto(nueva_carrera);
                        model.setMensaje("Nueva carrera agregada");
                        break;
                    case ApplicationDesktop.MODO_EDITAR:
                        model.getModelTemplate().modificar_objeto(nueva_carrera);
                        model.setMensaje("Carrera modificada");
                        break;
                }
                CARRERA_LISTADO_CONTROLLER.buscar();
            } catch (GlobalException | NoDataException e) {
                model.setCurrent(nueva_carrera);
            }
        } else {
            model.setMensaje("Error!");
            model.setCurrent(nueva_carrera);
        }
    }

    public Carrera createObject() {
        Carrera carrera = new Carrera();
        carrera.setCodigo_carrera(view.codigoFld.getText());
        carrera.setNombre(view.nombreFld.getText());
        carrera.setTitulo(view.tituloFld.getText());
        return carrera;
    }

    public void checkErrors() {
        if (view.codigoFld.getText().length() == 0) {
            model.getErrores().put("Carrera", "Carrera requerida");
        }
        if (view.nombreFld.getText().length() == 0) {
            model.getErrores().put("Nombre", "Nombre requerida");
        }
        if (view.tituloFld.getText().length() == 0) {
            model.getErrores().put("Titulo", "Titulo requerido");
        }
    }
}
