package Controllers;

import Entities.Profesor;
import Views.ProfesorListadoView;
import Application.ApplicationDesktop;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import Models.ObjetoListadoModel;
import Models.ObjetoModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class ProfesorListadoController {

    private final ProfesorListadoView view;
    private final ObjetoListadoModel<Profesor, String> model;

    public ProfesorListadoController(ProfesorListadoView view, ObjetoListadoModel model) {
        model.init();

        this.view = view;
        this.model = model;

        view.setController(this);
        view.setModel(model);
    }

    public void buscar() {
        try {
            if (view.cedulaFld.getText().equals("")) {
                Collection<Profesor> filas = model.getModelTemplate().listar_objeto();
                List<Profesor> rows = new ArrayList(filas);
                model.setTableModel(rows);
            } else {
                List<Profesor> rows = new ArrayList();
                rows.add(model.getModelTemplate().buscar_objeto(view.cedulaFld.getText()));
                model.setTableModel(rows);
            }
        } catch (GlobalException | NoDataException ex) {
        }
    }

    public void agregar() {
        ObjetoModel modelProfesor = ApplicationDesktop.PROFESOR_VIEW.getModel();
        modelProfesor.clearErrors();
        modelProfesor.setModo(ApplicationDesktop.MODO_AGREGAR);
        modelProfesor.setCurrent(new Profesor());
        ApplicationDesktop.PROFESOR_VIEW.setVisible(true);
    }

    public void editar(int row) {
        ObjetoModel modelProfesor = ApplicationDesktop.PROFESOR_VIEW.getModel();
        modelProfesor.clearErrors();
        Profesor selected = model.getTableModel().getRowAt(row);
        modelProfesor.setModo(ApplicationDesktop.MODO_EDITAR);
        modelProfesor.setCurrent(selected);
        ApplicationDesktop.PROFESOR_VIEW.setVisible(true);
    }

    public void borrar(int row) {
        Profesor selected = model.getTableModel().getRowAt(row);
        try {
            model.getModelTemplate().eliminar_objeto(selected.getCedula_profesor());
        } catch (GlobalException | NoDataException ex) {
        }
        this.buscar();
    }
}
