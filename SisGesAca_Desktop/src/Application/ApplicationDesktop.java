package Application;

import Controllers.*;
import Entities.*;
import Models.*;
import Views.*;
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
    public static void main(String... args) {
        AppView appView = new AppView();
        APP_VIEW = appView;

        /**
         * ***************************************
         */
        ObjetoModel<Usuario, String> objetoModel_USUARIO = new ObjetoModel<>(Usuario.class);
        InicioSesionView inicioSesionview = INICIO_SESION_VIEW = new InicioSesionView();
        InicioSesionController inicioSesioncontroller = LOGIN_CONTROLLER = new InicioSesionController(inicioSesionview, objetoModel_USUARIO);

        /**
         * ***************************************
         */
        ObjetoModel<Alumno, String> alumnoModel = new ObjetoModel<>(Alumno.class);
        AlumnoView alumnoView = ALUMNO_VIEW = new AlumnoView();
        AlumnoController AlumnoController = new AlumnoController(alumnoView, alumnoModel);
        appView.addInternalFrame(alumnoView);

        ObjetoListadoModel<Alumno, String> alumnoListado = new ObjetoListadoModel<>(Alumno.class);
        AlumnoListadoView alumnoListadoView = ALUMNO_LISTADO_VIEW = new AlumnoListadoView();
        AlumnoListadoController alumnoListadoController = ALUMNO_LISTADO_CONTROLLER = new AlumnoListadoController(alumnoListadoView, alumnoListado);
        appView.addInternalFrame(alumnoListadoView);

        /**
         * ***************************************
         */
        ObjetoModel<Carrera, String> carreraModel = new ObjetoModel<>(Carrera.class);
        CarreraView carreraModelView = CARRERA_VIEW = new CarreraView();
        CARRERA_VIEW = carreraModelView;
        CarreraController carreraController = new CarreraController(carreraModelView, carreraModel);
        appView.addInternalFrame(carreraModelView);

        ObjetoListadoModel<Carrera, String> carreraListado = new ObjetoListadoModel<>(Carrera.class);
        CarreraListadoView carreraListadoView = CARRERA_LISTADO_VIEW = new CarreraListadoView();
        CarreraListadoController carrerasListadoController = CARRERA_LISTADO_CONTROLLER = new CarreraListadoController(carreraListadoView, carreraListado);
        appView.addInternalFrame(carreraListadoView);

        /**
         * ***************************************
         */
        ObjetoModel<Curso, String> cursoModel = new ObjetoModel<>(Curso.class);
        CursoView cursoView = CURSO_VIEW = new CursoView();
        CursoController cursoController = new CursoController(cursoView, cursoModel);
        appView.addInternalFrame(cursoView);

        ObjetoListadoModel<Curso, String> CursoListado = new ObjetoListadoModel<>(Curso.class);
        CursoListadoView cursoListadoView = CURSOS_VIEW = new CursoListadoView();
        CursoListadoController cursoscontroller = CURSO_LISTADO_CONTROLLER = new CursoListadoController(cursoListadoView, CursoListado);
        appView.addInternalFrame(cursoListadoView);

        /**
         * ***************************************
         */
        ObjetoModel<Profesor, String> profesorModel = new ObjetoModel<>(Profesor.class);
        ProfesorView profesorView = PROFESOR_VIEW = new ProfesorView();
        ProfesorController profesorController = new ProfesorController(profesorView, profesorModel);
        appView.addInternalFrame(profesorView);

        ObjetoListadoModel<Profesor, String> profesorListado = new ObjetoListadoModel<>(Profesor.class);
        ProfesorListadoView profesorListadoView = PROFESOR_LISTADO_VIEW = new ProfesorListadoView();
        ProfesorListadoController profesorListadoController = PROFESOR_LISTADO_CONTROLLER = new ProfesorListadoController(profesorListadoView, profesorListado);
        appView.addInternalFrame(profesorListadoView);
        /**
         * ***************************************
         */
//        appView.setVisible(true);
        INICIO_SESION_VIEW.setVisible(true);
    }

    public static AppView APP_VIEW;

    public static InicioSesionView INICIO_SESION_VIEW;
    public static InicioSesionController LOGIN_CONTROLLER;

    public static AlumnoView ALUMNO_VIEW;
    public static AlumnoListadoView ALUMNO_LISTADO_VIEW;
    public static AlumnoListadoController ALUMNO_LISTADO_CONTROLLER;

    public static CarreraView CARRERA_VIEW;
    public static CarreraListadoView CARRERA_LISTADO_VIEW;
    public static CarreraListadoController CARRERA_LISTADO_CONTROLLER;

    public static CursoView CURSO_VIEW;
    public static CursoListadoView CURSOS_VIEW;
    public static CursoListadoController CURSO_LISTADO_CONTROLLER;

    public static ProfesorView PROFESOR_VIEW;
    public static ProfesorListadoView PROFESOR_LISTADO_VIEW;
    public static ProfesorListadoController PROFESOR_LISTADO_CONTROLLER;

    public static final int MODO_AGREGAR = 0;
    public static final int MODO_EDITAR = 1;

    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.blue);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.blue);

}
