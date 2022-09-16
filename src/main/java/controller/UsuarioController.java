package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Usuario;
import connection.DBConnection;


public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String user_name, String password) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();//DBConection.java, me hace la conexion a la BD.
        //Ejecuta correctamente si el username y contrseana estan correctos, de lo contrario sale de la codicion y queda False(linea 42).
        String sql = "Select * from usuario where user_name = '" + user_name
                + "' and password = '" + password + "'";//se debe cumplir las dos condiciones usuario y contraseña
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String id_usuario = rs.getString("id_usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido"); 
                int cedula = rs.getInt("cedula");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
               
                Usuario usuario = new Usuario(id_usuario, nombre,apellido,cedula,celular, email, user_name, password);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false"; //entra bien la conexion a la base de datos pero la contraseña o algun campo de username y contrasena esten incorrectos
}

    @Override
    public String register(String id_usuario, String nombre, String apellido, int cedula, String celular,
            String email, String user_name, String password) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();//Conexion a la base de datos
        //Sentencia Insert mediante el formulario register.html
        String sql = "Insert into usuario values('" + id_usuario + "', '" + nombre + "', '" + apellido
                + "', '" + cedula + "', '" + celular + "', " + email + ", " + user_name + ", " + password + ")";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(id_usuario, nombre, apellido, cedula, celular, email, user_name, password);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }
   
}