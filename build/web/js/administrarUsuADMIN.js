/* 
 *      Autor:   Diego RM
 */

function mostrarAdministrar(id) {
    var opcion = id;
    limpiarTodo();
    $('#administrarUserADMIN').css('color', '#9EC944');
    if (opcion == 1) {
        $('#administrarCliente').show();

        $.ajax({
            url: 'admUserAdm/cliente',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);

                var tablaClientes = $('#administrarClien');

                var nuevaFila;
                var btn1, btn2, btn3;
                if (datos.codigo == 0) {

                    $.each(datos.datosResultado, function (i, items) {
                        var solicitud = items.idUsuarios;
                        if (items.estado == "Activo") {
                            btn1 = "<button id=\"" + i + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"estadoUsuarios(" + solicitud + ",0)\">Inhabilitar</button>";
                        } else {
                            if (items.estado == "Baneado") {
                                btn1 = "<button id=\"" + i + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"estadoUsuarios(" + solicitud + ",1)\">Habilitar</button>";
                            }
                        }
                        btn2 = "<button id=\"" + i + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"tipoRol(" + solicitud + ")\">Rol</button>";
                        if (items.tipoUser == "Cliente") {
                            nuevaFila = $('<tr >');

                            var nombre = $('<td>');
                            var apellido = $('<td>');
                            var correos = $('<td>');
                            var telefono = $('<td>');
                            var estado = $('<td>');
                            var documento = $('<td>');
                            var ciudad = $('<td>');
                            var pais = $('<td>');
                            var direccion = $('<td>');
                            var solicitudes = $('<td>');
                            var opcion = $('<td id=\"opcionesTabla\">');

                            nombre.html(items.usuario);
                            apellido.html(items.apellido1);
                            correos.html(items.correos);
                            telefono.html(items.telefonos);
                            estado.html(items.estado);
                            documento.html(items.documento_Nit);
                            ciudad.html(items.ciudad);
                            pais.html(items.pais);
                            direccion.html(items.direccion);
                            solicitudes.html(items.solicitudes);
                            opcion.html(btn1 + btn2);
                            nuevaFila.append(nombre).append(apellido).append(correos).append(telefono).append(estado).append(documento).append(ciudad).append(pais).append(direccion).append(solicitudes).append(opcion);
                            tablaClientes.append(nuevaFila);
                        }

                    });
                    pAdministrarCliente();

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
         
        $('#administrarEmpresas').show();

        $.ajax({
            url: 'admUserAdm/cliente',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);

                var tablaClientes = $('#listaEmpresas');

                var nuevaFila;
                var btn1, btn2, btn3;
                if (datos.codigo == 0) {

                    $.each(datos.datosResultado, function (i, items) {
                        var solicitud = items.idUsuarios;
                        if (items.estado == "Activo") {
                            btn1 = "<button id=\"" + i + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"estadoUsuarios(" + solicitud + ",0)\">Inhabilitar</button>";
                        } else {
                            if (items.estado == "Baneado") {
                                btn1 = "<button id=\"" + i + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"estadoUsuarios(" + solicitud + ",1)\">Habilitar</button>";
                            }
                        }
                        btn2 = "<button id=\"" + i + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"tipoRol(" + solicitud + ")\">Rol</button>";
                        if (items.tipoUser == "Empresa") {
                            nuevaFila = $('<tr >');

                            var nombre = $('<td>');
                            var apellido = $('<td>');
                            var correos = $('<td>');
                            var telefono = $('<td>');
                            var estado = $('<td>');
                            var documento = $('<td>');
                            var ciudad = $('<td>');
                            var pais = $('<td>');
                            var direccion = $('<td>');
                            var solicitudes = $('<td>');
                            var opcion = $('<td id=\"opcionesTabla\">');

                            nombre.html(items.usuario);
                            apellido.html(items.apellido1);
                            correos.html(items.correos);
                            telefono.html(items.telefonos);
                            estado.html(items.estado);
                            documento.html(items.documento_Nit);
                            ciudad.html(items.ciudad);
                            pais.html(items.pais);
                            direccion.html(items.direccion);
                            solicitudes.html(items.solicitudes);
                            opcion.html(btn1 + btn2);
                            nuevaFila.append(nombre).append(apellido).append(correos).append(telefono).append(estado).append(documento).append(ciudad).append(pais).append(direccion).append(solicitudes).append(opcion);
                            tablaClientes.append(nuevaFila);
                        }

                    });
                    pAdministrarEmpresa();

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
        $('#administrarEmpleados').show();

        $.ajax({
            url: 'admUserAdm/cliente',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);

                var tablaClientes = $('#listaEmplados');

                var nuevaFila;
                var btn1, btn2, btn3;
                if (datos.codigo == 0) {

                    $.each(datos.datosResultado, function (i, items) {
                        var solicitud = items.idUsuarios;
                        if (items.estado == "Activo") {
                            btn1 = "<button id=\"" + i + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"estadoUsuarios(" + solicitud + ",0)\">Inhabilitadar</button>";
                        } else {
                            if (items.estado == "Baneado") {
                                btn1 = "<button id=\"" + i + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"estadoUsuarios(" + solicitud + ",1)\">Habilitar</button>";
                            }
                        }
                        btn2 = "<button id=\"" + i + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"tipoRol(" + solicitud + ")\">Rol</button>";
                        if (items.tipoUser == "Empleado") {
                            nuevaFila = $('<tr >');

                            var nombre = $('<td>');
                            var apellido = $('<td>');
                            var correos = $('<td>');
                            var telefono = $('<td>');
                            var estado = $('<td>');
                            var documento = $('<td>');
                            var ciudad = $('<td>');
                            var pais = $('<td>');
                            var direccion = $('<td>');
                            var solicitudes = $('<td>');
                            var opcion = $('<td id=\"opcionesTabla\">');

                            nombre.html(items.usuario);
                            apellido.html(items.apellido1);
                            correos.html(items.correos);
                            telefono.html(items.telefonos);
                            estado.html(items.estado);
                            documento.html(items.documento_Nit);
                            ciudad.html(items.ciudad);
                            pais.html(items.pais);
                            direccion.html(items.direccion);
                            solicitudes.html(items.solicitudes);
                            opcion.html(btn1 + btn2);
                            nuevaFila.append(nombre).append(apellido).append(correos).append(telefono).append(estado).append(documento).append(ciudad).append(pais).append(direccion).append(solicitudes).append(opcion);
                            tablaClientes.append(nuevaFila);
                        }

                    });
                    pAdministrarEmpleado();

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
        $('#administrarInactivos').show();
        var adminNone = true;
        $.ajax({
            url: 'admUserAdm/inactivos',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);

                var tablaClientes = $('#listaAdmInactivo');

                var nuevaFila;
                var btn1, btn2, btn3;
                if (datos.codigo == 0) {

                    $.each(datos.datosResultado, function (i, items) {
                        if (items.tipoUser == "Administrador") {
                            adminNone == false;
                        }
                        if (adminNone == true) {


                            var solicitud = items.idUsuarios;
                            if (items.estado == "Activo") {
                                btn1 = "<button id=\"" + i + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"estadoUsuarios(" + solicitud + ",0)\">Inhabilitar</button>";
                            } else {
                                if (items.estado == "Baneado") {
                                    btn1 = "<button id=\"" + i + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"estadoUsuarios(" + solicitud + ",1)\">Habilitar</button>";
                                }
                            }
                            btn2 = "<button id=\"" + i + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"tipoRol(" + solicitud + ")\">Rol</button>";

                            nuevaFila = $('<tr >');
                            var nombre = $('<td>');
                            var apellido = $('<td>');
                            var correos = $('<td>');
                            var telefono = $('<td>');
                            var estado = $('<td>');
                            var documento = $('<td>');
                            var ciudad = $('<td>');
                            var pais = $('<td>');
                            var direccion = $('<td>');
                            var solicitudes = $('<td>');
                            var opcion = $('<td id=\"opcionesTabla\">');

                            nombre.html(items.usuario);
                            apellido.html(items.apellido1);
                            correos.html(items.correos);
                            telefono.html(items.telefonos);
                            estado.html(items.estado);
                            documento.html(items.documento_Nit);
                            ciudad.html(items.ciudad);
                            pais.html(items.pais);
                            direccion.html(items.direccion);
                            solicitudes.html(items.tipoUser);
                            opcion.html(btn1 + btn2);
                            nuevaFila.append(nombre).append(apellido).append(correos).append(telefono).append(estado).append(documento).append(ciudad).append(pais).append(direccion).append(solicitudes).append(opcion);
                            tablaClientes.append(nuevaFila);
                            
                        }
                    });
                    pAdministrarInactivos();

                } else {
                    msgFinal(datos.mensaje);
                }
            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error.responseText);
            }

        });

    }
}

function cambiarEstado(id, estado) {

    limpiarModal();
    var estadoStr;
    if (estado == 0) {
        estadoStr = "Baneado";
    }
    if (estado == 1) {
        estadoStr = "Activo";
    }
    var info = {};
    info.id = id;
    info.estado = estadoStr;
    $.ajax({
        url: 'admUserAdm/banear',
        data: info,
        method: "POST",
        dataType: 'json',
        success: function (datos) {
            console.log(datos);
            if (datos.codigo != 0) {
                $('.msjFinalEstilo').css('background-color', '#E91D1D');
                cerrarNormal();
            } else {
                $('.msjFinalEstilo').css('background-color', '#9EC944');
                cerrarReload();
            }
            msgFinal(datos.mensaje);



        },
        error: function (error) {
            console.log(error);
            alert('ERROR' + error.responseText);
        }
    });
}
function estadoUsuarios(id, estado) {
    var estadoStr;
    if (estado == 0) {
        estadoStr = "Inhabilitar";
    }
    if (estado == 1) {
        estadoStr = "Habilitar";
    }
    limpiarModal();
    var idsolicitud = id;
    $('#msnContOp').show();
    cerrarNormal();
    divBtnGuardar = $('.divValueBtn1');
    divBtnCancelar = $('.divValueBtn2');
    msnConctM('¿Seguro que quieres ' + estadoStr + ' este usuario?');
    divBtnGuardar.html("<input id=\"aggBtn\" value=\"" + idsolicitud + "\" id=\"" + idsolicitud + "\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"cambiarEstado(" + idsolicitud + "," + estado + ")\">");
    divBtnCancelar.html("<input id=\"btnValueId1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc2.png\" alt=\"Cancelar\" onclick=\"msnConctC()\">");
}

function tipoRol(id) {

    limpiarModal();
    cerrarNormal();
    $('.msjFinalEstilo').css('background-color', '#26447f');
    $('#msgConctEnd').css('font-size', '32px');
    msgFinal('\n\<a class=\"opcionestRol\" onclick=\"cambiarRol(' + id + ',1)\">Administrador</a>\n\
                <a class=\"opcionestRol\" onclick=\"cambiarRol(' + id + ',4)\">Empleado</a>\n\
                <a class=\"opcionestRol\" onclick=\"cambiarRol(' + id + ',2)\">Cliente</a>\n\
                <a class=\"opcionestRol\" onclick=\"cambiarRol(' + id + ',3)\">Empresa</a>');

}

function cambiarRol(id, rol) {
    limpiarModal();
    var infoRol = {};
    infoRol.id = id;
    infoRol.rol = rol;

    $.ajax({
        url: 'admUserAdm/cambiarRol',
        data: infoRol,
        method: "POST",
        dataType: 'json',
        success: function (datos) {
            console.log(datos);
            if (datos.codigo != 0) {
                $('.msjFinalEstilo').css('background-color', '#E91D1D');
                cerrarNormal();
            } else {
                $('.msjFinalEstilo').css('background-color', '#9EC944');
                cerrarReload();
            }
            msgFinal(datos.mensaje);

        },
        error: function (error) {
            console.log(error);
            alert('ERROR' + error.responseText);
        }
    });
}
