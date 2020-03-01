/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entities.*;
import Exceptions.*;
import Services.*;
import java.util.Collection;

/**
 *
 * @author Moviles
 */
public class Model {

    private static Model uniqueInstance;
    private AlumnoService daoAlumno;
    private CarreraService daoCarrera;
    private CicloService daoCiclo;
    private CursoService daoCurso;
    private ProfesorService daoProfesor;

    public Model() {
        daoAlumno = new AlumnoService();
        daoCarrera = new CarreraService();
        daoCiclo = new CicloService();
        daoCurso = new CursoService();
        daoProfesor = new ProfesorService();
    }

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }

//    Servicce Alumno
    public void insertar_alumno(Alumno elAlumno) throws GlobalException, NoDataException {
        daoAlumno.insertar_alumno(elAlumno);
    }

    public void modificar_alumno(Alumno elAlumno) throws GlobalException, NoDataException {
        daoAlumno.modificar_alumno(elAlumno);
    }

    public Alumno buscar_alumno(String id) throws GlobalException, NoDataException {
        return daoAlumno.buscar_alumno(id);
    }

    public Collection listar_alumno() throws GlobalException, NoDataException {
        return daoAlumno.listar_alumno();
    }

    public void eliminar_alumno(String id) throws GlobalException, NoDataException {
        daoAlumno.eliminar_alumno(id);
    }

    //    Servicce Carrera
    public void insertar_carrera(Carrera laCarrera) throws GlobalException, NoDataException {
        daoCarrera.insertar_carrera(laCarrera);
    }

    public void modificar_carrera(Carrera laCarrera) throws GlobalException, NoDataException {
        daoCarrera.modificar_carrera(laCarrera);
    }

    public Carrera buscar_carrera(String id) throws GlobalException, NoDataException {
        return daoCarrera.buscar_carrera(id);
    }

    public Collection listar_carrera() throws GlobalException, NoDataException {
        return daoCarrera.listar_carrera();
    }

    public void eliminar_carrera(String id) throws GlobalException, NoDataException {
        daoCarrera.eliminar_carrera(id);
    }

    //    Servicce Ciclo
    public Collection listar_ciclo() throws GlobalException, NoDataException {
        return daoCiclo.listar_ciclo();
    }

    //    Servicce Curso
    public void insertar_curso(Curso elCurso) throws GlobalException, NoDataException {
        daoCurso.insertar_curso(elCurso);
    }

    public void modificar_curso(Curso elCurso) throws GlobalException, NoDataException {
        daoCurso.modificar_curso(elCurso);
    }

    public Curso buscar_curso(String id) throws GlobalException, NoDataException {
        return daoCurso.buscar_curso(id);
    }

    public Collection listar_curso() throws GlobalException, NoDataException {
        return daoCurso.listar_curso();
    }

    public void eliminar_curso(String id) throws GlobalException, NoDataException {
        daoCurso.eliminar_curso(id);
    }

    //    Servicce Profesor
    public void insertar_profesor(Profesor elProfesor) throws GlobalException, NoDataException {
        daoProfesor.insertar_profesor(elProfesor);
    }

    public void modificar_profesor(Profesor elProfesor) throws GlobalException, NoDataException {
        daoProfesor.modificar_profesor(elProfesor);
    }

    public Profesor buscar_profesor(String id) throws GlobalException, NoDataException {
        return daoProfesor.buscar_profesor(id);
    }

    public Collection listar_profesor() throws GlobalException, NoDataException {
        return daoProfesor.listar_profesor();
    }

    public void eliminar_profesor(String id) throws GlobalException, NoDataException {
        daoProfesor.listar_profesor();
    }

}
