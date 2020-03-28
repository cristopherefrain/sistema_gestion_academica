package Controllers;

import Entities.Curso;
import Views.CursoListadoView;
import Application.ApplicationDesktop;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import Models.ObjetoListadoModel;
import Models.ObjetoModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public final class CursoListadoController {

    private final CursoListadoView view;
    private final ObjetoListadoModel<Curso, String> model;

    public CursoListadoController(CursoListadoView view, ObjetoListadoModel model) {
        model.init();

        this.view = view;
        this.model = model;

        view.setController(this);
        view.setModel(model);
    }

    public void buscar() {
        try {
            if (view.codigo_carreraFld.getText().equals("")) {
                Collection<Curso> filas = model.getModelTemplate().listar_objeto();
                List<Curso> rows = new ArrayList(filas);
                model.setTableModel(rows);
            } else {
                List<Curso> rows = new ArrayList();
                rows.add(model.getModelTemplate().buscar_objeto(view.codigo_carreraFld.getText()));
                model.setTableModel(rows);
            }
        } catch (GlobalException | NoDataException ex) {
        }
    }

    public void agregar() {
        ObjetoModel modelCurso = ApplicationDesktop.CURSO_VIEW.getModel();
        modelCurso.clearErrors();
        modelCurso.setModo(ApplicationDesktop.MODO_AGREGAR);
        modelCurso.setCurrent(new Curso());
        ApplicationDesktop.CURSO_VIEW.setVisible(true);
    }

    public void editar(int row) {
        ObjetoModel ModelCurso = ApplicationDesktop.CURSO_VIEW.getModel();
        ModelCurso.clearErrors();
        Curso selected = model.getTableModel().getRowAt(row);
        ModelCurso.setModo(ApplicationDesktop.MODO_EDITAR);
        ModelCurso.setCurrent(selected);
        ApplicationDesktop.CURSO_VIEW.setVisible(true);
    }

    public void borrar(int row) {
        Curso selected = model.getTableModel().getRowAt(row);
        try {
            model.getModelTemplate().eliminar_objeto(selected.getCodigo_curso());
        } catch (GlobalException | NoDataException ex) {
        }
        this.buscar();
    }
}
