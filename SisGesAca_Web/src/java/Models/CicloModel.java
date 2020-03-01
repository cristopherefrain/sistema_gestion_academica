/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entities.Ciclo;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wizard
 */
public class CicloModel {

    private Model domainModel;
    private Ciclo current;

    public CicloModel() {
        domainModel = Model.instance();
        current = null;

    }

    public CicloModel(Model domainModel, Ciclo current) {
        this.domainModel = domainModel;
        this.current = current;
    }

    public List<Ciclo> listar_ciclo() throws GlobalException, NoDataException {
        return new ArrayList(domainModel.listar_ciclo());
    }
}
