package Models;

import Entities.Alumno;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author wizard
 */
public class AlumnosModels extends Observable {

    public class AlumnoModelMain extends AlumnoModel {

        MutableComboBoxModel<String> carrera;
        HashMap<String, String> errores;
        String mensaje;
        int modo;

        public void init(String[] carrera) {
            setCarrera(carrera);
            setCurrent(new Alumno());
            clearErrors();
        }

        public AlumnoModelMain() {
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
        public void setCurrent(Alumno current) {
            this.current = current;
            setChanged();
            notifyObservers();
        }

        public ComboBoxModel<String> getCarrera() {
            return carrera;
        }

        public void setCarrera(String[] carrera) {
            this.carrera = new DefaultComboBoxModel(carrera);
            setChanged();
            notifyObservers();
        }

        public void addObserver(Observer o) {
            AlumnosModels.this.addObserver(o);
        }

    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

}
