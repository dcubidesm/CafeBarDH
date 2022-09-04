
package beans;


public class Producto {
    private String id_producto;
    private String producto;
    private int valor;
    private int cantidad;

    public Producto(String id_producto, String producto, int valor, int cantidad) {
        this.id_producto = id_producto;
        this.producto = producto;
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", producto=" + producto + ", valor=" + valor + ", cantidad=" + cantidad + '}';
    }
    
    
}
