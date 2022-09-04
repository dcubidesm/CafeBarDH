package test;

import beans.Producto;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {
   public static void main (String[] args) {
        actualizarProducto("1",  "Cerveza Club Dorada");
        listarProducto();
    }
    public static void actualizarProducto(String id_producto, String producto){
        DBConnection con = new DBConnection();
        String sql = "UPDATE producto SET producto = '" + producto +"'WHERE id_producto = " + id_producto;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
    
    }
    public static void listarProducto(){
        DBConnection con = new DBConnection();
        String sql = " SELECT * FROM PRODUCTO ";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String id_producto = rs.getString("id_producto");
                String producto = rs.getString("producto");
                int valor = rs.getInt("valor");
                int cantidad = rs.getInt("cantidad");
                Producto productos = new Producto(id_producto, producto, valor, cantidad);
                System.out.println(productos.toString());
                
            }
            st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
    }
}
