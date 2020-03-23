package Models;

import Entities.Carrera;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author wizard
 */
public class CarrerasModels extends Observable {

    public class CarreraModelMain extends CarreraModel {

        HashMap<String, String> errores;
        String mensaje;
        int modo;

        public CarreraModelMain() {
            super();
        }

        public int getModo() {
            return modo;
        }

        public void setModo(int modo) {
            this.modo = modo;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public HashMap<String, String> getErrores() {
            return errores;
        }

        public void setErrores(HashMap<String, String> errores) {
            this.errores = errores;
        }

        public void clearErrors() {
            setErrores(new HashMap<>());
            setMensaje("");
        }

        @Override
        public void setCurrent(Carrera current) {
            this.current = current;
            setChanged();
            notifyObservers();
        }

        public void addObserver(Observer o) {
            CarrerasModels.this.addObserver(o);
        }
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
