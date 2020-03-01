package Models;

import Entities.Alumno;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AlumnoTableModel extends AbstractTableModel {

    List<Alumno> rows;
    int[] cols;

    public static final int CEDULA_ALUMNO = 0;
    public static final int NOMBRE = 1;
    public static final int TELEFONO = 2;
    public static final int EMAIL = 3;
    public static final int FECHA_NACIMIENTO = 4;
    public static final int CARRERA = 5;

    String[] colNames = new String[6];

    public AlumnoTableModel(int[] cols, List<Alumno> rows) {
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
        Alumno alumno = rows.get(row);
        switch (cols[col]) {
            case CEDULA_ALUMNO:
                return alumno.getCedula_alumno();
            case NOMBRE:
                return alumno.getNombre();
            case TELEFONO:
                return alumno.getTelefono();
            case EMAIL:
                return alumno.getEmail();
            case FECHA_NACIMIENTO:
                return alumno.getFecha_nacimiento();
            case CARRERA:
                return alumno.getCarrera();
            default:
                return "";
        }
    }

    public Alumno getRowAt(int row) {
        return rows.get(row);
    }

    private void initColNames() {
        colNames[CEDULA_ALUMNO] = "Cedula Alumno";
        colNames[NOMBRE] = "Nombre";
        colNames[TELEFONO] = "Telefono";
        colNames[EMAIL] = "Email";
        colNames[FECHA_NACIMIENTO] = "Fecha Nacimiento";
        colNames[CARRERA] = "Carrera";
    }
}
