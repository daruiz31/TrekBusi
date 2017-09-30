/* 
 *      Autor:  Diego RM
 */
function programaADMIN(id) {
    var opcion = id;
    limpiarTodo();

    if (opcion == 1) {

        $('#programaServicios').show();

        $.ajax({
            url: 'peticionesADMIN/programaServicios',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                var tablaProductos = $('#proTablaServi');
                var boton = " ";
                var nuevaFila;
                if (datos.codigo == 0) {
                    $.each(datos.datosResultado, function (i, items) {
                        var solicitud = items.idSolicitud;
                        if (items.estado == "pendiente") {
                            boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"cancelarProducto(this.id)\">Cancelar</button>";
                        }
                        if (items.estado == "Cancelado") {
                            boton = "Cancelarón el pedido.";
                        }
                        if (items.estado == "Confirmado") {
                            boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"terminarSolicitud(this.id)\">Terminar</button>";
                        }
                        if (items.estado == "Vendido") {
                            boton = "Manten el contacto con tu cliente.";
                        }
                        if (items.estado == "Terminado" || items.estado == "terminado") {
                            boton = "Manten el contacto con tu cliente.";
                        }
                        if (items.estado == "Denegado") {
                            boton = boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"confirmarServicio(this.id)\">Confirmar</button>";
                        }
                        nuevaFila = $('<tr>');
                        var usuario = $('<td>');
                        var correo = $('<td>');
                        var telefono = $('<td>');
                        var servicio = $('<td>');
                        var descripcion = $('<td>');
                        var fechaSolicitada = $('<td>');
                        var fechaPedido = $('<td>');
                        var presupuesto = $('<td>');
                        var ciudad = $('<td>');
                        var direccion = $('<td>');
                        var estado = $('<td>');
                        var opcion = $('<td id=\"opcionesTabla\">');

                        usuario.html(items.nombre_RazonSocial);
                        correo.html(items.correos);
                        telefono.html(items.telefonos);
                        servicio.html(items.nombre);
                        descripcion.html(items.descripcion);
                        fechaSolicitada.html(items.fechaServicio);
                        fechaPedido.html(items.fechaPedido);
                        presupuesto.html(items.presupuestoDisponible);
                        ciudad.html(items.ciudad);
                        direccion.html(items.direccion);
                        estado.html(items.estado);
                        opcion.html(boton);


                        nuevaFila.append(usuario).append(correo).append(telefono).append(servicio).append(descripcion).append(fechaSolicitada).append(fechaPedido).append(presupuesto).append(ciudad).append(direccion).append(estado).append(opcion);
                        tablaProductos.append(nuevaFila);
                    });
                    pProgramaServicio();

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
        $('#programaProductos').show();

        $.ajax({
            url: 'peticionesADMIN/programaProductos',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                var tablaProductos = $('#programaTablaProductos');
                var boton = " ";

                var nuevaFila;
                $.each(datos.datosResultado, function (i, items) {
                    var solicitud = items.idSolicitud;
                    var boton2 = "<a target=\"_blank\" class=\"linkVermas\" href=\"http://localhost:8080/Proyecto/reporteProductos?pedido="+solicitud+"\"><img src=\"imagenes/msn/lupa1.png\"/>Ver mas</a>";

                    if (items.estado == "pendiente") {
                        boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"cancelarProducto(this.id)\">Cancelar</button>";
                    }
                    if (items.estado == "Cancelado") {
                        boton = "Cancelarón el pedido.";
                    }
                    if (items.estado == "Confirmado") {
                        boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"terminarSolicitud(this.id)\">Terminar</button>";
                    }
                    if (items.estado == "Denegado") {
                        boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"confirmarServicio(this.id)\">Confirmar</button>";
                    }
                    if (items.estado == "Terminado") {
                        boton = "Manten el contacto con tu cliente.";
                    }
                    nuevaFila = $('<tr>');
                    var usuario = $('<td></td>');
                    var correo = $('<td>');
                    var telefono = $('<td>');
                    var producto = $('<td>');
                    var descripcion = $('<td>');
                    var ciudad = $('<td>');
                    var direccion = $('<td>');
                    var neto = $('<td>');
                    var fechaPedido = $('<td>');
                    var estado = $('<td>');
                    var opcion = $('<td id=\"opcionesTabla\">');

                    usuario.html(items.nombre_RazonSocial);
                    correo.html(items.correos);
                    telefono.html(items.telefonos);
                    producto.html(items.nombre);
                    descripcion.html(items.descripcion);
                    fechaPedido.html(items.fechaPedido);
                    neto.html(items.presupuestoDisponible);
                    ciudad.html(items.ciudad);
                    direccion.html(items.direccion);
                    estado.html(items.estado);
                    opcion.html(boton + boton2);


                    nuevaFila.append(usuario).append(correo).append(telefono).append(producto).append(descripcion).append(ciudad).append(direccion).append(neto).append(fechaPedido).append(estado).append(opcion);
                    tablaProductos.append(nuevaFila);
                });
                pProgramaProductos();
            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error);
            }

        });

    } else if (opcion == 3) {
        $('#programaAlquiler').show();

        $.ajax({
            url: 'peticionesADMIN/programaAlquiler',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                var tablaProductos = $('#programaTablaAlquiler');
                var boton;
                var nuevaFila;
                if (datos.codigo == 0) {

                    $.each(datos.datosResultado, function (i, items) {

                        var solicitud = items.idSolicitud;
                        debugger;
                        if (items.estado == "pendiente") {
                            boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"cancelarProducto(this.id)\">Cancelar</button>";
                        }
                        if (items.estado == "cancelado") {
                            boton = "Cancelarón el pedido.";
                        }
                        if (items.estado == "Confirmado") {
                            boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"terminarAlquiler(this.id)\">Terminar</button>";
                        }
                        if (items.estado == "denegado") {
                            boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"confirmarServicio(this.id)\">Confirmar</button>";
                        }
                        if (items.estado == "Terminado") {
                            boton = "Manten el contacto con tu cliente.";
                        }
                        if (items.estado == "vendido") {
                            boton = "Manten el contacto con tu cliente.";
                        }
                        if (items.estado != "pendiente" && items.estado != "Pendiente") {
                            nuevaFila = $('<tr>');
                            var usuario = $('<td></td>');
                            var correo = $('<td>');
                            var telefono = $('<td>');
                            var ciudad = $('<td>');
                            var producto = $('<td>');
                            var descripcion = $('<td>');
                            var neto = $('<td>');
                            var direccion = $('<td>');
                            var fechaInicio = $('<td>');
                            var fechaFin = $('<td>');
                            var fechaPedido = $('<td>');
                            var estado = $('<td>');
                            var opcion = $('<td id=\"opcionesTabla\">');



                            usuario.html(items.usuario);
                            correo.html(items.correo);
                            telefono.html(items.telefono);
                            ciudad.html(items.ciudad);
                            producto.html(items.nombreSolicitud);
                            descripcion.html(items.descripcion);
                            neto.html(items.costo);
                            direccion.html(items.direccion);
                            fechaInicio.html(items.fechaInicio);
                            fechaFin.html(items.fechaFin);
                            fechaPedido.html(items.fechaPedido);
                            estado.html(items.estado);
                            opcion.html(boton);
                            nuevaFila.append(usuario).append(correo).append(telefono).append(ciudad).append(producto).append(descripcion).append(neto).append(direccion).append(fechaInicio).append(fechaFin).append(fechaPedido).append(estado).append(opcion);
                            tablaProductos.append(nuevaFila);
                        }

                    });

                    pProgramaAlquiler();
                } else {
                    msgFinal(datos.mensaje);
                }
            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error);
            }

        });

    } else if (opcion == 4) {
        $('#buscadorProgramaEstadistica').show();
        $('#programaEstadisticas').show();

    }
}

function terminarAlquiler(id) {
    limpiarModal();
    var idSolicitud = {};
    idSolicitud.solicitud = document.getElementById(id).value;

    $.ajax({
        url: 'peticionesADMIN/terminarAlq',
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

function terminarSolicitud(id) {
    limpiarModal();
    var idSolicitud = {};
    idSolicitud.solicitud = document.getElementById(id).value;

    $.ajax({
        url: 'peticionesADMIN/terminar',
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