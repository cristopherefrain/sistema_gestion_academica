package Controllers;

import Entities.Alumno;
import Views.AlumnoListadoView;
import Application.ApplicationDesktop;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import Models.ObjetoListadoModel;
import Models.ObjetoModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public final class AlumnoListadoController {

    private final AlumnoListadoView view;
    private final ObjetoListadoModel<Alumno, String> model;

    public AlumnoListadoController(AlumnoListadoView view, ObjetoListadoModel model) {
        model.init();

        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void buscar() {
        try {
            if (view.cedulaFld.getText().equals("")) {
                Collection<Alumno> filas = model.getModelTemplate().listar_objeto();
                List<Alumno> rows = new ArrayList(filas);
                model.setTableModel(rows);
            } else {
                List<Alumno> rows = new ArrayList();
                rows.add(model.getModelTemplate().buscar_objeto(view.cedulaFld.getText()));
                model.setTableModel(rows);
            }
        } catch (GlobalException | NoDataException ex) {
        }
    }

    public void agregar() {
        ObjetoModel modelAlumno = ApplicationDesktop.ALUMNO_VIEW.getModel();
        modelAlumno.clearErrors();
        modelAlumno.setModo(ApplicationDesktop.MODO_AGREGAR);
        modelAlumno.setCurrent(new Alumno());
        ApplicationDesktop.ALUMNO_VIEW.setVisible(true);
    }

    public void editar(int row) {
        ObjetoModel modelAlumno = ApplicationDesktop.ALUMNO_VIEW.getModel();
        modelAlumno.clearErrors();
        Alumno selected = model.getTableModel().getRowAt(row);
        modelAlumno.setModo(ApplicationDesktop.MODO_EDITAR);
        modelAlumno.setCurrent(selected);
        ApplicationDesktop.ALUMNO_VIEW.setVisible(true);
    }

    public void borrar(int row) {
        Alumno selected = model.getTableModel().getRowAt(row);
        try {
            model.getModelTemplate().eliminar_objeto(selected.getCedula_alumno());
        } catch (GlobalException | NoDataException ex) {
        }
        this.buscar();
    }
}
