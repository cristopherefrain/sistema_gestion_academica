package Models;

import Entities.Profesor;
import Exceptions.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wizard
 */
public class ProfesorModel {

    private final Model domainModel;
    protected Profesor current;

    public ProfesorModel() {
        domainModel = Model.instance();
        current = null;
    }

    public Profesor getCurrent() {
        return current;
    }

    public void setCurrent(Profesor current) {
        this.current = current;
    }

    public ProfesorModel(final Model domainModel, Profesor current) {
        this.domainModel = domainModel;
        this.current = current;
    }

    public void insertar_profesor(final Profesor elProfesor) throws GlobalException, NoDataException {
        domainModel.insertar_profesor(elProfesor);
    }

    public void modificar_profesor(final Profesor elProfesor) throws GlobalException, NoDataException {
        domainModel.modificar_profesor(elProfesor);
    }

    public Profesor buscar_profesor(final String id) throws GlobalException, NoDataException {
        return domainModel.buscar_profesor(id);
    }

    public List<Profesor> listar_profesor() throws GlobalException, NoDataException {
        return new ArrayList(domainModel.listar_profesor());
    }

    public void eliminar_profesor(final String id) throws GlobalException, NoDataException {
        domainModel.eliminar_profesor(id);
    }
}
