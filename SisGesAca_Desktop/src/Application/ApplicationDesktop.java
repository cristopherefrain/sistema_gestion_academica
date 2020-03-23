package Application;

import Controllers.*;
import Models.*;
import Models.AlumnosModels.AlumnoModelMain;
import Models.CarrerasModels.CarreraModelMain;
import Models.CursosModels.CursoModelMain;
import Models.InicioSesionModels.InicioSesionModelMain;
import Models.ProfesoresModels.ProfesorModelMain;
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
        Model domainModel = Model.instance();

        AppView appView = new AppView();
        APP_VIEW = appView;
        /**
         * ***************************************
         */
        InicioSesionModels mainInicioSesionModels = new InicioSesionModels();
        InicioSesionModelMain inicioSesionmodel = mainInicioSesionModels.new InicioSesionModelMain();
        InicioSesionView inicioSesionview = new InicioSesionView();
        INICIO_SESION_VIEW = inicioSesionview;
        InicioSesionController inicioSesioncontroller = new InicioSesionController(inicioSesionview, inicioSesionmodel, domainModel);
        LOGIN_CONTROLLER = inicioSesioncontroller;
        inicioSesionview.setVisible(true);
        /**
         * ***************************************
         */
        CarrerasModels mainCarrerasModels = new CarrerasModels();
        CarreraModelMain carreramodel = mainCarrerasModels.new CarreraModelMain();
        CarrerasModel carrerasmodel = new CarrerasModel();

        CarreraView carreraview = new CarreraView();
        CARRERA_VIEW = carreraview;
        CarreraController carreracontroller = new CarreraController(carreraview, carreramodel, domainModel);
        appView.addInternalFrame(carreraview);

        CarrerasView carrerasview = new CarrerasView();
        CARRERAS_VIEW = carrerasview;
        CarrerasController carrerascontroller = new CarrerasController(carrerasview, carrerasmodel, domainModel);
        appView.addInternalFrame(carrerasview);

        /**
         * ***************************************
         */
        CursosModels mainCursosModels = new CursosModels();
        CursoModelMain cursomodel = mainCursosModels.new CursoModelMain();
        CursosModel cursosmodel = new CursosModel();

        CursoView cursoview = new CursoView();
        CURSO_VIEW = cursoview;
        CursoController cursocontroller = new CursoController(cursoview, cursomodel, domainModel);
        appView.addInternalFrame(cursoview);

        CursosView cursosview = new CursosView();
        CURSOS_VIEW = cursosview;
        CursosController cursoscontroller = new CursosController(cursosview, cursosmodel, domainModel);
        appView.addInternalFrame(cursosview);

        /**
         * ***************************************
         */
        ProfesoresModels mainProfesoresModels = new ProfesoresModels();
        ProfesorModelMain profesormodel = mainProfesoresModels.new ProfesorModelMain();
        ProfesoresModel profesoresmodel = new ProfesoresModel();

        ProfesorView profesorview = new ProfesorView();
        PROFESOR_VIEW = profesorview;
        ProfesorController profesorcontroller = new ProfesorController(profesorview, profesormodel, domainModel);
        appView.addInternalFrame(profesorview);

        ProfesoresView profesoresview = new ProfesoresView();
        PROFESORES_VIEW = profesoresview;
        ProfesoresController profesorescontroller = new ProfesoresController(profesoresview, profesoresmodel, domainModel);
        appView.addInternalFrame(profesoresview);

        /**
         * ***************************************
         */
        AlumnosModels mainAlumnosModels = new AlumnosModels();
        AlumnoModelMain alumnomodel = mainAlumnosModels.new AlumnoModelMain();
        AlumnosModel alumnosmodel = new AlumnosModel();

        AlumnoView alumnoview = new AlumnoView();
        ALUMNO_VIEW = alumnoview;
        AlumnoController alumnocontroller = new AlumnoController(alumnoview, alumnomodel, domainModel);
        appView.addInternalFrame(alumnoview);

        AlumnosView alumnosview = new AlumnosView();
        ALUMNOS_VIEW = alumnosview;
        AlumnosController alumnoscontroller = new AlumnosController(alumnosview, alumnosmodel, domainModel);
        appView.addInternalFrame(alumnosview);

//        appView.setVisible(true);
    }

    public static AppView APP_VIEW;

    public static InicioSesionView INICIO_SESION_VIEW;
    public static InicioSesionController LOGIN_CONTROLLER;

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
