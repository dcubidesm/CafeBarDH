var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {


    fillUsuario().then(function () {

        $("#user-presupuesto").html("$" + user.presupuesto.toFixed());

        getAlquiladas(user.username);
    });

    $("#reservar-btn").attr("href", `home.html?username=${username}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-username").val(parsedResult.username);
                $("#input-contrasena").val(parsedResult.contrasena);
                $("#input-nombreCompleto").val(parsedResult.nombreCompleto);
                $("#input-cedula").val(parsedResult.cedula);
                $("#input-email").val(parsedResult.email);
                $("#input-presupuesto").val(parsedResult.presupuesto.toFixed(2));
                $("#input-premium").prop("checked", parsedResult.premium);

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function getAlquiladas(username) {


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletAlquilerListar",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarHistorial(parsedResult)

            } else {
                console.log("Error recuperando los datos de las reservas");
            }
        }
    });
}

function mostrarHistorial(mesas) {
    let contenido = "";
    if (mesas.length >= 1) {
        $.each(mesas, function (index, mesa) {
            mesa = JSON.parse(mesa);

            contenido += '<tr><th scope="row">' + mesa.id + '</th>' +
                    '<td>' + mesa.mesaNumero + '</td>' +
                    '<td>' + mesa.evento + '</td>' +
                    '<td><input type="checkbox" name="novedad" id="novedad' + mesa.id 
                    + '" disabled ';
            if (mesa.novedad) {
                contenido += 'checked'
            }
            contenido += '></td><td>' + mesa.fechaAlquiler + '</td>' +
                    '<td><button id="devolver-btn" onclick= "devolvermesa(' + mesa.id 
                    + ');" class="btn btn-danger">Devolver mesa</button></td></tr>';

        });
        $("#historial-tbody").html(contenido);
        $("#historial-table").removeClass("d-none");
        $("#historial-vacio").addClass("d-none");

    } else {
        $("#historial-vacio").removeClass("d-none");
        $("#historial-table").addClass("d-none");
    }
}


function devolverMesa(id) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMesaDevolver",
        data: $.param({
            username: username,
            id: id,
        }),
        success: function (result) {

            if (result != false) {

                location.reload();

            } else {
                console.log("Error devolviendo la mesa");
            }
        }
    });

}

function modificarUsuario() {

    let username = $("#input-username").val();
    let contrasena = $("#input-contrasena").val();
    let nombreCompleto = $("#input-nombreCompleto").val();
    let cedula = $("#input-cedula").val();
    let email = $("#input-email").val();
    let presupuesto = $("#input-presupuesto").val();
    let premium = $("#input-premium").prop('checked');
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            username: username,
            contrasena: contrasena,
            nombreCompleto: nombreCompleto,
            cedula: cedula,
            email: email,
            presupuesto: presupuesto,
            premium: premium
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            username: username
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado");

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}