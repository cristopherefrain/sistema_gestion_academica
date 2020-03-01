package Models;

import Entities.Carrera;
import java.util.*;

public class CarrerasModel extends Observable{
    
    Carrera filter;
    CarreraTableModel carreras;
    HashMap<String,String> errores;
    String mensaje;
    
    public CarrerasModel(){
    }

    public void init(){
        
        filter = new Carrera();
        List<Carrera> filas = new ArrayList<>();
        this.setCarrera(filas);
        clearErrors();
    }
    
    public void setCarrera(List<Carrera> carreras){
        
        int[] cols={CarreraTableModel.CODIGO_CARRERA, CarreraTableModel.NOMBRE, CarreraTableModel.TITULO};
        this.carreras = new CarreraTableModel(cols, carreras);  
        setChanged();
        notifyObservers();        
    }
    
    public Carrera getFilter(){
        return filter;
    }
    
    public void setFilter(Carrera filter){
        this.filter = filter;
    }
    
     public CarreraTableModel getCarreras(){
        return carreras;
    }

    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        setChanged();
        notifyObservers();
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
}