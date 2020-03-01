package Models;

import Entities.Alumno;
import java.util.*;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.MutableComboBoxModel;

public class AlumnoModel extends Observable{
    
    Alumno current;
    MutableComboBoxModel<String> carrera;
    HashMap<String,String> errores;
    String mensaje;
    int modo;  

    public void init(String[] carrera) {
        setCarrera(carrera);
        setCurrent(new Alumno());
        clearErrors();
    }
    
    public AlumnoModel(){

    }
    
    public int getModo(){
        return modo;
    }

    public void setModo(int modo){
        this.modo = modo;
    }
    
    public String getMensaje(){
        return mensaje;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    public HashMap<String, String> getErrores(){
        return errores;
    }

    public void setErrores(HashMap<String, String> errores){
        this.errores = errores;
    }
    
    public void clearErrors(){
        setErrores(new HashMap<>());
        setMensaje("");      
    }
    
    public Alumno getCurrent(){
        return current;
    }
    
    public void setCurrent(Alumno current){
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
    
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }   
}
