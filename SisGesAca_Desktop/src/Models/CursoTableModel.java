package Models;

import Entities.Curso;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CursoTableModel extends AbstractTableModel {

    List<Curso> rows;
    int[] cols;

    public static final int CODIGO_CURSO = 0;
    public static final int CODIGO_CARRERA = 1;
    public static final int NO_CICLO = 2;
    public static final int NOMBRE = 3;
    public static final int CREDITOS = 4;
    public static final int HORAS_SEMANALES = 5;

    String[] colNames = new String[6];

    public CursoTableModel(int[] cols, List<Curso> rows) {
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
        Curso curso = rows.get(row);
        switch (cols[col]) {
            case CODIGO_CURSO:
                return curso.getCodigo_curso();
            case CODIGO_CARRERA:
                return curso.getCodigo_carrera();
            case NO_CICLO:
                return curso.getNo_ciclo();
            case NOMBRE:
                return curso.getNombre();
            case CREDITOS:
                return curso.getCreditos();
            case HORAS_SEMANALES:
                return curso.getHoras_semanales();
            default:
                return "";
        }
    }

    public Curso getRowAt(int row) {
        return rows.get(row);
    }

    private void initColNames() {
        colNames[CODIGO_CURSO] = "Codigo Curso";
        colNames[CODIGO_CARRERA] = "Codigo Carrera";
        colNames[NO_CICLO] = "Numero Ciclo";
        colNames[NOMBRE] = "Nombre";
        colNames[CREDITOS] = "Creditos";
        colNames[HORAS_SEMANALES] = "Horas Semanales";
    }
}
