/*
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection connection;
    static String bd = "cafe_bar";
    static String port = "3306";
    static String login = "root";
    static String password = "admin";

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:"+ this.port + "/" + this.bd;
            connection = DriverManager.getConnection(url, this.login, this.password);
            System.out.println("Conexión Establecida");
        } catch (Exception ex) {
            System.out.println("Error en la conexión");
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public void desconectar(){
        connection = null;
    }    
}*/

package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection connection;
    static String bd ="railway";
    static String port = "6357";
    static String login = "root";
    static String password = "0yuxNqZCrkrxSrnlw9j9";
    static String ip = "containers-us-west-88.railway.app";
    
    public DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://"+ DBConnection.ip +":" + DBConnection.port + "/" + DBConnection.bd;
            connection = DriverManager.getConnection(url, DBConnection.login, this.password);
            System.out.println("Error");
        } catch (Exception ex) {
            System.out.println("Error");
        }
}
       
    public Connection getConnection(){
        return connection;
    }
    
    public void desconectar(){
        connection = null;
    }    
}
