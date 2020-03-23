package Models;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author wizard
 */
public class InicioSesionModels extends Observable {

    public class InicioSesionModelMain extends InicioSesionModel {

        HashMap<String, String> errores;
        String mensaje;

        public InicioSesionModelMain() {
            super();
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

        public void addObserver(Observer o) {
            InicioSesionModels.this.addObserver(o);
        }
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

}
