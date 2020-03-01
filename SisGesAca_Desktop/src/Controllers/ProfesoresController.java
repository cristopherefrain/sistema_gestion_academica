package Controllers;

import Entities.Profesor;
import Models.Model;
import Models.ProfesorModel;
import Models.ProfesoresModel;
import Views.ProfesoresView;
import Application.ApplicationDesktop;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class ProfesoresController {

    Model domainModel;
    ProfesoresView view;
    ProfesoresModel model;

    public ProfesoresController(ProfesoresView view, ProfesoresModel model, Model domainModel) {
        model.init();
        this.domainModel = domainModel;

        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void buscar() {
        try {
            if (view.cedulaFld.getText().equals("")) {
                Collection<Profesor> filas = domainModel.listar_profesor();
                List<Profesor> rows = new ArrayList(filas);
                model.setProfesor(rows);

            } else {
                List<Profesor> rows = new ArrayList();
                rows.add(domainModel.buscar_profesor(view.cedulaFld.getText()));
                model.setProfesor(rows);
            }
        } catch (Exception ex) {
        }
    }

    public void agregar() {
        ProfesorModel profesormodel = ApplicationDesktop.PROFESOR_VIEW.getModel();
        profesormodel.clearErrors();
        profesormodel.setModo(ApplicationDesktop.MODO_AGREGAR);
        profesormodel.setCurrent(new Profesor());
        ApplicationDesktop.PROFESOR_VIEW.setVisible(true);
    }

    public void editar(int row) {
        ProfesorModel profesormodel = ApplicationDesktop.PROFESOR_VIEW.getModel();
        profesormodel.clearErrors();
        Profesor seleccionado = model.getProfesores().getRowAt(row);
        profesormodel.setModo(ApplicationDesktop.MODO_EDITAR);
        profesormodel.setCurrent(seleccionado);
        ApplicationDesktop.PROFESOR_VIEW.setVisible(true);
    }

    public void borrar(int row) {
        Profesor seleccionada = model.getProfesores().getRowAt(row);
        try {
            domainModel.eliminar_profesor(seleccionada.getCedula_profesor());
        } catch (Exception ex) {
        }
        this.buscar();
    }
}
