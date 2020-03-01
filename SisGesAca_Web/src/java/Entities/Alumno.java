package Entities;

public class Alumno {
    
    private String cedula_alumno;
    private String nombre;
    private String telefono;
    private String email;
    private String fecha_nacimiento;
    private String carrera;
    
    public Alumno(){
        cedula_alumno = new String();
        nombre = new String();
        telefono = new String(); 
        email = new String();
        fecha_nacimiento = new String();
        carrera = new String();
    }
    public Alumno(String cedula_alumno, String nombre, String telefono, String email, String fecha_nacimiento, String carrera){
       this.cedula_alumno = cedula_alumno;
       this.nombre = nombre;
       this.telefono = telefono;
       this.email= email;
       this.fecha_nacimiento = fecha_nacimiento;
       this.carrera = carrera;
    } 

    public String getCedula_alumno() {
        return cedula_alumno;
    }

    public void setCedula_alumno(String cedula_alumno) {
        this.cedula_alumno = cedula_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Alumno{" + "cedula_alumno=" + cedula_alumno + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", fecha_nacimiento=" + fecha_nacimiento + ", carrera=" + carrera + '}';
    }
}