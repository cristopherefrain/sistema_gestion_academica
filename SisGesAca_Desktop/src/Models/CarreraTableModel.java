package Models;

import Entities.Carrera;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CarreraTableModel extends AbstractTableModel {

    List<Carrera> rows;
    int[] cols;

    public static final int CODIGO_CARRERA = 0;
    public static final int NOMBRE = 1;
    public static final int TITULO = 2;

    String[] colNames = new String[3];

    public CarreraTableModel(int[] cols, List<Carrera> rows) {
        this.cols = cols;
        this.rows = rows;
        initColNames();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int col) {
        return colNames[cols[col]];
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Carrera carrera = rows.get(row);
        switch (cols[col]) {
            case CODIGO_CARRERA:
                return carrera.getCodigo_carrera();
            case NOMBRE:
                return carrera.getNombre();
            case TITULO:
                return carrera.getTitulo();
            default:
                return "";
        }
    }

    public Carrera getRowAt(int row) {
        return rows.get(row);
    }

    private void initColNames() {
        colNames[CODIGO_CARRERA] = "Codigo Carrera";
        colNames[NOMBRE] = "Nombre";
        colNames[TITULO] = "Titulo";
    }
}
