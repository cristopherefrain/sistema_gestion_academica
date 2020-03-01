package Controllers;

import Entities.Carrera;
import Models.CarreraModel;
import Models.CarrerasModel;
import Models.Model;
import Views.CarrerasView;
import Application.ApplicationDesktop;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class CarrerasController {

    Model domainModel;
    CarrerasView view;
    CarrerasModel model;

    public CarrerasController(CarrerasView view, CarrerasModel model, Model domainModel) {
        model.init();
        this.domainModel = domainModel;

        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void buscar() {
        try {
            if (view.codigo_carreraFld.getText().equals("")) {
                Collection<Carrera> filas = domainModel.listar_carrera();
                List<Carrera> rows = new ArrayList(filas);
                model.setCarrera(rows);

            } else {
                List<Carrera> rows = new ArrayList();
                rows.add(domainModel.buscar_carrera(view.codigo_carreraFld.getText()));
                model.setCarrera(rows);
            }
        } catch (Exception ex) {
        }
    }

    public void agregar() {
        CarreraModel carreramodel = ApplicationDesktop.CARRERA_VIEW.getModel();
        carreramodel.clearErrors();
        carreramodel.setModo(ApplicationDesktop.MODO_AGREGAR);
        carreramodel.setCurrent(new Carrera());
        ApplicationDesktop.CARRERA_VIEW.setVisible(true);
    }

    public void editar(int row) {
        CarreraModel carreramodel = ApplicationDesktop.CARRERA_VIEW.getModel();
        carreramodel.clearErrors();
        Carrera seleccionado = model.getCarreras().getRowAt(row);
        carreramodel.setModo(ApplicationDesktop.MODO_EDITAR);
        carreramodel.setCurrent(seleccionado);
        ApplicationDesktop.CARRERA_VIEW.setVisible(true);
    }

    public void borrar(int row) {
        Carrera seleccionada = model.getCarreras().getRowAt(row);
        try {
            domainModel.eliminar_carrera(seleccionada.getCodigo_carrera());
        } catch (Exception ex) {
        }
        this.buscar();
    }
}