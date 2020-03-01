package Models;

import Entities.Profesor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProfesorTableModel extends AbstractTableModel {

    List<Profesor> rows;
    int[] cols;

    public static final int CEDULA_PROFESOR = 0;
    public static final int NOMBRE = 1;
    public static final int TELEFONO = 2;
    public static final int EMAIL = 3;

    String[] colNames = new String[4];

    public ProfesorTableModel(int[] cols, List<Profesor> rows) {
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
        Profesor profesor = rows.get(row);
        switch (cols[col]) {
            case CEDULA_PROFESOR:
                return profesor.getCedula_profesor();
            case NOMBRE:
                return profesor.getNombre();
            case TELEFONO:
                return profesor.getTelefono();
            case EMAIL:
                return profesor.getEmail();
            default:
                return "";
        }
    }

    public Profesor getRowAt(int row) {
        return rows.get(row);
    }

    private void initColNames() {
        colNames[CEDULA_PROFESOR] = "Cedula Profesor";
        colNames[NOMBRE] = "Nombre";
        colNames[TELEFONO] = "Telefono";
        colNames[EMAIL] = "Email";
    }
}
