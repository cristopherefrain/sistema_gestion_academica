package Models;

import Entities.*;
import static Services.UtilitiesSQL.validateCredentials;
import Exceptions.*;
import Services.*;
import java.util.Collection;

/**
 *
 * @author wizard
 */
public class Model {

    private static Model uniqueInstance;
    private final ServiceTemplate<Alumno, String> daoAlumno;
    private final ServiceTemplate<Carrera, String> daoCarrera;
    private final ServiceTemplate<Ciclo, String> daoCiclo;
    private final ServiceTemplate<Curso, String> daoCurso;
    private final ServiceTemplate<Profesor, String> daoProfesor;
    private final ServiceTemplate<Usuario, String> daoInicioSesion;

    public Model() {
        daoAlumno = new ServiceTemplate<>(Alumno.class);
        daoCarrera = new ServiceTemplate<>(Carrera.class);
        daoCiclo = new ServiceTemplate<>(Ciclo.class);
        daoCurso = new ServiceTemplate<>(Curso.class);
        daoProfesor = new ServiceTemplate<>(Profesor.class);
        daoInicioSesion = new ServiceTemplate<>(Usuario.class);
    }

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }

    /*Buscar Objeto*/
    public Object buscar_objeto(Class<?> entityClass, Object id) throws GlobalException, NoDataException {
        switch (entityClass.getSimpleName()) {
            case "Alumno":
                return daoAlumno.buscar_objeto((String) id);
            case "Carrera":
                return daoCarrera.buscar_objeto((String) id);
            case "Ciclo":
                return daoCiclo.buscar_objeto((String) id);
            case "Curso":
                return daoCurso.buscar_objeto((String) id);
            case "Profesor":
                return daoProfesor.buscar_objeto((String) id);
            default:
                return null;
        }
    }

    /*Listar Objeto*/
    public Collection listar_objeto(Class<?> entityClass) throws GlobalException, NoDataException {
        switch (entityClass.getSimpleName()) {
            case "Alumno":
                return daoAlumno.listar_objeto();
            case "Carrera":
                return daoCarrera.listar_objeto();
            case "Ciclo":
                return daoCiclo.listar_objeto();
            case "Curso":
                return daoCurso.listar_objeto();
            case "Profesor":
                return daoProfesor.listar_objeto();
            default:
                return null;
        }
    }

    /*Insertar Objeto*/
    public void insertar_objeto(Class<?> entityClass, Object objeto) throws GlobalException, NoDataException {
        switch (entityClass.getSimpleName()) {
            case "Alumno":
                daoAlumno.insertar_objeto((Alumno) objeto);
                break;
            case "Carrera":
                daoCarrera.insertar_objeto((Carrera) objeto);
                break;
            case "Ciclo":
                daoCiclo.insertar_objeto((Ciclo) objeto);
                break;
            case "Curso":
                daoCurso.insertar_objeto((Curso) objeto);
                break;
            case "Profesor":
                daoProfesor.insertar_objeto((Profesor) objeto);
                break;
            default:
                break;
        }
    }

    /*Modificar Objeto*/
    public void modificar_objeto(Class<?> entityClass, Object objeto) throws GlobalException, NoDataException {
        switch (entityClass.getSimpleName()) {
            case "Alumno":
                daoAlumno.modificar_objeto((Alumno) objeto);
                break;
            case "Carrera":
                daoCarrera.modificar_objeto((Carrera) objeto);
                break;
            case "Ciclo":
                daoCiclo.modificar_objeto((Ciclo) objeto);
                break;
            case "Curso":
                daoCurso.modificar_objeto((Curso) objeto);
                break;
            case "Profesor":
                daoProfesor.modificar_objeto((Profesor) objeto);
                break;
            default:
                break;
        }
    }

    /*Eliminar Objeto*/
    public void eliminar_objeto(Class<?> entityClass, Object id) throws GlobalException, NoDataException {
        switch (entityClass.getSimpleName()) {
            case "Alumno":
                daoAlumno.eliminar_objeto((String) id);
                break;
            case "Carrera":
                daoCarrera.eliminar_objeto((String) id);
                break;
            case "Ciclo":
                daoCiclo.eliminar_objeto((String) id);
                break;
            case "Curso":
                daoCurso.eliminar_objeto((String) id);
                break;
            case "Profesor":
                daoProfesor.eliminar_objeto((String) id);
                break;
            default:
                break;
        }
    }

    //Service Inicio Sesion
    public Boolean iniciarSesion(final String cedula, final String clave) {
        return validateCredentials(cedula, clave);
    }

}
