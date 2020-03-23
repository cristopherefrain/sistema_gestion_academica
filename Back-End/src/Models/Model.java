package Models;

import Entities.*;
import Exceptions.*;
import Services.*;
import java.util.Collection;

/**
 *
 * @author wizard
 */
public class Model {

    private static Model uniqueInstance;
    private final AlumnoService daoAlumno;
    private final CarreraService daoCarrera;
    private final CicloService daoCiclo;
    private final CursoService daoCurso;
    private final ProfesorService daoProfesor;
    private final InicioSesionService daoInicioSesion;

    public Model() {
        daoAlumno = new AlumnoService();
        daoCarrera = new CarreraService();
        daoCiclo = new CicloService();
        daoCurso = new CursoService();
        daoProfesor = new ProfesorService();
        daoInicioSesion = new InicioSesionService();
    }

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }

//    Service Alumno
    public void insertar_alumno(final Alumno elAlumno) throws GlobalException, NoDataException {
        daoAlumno.insertar_alumno(elAlumno);
    }

    public void modificar_alumno(final Alumno elAlumno) throws GlobalException, NoDataException {
        daoAlumno.modificar_alumno(elAlumno);
    }

    public Alumno buscar_alumno(final String id) throws GlobalException, NoDataException {
        return daoAlumno.buscar_alumno(id);
    }

    public Collection listar_alumno() throws GlobalException, NoDataException {
        return daoAlumno.listar_alumno();
    }

    public void eliminar_alumno(final String id) throws GlobalException, NoDataException {
        daoAlumno.eliminar_alumno(id);
    }

    //    Service Carrera
    public void insertar_carrera(final Carrera laCarrera) throws GlobalException, NoDataException {
        daoCarrera.insertar_carrera(laCarrera);
    }

    public void modificar_carrera(final Carrera laCarrera) throws GlobalException, NoDataException {
        daoCarrera.modificar_carrera(laCarrera);
    }

    public Carrera buscar_carrera(final String id) throws GlobalException, NoDataException {
        return daoCarrera.buscar_carrera(id);
    }

    public Collection listar_carrera() throws GlobalException, NoDataException {
        return daoCarrera.listar_carrera();
    }

    public void eliminar_carrera(final String id) throws GlobalException, NoDataException {
        daoCarrera.eliminar_carrera(id);
    }

    //    Service Ciclo
    public Collection listar_ciclo() throws GlobalException, NoDataException {
        return daoCiclo.listar_ciclo();
    }

    //    Service Curso
    public void insertar_curso(final Curso elCurso) throws GlobalException, NoDataException {
        daoCurso.insertar_curso(elCurso);
    }

    public void modificar_curso(final Curso elCurso) throws GlobalException, NoDataException {
        daoCurso.modificar_curso(elCurso);
    }

    public Curso buscar_curso(final String id) throws GlobalException, NoDataException {
        return daoCurso.buscar_curso(id);
    }

    public Collection listar_curso() throws GlobalException, NoDataException {
        return daoCurso.listar_curso();
    }

    public void eliminar_curso(final String id) throws GlobalException, NoDataException {
        daoCurso.eliminar_curso(id);
    }

    //    Service Profesor
    public void insertar_profesor(final Profesor elProfesor) throws GlobalException, NoDataException {
        daoProfesor.insertar_profesor(elProfesor);
    }

    public void modificar_profesor(final Profesor elProfesor) throws GlobalException, NoDataException {
        daoProfesor.modificar_profesor(elProfesor);
    }

    public Profesor buscar_profesor(final String id) throws GlobalException, NoDataException {
        return daoProfesor.buscar_profesor(id);
    }

    public Collection listar_profesor() throws GlobalException, NoDataException {
        return daoProfesor.listar_profesor();
    }

    public void eliminar_profesor(final String id) throws GlobalException, NoDataException {
        daoProfesor.listar_profesor();
    }

    //    Service Inicio Sesion
    public Boolean iniciarSesion(final Usuario usuario) {
        return daoInicioSesion.iniciarSesion(usuario);
    }

}
