package Models;

import Entities.Profesor;
import java.util.*;

public class ProfesorModel extends Observable{
    
    Profesor current;
    HashMap<String,String> errores;
    String mensaje;
    int modo;  

    public ProfesorModel(){

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
    
    public Profesor getCurrent(){
        return current;
    }
    
    public void setCurrent(Profesor current){
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
