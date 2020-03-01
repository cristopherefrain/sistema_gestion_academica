package Models;

import Entities.Alumno;
import java.util.*;

public class AlumnosModel extends Observable{
    
    Alumno filter;
    AlumnoTableModel cursos;
    HashMap<String,String> errores;
    String mensaje;
    
    public AlumnosModel(){
    }

    public void init(){
        
        filter = new Alumno();
        List<Alumno> filas = new ArrayList<>();
        this.setAlumno(filas);
        clearErrors();
    }
    
    public void setAlumno(List<Alumno> alumnos){
        
        int[] cols={AlumnoTableModel.CEDULA_ALUMNO, AlumnoTableModel.NOMBRE, AlumnoTableModel.TELEFONO, AlumnoTableModel.EMAIL, AlumnoTableModel.FECHA_NACIMIENTO, AlumnoTableModel.CARRERA};
        this.cursos = new AlumnoTableModel(cols, alumnos);  
        setChanged();
        notifyObservers();        
    }
    
    public Alumno getFilter(){
        return filter;
    }
    
    public void setFilter(Alumno filter){
        this.filter = filter;
    }
    
     public AlumnoTableModel getAlumnos(){
        return cursos;
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