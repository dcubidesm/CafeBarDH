
package beans;


public class Usuario {
    private String username;
    private String nombre;
    private String apellido; 
    private int cedula;
    private String celular;
    private String email;
    private String password;

    public Usuario(String username, String nombre, String apellido, int cedula, String celular, String email, String password) {
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.celular = celular;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", celular=" + celular + ", email=" + email + ", password=" + password + '}';
    }




}
