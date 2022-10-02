
package beans;

import java.sql.Date;

public class Alquiler {
    private int id;
    private String username;
    private Date fecha;
    private boolean novedad;
    private String evento;

    public Alquiler(int id, String username, Date fecha, boolean novedad, String evento) {
        this.id = id;
        this.username = username;
        this.fecha = fecha;
        this.novedad = novedad;
        this.evento = evento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "id=" + id + ", username=" + username + ", fecha=" + fecha + ", novedad=" + novedad + ", evento=" + evento + '}';
    }
    
}
