
package beans;
import java.sql.Date;

public class Reserva {
    private String id_mesa;
    private String id_usuario;
    private String id_producto;
    private Date fecha;

    public Reserva(String id_mesa, String id_usuario, String id_producto, Date fecha) {
        this.id_mesa = id_mesa;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
        this.fecha = fecha;
    }

    public String getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(String id_mesa) {
        this.id_mesa = id_mesa;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id_mesa=" + id_mesa + ", id_usuario=" + id_usuario + ", id_producto=" + id_producto + ", fecha=" + fecha + '}';
    }
    
    
}
