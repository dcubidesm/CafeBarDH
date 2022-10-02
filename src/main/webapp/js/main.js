var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        
        $("#mi-perfil-btn").attr("href","profile.html?username=" + username);
        
        $("#user-presupuesto").html(user.presupuesto.toFixed(2) + "$");

        getMesa(false, "ASC");

        $("#ordenar-evento").click(ordenarMesas);
    });
});


async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}
function getMesa(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMesaListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarMesas(parsedResult);
            } else {
                console.log("Error recuperando los datos de la Mesa");
            }
        }
    });
}
function mostrarMesas(mesas) {

    let contenido = "";

    $.each(mesas, function (index, mesa) {

        mesa = JSON.parse(mesa);
        let precio;

        if (mesa.reservasDisponibles > 0) {

            if (user.premium) {

                if (mesa.novedad) {
                    precio = (2 - (2 * 0.1));
                } else {
                    precio = (1 - (1 * 0.1));
                }
            } else {
                if (mesa.novedad) {
                    precio = 2;
                } else {
                    precio = 1;
                }
            }

            contenido += '<tr><th scope="row">' + mesa.id + '</th>' +
                    '<td>' + mesa.mesaNumero + '</td>' +
                    '<td>' + mesa.evento + '</td>' +
                    '<td>' + mesa.mesero + '</td>' +
                    '<td>' + mesa.reservasDisponibles + '</td>' +
                    '<td><input type="checkbox" name="novedad" id="novedad' + mesa.id + '" disabled ';
            if (mesa.novedad) {
                contenido += 'checked';
            }
            contenido += '></td>' +
                    '<td>' + precio + '</td>' +
                    '<td><button onclick="alquilarMesa(' + mesa.id + ',' + precio + ');" class="btn btn-success" ';
            if (user.presupuesto < precio) {
                contenido += ' disabled ';
            }

            contenido += '>Reservar</button></td></tr>'

        }
    });
    $("#mesas-tbody").html(contenido);
    
    
}
function ordenarMesas() {

    if ($("#icono-ordenar").hasClass("fa-sort")) {
        getMesas(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
        getMesas(true, "DESC");
        $("#icono-ordenar").removeClass("fa-sort-down");
        $("#icono-ordenar").addClass("fa-sort-up");
    } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
        getMesas(false, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}
function alquilarMesa(id, precio) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMesaAlquilar",
        data: $.param({
            id: id,
            username: username

        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                restarDinero(precio).then(function () {
                    location.reload();
                })
            } else {
                console.log("Error en la reserva de la mesa");
            }
        }
    });
}


async function restarDinero(precio) {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioRestarDinero",
        data: $.param({
            username: username,
            presupuesto: parseFloat(user.presupuesto - precio)

        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                console.log("presupuesto actualizado");
            } else {
                console.log("Error en el proceso de pago");
            }
        }
    });
}
