package Controllers;

import Entities.Carrera;
import Entities.Ciclo;
import Entities.Curso;
import Models.Model;
import Views.CursoView;
import Application.ApplicationDesktop;
import Models.CursosModels.CursoModelMain;
import java.util.List;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class CursoController {

    Model domainModel;
    CursoView view;
    CursoModelMain model;

    public CursoController(CursoView view, CursoModelMain model, Model domainModel) {
        String[] inicializar1 = {}, inicializar2 = {};
        try {
            model.init(inicializar1, inicializar2);
        } catch (Exception ex) {
        }
        this.domainModel = domainModel;
        this.view = view;
        this.model = model;
        this.model.setCurrent(new Curso());
        this.model.clearErrors();
        view.setController(this);
        view.setModel(model);
    }

    public void actualizar() {
        try {
            //actualiza jComboBox de carreras
            List<Carrera> lista_carreras = new ArrayList(domainModel.listar_carrera());
            List<Ciclo> lista_ciclos = new ArrayList(domainModel.listar_ciclo());
            List<String> codigos = new ArrayList();
            List<String> ciclos = new ArrayList();
            for (int i = 0; i < lista_carreras.size(); i++) {
                codigos.add(lista_carreras.get(i).getCodigo_carrera());
            }
            for (int i = 0; i < lista_ciclos.size(); i++) {
                ciclos.add(lista_ciclos.get(i).getNo_ciclo());
            }

            view.carreraFld.setModel(new DefaultComboBoxModel(codigos.toArray()));
            view.cicloFld.setModel(new DefaultComboBoxModel(ciclos.toArray()));
        } catch (Exception ex) {
        }
    }

    public void guardar() {

        Curso nuevo_curso = new Curso();
        model.clearErrors();

        nuevo_curso.setCodigo_curso(view.cursoFld.getText());
        if (view.cursoFld.getText().length() == 0) {
            model.getErrores().put("Curso", "Curso requerido");
        }

        nuevo_curso.setNombre(view.nombreFld.getText());
        if (view.nombreFld.getText().length() == 0) {
            model.getErrores().put("Nombre", "Nombre requerido");
        }

        nuevo_curso.setCreditos(view.creditosFld.getText());
        if (view.creditosFld.getText().length() == 0) {
            model.getErrores().put("Creditos", "Creditos requeridos");
        }

        nuevo_curso.setHoras_semanales(view.horasFld.getText());
        if (view.horasFld.getText().length() == 0) {
            model.getErrores().put("Horas", "Horas requeridas");
        }

        nuevo_curso.setCodigo_carrera(view.carreraFld.getSelectedItem().toString());

        nuevo_curso.setNo_ciclo(view.cicloFld.getSelectedItem().toString());

        if (model.getErrores().isEmpty()) {

            try {
                switch (model.getModo()) {

                    case ApplicationDesktop.MODO_AGREGAR:

                        domainModel.insertar_curso(nuevo_curso);

                        break;

                    case ApplicationDesktop.MODO_EDITAR:

                        domainModel.modificar_curso(nuevo_curso);

                        break;
                }
            } catch (Exception e) {
                model.setCurrent(nuevo_curso);
            }
        } else {
            model.setMensaje("Error!");
            model.setCurrent(nuevo_curso);
        }
    }

}
