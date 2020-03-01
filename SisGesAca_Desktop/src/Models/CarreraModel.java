package Models;

import Entities.Carrera;
import java.util.*;

public class CarreraModel extends Observable{
    
    Carrera current;
    HashMap<String,String> errores;
    String mensaje;
    int modo;  

    public CarreraModel(){

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
    
    public Carrera getCurrent(){
        return current;
    }
    
    public void setCurrent(Carrera current){
        this.current = current;
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
