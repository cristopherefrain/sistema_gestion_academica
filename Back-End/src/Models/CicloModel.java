package Models;

import Entities.Ciclo;
import Exceptions.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wizard
 */
public class CicloModel {

    private final Model domainModel;
    protected Ciclo current;

    public CicloModel() {
        domainModel = Model.instance();
        current = null;

    }

    public CicloModel(final Model domainModel, Ciclo current) {
        this.domainModel = domainModel;
        this.current = current;
    }

    public Ciclo getCurrent() {
        return current;
    }

    public void setCurrent(Ciclo current) {
        this.current = current;
    }

    public List<Ciclo> listar_ciclo() throws GlobalException, NoDataException {
        return new ArrayList(domainModel.listar_ciclo());
    }
}
