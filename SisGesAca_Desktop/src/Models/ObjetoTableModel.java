package Models;

import static Models.UtilitiesTableModel.getValueAtCol;
import static Models.UtilitiesTableModel.initColNames;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author wizard
 * @param <T>
 */
public final class ObjetoTableModel<T> extends AbstractTableModel {

    private final Class<T> objectType;
    private final List<T> rows;
    private final int[] cols;
    private final String[] colNames;

    public ObjetoTableModel(Class<T> objectType, List<T> rows, int[] cols) {
        this.objectType = objectType;
        this.rows = rows;
        this.cols = cols;
        this.colNames = initColNames(objectType);
    }

    @Override
    public T getValueAt(int row, int col) {
        T objeto = rows.get(row);
        return (T) getValueAtCol(objectType, cols[col], objeto);
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

    public T getRowAt(int row) {
        return rows.get(row);
    }
}
