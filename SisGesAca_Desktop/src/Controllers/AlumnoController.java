package Controllers;

import Application.ApplicationDesktop;
import static Application.ApplicationDesktop.ALUMNO_LISTADO_CONTROLLER;
import Entities.Alumno;
import Entities.Carrera;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import Models.ObjetoModel;
import Views.AlumnoView;
import java.util.List;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public final class AlumnoController {

    private final AlumnoView view;
    private final ObjetoModel<Alumno, String> model;

    public AlumnoController(AlumnoView view, ObjetoModel model) {
        String[] inicializar = {};
        model.init(inicializar, null);

        this.view = view;
        this.model = model;

        view.setController(this);
        view.setModel(model);
    }

    public void actualizar() {
        try {
            List<Carrera> lista_carreras = new ArrayList(model.getModelTemplate().listar_objeto(Carrera.class));
            List<String> lista_codigos_carreras = new ArrayList();
            for (int i = 0; i < lista_carreras.size(); i++) {
                lista_codigos_carreras.add(lista_carreras.get(i).getCodigo_carrera());
            }
            view.carreraFld.setModel(new DefaultComboBoxModel(lista_codigos_carreras.toArray()));
        } catch (GlobalException | NoDataException ex) {
        }
    }

    public void guardar() {
        model.clearErrors();
        Alumno nuevo_alumno = createObject();
        checkErrors();
        if (model.getErrores().isEmpty()) {
            try {
                switch (model.getModo()) {
                    case ApplicationDesktop.MODO_AGREGAR:
                        model.getModelTemplate().insertar_objeto(nuevo_alumno);
                        break;
                    case ApplicationDesktop.MODO_EDITAR:
                        model.getModelTemplate().modificar_objeto(nuevo_alumno);
                        break;
                }
                ALUMNO_LISTADO_CONTROLLER.buscar();
            } catch (GlobalException | NoDataException e) {
                model.setCurrent(nuevo_alumno);
            }
        } else {
            model.setMensaje("Error!");
            model.setCurrent(nuevo_alumno);
        }
    }

    public Alumno createObject() {
        Alumno alumno = new Alumno();
        alumno.setCedula_alumno(view.cedulaFld.getText());
        alumno.setNombre(view.nombreFld.getText());
        alumno.setTelefono(view.telefonoFld.getText());
        alumno.setEmail(view.emailFld.getText());
        alumno.setFecha_nacimiento(view.fechaFld.getText());
        alumno.setCarrera(view.carreraFld.getSelectedItem().toString());
        return alumno;
    }

    public void checkErrors() {
        if (view.cedulaFld.getText().length() == 0) {
            model.getErrores().put("Curso", "Curso requerido");
        }
        if (view.telefonoFld.getText().length() == 0) {
            model.getErrores().put("Nombre", "Nombre requerido");
        }
        if (view.emailFld.getText().length() == 0) {
            model.getErrores().put("Telefono", "Telefono requerido");
        }
        if (view.fechaFld.getText().length() == 0) {
            model.getErrores().put("Email", "Email requerido");
        }
        if (view.fechaFld.getText().length() == 0) {
            model.getErrores().put("Fecha", "Fecha requerida");
        }
    }
}
