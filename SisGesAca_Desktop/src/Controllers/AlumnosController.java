package Controllers;

import Entities.Alumno;
import Models.AlumnosModel;
import Models.Model;
import Views.AlumnosView;
import Application.ApplicationDesktop;
import Models.AlumnosModels.AlumnoModelMain;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class AlumnosController {

    Model domainModel;
    AlumnosView view;
    AlumnosModel model;

    public AlumnosController(AlumnosView view, AlumnosModel model, Model domainModel) {
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
                Collection<Alumno> filas = domainModel.listar_alumno();
                List<Alumno> rows = new ArrayList(filas);
                model.setAlumno(rows);

            } else {
                List<Alumno> rows = new ArrayList();
                rows.add(domainModel.buscar_alumno(view.cedulaFld.getText()));
                model.setAlumno(rows);
            }
        } catch (Exception ex) {
        }
    }

    public void agregar() {
        AlumnoModelMain alumnomodelMain = ApplicationDesktop.ALUMNO_VIEW.getModel();
        alumnomodelMain.clearErrors();
        alumnomodelMain.setModo(ApplicationDesktop.MODO_AGREGAR);
        alumnomodelMain.setCurrent(new Alumno());
        ApplicationDesktop.ALUMNO_VIEW.setVisible(true);
    }

    public void editar(int row) {
        AlumnoModelMain alumnomodelMain = ApplicationDesktop.ALUMNO_VIEW.getModel();
        alumnomodelMain.clearErrors();
        Alumno seleccionado = model.getAlumnos().getRowAt(row);
        alumnomodelMain.setModo(ApplicationDesktop.MODO_EDITAR);
        alumnomodelMain.setCurrent(seleccionado);
        ApplicationDesktop.ALUMNO_VIEW.setVisible(true);
    }

    public void borrar(int row) {
        Alumno seleccionada = model.getAlumnos().getRowAt(row);
        try {
            domainModel.eliminar_alumno(seleccionada.getCedula_alumno());
        } catch (Exception ex) {
        }
        this.buscar();
    }
}
