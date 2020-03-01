package Controllers;

import Application.ApplicationDesktop;
import Entities.Alumno;
import Entities.Carrera;
import Models.AlumnoModel;
import Models.Model;
import Views.AlumnoView;
import java.util.List;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class AlumnoController {

    Model domainModel;
    AlumnoView view;
    AlumnoModel model;

    public AlumnoController(AlumnoView view, AlumnoModel model, Model domainModel) {
        String[] inicializar = {};
        try {
            model.init(inicializar);
        } catch (Exception ex) {
        }
        this.domainModel = domainModel;
        this.view = view;
        this.model = model;
        this.model.setCurrent(new Alumno());
        this.model.clearErrors();
        view.setController(this);
        view.setModel(model);
    }

    public void actualizar() {
        try {
            //actualiza jComboBox de carreras
            List<Carrera> lista_carreras = new ArrayList(domainModel.listar_carrera());          
            List<String> codigos = new ArrayList();           
            for (int i = 0; i < lista_carreras.size(); i++) {
                codigos.add(lista_carreras.get(i).getCodigo_carrera());
            }         
            view.carreraFld.setModel(new DefaultComboBoxModel(codigos.toArray()));
        } catch (Exception ex) {
        }
    }

    public void guardar() {

        Alumno nuevo_alumno = new Alumno();
        model.clearErrors();

        nuevo_alumno.setCedula_alumno(view.cedulaFld.getText());
        if (view.cedulaFld.getText().length() == 0) {
            model.getErrores().put("Curso", "Curso requerido");
        }

        nuevo_alumno.setNombre(view.nombreFld.getText());
        if (view.telefonoFld.getText().length() == 0) {
            model.getErrores().put("Nombre", "Nombre requerido");
        }

        nuevo_alumno.setTelefono(view.telefonoFld.getText());
        if (view.emailFld.getText().length() == 0) {
            model.getErrores().put("Telefono", "Telefono requerido");
        }

        nuevo_alumno.setEmail(view.emailFld.getText());
        if (view.fechaFld.getText().length() == 0) {
            model.getErrores().put("Email", "Email requerido");
        }
        
        nuevo_alumno.setFecha_nacimiento(view.fechaFld.getText());
        if (view.fechaFld.getText().length() == 0) {
            model.getErrores().put("Fecha", "Fecha requerida");
        }
        
        nuevo_alumno.setCarrera(view.carreraFld.getSelectedItem().toString());        

        if (model.getErrores().isEmpty()) {

            try {
                switch (model.getModo()) {

                    case ApplicationDesktop.MODO_AGREGAR:

                        domainModel.insertar_alumno(nuevo_alumno);

                        break;

                    case ApplicationDesktop.MODO_EDITAR:

                        domainModel.modificar_alumno(nuevo_alumno);

                        break;
                }
            } catch (Exception e) {
                model.setCurrent(nuevo_alumno);
            }
        } else {
            model.setMensaje("Error!");
            model.setCurrent(nuevo_alumno);
        }
    }

}
