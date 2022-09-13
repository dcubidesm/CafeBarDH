$(document).ready(function() {

    $("$form-login").submit(funtion (event) {
    

        event.preventDefault();
        autenticarUsuario();
    });

     
function autenticarUsuario(){

    let user_name = $("user_name").val();
    let password = $("#password").val();
    $ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            user_name: user_name,
            password: password
        }),
        success: function (result) {
            let parsedReult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let user_name = parsedResult ['username'];
                document.location.href = "login.html?user_name=" + user_name;
            } else {
                $("#login-error").removeClass("d-done");
            }
        }
    });
}

package controller;
import java.util.Map;
public interface IUsuarioController {
    public String login (String user_name, String password);
        
}
   
