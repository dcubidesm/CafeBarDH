$(document).ready(function () {
//trae lo que trae form-login(login.html-linea22) este trae el usuario y contrasena desde el FRONT y lo envia a auntenticar usuario autenticarUsuario();
    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();//lo envia al método autenticarUsuario(); linea 13
    });

    $("#form-register").submit(function (event) {//llama a la funcion registrarUsuario();

        event.preventDefault();
        registrarUsuario();
    });


});

function autenticarUsuario() {

    let user_name = $("#user_name").val();///user_name viene del backend//pone el dato capturado en el campo Usuario(usuario) en el front
    let password = $("#password").val();///password viene del backend//pone el dato capturado en el campo contrseña(contrasena) en el front 
    //.JS, Trabaja con peticiones , solicitudes, requerimientos, con el método GET, captura los datos del front y lo enviará a ServletUsarioLogin

    $.ajax({//
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            user_name: user_name,
            password: password
        }),
        //Si los datos ingresados son incorrectos, lo manda login-error que esta en login.html -linea 36->
        //->(viene de Bootstrap)-> alert alert-danger d-none en login.html y valida que username y contraseña esten bien si no lo estan manda la alerta de error, datos incorrectos
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let username = parsedResult['user_name'];
                document.location.href = "home.html?username=" + user_name;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}

//método para el formulario del registro del Usurio (usuario.html)
function registrarUsuario() {

    let username = $("#input-username").val();
    let contrasena = $("#input-contrasena").val();
    let contrasenaConfirmacion = $("#input-contrasena-repeat").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let email = $("#input-email").val();
    let saldo = $("#input-saldo").val();
    let premium = $("#input-premium").prop("checked");

    if (contrasena == contrasenaConfirmacion) {//Valida que las dos contraseñas ingresadas sean las mismas

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",//Se comunica con el Servlet del registro
            data: $.param({
                username: username,
                contrasena: contrasena,
                nombre: nombre,
                apellidos: apellidos,
                email: email,
                saldo: saldo,
                premium: premium
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let username = parsedResult['username'];
                    document.location.href = "home.html?username=" + username;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}