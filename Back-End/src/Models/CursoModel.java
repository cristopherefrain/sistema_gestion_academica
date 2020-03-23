package Models;

import Entities.Curso;
import Exceptions.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wizard
 */
public class CursoModel {

    private final Model domainModel;
    protected Curso current;

    public CursoModel() {
        domainModel = Model.instance();
        current = null;
    }

    public CursoModel(final Model domainModel, Curso current) {
        this.domainModel = domainModel;
        this.current = current;
    }

    public Curso getCurrent() {
        return current;
    }

    public void setCurrent(Curso current) {
        this.current = current;
    }

    public void insertar_curso(final Curso elAlumno) throws GlobalException, NoDataException {
        domainModel.insertar_curso(elAlumno);
    }

    public void modificar_curso(final Curso elAlumno) throws GlobalException, NoDataException {
        domainModel.modificar_curso(elAlumno);
    }

    public Curso buscar_curso(final String id) throws GlobalException, NoDataException {
        return domainModel.buscar_curso(id);
    }

    public List<Curso> listar_curso() throws GlobalException, NoDataException {
        return new ArrayList(domainModel.listar_curso());
    }

    public void eliminar_curso(final String id) throws GlobalException, NoDataException {
        domainModel.eliminar_curso(id);
    }
}
