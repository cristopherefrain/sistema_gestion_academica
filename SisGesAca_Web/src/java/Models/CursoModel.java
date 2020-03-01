/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entities.Curso;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wizard
 */
public class CursoModel {

    private Model domainModel;
    private Curso current;

    public CursoModel() {
        domainModel = Model.instance();
        current = null;
    }

    public CursoModel(Model domainModel, Curso current) {
        this.domainModel = domainModel;
        this.current = current;
    }

    public void insertar_curso(Curso elAlumno) throws GlobalException, NoDataException {
        domainModel.insertar_curso(elAlumno);
    }

    public void modificar_curso(Curso elAlumno) throws GlobalException, NoDataException {
        domainModel.modificar_curso(elAlumno);
    }

    public Curso buscar_curso(String id) throws GlobalException, NoDataException {
        return domainModel.buscar_curso(id);
    }

    public List<Curso> listar_curso() throws GlobalException, NoDataException {
        return new ArrayList(domainModel.listar_curso());
    }

    public void eliminar_curso(String id) throws GlobalException, NoDataException {
        domainModel.eliminar_curso(id);
    }
}
