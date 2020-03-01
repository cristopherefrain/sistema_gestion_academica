package Entities;

public class Ciclo {

    private String no_ciclo;
    private String anio;
    private String numero;
    private String fecha_inicio;
    private String fecha_fin;
  
    public Ciclo() {
        no_ciclo = new String();
        anio = new String();
        numero = new String();
        fecha_inicio = new String();
        fecha_fin = new String();
    }

    public Ciclo(String no_ciclo, String anio, String numero, String fecha_inicio, String fecha_fin) {
        this.no_ciclo = no_ciclo;
        this.anio = anio;
        this.numero = numero;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public String getNo_ciclo() {
        return no_ciclo;
    }

    public void setNo_ciclo(String no_ciclo) {
        this.no_ciclo = no_ciclo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    @Override
    public String toString() {
        return "Ciclo{" + "no_ciclo=" + no_ciclo + ", anio=" + anio + ", numero=" + numero + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + '}';
    }
}
