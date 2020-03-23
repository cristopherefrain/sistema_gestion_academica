package Models;

import Entities.Curso;
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
public class CursosModels extends Observable {

    public class CursoModelMain extends CursoModel {

        MutableComboBoxModel<String> carrera;
        MutableComboBoxModel<String> ciclo;
        HashMap<String, String> errores;
        String mensaje;
        int modo;

        public void init(String[] carrera, String[] ciclo) {
            setCarrera(carrera);
            setCiclo(ciclo);
            setCurrent(new Curso());
            clearErrors();
        }

        public CursoModelMain() {
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
        public void setCurrent(Curso current) {
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

        public ComboBoxModel<String> getCiclo() {
            return ciclo;
        }

        public void setCiclo(String[] ciclo) {
            this.ciclo = new DefaultComboBoxModel(ciclo);
            setChanged();
            notifyObservers();
        }

        public void addObserver(Observer o) {
            CursosModels.this.addObserver(o);
        }
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
