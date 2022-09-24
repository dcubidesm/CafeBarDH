package beans;

public class Mesa {
    private int id;
    private String evento;
    private String horario;
    private String capacidad;
    private int reserva;

    public Mesa(int id, String evento, String horario, String capacidad, int reserva) {
        this.id = id;
        this.evento = evento;
        this.horario = horario;
        this.capacidad = capacidad;
        this.reserva = reserva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public int getReserva() {
        return reserva;
    }

    public void setReserva(int reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "Mesa{" + "id=" + id + ", evento=" + evento + ", horario=" + horario + ", capacidad=" + capacidad + ", reserva=" + reserva + '}';
    }


}