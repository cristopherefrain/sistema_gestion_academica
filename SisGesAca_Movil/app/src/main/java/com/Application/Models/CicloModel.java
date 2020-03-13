package com.Application.Models;

import com.Application.Entities.Ciclo;
import com.Application.Exceptions.GlobalException;
import com.Application.Exceptions.NoDataException;
import com.Application.Models.Model;

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
