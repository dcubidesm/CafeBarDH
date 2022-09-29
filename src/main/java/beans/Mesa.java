
package beans;

public class Mesa {
    private int id;
    private String mesaNumero;
    private String evento;
    private String mesero;
    private int reservasDisponibles;
    private boolean novedad;

    public Mesa(int id, String mesaNumero, String evento, String mesero, int reservasDisponibles, boolean novedad) {
        this.id = id;
        this.mesaNumero = mesaNumero;
        this.evento = evento;
        this.mesero = mesero;
        this.reservasDisponibles = reservasDisponibles;
        this.novedad = novedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMesaNumero() {
        return mesaNumero;
    }

    public void setMesaNumero(String mesaNumero) {
        this.mesaNumero = mesaNumero;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getMesero() {
        return mesero;
    }

    public void setMesero(String mesero) {
        this.mesero = mesero;
    }

    public int getReservasDisponibles() {
        return reservasDisponibles;
    }

    public void setReservasDisponibles(int reservasDisponibles) {
        this.reservasDisponibles = reservasDisponibles;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    @Override
    public String toString() {
        return "Mesa{" + "id=" + id + ", mesaNumero=" + mesaNumero + ", evento=" + evento + ", mesero=" + mesero + ", reservasDisponibles=" + reservasDisponibles + ", novedad=" + novedad + '}';
    }

    
        
}
