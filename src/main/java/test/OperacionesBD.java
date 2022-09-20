package test;
import beans.Mesa;
import beans.Usuario;
import beans.Alquiler;
import connection.DBConnection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;


public class OperacionesBD {
    public static void main(String[] args) {
        //actualizarmesa(2,"Crema de Wiskey",60000,10);
        listamesa();
        //actualizarUsuario(1,"Maria","Apolo",1256598745,"3202126987","mariapolo@gmail.com","g3M1niz9");
        //listaUsuario();
        //actualizarReserva("2","1","1","2022-09-21");
        //listaReserva();
        //insertarmesa("1","Botella Agua",2500,2);
        //eliminarmesa("1");
       //insertarUsuario("11","Paola","Pedrozo",52388987,"3202126987","paoprdrozo@hotmail.com","paop123","Colcafe123+");
       //eliminarUsuario("11");
       //insertarReserva("11","2","9","2022-07-31 14:00:00");
       //eliminarReserva("10");
    }
//CRUD DE TABLA PRODUCTOS
public static void listamesa(){
     DBConnection con = new DBConnection();//Conexion a la base de datos
     String sql = "SELECT * FROM mesa";//Consulta Select con tabla mesas
    
     try {
        Statement st = con.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        //El while trae los datos pero toca finalizarla* recorre cada campo de la tabla y se toma los campos creados en mesas.java 
        //y trae los de la base de datos, debes ir en el mismo orden
        while (rs.next()){
        int id = rs.getInt("id");
        String evento = rs.getString("evento");
        String horario = rs.getString("horario");
        String capacidad = rs.getString("capacidad");
        int reserva = rs.getInt("reserva");
         
        Mesa mesas = new Mesa(id, evento, horario ,capacidad, reserva );
        System.out.println(mesas.toString());
        }
        st.executeQuery(sql);//* finaliza el While cuando termine de validar todos los campos
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
    }

public static void actualizarmesa(String codigo,String producto,int valor ,int cantidad){
    DBConnection con = new DBConnection();
    String sql = "UPDATE producto SET producto = '" + producto + "', valor = '" + valor + "', cantidad = '" + cantidad + 
            "'WHERE codigo = " + codigo;
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

public static void insertarmesa(String codigo, String producto, int valor, int cantidad) {
        //,String producto,int valor ,int cantidad){
    DBConnection con = new DBConnection();
    String sql = "INSERT INTO producto (codigo, producto, valor, cantidad)"
            + "VALUES( '" + codigo + "','" + producto + "','" + valor + "','" + cantidad + "')";
    
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

public static void eliminarmesa(String codigo){
    DBConnection con = new DBConnection();
    String sql = "DELETE FROM producto WHERE codigo = " + codigo;
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
        //El while trae los datos pero toca finalizarla* recorre cada campo de la tabla y se toma los campos creados en mesas.java 
        //y trae los de la base de datos, debes ir en el mismo orden
        while (rs.next()){
        String username = rs.getString("username");
        String contrasena = rs.getString("contrasena"); 
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido"); 
        int cedula = rs.getInt("cedula");
        String celular = rs.getString("celular");
        String email = rs.getString("email");
        double saldo = rs.getDouble ("saldo");
          
        Usuario usuarios = new Usuario(username, contrasena, nombre,apellido,cedula,celular, email, saldo);
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


public static void actualizarUsuario(String username, String nombre, String apellido, int cedula, String celular, String email, String contrasena){
    DBConnection con = new DBConnection();
    String sql = "UPDATE usuario SET nombre = '" + nombre + "' , apellido = '" + apellido + "', cedula = '" + cedula +
                "', celular = '" + celular + "', email = '" + email + "', contrasena = '" + contrasena +
                "'WHERE username = " + username;
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

//public static void insertarUsuario(String username, String nombre, String apellido, int cedula, String celular, String email, String username, String contrasena) {
        //,String producto,int valor ,int cantidad){
  //  DBConnection con = new DBConnection();
    //String sql = "INSERT INTO usuario (username, nombre, apellido, cedula, celular, email, username, contrasena)"
      //      + "VALUES( '" + username + "','" + nombre + "','" + apellido + "','" + cedula + "','" + celular +"','"
        //    + email + "','" + username + "','" + contrasena + "')";
    
  //  try {
    //    Statement st = con.getConnection().createStatement();
      //  st.executeUpdate(sql);
        //} catch (Exception ex) {
          //  System.out.println(ex.getMessage());
        //}
        //finally{
          //  con.desconectar();
        //}
    
    //}

//public static void eliminarUsuario(String username){
  //  DBConnection con = new DBConnection();
   // String sql = "DELETE FROM usuario WHERE username = " + username;
    //try {
      //  Statement st = con.getConnection().createStatement();
        //st.executeUpdate(sql);
        //} catch (Exception ex) {
         //   System.out.println(ex.getMessage());
        //}
        //finally{
          //  con.desconectar();
        //}
    
    //}

//CRUD DE TABLA RESERVA
//public static void listaReserva(){
   //  DBConnection con = new DBConnection();//Conexion a la base de datos
   //  String sql = "SELECT * FROM reserva";//Consulta Select con tabla usuario
    
   //  try {
   //     Statement st = con.getConnection().createStatement();
     //   ResultSet rs = st.executeQuery(sql);
        //El while trae los datos pero toca finalizarla* recorre cada campo de la tabla y se toma los campos creados en mesas.java 
        //y trae los de la base de datos, debes ir en el mismo orden
      //  while (rs.next()){
      //  String codigo = rs.getString("codigo");
     //   String username = rs.getString("username");
      //  String mesa = rs.getString("mesa");
     //   String fecha = rs.getString("fecha");
      //  Alquiler reservas = new Alquiler(codigo, username,mesa,fecha);
      //  System.out.println(reservas.toString());
      //  }
      //  st.executeQuery(sql);//* finaliza el While cuando termine de validar todos los campos
      //  } catch (Exception ex) {
      //      System.out.println(ex.getMessage());
      //  }
      //  finally{
       //     con.desconectar();
      //  }
  //  }

public static void actualizarReserva(String codigo,String username,String mesa, String fecha){
    DBConnection con = new DBConnection();
    String sql = "UPDATE reserva SET username = '" + username + "', codigo = '" + codigo + 
            "', fecha = '" + fecha + 
            "'WHERE codigo = " + codigo;
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

public static void insertarReserva(String codigo, String username, String mesa, String fecha) {
    DBConnection con = new DBConnection();
    String sql = "INSERT INTO reserva (codigo, username, codigo, fecha)"
            + "VALUES( '" + codigo + "','" + username + "','" + mesa + "','" + fecha + "')";
    
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

public static void eliminarReserva(String mesa){
    DBConnection con = new DBConnection();
    String sql = "DELETE FROM reserva WHERE mesa = " + mesa;
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
