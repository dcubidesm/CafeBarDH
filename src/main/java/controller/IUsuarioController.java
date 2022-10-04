package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String username, String contrasena);

    public String register(String username, String contrasena,
            String nombreCompleto, String cedula, String email, double presupuesto, boolean premium);

    public String pedir(String username);

    public String modificar(String username, String nuevaContrasena,
            String nuevoNombreCompleto, String nuevaCedula, String nuevoEmail,
            double nuevoPresupuesto, boolean nuevoPremium);

    public String verReservasDisponibles(String username);

    
    public String devolverMesas(String username, Map<Integer, Integer> reservasDisponibles);

    public String eliminar(String username);

    public String restarDinero(String username, double nuevoPresupuesto);

}
