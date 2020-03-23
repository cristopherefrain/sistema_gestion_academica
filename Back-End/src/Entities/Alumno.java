package Entities;

/**
 *
 * @author wizard
 */
public final class Alumno {

    private String cedula_alumno;
    private String nombre;
    private String telefono;
    private String email;
    private String fecha_nacimiento;
    private String carrera;

    public Alumno() {
        cedula_alumno = new String();
        nombre = new String();
        telefono = new String();
        email = new String();
        fecha_nacimiento = new String();
        carrera = new String();
    }

    public Alumno(final String cedula_alumno, final String nombre, final String telefono, final String email, final String fecha_nacimiento, final String carrera) {
        this.cedula_alumno = cedula_alumno;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.carrera = carrera;
    }

    public String getCedula_alumno() {
        return cedula_alumno;
    }

    public void setCedula_alumno(final String cedula_alumno) {
        this.cedula_alumno = cedula_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(final String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(final String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(final String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Alumno{" + "cedula_alumno=" + cedula_alumno + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", fecha_nacimiento=" + fecha_nacimiento + ", carrera=" + carrera + '}';
    }
}
