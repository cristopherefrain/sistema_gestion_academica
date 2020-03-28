package Models;

import static Models.UtilitiesTableModel.getCols;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author wizard
 * @param <T>
 * @param <K>
 */
public final class ObjetoListadoModel<T, K> extends Observable {

    private final Class<T> objectType;
    private final ModelTemplate<T, K> modelTemplate;
    private T filter;
    private ObjetoTableModel<T> tableModel;
    private HashMap<String, String> errores;
    private String mensaje;

    public ObjetoListadoModel(Class<T> objectType) {
        super();
        this.objectType = objectType;
        this.modelTemplate = new ModelTemplate<>(objectType);
        this.filter = null;
        this.tableModel = null;
        this.errores = null;
        this.mensaje = "";
    }

    public void init() {
        try {
            filter = objectType.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        }
        List<T> filas = new ArrayList<>();
        setTableModel(filas);
        clearErrors();
    }

    public void clearErrors() {
        setErrores(new HashMap<>());
        setMensaje("");
    }

    public ModelTemplate<T, K> getModelTemplate() {
        return modelTemplate;
    }

    public T getFilter() {
        return filter;
    }

    public void setFilter(T filter) {
        this.filter = filter;
        setChanged();
        notifyObservers();
    }

    public ObjetoTableModel<T> getTableModel() {
        return tableModel;
    }

    public void setTableModel(List<T> objetos) {
        int[] cols = getCols(objectType);
        this.tableModel = new ObjetoTableModel(objectType, objetos, cols);
        setChanged();
        notifyObservers();
    }

    public HashMap<String, String> getErrores() {
        return errores;
    }

    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
