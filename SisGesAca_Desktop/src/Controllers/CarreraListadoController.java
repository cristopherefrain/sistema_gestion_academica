package Controllers;

import Entities.Carrera;
import Views.CarreraListadoView;
import Application.ApplicationDesktop;
import Exceptions.GlobalException;
import Exceptions.NoDataException;
import Models.ObjetoListadoModel;
import Models.ObjetoModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public final class CarreraListadoController {

    private final CarreraListadoView view;
    private final ObjetoListadoModel<Carrera, String> model;

    public CarreraListadoController(CarreraListadoView view, ObjetoListadoModel model) {
        model.init();

        this.view = view;
        this.model = model;

        view.setController(this);
        view.setModel(model);
    }

    public void buscar() {
        try {
            if (view.codigo_carreraFld.getText().equals("")) {
                Collection<Carrera> filas = model.getModelTemplate().listar_objeto();
                List<Carrera> rows = new ArrayList(filas);
                model.setTableModel(rows);

            } else {
                List<Carrera> rows = new ArrayList();
                rows.add(model.getModelTemplate().buscar_objeto(view.codigo_carreraFld.getText()));
                model.setTableModel(rows);
            }
        } catch (GlobalException | NoDataException ex) {
        }
    }

    public void agregar() {
        ObjetoModel modelCarrera = ApplicationDesktop.CARRERA_VIEW.getModel();
        modelCarrera.clearErrors();
        modelCarrera.setModo(ApplicationDesktop.MODO_AGREGAR);
        modelCarrera.setCurrent(new Carrera());
        ApplicationDesktop.CARRERA_VIEW.setVisible(true);
    }

    public void editar(int row) {
        ObjetoModel modelCarrera = ApplicationDesktop.CARRERA_VIEW.getModel();
        modelCarrera.clearErrors();
        Carrera selected = model.getTableModel().getRowAt(row);
        modelCarrera.setModo(ApplicationDesktop.MODO_EDITAR);
        modelCarrera.setCurrent(selected);
        ApplicationDesktop.CARRERA_VIEW.setVisible(true);
    }

    public void borrar(int row) {
        Carrera selected = model.getTableModel().getRowAt(row);
        try {
            model.getModelTemplate().eliminar_objeto(selected.getCodigo_carrera());
        } catch (GlobalException | NoDataException ex) {
        }
        this.buscar();
    }
}
