package com.Application.Models;

import com.Application.Entities.Alumno;
import com.Application.Exceptions.GlobalException;
import com.Application.Exceptions.NoDataException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wizard
 */
public class AlumnoModel {

    private Model domainModel;
    private Alumno current;

    public AlumnoModel() {
        domainModel = Model.instance();
        current = null;
    }

    public AlumnoModel(Model domainModel, Alumno current) {
        this.domainModel = domainModel;
        this.current = current;
    }

    public void insertar_alumno(Alumno elAlumno) throws GlobalException, NoDataException {
        domainModel.insertar_alumno(elAlumno);
    }

    public void modificar_alumno(Alumno elAlumno) throws GlobalException, NoDataException {
        domainModel.modificar_alumno(elAlumno);
    }

    public Alumno buscar_alumno(String id) throws GlobalException, NoDataException {
        return domainModel.buscar_alumno(id);
    }

    public List<Alumno> listar_alumno() throws GlobalException, NoDataException {
        return new ArrayList(domainModel.listar_alumno());
    }

    public void eliminar_alumno(String id) throws GlobalException, NoDataException {
        domainModel.eliminar_alumno(id);
    }

}