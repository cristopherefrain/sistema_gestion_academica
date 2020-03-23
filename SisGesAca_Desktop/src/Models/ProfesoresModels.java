package Models;

import Entities.Profesor;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author wizard
 */
public class ProfesoresModels extends Observable {

    public class ProfesorModelMain extends ProfesorModel {

        HashMap<String, String> errores;
        String mensaje;
        int modo;

        public ProfesorModelMain() {
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
        public void setCurrent(Profesor current) {
            this.current = current;
            setChanged();
            notifyObservers();
        }

        public void addObserver(Observer o) {
            ProfesoresModels.this.addObserver(o);
        }
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

}
