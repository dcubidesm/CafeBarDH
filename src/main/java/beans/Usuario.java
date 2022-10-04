
package beans;

public class Usuario {
    private String username;
    private String contrasena;
    private String nombreCompleto;
    private String cedula;
    private String email;
    private Double presupuesto;
    private boolean premium;

    public Usuario(String username, String contrasena, String nombreCompleto, String cedula, String email, Double presupuesto, boolean premium) {
        this.username = username;
        this.contrasena = contrasena;
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.email = email;
        this.presupuesto = presupuesto;
        this.premium = premium;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", contrasena=" + contrasena + ", nombreCompleto=" + nombreCompleto + ", cedula=" + cedula + ", email=" + email + ", presupuesto=" + presupuesto + ", premium=" + premium + '}';
    }

    
    
}
