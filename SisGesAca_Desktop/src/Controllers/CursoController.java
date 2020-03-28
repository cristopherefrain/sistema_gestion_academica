package Controllers;

import Entities.Carrera;
import Entities.Ciclo;
import Entities.Curso;
import Models.ObjetoModel;
import Views.CursoView;
import Application.ApplicationDesktop;
import static Application.ApplicationDesktop.CURSO_LISTADO_CONTROLLER;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public final class CursoController {

    private final CursoView view;
    private final ObjetoModel<Curso, String> model;

    public CursoController(CursoView view, ObjetoModel model) {
        String[] inicializar1 = {}, inicializar2 = {};
        model.init(inicializar1, inicializar2);

        this.view = view;
        this.model = model;

        view.setController(this);
        view.setModel(model);
    }

    public void actualizar() {
        try {
            List<Carrera> lista_carreras = new ArrayList(model.getModelTemplate().listar_objeto(Carrera.class));
            List<Ciclo> lista_ciclos = new ArrayList(model.getModelTemplate().listar_objeto(Ciclo.class));
            List<String> codigos_carreras = new ArrayList();
            List<String> no_ciclos = new ArrayList();
            for (int i = 0; i < lista_carreras.size(); i++) {
                codigos_carreras.add(lista_carreras.get(i).getCodigo_carrera());
            }
            for (int i = 0; i < lista_ciclos.size(); i++) {
                no_ciclos.add(lista_ciclos.get(i).getNo_ciclo());
            }
            view.carreraFld.setModel(new DefaultComboBoxModel(codigos_carreras.toArray()));
            view.cicloFld.setModel(new DefaultComboBoxModel(no_ciclos.toArray()));
        } catch (GlobalException | NoDataException ex) {
        }
    }

    public void guardar() {
        model.clearErrors();
        Curso nuevo_curso = createObject();
        checkErrors();
        if (model.getErrores().isEmpty()) {
            try {
                switch (model.getModo()) {
                    case ApplicationDesktop.MODO_AGREGAR:
                        model.getModelTemplate().insertar_objeto(nuevo_curso);
                        break;
                    case ApplicationDesktop.MODO_EDITAR:
                        model.getModelTemplate().modificar_objeto(nuevo_curso);
                        break;
                }
                CURSO_LISTADO_CONTROLLER.buscar();
            } catch (GlobalException | NoDataException e) {
                model.setCurrent(nuevo_curso);
            }
        } else {
            model.setMensaje("Error!");
            model.setCurrent(nuevo_curso);
        }
    }

    public Curso createObject() {
        Curso curso = new Curso();
        curso.setCodigo_curso(view.cursoFld.getText());
        curso.setNombre(view.nombreFld.getText());
        curso.setCreditos(view.creditosFld.getText());
        curso.setHoras_semanales(view.horasFld.getText());
        curso.setCodigo_carrera(view.carreraFld.getSelectedItem().toString());
        curso.setNo_ciclo(view.cicloFld.getSelectedItem().toString());
        return curso;
    }

    public void checkErrors() {
        if (view.cursoFld.getText().length() == 0) {
            model.getErrores().put("Curso", "Curso requerido");
        }
        if (view.nombreFld.getText().length() == 0) {
            model.getErrores().put("Nombre", "Nombre requerido");
        }
        if (view.creditosFld.getText().length() == 0) {
            model.getErrores().put("Creditos", "Creditos requeridos");
        }
        if (view.horasFld.getText().length() == 0) {
            model.getErrores().put("Horas", "Horas requeridas");
        }
    }

}
