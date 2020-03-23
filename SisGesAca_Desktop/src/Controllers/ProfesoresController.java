package Controllers;

import Entities.Profesor;
import Models.Model;
import Models.ProfesoresModel;
import Views.ProfesoresView;
import Application.ApplicationDesktop;
import Models.ProfesoresModels.ProfesorModelMain;
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
        ProfesorModelMain profesormodelMain = ApplicationDesktop.PROFESOR_VIEW.getModel();
        profesormodelMain.clearErrors();
        profesormodelMain.setModo(ApplicationDesktop.MODO_AGREGAR);
        profesormodelMain.setCurrent(new Profesor());
        ApplicationDesktop.PROFESOR_VIEW.setVisible(true);
    }

    public void editar(int row) {
        ProfesorModelMain profesormodelMain = ApplicationDesktop.PROFESOR_VIEW.getModel();
        profesormodelMain.clearErrors();
        Profesor seleccionado = model.getProfesores().getRowAt(row);
        profesormodelMain.setModo(ApplicationDesktop.MODO_EDITAR);
        profesormodelMain.setCurrent(seleccionado);
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
