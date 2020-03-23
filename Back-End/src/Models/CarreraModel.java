package Models;

import Entities.Carrera;
import Exceptions.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wizard
 */
public class CarreraModel {

    private final Model domainModel;
    protected Carrera current;

    public CarreraModel() {
        domainModel = Model.instance();
        current = null;
    }

    public CarreraModel(final Model domainModel, Carrera current) {
        this.domainModel = domainModel;
        this.current = current;
    }

    public Carrera getCurrent() {
        return current;
    }

    public void setCurrent(Carrera current) {
        this.current = current;
    }

    public void insertar_carrera(final Carrera laCarrera) throws GlobalException, NoDataException {
        domainModel.insertar_carrera(laCarrera);
    }

    public void modificar_carrera(final Carrera laCarrera) throws GlobalException, NoDataException {
        domainModel.modificar_carrera(laCarrera);
    }

    public Carrera buscar_carrera(final String id) throws GlobalException, NoDataException {
        return domainModel.buscar_carrera(id);
    }

    public List<Carrera> listar_carrera() throws GlobalException, NoDataException {
        return new ArrayList(domainModel.listar_carrera());
    }

    public void eliminar_carrera(final String id) throws GlobalException, NoDataException {
        domainModel.eliminar_carrera(id);
    }
}
