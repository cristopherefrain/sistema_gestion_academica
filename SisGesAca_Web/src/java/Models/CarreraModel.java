/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entities.Carrera;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wizard
 */
public class CarreraModel {

    private Model domainModel;
    private Carrera current;

    public CarreraModel() {
        domainModel = Model.instance();
        current = null;
    }

    public CarreraModel(Model domainModel, Carrera current) {
        this.domainModel = domainModel;
        this.current = current;
    }

    public void insertar_carrera(Carrera laCarrera) throws GlobalException, NoDataException {
        domainModel.insertar_carrera(laCarrera);
    }

    public void modificar_carrera(Carrera laCarrera) throws GlobalException, NoDataException {
        domainModel.modificar_carrera(laCarrera);
    }

    public Carrera buscar_carrera(String id) throws GlobalException, NoDataException {
        return domainModel.buscar_carrera(id);
    }

    public List<Carrera> listar_carrera() throws GlobalException, NoDataException {
        return new ArrayList(domainModel.listar_carrera());
    }

    public void eliminar_carrera(String id) throws GlobalException, NoDataException {
        domainModel.eliminar_carrera(id);
    }
}
