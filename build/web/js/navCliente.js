/* 
 *  Autor:  Diego RM
 */

function limpiarNavCliente() {

}


var objetosDOM = {
    // Parrafos     
    nombreUser: $('#datoNombreUser'),
    nombre1User: $('#datoPrimerN'),
    nombre2User: $('#datoSegunUser'),
    apellido1User: $('#datoPrimerA'),
    apellido2User: $('#datoSegunA'),
    paisUser: $('#datoPais'),
    ciudadUser: $('#datoCiudad'),
    direccionUser: $('#datoDireccion'),
    telefonosUser: $('#datoTelefono1')


            //Cajas de texto
}
function servicios(id) {
    eliminarSeguimiento();
    var opcion = document.getElementById(id).value;

    if (opcion == 1) {
        $('#mostrarSeguimiento').show();
        $('#descargarArchivos').show();
        $('#archivosImagen').show();
        $('#archivosPerfil').hide();

    }
    if (opcion == 2) {
        window.location.href = 'comprar-productos.jsp';
    }
    if (opcion == 3) {
        $('#productosMostrar').show();
        $('#solicitudesProcliente').show();
        $('#carritoCliente').show();
        $('#solicitudesSevcliente').show();
        $('#pedidosImagen').show();
        $('#pedidosPerfil').hide();

    }
    if (opcion == 4) {
        $('#pedidosMostrar').show();
        $('#productosProcliente').show();
        $('#serviciosCliente').show();
        $('#negocioImagen').show();
        $('#negociosPerfil').hide();

    }
}

function seguimiento(id) {
    var opcion = document.getElementById(id).value;

    if (opcion == 1) {
        eliminarModificacion();
        eliminarLetreros();
        $('.perfilCliente').show();
        $('#descargarArchivos').hide();
        $('#perfilCliente').css('color', '#9EC944');

        $('#informacionCliente').show();
        $('#informacionCliente2').show();
        $('#informacionCliente3').show();
        $('#informacionCliente4').show();

        $.ajax({
            url: 'navegadoCliente/infoUser',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                $('#datoNombreUser').html(datos.usuario);
                $('#datoPrimerN').html(datos.nombre_RazonSocial);
                $('#datoSegunUser').html(datos.nombre2);
                $('#datoPrimerA').html(datos.apellido1);
                $('#datoSegunA').html(datos.apellido2);
                $('#datoPais').html(datos.pais);
                $('#datoCiudad').html(datos.ciudad);
                $('#datoDireccion').html(datos.direccion);
                var telefonos = datos.telefonos;
                var seperartel = telefonos.split(';');
                var telefono1 = seperartel[0];
                var telefono2 = seperartel[1];
                var telefono3 = seperartel[2];
                $('#datoTelefono1').html(telefono1);
                $('#datoTelefono2').html(telefono2);
                $('#datoTelefono3').html(telefono3);
                $('#datoDocumento').html(datos.documento_Nit);
            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error);
            }

        });
    }
    if (opcion == 2) {

    }
}
function perfil(id) {
    var opcion = document.getElementById(id).value;
    if (opcion == 1) {
        $('#modificarCliente').show();
        $('#modificarCliente2').show();
        $('#modificarCliente3').show();
        $('#modificarCliente4').show();
        $('#modificarPerfilatras').show();
        $('#actualizarPerfil').show();
        $('#informacionCliente').hide();
        $('#informacionCliente2').hide();
        $('#informacionCliente3').hide();
        $('#informacionCliente4').hide();
        $('#modificarPerfil').hide();
        $('#eliminarPerfil').hide();
        $.ajax({
            url: 'navegadoCliente/infoUser',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                $('#nombre1').val(datos.nombre_RazonSocial);
                $('#usuario').val(datos.usuario);
                var telefonos = datos.telefonos;
                var seperartel = telefonos.split(';');
                var telefono1 = seperartel[0];
                var telefono2 = seperartel[1];
                var telefono3 = seperartel[2];
                $('#telefono1').val(telefono1);
                $('#telefono2').val(telefono2);
                $('#telefono3').val(telefono3);
                $('#nombre2').val(datos.nombre2);
                $('#paisSel').val(datos.pais);
                $('#ciudadSel').val(datos.ciudad);
                $('#documentoNit').val(datos.documento_Nit);
                $('#apellido1').val(datos.apellido1);
                $('#apellido2').val(datos.apellido2);
                $('#direccion').val(datos.direccion);

            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error);
            }

        });

    }
    if (opcion == 2) {

        limpiarModal();
        $('#msnContOp').show();
        cerrarNormal();
        divBtnGuardar = $('.divValueBtn1');
        divBtnCancelar = $('.divValueBtn2');
        msnConctM('¿Seguro deseas eliminar tu cuenta?');
        divBtnGuardar.html("<input id=\"aggBtn\" id=\"btnEliminar\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"eliminarCliente()\">");
        divBtnCancelar.html("<input id=\"btnValueId1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc2.png\" alt=\"Cancelar\" onclick=\"msnConctC()\">");

    }
    if (opcion == 3) {
        $('#modificarCliente').hide();
        $('#modificarCliente2').hide();
        $('#modificarCliente3').hide();
        $('#modificarCliente4').hide();

        $('#actualizarPerfil').hide();
        $('#modificarPerfilatras').hide();
        $('#informacionCliente').show();
        $('#informacionCliente2').show();
        $('#informacionCliente3').show();
        $('#informacionCliente4').show();
        $('#eliminarPerfil').show();
        $('#modificarPerfil').show();
        eliminarLetreros();

    }
    if (opcion == 4) {
        limpiarModal();

        var divBtnGuardar = $('.divValueBtn1');
        var divBtnCancelar = $('.divValueBtn2');
        var inputAlert = ~('#inputAlert');
        var perfil = {};
        perfil.nombre1 = $('#nombre1').val();
        perfil.usuario = $('#usuario').val();
        var telefono1 = $('#telefono1').val();
        var telefono2 = $('#telefono2').val();
        var telefono3 = $('#telefono3').val();
        perfil.nombre2 = $('#nombre2').val();
        perfil.pais = $('#paisSel').val();
        perfil.ciudad = $('#ciudadSel').val();
        perfil.documento = $('#documentoNit').val();
        perfil.apellido1 = $('#apellido1').val();
        perfil.apellido2 = $('#apellido2').val();
        perfil.direccion = $('#direccion').val();
        perfil.telefono = " ";

        if (telefono1 != null || telefono1 != 0) {
            perfil.telefono += telefono1 + "; ";
        }
        if (telefono2 != null || telefono2 != 0) {
            perfil.telefono += telefono2 + "; ";
        }
        if (telefono3 != null || telefono3 != 0) {
            perfil.telefono += telefono3 + "; ";
        }
        if (perfil.nombre1 == null || perfil.nombre1 == 0 || /^\s+$/.test(perfil.nombre1)) {
            $('#msnContOp').show();
            cerrarNormal();

            msnConctM('Falta tu nombre');
            divBtnGuardar.html("<input  class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"datosPerfil(1)\">");
            divBtnCancelar.html("<input placeholder=\"NOMBRE\" type=\"text\" class=\"txtModificatUsu\" onkeypress=\"return validar(event)\" />");
            $('.txtModificatUsu').focus();
        } else {
            if (perfil.usuario == null || perfil.usuario == 0 || /^\s+$/.test(perfil.usuario)) {
                $('#msnContOp').show();
                cerrarNormal();

                msnConctM('Falta tu nombre de usuario');
                divBtnGuardar.html("<input  class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"datosPerfil(2)\">");
                divBtnCancelar.html("<input placeholder=\"USUARIO\" type=\"text\" class=\"txtModificatUsu\" onkeypress=\"return validar(event)\" />");
                $('.txtModificatUsu').focus();
            } else {
                if (perfil.nombre2 == null || perfil.nombre2 == 0 || /^\s+$/.test(perfil.nombre2)) {
                    $('#msnContOp').show();
                    cerrarNormal();

                    msnConctM('Falta tu segundo nombre');
                    divBtnGuardar.html("<input  class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"datosPerfil(3)\">");
                    divBtnCancelar.html("<input placeholder=\"NOMBRE\" type=\"text\" class=\"txtModificatUsu\" onkeypress=\"return validar(event)\" />");
                    $('.txtModificatUsu').focus();
                } else {
                    if (perfil.pais == null || perfil.pais == 0 || /^\s+$/.test(perfil.pais) || perfil.pais == "Selecciona Pais") {
                        cerrarNormal();
                        msgFinal("Falta tu país de residencia");
                    } else {
                        if (perfil.ciudad == null || perfil.ciudad == 0 || /^\s+$/.test(perfil.ciudad)) {
                            cerrarNormal();
                            msgFinal("Falta tu ciudad de residencia");
                        } else {
                            if (perfil.documento == null || perfil.documento == 0 || /^\s+$/.test(perfil.documento)) {
                                $('#msnContOp').show();
                                cerrarNormal();

                                msnConctM('Falta tu documento');
                                divBtnGuardar.html("<input  class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"datosPerfil(4)\">");
                                divBtnCancelar.html("<input placeholder=\"DOCUMENTO\" type=\"text\" class=\"txtModificatUsu\" onkeypress=\"ValidaSoloNumeros()\"/>");
                                $('.txtModificatUsu').focus();
                            } else {
                                if (perfil.apellido1 == null || perfil.apellido1 == 0 || /^\s+$/.test(perfil.apellido1)) {
                                    $('#msnContOp').show();
                                    cerrarNormal();

                                    msnConctM('Falta tu primer apellido');
                                    divBtnGuardar.html("<input  class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"datosPerfil(5)\">");
                                    divBtnCancelar.html("<input placeholder=\"APELLIDO\" type=\"text\" class=\"txtModificatUsu\" onkeypress=\"return validar(event)\" />");
                                    $('.txtModificatUsu').focus();
                                } else {
                                    if (perfil.apellido2 == null || perfil.apellido2 == 0 || /^\s+$/.test(perfil.apellido2)) {
                                        $('#msnContOp').show();
                                        cerrarNormal();

                                        msnConctM('Falta tu segundo apellido');
                                        divBtnGuardar.html("<input  class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"datosPerfil(6)\">");
                                        divBtnCancelar.html("<input placeholder=\"APELLIDO\" type=\"text\" class=\"txtModificatUsu\" onkeypress=\"return validar(event)\" />");
                                        $('.txtModificatUsu').focus();
                                    } else {
                                        if (perfil.direccion == null || perfil.direccion == 0 || /^\s+$/.test(perfil.direccion)) {
                                            $('#msnContOp').show();
                                            cerrarNormal();

                                            msnConctM('Falta tu dirección de domicilio');
                                            divBtnGuardar.html("<input  class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"datosPerfil(7)\">");
                                            divBtnCancelar.html("<input placeholder=\"DIRECCION\" type=\"text\" class=\"txtModificatUsu\" />");
                                            $('.txtModificatUsu').focus();
                                        } else {
                                            if (perfil.telefono == null || perfil.telefono == 0 || /^\s+$/.test(perfil.telefono) || perfil.telefono == " ") {
                                                $('#msnContOp').show();
                                                cerrarNormal();

                                                msnConctM('Falta almenos un(1) número teléfonico');
                                                divBtnGuardar.html("<input  class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"datosPerfil(8)\">");
                                                divBtnCancelar.html("<input placeholder=\"TELÉFONO\" type=\"text\" class=\"txtModificatUsu\" onkeypress=\"ValidaSoloNumeros()\" />");
                                                $('.txtModificatUsu').focus();
                                            } else {
                                                limpiarModal();
                                                $.ajax({
                                                    url: 'navegadoCliente/actualizarPerfil',
                                                    data: perfil,
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
                                                        alert('ERROR' + error);
                                                    }

                                                });
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


    }
}

function productosCliente(id) {
    var botn = document.getElementById(id).value;

    if (botn == 1) {
        $('#solicitudesProcliente').css('color', 'black');
        $('#carritoCliente').css('color', '#9EC944');
        $('#solicitudesSevcliente').css('color', 'black');
        $('.carritoCliente').show();
        $('.productosAdquiridos').hide();
        $('.serviciosAdquiridos').hide();
        $.ajax({
            url: 'navegadoCliente/listarBuyAlquiler',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                var tablaProductos = $('#productosClienteAlquiler');
                if (datos.codigo == 0) {

                    
                    var nuevaFila;
                    $.each(datos.datosResultado, function (i, items) {
                      
                        nuevaFila = $('<tr>');
                        var producto = $('<td>');
                        var descripcion = $('<td>');
                        var costo = $('<td>');
                        var fechaSolicitud = $('<td>');
                        var fechaInicio = $('<td>');
                        var fechaFin = $('<td>');

                        producto.html(items.nombreProducto);
                        descripcion.html(items.descripcion);
                        costo.html(items.costo);
                        fechaSolicitud.html(items.fechaPedido);
                        fechaInicio.html(items.fechaInicio);
                        fechaFin.html(items.fechaFin);


                        nuevaFila.append(fechaSolicitud).append(fechaInicio).append(fechaFin).append(producto).append(descripcion).append(costo);
                        tablaProductos.append(nuevaFila);
                    });


                } else {
                    alert(datos.mensaje);
                }
            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error.responseText);
            }

        });
    }
    if (botn == 2) {

        $('.productosAdquiridos').show();
        $('.carritoCliente').hide();
        $('#solicitudesProcliente').css('color', '#9EC944');
        $('#solicitudesSevcliente').css('color', 'black');
        $('#carritoCliente').css('color', 'black');
        $('.serviciosAdquiridos').hide();
        $.ajax({
            url: 'navegadoCliente/listarBuyproductos',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);

                var tablaServicios = $('#productosClienteBuy');

                var nuevaFila;
                if (datos.codigo == 0) {
                    $.each(datos.datosResultado, function (i, items) {

                        nuevaFila = $('<tr id=\"filasLista1Cliente\">');
                        var foto = $('<td></td>');
                        var tipoProducto = $('<td>');
                        var nombre = $('<td>');
                        var marca = $('<td>');
                        var descripcion = $('<td>');
                        var costo = $('<td>');
                        var fechaCompra = $('<td>');
                        var img = "<img id=\"imgsTables\" src =" + items.foto + " />";

                        foto.html(img);
                        tipoProducto.html(items.tipoProducto);
                        nombre.html(items.nombre);
                        marca.html(items.marca);
                        descripcion.html(items.descripcion);
                        costo.html(items.total);
                        fechaCompra.html(items.fechaSolicitud);

                        nuevaFila.append(foto).append(tipoProducto).append(nombre).append(marca).append(descripcion).append(costo).append(fechaCompra);
                        tablaServicios.append(nuevaFila);
                    });


                } else {
                    alert(datos.mensaje);
                }
            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error.responseText);
            }
        });

    }
    if (botn == 3) {
        $('#solicitudesProcliente').css('color', 'black');
        $('#carritoCliente').css('color', 'black');
        $('#solicitudesSevcliente').css('color', '#9EC944');
        $('.productosAdquiridos').hide();
        $('.carritoCliente').hide();
        $.ajax({
            url: 'navegadoCliente/listarBuyservicios',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);

                var tablaServicios = $('#serviciosClienteBuy');

                var nuevaFila;
                if (datos.codigo == 0) {
                    $.each(datos.datosResultado, function (i, items) {
                        $('.serviciosAdquiridos').show();
                        nuevaFila = $('<tr>');
                        var nombreServ = $('<td>');
                        var descripcion = $('<td>');
                        var fechaAcordada = $('<td>');
                        var fecgaPedido = $('<td>');
                        var estado = $('<td>');


                        nombreServ.html(items.nombre);
                        descripcion.html(items.descripcion);
                        fechaAcordada.html(items.fechaServicio);
                        fecgaPedido.html(items.fechaPedido);
                        estado.html(items.estado)

                        nuevaFila.append(nombreServ).append(descripcion).append(fechaAcordada).append(fecgaPedido).append(estado);
                        tablaServicios.append(nuevaFila);
                    });


                } else {
                    alert(datos.mensaje);
                }
            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error.responseText);
            }
        });
    }
}
function negocioCliente(id) {
    var boton = document.getElementById(id).value;
    limpiarNavCTablas();
    if (boton == 1) {
        $('.negociosServicios').show();
        $('.negociosProductos').hide();
        $('.negociosAlquiler').hide();
        var solicitud = 0;
        var boton = " ";
        $.ajax({
            url: 'navegadoCliente/listarServiciosNegocio',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);

                var tablaServicios = $('#negociosServicios');
                $('#serviciosCliente').css('color', '#9EC944');
                $('#productosAlquil').css('color', 'black');
                $('#productosProcliente').css('color', 'black');
                var nuevaFila;
                if (datos.codigo == 0) {
                    $.each(datos.datosResultado, function (i, items) {
                        $('.serviciosAdquiridos').show();
                        solicitud = items.idSolicitud;
                        if (items.estado == "Pendiente") {
                            boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"cancelarServicio(this.id)\">Cancelar</button>";
                        }
                        if (items.estado == "Cancelado") {
                            boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"solicitarServicio(this.id)\">Solicitar</button>";
                        }
                        if (items.estado == "Confirmado") {
                            boton = "Gracias por confiar en nosotros.";
                        }
                        if (items.estado == "Denegado") {
                            boton = "Lo sentimos pero nuestros ingenieros determinaron que tu petición no es viable.";
                        }

                        nuevaFila = $('<tr>');
                        var nombreServ = $('<td>');
                        var descripcion = $('<td>');
                        var fechaAcordada = $('<td>');
                        var fecgaPedido = $('<td>');
                        var estado = $('<td>');
                        var opciones = $('<td id=\"opcionesTabla\">');

                        nombreServ.html(items.nombre);
                        descripcion.html(items.descripcion);
                        fechaAcordada.html(items.fechaServicio);
                        fecgaPedido.html(items.fechaPedido);
                        estado.html(items.estado);
                        opciones.html(boton);


                        nuevaFila.append(nombreServ).append(descripcion).append(fechaAcordada).append(fecgaPedido).append(estado).append(opciones);



                        tablaServicios.append(nuevaFila);

                    });
                    pNegociosServi();

                } else {
                    alert(datos.mensaje);
                }
            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error.responseText);
            }
        });
    }
    if (boton == 2) {
        $('.negociosProductos').show();
        $('.negociosServicios').hide();
        $('.negociosAlquiler').hide();
        $.ajax({
            url: 'navegadoCliente/todosProductos',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);

                var tablaProductos = $('#negociosProductos');
                $('#productosProcliente').css('color', '#9EC944');
                $('#serviciosCliente').css('color', 'black');
                $('#productosAlquil').css('color', 'black');
                var nuevaFila;
                if (datos.codigo == 0) {

                    $.each(datos.datosResultado, function (i, items) {
                        solicitud = items.idDetalleSolicitud;

                        var contador = items.contador;
                        if (items.estado == "Pendiente") {
                            boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"cancelarProducto(this.id)\">Cancelar</button>";
                        }
                        if (items.estado == "Cancelado") {
                            boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"solicitarProducto(this.id)\">Solicitar</button>";
                        }
                        if (items.estado == "Confirmado") {
                            boton = "Gracias por confiar en nosotros.";
                        }
                        if (items.estado == "Denegado") {
                            boton = "Lo sentimos pero nuestros ingenieros determinaron que tu petición no es viable.";
                        }
                        nuevaFila = $('<tr>');
                        var foto = $('<td></td>');
                        var nombre = $('<td>');
                        var marca = $('<td>');
                        var descripcion = $('<td>');
                        var costo = $('<td>');
                        var fechaCompra = $('<td>');
                        var estado = $('<td>');
                        var img = "<img id=\"imgsTables\" src =" + items.foto + " />";
                        var opcion = $('<td id=\"opcionesTabla\">');

                        foto.html(img);
                        nombre.html(items.nombre);
                        marca.html(items.marca);
                        descripcion.html(items.descripcion);
                        costo.html(items.total);
                        fechaCompra.html(items.fechaSolicitud);
                        estado.html(items.estado);
                        opcion.html(boton);

                        nuevaFila.append(foto).append(nombre).append(marca).append(descripcion).append(costo).append(fechaCompra).append(estado).append(opcion);
                        tablaProductos.append(nuevaFila);
                    });
                    pNegociosProdu();

                } else {
                    alert(datos.mensaje);
                }
            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error.responseText);
            }
        });

    }
    if (boton == 3) {
        $('.negociosProductos').hide();
        $('.negociosServicios').hide();
        $('.negociosAlquiler').show();

        $.ajax({
            url: 'navegadoCliente/todosAlquiler',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);

                var tablaProductos = $('#negociosAlquiler');
                $('#productosAlquil').css('color', '#9EC944');
                $('#productosProcliente').css('color', 'black');
                $('#serviciosCliente').css('color', 'black');
                var nuevaFila;
                if (datos.codigo == 0) {

                    $.each(datos.datosResultado, function (i, items) {
                        solicitud = items.idSolicitud;

                        var contador = items.contador;
                        if (items.estado == "Pendiente") {
                            boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"cancelarProductoAlquilado(this.id)\">Cancelar</button>";
                        }
                        if (items.estado == "Cancelado") {
                            boton = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"solicitarProductoAlquilado(this.id)\">Solicitar</button>";
                        }
                        if (items.estado == "Confirmado") {
                            boton = "Gracias por confiar en nosotros.";
                        }
                        if (items.estado == "Denegado") {
                            boton = "Lo sentimos pero nuestros ingenieros determinaron que tu petición no es viable.";
                        }
                        nuevaFila = $('<tr>');
                        var producto = $('<td>');
                        var descripcion = $('<td>');
                        var costo = $('<td>');
                        var fechaSolicitud = $('<td>');
                        var fechaInicio = $('<td>');
                        var fechaFin = $('<td>');
                        var estado = $('<td>');
                        var informacion = $('<td>');
                        producto.html(items.nombreProducto);
                        descripcion.html(items.descripcion);
                        costo.html(items.costo);
                        fechaSolicitud.html(items.fechaPedido);
                        fechaInicio.html(items.fechaInicio);
                        fechaFin.html(items.fechaFin);
                        estado.html(items.estado);
                        informacion.html(boton);
                        nuevaFila.append(producto).append(descripcion).append(costo).append(fechaSolicitud).append(fechaInicio).append(fechaFin).append(estado).append(informacion);

                        tablaProductos.append(nuevaFila);
                    });
                    pNegociosAlquiler();

                } else {
                    alert(datos.mensaje);
                }
            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error.responseText);
            }
        });
    }
}
function cancelarServicioGo(id) {
    var idSolicitud = {};
    idSolicitud.solicitud = id;
    limpiarModal();
    $.ajax({
        url: 'navegadoCliente/cancelarServicio',
        data: idSolicitud,
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

function cancelarServicio(id) {
    var idsolicitud = document.getElementById(id).value;
    limpiarModal();
    $('#msnContOp').show();
    cerrarNormal();
    divBtnGuardar = $('.divValueBtn1');
    divBtnCancelar = $('.divValueBtn2');
    msnConctM('¿Seguro que quieres rechazar este trabajo?');
    divBtnGuardar.html("<input id=\"aggBtn\" value=\"" + idsolicitud + "\" id=\"" + idsolicitud + "\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"cancelarServicioGo(" + idsolicitud + ")\">");
    divBtnCancelar.html("<input id=\"btnValueId1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc2.png\" alt=\"Cancelar\" onclick=\"msnConctC()\">");

}
function soliciraeServicioGo(id) {
    var idSolicitud = {};
    idSolicitud.solicitud = id;
    limpiarModal();
    $.ajax({
        url: 'navegadoCliente/solicitarServicio',
        data: idSolicitud,
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
function solicitaAlquilerGo(id) {
    var idSolicitud = {};
    idSolicitud.solicitud = id;
    limpiarModal();
    $.ajax({
        url: 'navegadoCliente/solicitarAlquiler',
        data: idSolicitud,
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
function solicitarProductoAlquilado(id) {
    var idsolicitud = document.getElementById(id).value;
    limpiarModal();
    $('#msnContOp').show();
    cerrarNormal();
    divBtnGuardar = $('.divValueBtn1');
    divBtnCancelar = $('.divValueBtn2');
    msnConctM('¿Quieres enviar la solicitud para alquilar nuevamente?');
    divBtnGuardar.html("<input id=\"aggBtn\" value=\"" + idsolicitud + "\" id=\"" + idsolicitud + "\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"solicitaAlquilerGo(" + idsolicitud + ")\">");
    divBtnCancelar.html("<input id=\"btnValueId1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc2.png\" alt=\"Cancelar\" onclick=\"msnConctC()\">");
}
function solicitarServicio(id) {

    var idsolicitud = document.getElementById(id).value;
    limpiarModal();
    $('#msnContOp').show();
    cerrarNormal();
    divBtnGuardar = $('.divValueBtn1');
    divBtnCancelar = $('.divValueBtn2');
    msnConctM('¿Quieres enviar la solicitud de servicio nuevamente?');
    divBtnGuardar.html("<input id=\"aggBtn\" value=\"" + idsolicitud + "\" id=\"" + idsolicitud + "\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"soliciraeServicioGo(" + idsolicitud + ")\">");
    divBtnCancelar.html("<input id=\"btnValueId1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc2.png\" alt=\"Cancelar\" onclick=\"msnConctC()\">");
}
function cancelarProductoGo(id) {
    var idSolicitud = {};

    idSolicitud.solicitud = id;
    limpiarModal();
    $.ajax({
        url: 'navegadoCliente/cancelarProductos',
        data: idSolicitud,
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
function cancelarProductoAlqGo(id) {
    var idSolicitud = {};

    idSolicitud.solicitud = id;
    limpiarModal();
    $.ajax({
        url: 'navegadoCliente/cancelarAlqProductos',
        data: idSolicitud,
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
function cancelarProducto(id) {
    var idsolicitud = document.getElementById(id).value;
    limpiarModal();
    $('#msnContOp').show();
    cerrarNormal();
    divBtnGuardar = $('.divValueBtn1');
    divBtnCancelar = $('.divValueBtn2');
    msnConctM('¿Estas seguro de cancelar la solicitud del producto?');
    divBtnGuardar.html("<input id=\"aggBtn\" value=\"" + idsolicitud + "\" id=\"" + idsolicitud + "\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"cancelarProductoGo(" + idsolicitud + ")\">");
    divBtnCancelar.html("<input id=\"btnValueId1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc2.png\" alt=\"Cancelar\" onclick=\"msnConctC()\">");

}
function cancelarProductoAlquilado(id) {
    var idsolicitud = document.getElementById(id).value;
    limpiarModal();
    $('#msnContOp').show();
    cerrarNormal();
    divBtnGuardar = $('.divValueBtn1');
    divBtnCancelar = $('.divValueBtn2');
    msnConctM('¿Quieres cancelar la solicitud de alquiler?');
    divBtnGuardar.html("<input id=\"aggBtn\" value=\"" + idsolicitud + "\" id=\"" + idsolicitud + "\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"cancelarProductoAlqGo(" + idsolicitud + ")\">");
    divBtnCancelar.html("<input id=\"btnValueId1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc2.png\" alt=\"Cancelar\" onclick=\"msnConctC()\">");
}
function solicitarProductoGo(id) {
    var idSolicitud = {};
    limpiarModal();
    idSolicitud.solicitud = id;
    $.ajax({
        url: 'navegadoCliente/solicitarProducto',
        data: idSolicitud,
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
function solicitarProducto(id) {
    var idsolicitud = document.getElementById(id).value;
    limpiarModal();
    $('#msnContOp').show();
    cerrarNormal();
    divBtnGuardar = $('.divValueBtn1');
    divBtnCancelar = $('.divValueBtn2');
    msnConctM('¿Estas seguro de cancelar la solicitud del producto?');
    divBtnGuardar.html("<input id=\"aggBtn\" value=\"" + idsolicitud + "\" id=\"" + idsolicitud + "\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"solicitarProductoGo(" + idsolicitud + ")\">");
    divBtnCancelar.html("<input id=\"btnValueId1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc2.png\" alt=\"Cancelar\" onclick=\"msnConctC()\">");


}


function eliminarSeguimiento() {
    $('#archivosPerfil').show();
    $('#pedidosPerfil').show();
    $('#negociosPerfil').show();
    $('#archivosImagen').hide();
    $('#pedidosImagen').hide();
    $('#negocioImagen').hide();
    $('#pedidosMostrar').hide();
    $('#productosMostrar').hide();
    $('.perfilCliente').hide();
    $('#modificarCliente').hide();
    $('#informacionCliente').hide();
    $('#informacionCliente2').hide();
    $('#informacionCliente3').hide();
    $('#informacionCliente4').hide();
    $('#mostrarSeguimiento').hide();
    $('#descargarArchivos').hide();
    $('.negociosServicios').hide();
    $('.negociosProductos').hide();
    $('#perfilCliente').css('color', 'black');
    $('#solicitudesProcliente').css('color', 'black');
    $('#carritoCliente').css('color', 'black');
    $('#solicitudesSevcliente').css('color', 'black');
    $('#productosProcliente').css('color', 'black');
    $('#serviciosCliente').css('color', 'black');
}

function eliminarModificacion() {

    $('#modificarCliente').hide();
    $('#modificarCliente').hide();
    $('#modificarCliente2').hide();
    $('#modificarCliente3').hide();
    $('#modificarCliente4').hide();
    $('#eliminarPerfil').show();
    $('#modificarPerfil').show();
    $('#modificarPerfilatras').hide();
    $('#actualizarPerfil').hide();

}
function eliminarLetreros() {
    $('#rtaActualizar').hide();
    $('#alertRTA').hide();
}
function eliminarMiscompras() {
    $('.carritoCliente').hide();
    $('.productosAdquiridos').hide();
}

function eliminarCliente() {
    var confimar2 = confirm("Ten en cuenta que se borraran tus archivos y no podras solicitar nuestros servicios via internet");
    if (confimar2) {
        $.ajax({
            url: 'navegadoCliente/eliminar',
            data: {},
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
                alert('ERROR' + error);
            }

        });
    }

}

function datosPerfil(datos) {

    var info = $('.txtModificatUsu').val();
    if (datos == 1) {
        $('#nombre1').val(info);
    }
    if (datos == 2) {
        $('#usuario').val(info);
    }
    if (datos == 3) {
        $('#nombre2').val(info);
    }
    if (datos == 4) {
        $('#documentoNit').val(info);
    }
    if (datos == 5) {
        $('#apellido1').val(info);
    }
    if (datos == 6) {
        $('#apellido2').val(info);
    }
    if (datos == 7) {
        $('#direccion').val(info);
    }
    if (datos == 8) {
        $('#telefono1').val(info);
    }
    msnConctC();

}