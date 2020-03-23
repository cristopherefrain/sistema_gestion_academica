package Models;

import Entities.Alumno;
import Exceptions.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wizard
 */
public class AlumnoModel {

    private final Model domainModel;
    protected Alumno current;

    public AlumnoModel() {
        domainModel = Model.instance();
        current = null;
    }

    public AlumnoModel(final Model domainModel, Alumno current) {
        this.domainModel = domainModel;
        this.current = current;
    }

    public Alumno getCurrent() {
        return current;
    }

    public void setCurrent(Alumno current) {
        this.current = current;
    }

    public void insertar_alumno(final Alumno elAlumno) throws GlobalException, NoDataException {
        domainModel.insertar_alumno(elAlumno);
    }

    public void modificar_alumno(final Alumno elAlumno) throws GlobalException, NoDataException {
        domainModel.modificar_alumno(elAlumno);
    }

    public Alumno buscar_alumno(final String id) throws GlobalException, NoDataException {
        return domainModel.buscar_alumno(id);
    }

    public List<Alumno> listar_alumno() throws GlobalException, NoDataException {
        return new ArrayList(domainModel.listar_alumno());
    }

    public void eliminar_alumno(final String id) throws GlobalException, NoDataException {
        domainModel.eliminar_alumno(id);
    }

}
