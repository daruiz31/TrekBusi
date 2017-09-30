/* 
 * Autor: Diego RM
 */

function mostrarNotificacion(id) {
    var opcion = id;
    limpiarTodo();
    $('#notificacionesADMIN').css('color', '#9EC944');

    if (opcion == 1) {

        $('#solicitudServicioADMIN').show();

        $.ajax({
            url: 'notificacionesServicios',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                var tablaServicios = $('#listaSolicitudServicios');
                var nuevaFila;
                if (datos.codigo == 0) {
                    $.each(datos.datosResultado, function (i, items) {
                        nuevaFila = $('<tr>');
                        var columnaNombreUsu = $('<td>');
                        var columnaCorreo = $('<td>');
                        var columnaTelefono = $('<td>');
                        var columnaTipoServ = $('<td>');
                        var columnaDescripcion = $('<td>');
                        var columnaFecha = $('<td>');
                        var columnaPresu = $('<td>');
                        var columnaCiudad = $('<td>');
                        var opciones = $('<td>');
                        var solicitud = items.idSolicitud;
                        var boton1 = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"confirmarServicio(this.id)\">Confirmar</button>";
                        var boton2 = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"cancelarServicioMsg(" + solicitud + ",2)\">Denegar</button>";
                        nuevaFila.val(items.idSolicitud);
                        columnaNombreUsu.html(items.nombre_RazonSocial);
                        columnaCorreo.html(items.correos);
                        columnaTelefono.html(items.telefonos);
                        columnaTipoServ.html(items.nombre);
                        columnaDescripcion.html(items.descripcion);
                        columnaFecha.html(items.fechaPedido);
                        columnaPresu.html(items.presupuestoDisponible);
                        columnaCiudad.html(items.ciudad);
                        opciones.html(boton1 + boton2);
                        nuevaFila.append(columnaNombreUsu).append(columnaCorreo).append(columnaTelefono).append(columnaTipoServ).append(columnaDescripcion).append(columnaFecha).append(columnaPresu).append(columnaCiudad).append(opciones);
                        tablaServicios.append(nuevaFila);
                    });
                    pNotiServicios();
                } else {
                    msgFinal(datos.mensaje);
                }
            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error.responseText);
            }
        });
    } else if (opcion == 2) {
        $('#solicitudProductoADMIN').show();
        $('#buscadorNotifiProducto').show();
        $.ajax({
            url: 'notiADMIN/productos',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                var tablaServicios = $('#listaSolicitudProductos');
                var nuevaFila;
                if (datos.codigo == 0) {
                    $.each(datos.datosResultado, function (i, items) {
                        nuevaFila = $('<tr>');
                        var columnaNombreUsu = $('<td>');
                        var columnaCorreo = $('<td>');
                        var columnaTelefono = $('<td>');
                        var columnaTipoProduco = $('<td>');
                        var columnaProducto = $('<td>');
                        var columnaFecha = $('<td>');
                        var columnaPresu = $('<td>');
                        var columnaCiudad = $('<td>');
                        var opciones = $('<td>');
                        var solicitud = items.idSolicitud;
                        var boton1 = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"confirmarServicio(this.id)\">Confirmar</button>";
                        var boton2 = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"cancelarServicioMsg(" + solicitud + ",1)\">Denegar</button>";
                        var boton3 = "<a target=\"_blank\" class=\"linkVermas\" href=\"http://localhost:8080/Proyecto/reporteProductos?pedido="+solicitud+"\"><img src=\"imagenes/msn/lupa1.png\"/>Ver mas</a>";
                        nuevaFila.val(items.idSolicitud);
                        columnaNombreUsu.html(items.nombre_RazonSocial);
                        columnaCorreo.html(items.correos);
                        columnaTelefono.html(items.telefonos);
                        columnaTipoProduco.html(items.nombre);
                        columnaProducto.html(items.descripcion);
                        columnaFecha.html(items.fechaPedido);
                        columnaPresu.html(items.presupuestoDisponible);
                        columnaCiudad.html(items.ciudad);
                        opciones.html(boton1 + boton2 + boton3);
                        nuevaFila.append(columnaNombreUsu).append(columnaCorreo).append(columnaTelefono).append(columnaTipoProduco).append(columnaProducto).append(columnaFecha).append(columnaPresu).append(columnaCiudad).append(opciones);
                        tablaServicios.append(nuevaFila);
                    });
                    pNotiProductos();
                        
                } else {
                    msgFinal(datos.mensaje);
                }
            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error.responseText);
            }
        });

    } else if (opcion == 3) {

        $('#solicitudAlquilerADMIN').show();
        $('#buscadorNotifiAlquiler').show();
        $.ajax({
            url: 'notiADMIN/alquiler',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                var tablaServicios = $('#listaSolicitudAlquiler');
                var nuevaFila;
                if (datos.codigo == 0) {
                    $.each(datos.datosResultado, function (i, items) {
                        nuevaFila = $('<tr>');
                        var columnaNombreUsu = $('<td>');
                        var columnaCorreo = $('<td>');
                        var columnaTelefono = $('<td>');
                        var columnaTipoProduco = $('<td>');
                        var columnaProducto = $('<td>');
                        var columnaFecha = $('<td>');
                        var columnaPresu = $('<td>');
                        var columnaCiudad = $('<td>');
                        var opciones = $('<td id=\"opcionesTabla\">');
                        var solicitud = items.idSolicitud;
                        var boton1 = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"confirmarAlquiler(this.id)\">Confirmar</button>";
                        var boton2 = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"cancelarServicioMsg(" + solicitud + ",3)\">Denegar</button>";
                        nuevaFila.val(items.idSolicitud);
                        columnaNombreUsu.html(items.nombre_RazonSocial);
                        columnaCorreo.html(items.correos);
                        columnaTelefono.html(items.telefonos);
                        columnaTipoProduco.html(items.nombre);
                        columnaProducto.html(items.descripcion);
                        columnaFecha.html(items.fechaPedido);
                        columnaPresu.html(items.presupuestoDisponible);
                        columnaCiudad.html(items.ciudad);
                        opciones.html(boton1 + boton2);
                        nuevaFila.append(columnaNombreUsu).append(columnaCorreo).append(columnaTelefono).append(columnaTipoProduco).append(columnaProducto).append(columnaFecha).append(columnaPresu).append(columnaCiudad).append(opciones);
                        tablaServicios.append(nuevaFila);
                    });
                    pNotiAlquiler();

                } else {
                    msgFinal(datos.mensaje);
                }
            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error.responseText);
            }
        });
    } else if (opcion == 4) {
        $('#solicitudReportesADMIN').show();
        $('#buscadorNotifiReportes').show();

    }
}
function confirmarAlquiler(id) {
    limpiarModal();
    var idSolicitud = {};
    idSolicitud.solicitud = document.getElementById(id).value;

    $.ajax({
        url: 'peticionesADMIN/confirmarAlquiler',
        data: idSolicitud,
        method: "POST",
        dataType: 'json',
        success: function (datos) {
            console.log(datos);

            if (datos.codigo != 0) {
                $('.msjFinalEstilo').css('background-color', '#E91D1D');

            } else {
                $('.msjFinalEstilo').css('background-color', '#9EC944');

            }
            msgFinal(datos.mensaje);
            cerrarReload();

        },
        error: function (error) {
            console.log(error);
            alert('ERROR' + error.responseText);
        }
    });
}
function confirmarServicio(id) {
    limpiarModal();
    var idSolicitud = {};
    idSolicitud.solicitud = document.getElementById(id).value;

    $.ajax({
        url: 'peticionesADMIN/confirmar',
        data: idSolicitud,
        method: "POST",
        dataType: 'json',
        success: function (datos) {
            console.log(datos);

            if (datos.codigo != 0) {
                $('.msjFinalEstilo').css('background-color', '#E91D1D');

            } else {
                $('.msjFinalEstilo').css('background-color', '#9EC944');

            }
            msgFinal(datos.mensaje);
            cerrarReload();

        },
        error: function (error) {
            console.log(error);
            alert('ERROR' + error.responseText);
        }
    });
}
function modificarDpCancelar(opcion) {
    cerrarModal2();
    if (opcion == 1) {
        programaADMIN(2);
    }
    if (opcion == 2) {
        programaADMIN(1);
    }
    if (opcion == 3) {
        programaADMIN(3);
    }

}

function cancelarServicio(id, opcion) {
    limpiarModal();
    var idSolicitud = {};
    idSolicitud.solicitud = id;
    idSolicitud.opcion = opcion;
    $.ajax({
        url: 'peticionesADMIN/denegar',
        data: idSolicitud,
        method: "POST",
        dataType: 'json',
        success: function (datos) {
            console.log(datos);
            if (datos.codigo != 0) {
                $('.msjFinalEstilo').css('background-color', '#E91D1D');
                msgFinal(datos.mensaje);
                cerrarReload();


            } else {
                $('.msjFinalEstilo').css('background-color', '#9EC944');
                $('#msgConctEnd').css('font-size', '40px');
                msgFinal("Has cancelado la solicitud, puedes <a class=\"aLinkRegExito\" onclick=\"modificarDpCancelar(" + opcion + ")\"\>modificarla</a> cuando quieras.");
                cerrarReload();

            }


        },
        error: function (error) {
            console.log(error);
            alert('ERROR' + error.responseText);
        }
    });


}

function acceptar(id, opcion) {
    var idReg = document.getElementById(id).value;
    cancelarServicio(idReg, opcion);
}
function closeCancelar() {
    msnConctC();
}
function cancelarServicioMsg(id, opcion) {
    limpiarModal();
    $('#msnContOp').show();
    cerrarNormal();
    divBtnGuardar = $('.divValueBtn1');
    divBtnCancelar = $('.divValueBtn2');
    var idsolicitud = document.getElementById(id).value;
    msnConctM('¿Seguro que quieres rechazar este trabajo?');
    divBtnGuardar.html("<input id=\"aggBtn\" value=\"" + idsolicitud + "\" id=\"" + idsolicitud + "\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"acceptar(" + idsolicitud + "," + opcion + ")\">");
    divBtnCancelar.html("<input id=\"btnValueId1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc2.png\" alt=\"Cancelar\" onclick=\"closeCancelar()\">");
}


