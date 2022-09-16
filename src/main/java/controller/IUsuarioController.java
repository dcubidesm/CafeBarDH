//es como un intermediario un puente (es decir interface) acá solo llama los campos user_name y password de la BD, que comunica con UsuarioController.java y ServletUsuarioLogin.java(Servlet), es un servicio de comunicación entre el .JS
package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String user_name, String password);

public String register( String id_usuario,String nombre, String apellido,int cedula,String celular, String email, 
            String user_name, String password);    
    
}