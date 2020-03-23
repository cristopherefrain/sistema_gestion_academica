package Controllers;

import Entities.Curso;
import Models.CursosModel;
import Models.Model;
import Views.CursosView;
import Application.ApplicationDesktop;
import Models.CursosModels.CursoModelMain;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class CursosController {

    Model domainModel;
    CursosView view;
    CursosModel model;

    public CursosController(CursosView view, CursosModel model, Model domainModel) {
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
                Collection<Curso> filas = domainModel.listar_curso();
                List<Curso> rows = new ArrayList(filas);
                model.setCurso(rows);

            } else {
                List<Curso> rows = new ArrayList();
                rows.add(domainModel.buscar_curso(view.codigo_carreraFld.getText()));
                model.setCurso(rows);
            }
        } catch (Exception ex) {
        }
    }

    public void agregar() {
        CursoModelMain cursomodelMain = ApplicationDesktop.CURSO_VIEW.getModel();
        cursomodelMain.clearErrors();
        cursomodelMain.setModo(ApplicationDesktop.MODO_AGREGAR);
        cursomodelMain.setCurrent(new Curso());
        ApplicationDesktop.CURSO_VIEW.setVisible(true);
    }

    public void editar(int row) {
        CursoModelMain cursomodelMain = ApplicationDesktop.CURSO_VIEW.getModel();
        cursomodelMain.clearErrors();
        Curso seleccionado = model.getCursos().getRowAt(row);
        cursomodelMain.setModo(ApplicationDesktop.MODO_EDITAR);
        cursomodelMain.setCurrent(seleccionado);
        ApplicationDesktop.CURSO_VIEW.setVisible(true);
    }

    public void borrar(int row) {
        Curso seleccionada = model.getCursos().getRowAt(row);
        try {
            domainModel.eliminar_curso(seleccionada.getCodigo_curso());
        } catch (Exception ex) {
        }
        this.buscar();
    }
}
