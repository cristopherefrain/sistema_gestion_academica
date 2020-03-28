package Models;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author wizard
 * @param <T>
 * @param <K>
 */
public final class ObjetoModel<T, K> extends Observable {

    private final Class<T> objectType;
    private final ModelTemplate<T, K> modelTemplate;
    private MutableComboBoxModel<String> comboBox1;
    private MutableComboBoxModel<String> comboBox2;
    private HashMap<String, String> errores;
    private String mensaje;
    private int modo;

    public ObjetoModel(Class<T> objectType) {
        super();
        this.objectType = objectType;
        this.modelTemplate = new ModelTemplate<>(objectType);
        this.comboBox1 = null;
        this.comboBox2 = null;
        this.errores = new HashMap<>();
        this.mensaje = "";
        this.modo = -1;
    }

    public void init(String[] comboBox1, String[] comboBox2) {
        setComboBox1(comboBox1);
        setComboBox2(comboBox2);
        try {
            try {
                setCurrent(objectType.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            }
        } catch (NoSuchMethodException | SecurityException ex) {
        }
        clearErrors();
    }

    public void clearErrors() {
        setErrores(new HashMap<>());
        setMensaje("");
    }

    public ModelTemplate<T, K> getModelTemplate() {
        return modelTemplate;
    }

    public void setCurrent(T current) {
        modelTemplate.setCurrent(current);
        setChanged();
        notifyObservers();
    }

    public T getCurrent() {
        return modelTemplate.getCurrent();
    }

    public MutableComboBoxModel<String> getComboBox1() {
        return comboBox1;
    }

    public MutableComboBoxModel<String> getComboBox2() {
        return comboBox2;
    }

    public void setComboBox1(String[] comboBox1) {
        if (comboBox1 != null) {
            this.comboBox1 = new DefaultComboBoxModel(comboBox1);
            setChanged();
            notifyObservers();
        }
    }

    public void setComboBox2(String[] comboBox2) {
        if (comboBox2 != null) {
            this.comboBox2 = new DefaultComboBoxModel(comboBox2);
            setChanged();
            notifyObservers();
        }
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

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
