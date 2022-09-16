package test;
import beans.Producto;
import beans.Usuario;
import beans.Reserva;
import connection.DBConnection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;


public class OperacionesDB {
    public static void main(String[] args) {
       listaProducto();
    }
//CRUD DE TABLA PRODUCTOS
public static void listaProducto(){
     DBConnection con = new DBConnection();//Conexion a la base de datos
     String sql = "SELECT * FROM producto";//Consulta Select con tabla productos
    
     try {
        Statement st = con.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        //El while trae los datos pero toca finalizarla* recorre cada campo de la tabla y se toma los campos creados en Productos.java 
        //y trae los de la base de datos, debes ir en el mismo orden
        while (rs.next()){
        String id_producto = rs.getString("id_producto");
        String producto = rs.getString("producto");
        int valor = rs.getInt("valor");
        int cantidad = rs.getInt("cantidad"); 
        Producto productos = new Producto(id_producto, producto,valor,cantidad );
        System.out.println(productos.toString());
        }
        st.executeQuery(sql);//* finaliza el While cuando termine de validar todos los campos
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
    }

public static void actualizarProducto(String id_producto,String producto,int valor ,int cantidad){
    DBConnection con = new DBConnection();
    String sql = "UPDATE producto SET producto = '" + producto + "', valor = '" + valor + "', cantidad = '" + cantidad + 
            "'WHERE id_producto = " + id_producto;
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

public static void insertarProducto(String id_producto, String producto, int valor, int cantidad) {
        //,String producto,int valor ,int cantidad){
    DBConnection con = new DBConnection();
    String sql = "INSERT INTO producto (id_producto, producto, valor, cantidad)"
            + "VALUES( '" + id_producto + "','" + producto + "','" + valor + "','" + cantidad + "')";
    
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

public static void eliminarProducto(String id_producto){
    DBConnection con = new DBConnection();
    String sql = "DELETE FROM producto WHERE id_producto = " + id_producto;
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

//CRUD DE TABLA USUARIO
public static void listaUsuario(){
     DBConnection con = new DBConnection();//Conexion a la base de datos
     String sql = "SELECT * FROM usuario";//Consulta Select con tabla usuario
    
     try {
        Statement st = con.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        //El while trae los datos pero toca finalizarla* recorre cada campo de la tabla y se toma los campos creados en Productos.java 
        //y trae los de la base de datos, debes ir en el mismo orden
        while (rs.next()){
        String id_usuario = rs.getString("id_usuario");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido"); 
        int cedula = rs.getInt("cedula");
        String celular = rs.getString("celular");
        String email = rs.getString("email");
        String user_name = rs.getString("user_name");
        String password = rs.getString("password");   
        Usuario usuarios = new Usuario(id_usuario, nombre,apellido,cedula,celular, email, user_name, password);
        System.out.println(usuarios.toString());
        }
        st.executeQuery(sql);//* finaliza el While cuando termine de validar todos los campos
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
    }


public static void actualizarUsuario(String id_usuario, String nombre, String apellido, int cedula, String celular, String email, String password){
    DBConnection con = new DBConnection();
    String sql = "UPDATE usuario SET nombre = '" + nombre + "' , apellido = '" + apellido + "', cedula = '" + cedula +
                "', celular = '" + celular + "', email = '" + email + "', password = '" + password +
                "'WHERE id_usuario = " + id_usuario;
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

public static void insertarUsuario(String id_usuario, String nombre, String apellido, int cedula, String celular, String email, String user_name, String password) {
        //,String producto,int valor ,int cantidad){
    DBConnection con = new DBConnection();
    String sql = "INSERT INTO usuario (id_usuario, nombre, apellido, cedula, celular, email, user_name, password)"
            + "VALUES( '" + id_usuario + "','" + nombre + "','" + apellido + "','" + cedula + "','" + celular +"','"
            + email + "','" + user_name + "','" + password + "')";
    
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

public static void eliminarUsuario(String id_usuario){
    DBConnection con = new DBConnection();
    String sql = "DELETE FROM usuario WHERE id_usuario = " + id_usuario;
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

//CRUD DE TABLA RESERVA
public static void listaReserva(){
     DBConnection con = new DBConnection();//Conexion a la base de datos
     String sql = "SELECT * FROM reserva";//Consulta Select con tabla usuario
    
     try {
        Statement st = con.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        //El while trae los datos pero toca finalizarla* recorre cada campo de la tabla y se toma los campos creados en Productos.java 
        //y trae los de la base de datos, debes ir en el mismo orden
        while (rs.next()){
        String id_mesa = rs.getString("id_mesa");
        String id_usuario = rs.getString("id_usuario");
        String id_producto = rs.getString("id_producto");
        String fecha = rs.getString("fecha");
        Reserva reservas = new Reserva(id_mesa, id_usuario,id_producto,fecha);
        System.out.println(reservas.toString());
        }
        st.executeQuery(sql);//* finaliza el While cuando termine de validar todos los campos
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
    }

public static void actualizarReserva(String id_mesa,String id_usuario,String id_producto, String fecha){
    DBConnection con = new DBConnection();
    String sql = "UPDATE reserva SET id_usuario = '" + id_usuario + "', id_producto = '" + id_producto + 
            "', fecha = '" + fecha + 
            "'WHERE id_mesa = " + id_mesa;
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

public static void insertarReserva(String id_mesa, String id_usuario, String id_producto, String fecha) {
    DBConnection con = new DBConnection();
    String sql = "INSERT INTO reserva (id_mesa, id_usuario, id_producto, fecha)"
            + "VALUES( '" + id_mesa + "','" + id_usuario + "','" + id_producto + "','" + fecha + "')";
    
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

public static void eliminarReserva(String id_mesa){
    DBConnection con = new DBConnection();
    String sql = "DELETE FROM reserva WHERE id_mesa = " + id_mesa;
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

}






