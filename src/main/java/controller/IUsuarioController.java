//es como un intermediario un puente (es decir interface) acá solo llama los campos user_name y password de la BD, que comunica con UsuarioController.java y ServletUsuarioLogin.java(Servlet), es un servicio de comunicación entre el .JS
package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String username, String contrasena);

public String register(String username,String contrasena, String nombre, String apellido,int cedula,String celular, String email, 
            Double saldo);    
    
}
