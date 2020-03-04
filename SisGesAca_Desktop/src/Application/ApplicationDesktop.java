/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Controllers.AlumnoController;
import Controllers.AlumnosController;
import Controllers.CarreraController;
import Controllers.CarrerasController;
import Controllers.CursoController;
import Controllers.CursosController;
import Controllers.ProfesorController;
import Controllers.ProfesoresController;
import Models.AlumnoModel;
import Models.AlumnosModel;
import Models.CarreraModel;
import Models.CarrerasModel;
import Models.CursoModel;
import Models.CursosModel;
import Models.Model;
import Models.ProfesorModel;
import Models.ProfesoresModel;
import Views.AlumnoView;
import Views.AlumnosView;
import Views.AppView;
import Views.CarreraView;
import Views.CarrerasView;
import Views.CursoView;
import Views.CursosView;
import Views.LoginView;
import Views.ProfesorView;
import Views.ProfesoresView;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author wizard
 */
public class ApplicationDesktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model domainModel = Model.instance();

        APP_VIEW = new AppView();
        LoginView loginView = new LoginView();

        CarreraModel carreramodel = new CarreraModel();
        CarrerasModel carrerasmodel = new CarrerasModel();

        CarreraView carreraview = new CarreraView();
        CARRERA_VIEW = carreraview;
        CarreraController carreracontroller = new CarreraController(carreraview, carreramodel, domainModel);
        APP_VIEW.addInternalFrame(carreraview);

        CarrerasView carrerasview = new CarrerasView();
        CARRERAS_VIEW = carrerasview;
        CarrerasController carrerascontroller = new CarrerasController(carrerasview, carrerasmodel, domainModel);
        APP_VIEW.addInternalFrame(carrerasview);

        /**
         * ***************************************
         */
        CursoModel cursomodel = new CursoModel();
        CursosModel cursosmodel = new CursosModel();

        CursoView cursoview = new CursoView();
        CURSO_VIEW = cursoview;
        CursoController cursocontroller = new CursoController(cursoview, cursomodel, domainModel);
        APP_VIEW.addInternalFrame(cursoview);

        CursosView cursosview = new CursosView();
        CURSOS_VIEW = cursosview;
        CursosController cursoscontroller = new CursosController(cursosview, cursosmodel, domainModel);
        APP_VIEW.addInternalFrame(cursosview);

        /**
         * ***************************************
         */
        ProfesorModel profesormodel = new ProfesorModel();
        ProfesoresModel profesoresmodel = new ProfesoresModel();

        ProfesorView profesorview = new ProfesorView();
        PROFESOR_VIEW = profesorview;
        ProfesorController profesorcontroller = new ProfesorController(profesorview, profesormodel, domainModel);
        APP_VIEW.addInternalFrame(profesorview);

        ProfesoresView profesoresview = new ProfesoresView();
        PROFESORES_VIEW = profesoresview;
        ProfesoresController profesorescontroller = new ProfesoresController(profesoresview, profesoresmodel, domainModel);
        APP_VIEW.addInternalFrame(profesoresview);

        /**
         * ***************************************
         */
        AlumnoModel alumnomodel = new AlumnoModel();
        AlumnosModel alumnosmodel = new AlumnosModel();

        AlumnoView alumnoview = new AlumnoView();
        ALUMNO_VIEW = alumnoview;
        AlumnoController alumnocontroller = new AlumnoController(alumnoview, alumnomodel, domainModel);
        APP_VIEW.addInternalFrame(alumnoview);

        AlumnosView alumnosview = new AlumnosView();
        ALUMNOS_VIEW = alumnosview;
        AlumnosController alumnoscontroller = new AlumnosController(alumnosview, alumnosmodel, domainModel);
        APP_VIEW.addInternalFrame(alumnosview);

        loginView.setVisible(true);
    }
    
    public static AppView APP_VIEW;

    public static CarreraView CARRERA_VIEW;
    public static CarrerasView CARRERAS_VIEW;

    public static CursoView CURSO_VIEW;
    public static CursosView CURSOS_VIEW;

    public static ProfesorView PROFESOR_VIEW;
    public static ProfesoresView PROFESORES_VIEW;

    public static AlumnoView ALUMNO_VIEW;
    public static AlumnosView ALUMNOS_VIEW;

    public static final int MODO_AGREGAR = 0;
    public static final int MODO_EDITAR = 1;

    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.blue);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.blue);
    
}
