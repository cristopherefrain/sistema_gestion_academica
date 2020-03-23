package Entities;

/**
 *
 * @author wizard
 */
public final class Profesor {

    private String cedula_profesor;
    private String nombre;
    private String telefono;
    private String email;

    public Profesor() {
        cedula_profesor = new String();
        nombre = new String();
        telefono = new String();
        email = new String();
    }

    public Profesor(final String cedula_profesor, final String nombre, final String telefono, final String email) {
        this.cedula_profesor = cedula_profesor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getCedula_profesor() {
        return cedula_profesor;
    }

    public void setCedula_profesor(final String cedula_profesor) {
        this.cedula_profesor = cedula_profesor;
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

    @Override
    public String toString() {
        return "Profesor{" + "cedula_profesor=" + cedula_profesor + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + '}';
    }
}
