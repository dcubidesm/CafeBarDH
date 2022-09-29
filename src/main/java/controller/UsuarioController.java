package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Usuario;
import connection.DBConnection;
import java.util.HashMap;
import java.util.Map;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String username, String contrasena) {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "Select * from usuario where username = '" + username
                + "' and contrasena = '" + contrasena + "'";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String nombreCompleto = rs.getString("nombreCompleto");
                String cedula = rs.getString("cedula");
                String email = rs.getString("email");
                double presupuesto = rs.getDouble("presupuesto");
                boolean premium = rs.getBoolean("premium");
                Usuario usuario = new Usuario(username, contrasena, nombreCompleto, cedula, email, presupuesto, premium);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }

    @Override
    public String register(String username, String contrasena, String nombreCompleto, String cedula, String email,
            double presupuesto, boolean premium) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into usuario values('" + username + "', '" + contrasena + "', '" + nombreCompleto
                + "', '" + cedula + "', '" + email + "', " + presupuesto + ", " + premium + ")";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(username, contrasena, nombreCompleto, cedula, email, presupuesto, premium);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String pedir(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from usuario where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String contrasena = rs.getString("contrasena");
                String nombreCompleto = rs.getString("nombreCompleto");
                String cedula = rs.getString("cedula");
                String email = rs.getString("email");
                double presupuesto = rs.getDouble("presupuesto");
                boolean premium = rs.getBoolean("premium");

                Usuario usuario = new Usuario(username, contrasena,
                        nombreCompleto, cedula, email, presupuesto, premium);

                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String modificar(String username, String nuevaContrasena,
            String nuevoNombreCompleto, String nuevaCedula,
            String nuevoEmail, double nuevoPresupuesto, boolean nuevoPremium) {

        DBConnection con = new DBConnection();

        String sql = "Update usuario set contrasena = '" + nuevaContrasena
                + "', nombreCompleto = '" + nuevoNombreCompleto + "', "
                + "cedula = '" + nuevaCedula + "', email = '"
                + nuevoEmail + "', presupuesto = " + nuevoPresupuesto + ", premium = ";

        if (nuevoPremium == true) {
            sql += " 1 ";
        } else {
            sql += " 0 ";
        }

        sql += " where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String verReservasDisponibles(String username) {

        DBConnection con = new DBConnection();
        String sql = "Select id,count(*) as num_reservasDispobiles from alquiler where username = '"
                + username + "' group by id;";

        Map<Integer, Integer> reservasDisponibles = new HashMap<Integer, Integer>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                int num_reservasDisponibles = rs.getInt("num_reservasDisponibles");

                reservasDisponibles.put(id, num_reservasDisponibles);
            }

            devolverMesas(username, reservasDisponibles);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String devolverMesas(String username, Map<Integer, Integer> reservasDisponibles) {

        DBConnection con = new DBConnection();

        try {
            for (Map.Entry<Integer, Integer> mesa : reservasDisponibles.entrySet()) {
                int id = mesa.getKey();
                int num_reservasDisponibles = mesa.getValue();

                String sql = "Update mesa set reservasDisponibles = (Select reservasDisponibles + " + num_reservasDisponibles
                        + " from mesa where id = " + id + ") where id = " + id;

                Statement st = con.getConnection().createStatement();
                st.executeUpdate(sql);

            }

            this.eliminar(username);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }

    @Override
    public String eliminar(String username) {

        DBConnection con = new DBConnection();

        String sql1 = "Delete from alquiler where username = '" + username + "'";
        String sql2 = "Delete from usuario where username = '" + username + "'";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
       @Override
    public String restarDinero(String username, double nuevoPresupuesto) {

        DBConnection con = new DBConnection();
        String sql = "Update usuario set presupuesto = " + nuevoPresupuesto + " where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
}

 