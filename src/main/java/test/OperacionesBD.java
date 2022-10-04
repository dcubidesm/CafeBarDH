
package test;
import beans.Mesa;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {
    
    public static void main(String[] args) {
        //actualizarMesas(1, "Superheroes/DC");
        listarMesas();
    }
    
    public static void actualizarMesas(int id, String evento){
        DBConnection con = new DBConnection();
        String sql = "UPDATE mesa SET evento= '"+ evento + "'WHERE id= "+id;
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
    
    public static void listarMesas(){
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM mesa";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String mesaNumero = rs.getString("mesaNumero");
                String evento = rs.getString("evento");
                String mesero = rs.getString("mesero");
                int reservasDisponibles = rs.getInt("reservasDisponibles");
                boolean novedad = rs.getBoolean("novedad");
                Mesa mesas = new Mesa(id, mesaNumero, evento, mesero, reservasDisponibles, novedad);
                System.out.println(mesas.toString());
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
