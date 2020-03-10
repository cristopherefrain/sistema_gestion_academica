package Models;

import Entities.Usuario;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author wizard
 */
public class InicioSesionModel extends Observable {

    Usuario current;
    HashMap<String, String> errores;
    String mensaje;

    public InicioSesionModel() {
    }

    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
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

    public void clearErrors() {
        setErrores(new HashMap<>());
        setMensaje("");
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
