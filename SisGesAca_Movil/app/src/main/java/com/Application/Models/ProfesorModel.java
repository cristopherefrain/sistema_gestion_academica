package com.Application.Models;

import com.Application.Entities.Profesor;
import com.Application.Exceptions.GlobalException;
import com.Application.Exceptions.NoDataException;
import com.Application.Models.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wizard
 */
public class ProfesorModel {

    private Model domainModel;
    private Profesor current;

    public ProfesorModel() {
        domainModel = Model.instance();
        current = null;
    }

    public ProfesorModel(Model domainModel, Profesor current) {
        this.domainModel = domainModel;
        this.current = current;
    }

    public void insertar_profesor(Profesor elProfesor) throws GlobalException, NoDataException {
        domainModel.insertar_profesor(elProfesor);
    }

    public void modificar_profesor(Profesor elProfesor) throws GlobalException, NoDataException {
        domainModel.modificar_profesor(elProfesor);
    }

    public Profesor buscar_profesor(String id) throws GlobalException, NoDataException {
        return domainModel.buscar_profesor(id);
    }

    public List<Profesor> listar_profesor() throws GlobalException, NoDataException {
        return new ArrayList(domainModel.listar_profesor());
    }

    public void eliminar_profesor(String id) throws GlobalException, NoDataException {
        domainModel.eliminar_profesor(id);
    }
}
