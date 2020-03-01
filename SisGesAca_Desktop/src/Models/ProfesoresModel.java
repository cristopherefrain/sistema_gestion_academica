package Models;

import Entities.Profesor;
import java.util.*;

public class ProfesoresModel extends Observable{
    
    Profesor filter;
    ProfesorTableModel profesores;
    HashMap<String,String> errores;
    String mensaje;
    
    public ProfesoresModel(){
    }

    public void init(){
        
        filter = new Profesor();
        List<Profesor> filas = new ArrayList<>();
        this.setProfesor(filas);
        clearErrors();
    }
    
    public void setProfesor(List<Profesor> profesores){
        
        int[] cols={ProfesorTableModel.CEDULA_PROFESOR, ProfesorTableModel.NOMBRE, ProfesorTableModel.TELEFONO, ProfesorTableModel.EMAIL};
        this.profesores = new ProfesorTableModel(cols, profesores);  
        setChanged();
        notifyObservers();        
    }
    
    public Profesor getFilter(){
        return filter;
    }
    
    public void setFilter(Profesor filter){
        this.filter = filter;
    }
    
     public ProfesorTableModel getProfesores(){
        return profesores;
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