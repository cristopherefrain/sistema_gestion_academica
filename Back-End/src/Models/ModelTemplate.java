package Models;

import Exceptions.*;
import java.util.Collection;

/**
 *
 * @author wizard
 * @param <T>
 * @param <K>
 */
public class ModelTemplate<T, K> {

    private final Class<T> objectType;
    private final Model domainModel;
    protected T current;

    public ModelTemplate(Class<T> objectType) {
        this.objectType = objectType;
        this.domainModel = Model.instance();
        this.current = null;
    }

    public T getCurrent() {
        return current;
    }

    public void setCurrent(T current) {
        this.current = current;
    }

    /*Buscar Objeto*/
    public T buscar_objeto(final K id) throws GlobalException, NoDataException {
        return (T) domainModel.buscar_objeto(objectType, id);
    }

    /*Listar Objeto*/
    public Collection listar_objeto() throws GlobalException, NoDataException {
        return domainModel.listar_objeto(objectType);
    }

    /*Insertar Objeto*/
    public void insertar_objeto(T objeto) throws GlobalException, NoDataException {
        domainModel.insertar_objeto(objectType, objeto);
    }

    /*Modificar Objeto*/
    public void modificar_objeto(T objeto) throws GlobalException, NoDataException {
        domainModel.modificar_objeto(objectType, objeto);
    }

    /*Eliminar Objeto*/
    public void eliminar_objeto(final K id) throws GlobalException, NoDataException {
        domainModel.eliminar_objeto(objectType, id);
    }

    /*Buscar Objeto PARAMETRO*/
    public T buscar_objeto(Class<?> objectType, final K id) throws GlobalException, NoDataException {
        return (T) domainModel.buscar_objeto(objectType, id);
    }

    /*Listar Objeto PARAMETRO*/
    public Collection listar_objeto(Class<?> objectType) throws GlobalException, NoDataException {
        return domainModel.listar_objeto(objectType);
    }

    /*Insertar Objeto PARAMETRO*/
    public void insertar_objeto(Class<?> objectType, T objeto) throws GlobalException, NoDataException {
        domainModel.insertar_objeto(objectType, objeto);
    }

    /*Modificar Objeto PARAMETRO*/
    public void modificar_objeto(Class<?> objectType, T objeto) throws GlobalException, NoDataException {
        domainModel.modificar_objeto(objectType, objeto);
    }

    /*Eliminar Objeto PARAMETRO*/
    public void eliminar_objeto(Class<?> objectType, final K id) throws GlobalException, NoDataException {
        domainModel.eliminar_objeto(objectType, id);
    }

    //Service Inicio Sesion
    public Boolean iniciarSesion(final K cedula, final K clave) {
        return domainModel.iniciarSesion((String) cedula, (String) clave);
    }

}
