/* 
 *  Autor:      Diego RM
 */
function mostrarBaseDatos(id) {
    var opcion = id;
    limpiarTodo();
    if (opcion == 1) {

        $('#baseDatosInventario').show();
        $('#buscadorBaseDinventario').show();
        $.ajax({
            url: 'peticionesADMIN/inventario',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {

                console.log(datos);
                var nuevaFila;
                var boton1;
                var boton2;
                var tablaInventario = $('#inventarioBD');
                if (datos.codigo == 0) {

                    $.each(datos.datosResultado, function (i, items) {
                        var solicitud = items.idProducto;
                        boton1 = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"actualizarInventario(this.id)\">Actualizar</button>";
//                        boton2 = "<button id=\"" + solicitud + "\" value=\"" + solicitud + "\" class=\"btnsPerfil\" onclick=\"eliminarInventario(this.id)\">Eliminar</button>";
                        nuevaFila = $('<tr>');
                        var img = "<img id=\"imgsInventario\" src =" + items.foto + " />";
                        var TipoPro = $('<td>');
                        var Nombre = $('<td>');
                        var Marca = $('<td>');
                        var Referencia = $('<td>');
                        var Descripcion = $('<td id=\"descripcionInventario\">');
                        var ValorU = $('<td>');
                        var Capacidad = $('<td>');
                        var Estado = $('<td>');
                        var Imagen = $('<td>');
                        var opciones = $('<td>');
                        TipoPro.html(items.nombreTproducto);
                        Nombre.html(items.nombre);
                        Marca.html(items.marca);
                        Referencia.html(items.referencia);
                        Descripcion.html(items.descripcion);
                        ValorU.html(items.valorUnitario);
                        Capacidad.html(items.capacidad);
                        Estado.html(items.estado);
                        Imagen.html(img);
                        opciones.html(boton1);
                        nuevaFila.append(Imagen).append(TipoPro).append(Nombre).append(Marca).append(Referencia).append(Descripcion).append(ValorU).append(Capacidad).append(Estado).append(opciones);
                        tablaInventario.append(nuevaFila);
                    });
                    pInventario();
                }

            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error.responseText);
            }
        });
    } else if (opcion == 2) {
        $('#registroServicioADMIN').show();
        $('#buscadorBaseDservicios').show();
    } else if (opcion == 3) {
        $('#registroProductoADMIN').show();
        $('#buscadorBaseDproductos').show();
    } else if (opcion == 4) {
        $('#baseDatosActualizarProductos').show();
        $('#buscadorBaseDAproductos').show();
    } else if (opcion == 5) {
        $('#baseDatosActualizarServicios').show();
        $('#buscadorBaseDAservicios').show();
    } else if (opcion == 6) {
        $('#baseDatosSubirDocumentos').show();
        $('#buscadorBaseDdoc').show();
    } else if (opcion == 7) {
        $('#eliminarRegistros').show();
    }
}

function actualizarInventario(id) {
    var producto = {}
    producto.idProducto = document.getElementById(id).value;
    modalInventario();

    $.ajax({
        url: 'peticionesADMIN/inventarioActMostrar',
        data: producto,
        method: "POST",
        dataType: 'json',
        success: function (datos) {

            console.log(datos);
            if (datos.codigo == 0) {
                $.each(datos.datosResultado, function (i, items) {
                    $('#nombreInventario').val(items.nombre);
//                    $('#tipoProductoADMIN').val(items.nombreTproducto);
                    $('#marcaInventario').val(items.marca);
                    $('#referenciaInventario').val(items.referencia);
                    $('#descripcionInventario').val(items.descripcion);
                    $('#valorUInventario').val(items.valorUnitario);
                    $('#capacidadInventario').val(items.capacidad);
                    $('#posicionBtnInvt').html("<button class=\"actInvtBtn\" onclick=\"actualizarIvtF(" + items.idProducto + "," + items.idTipoPro + ")\" >Actualizar</button> ");
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
function actualizarIvtF(id, idTipoPro) {
    
    var infoProducto = {};
    infoProducto.idProducto = id;

    infoProducto.nombreProducto = $('#nombreInventario').val();
    infoProducto.tipoProducto = idTipoPro;
    infoProducto.estado = $('#estadoProducto').val();
    
    infoProducto.marca = $('#marcaInventario').val();
    infoProducto.referencia = $('#referenciaInventario').val();
    infoProducto.descripcion = $('#descripcionInventario').val();
    infoProducto.valorU = $('#valorUInventario').val();
    infoProducto.capacidad = $('#capacidadInventario').val();

    if (infoProducto.nombreProducto == null || infoProducto.nombreProducto == 0 || /^\s+$/.test(infoProducto.nombreProducto)) {
        msgFinal("Falta el  nombre del producto");
        cerrarNormal();
    } else {
        if (infoProducto.tipoProducto == null || infoProducto.tipoProducto == 0 || /^\s+$/.test(infoProducto.tipoProducto) || infoProducto.tipoProducto == "Tipo producto") {
            msgFinal("Falta tipo producto");
            cerrarNormal();
        } else {
            if (infoProducto.estado == null || infoProducto.estado == 0 || /^\s+$/.test(infoProducto.estado)) {
                msgFinal("Falta estado del producto");
                cerrarNormal();
            } else {
                if (infoProducto.marca == null || infoProducto.marca == 0 || /^\s+$/.test(infoProducto.marca)) {
                    msgFinal("Falta marca del producto");
                    cerrarNormal();
                } else {
                    if (infoProducto.referencia == null || infoProducto.referencia == 0 || /^\s+$/.test(infoProducto.referencia)) {
                        msgFinal("Falta referencia del producto");
                        cerrarNormal();
                    } else {
                        if (infoProducto.descripcion == null || infoProducto.descripcion == 0 || /^\s+$/.test(infoProducto.descripcion)) {
                            msgFinal("Falta descripción del producto");
                            cerrarNormal();
                        } else {
                            if (infoProducto.valorU == null || infoProducto.valorU == 0 || /^\s+$/.test(infoProducto.valorU)) {
                                msgFinal("Falta precio del producto");
                                cerrarNormal();
                            } else {
                                if (infoProducto.capacidad == null || infoProducto.capacidad == 0 || /^\s+$/.test(infoProducto.capacidad)) {
                                    msgFinal("Falta capacidad del producto");
                                    cerrarNormal();
                                } else {
                                    $.ajax({
                                        url: 'peticionesADMIN/inventarioActualizar',
                                        data: infoProducto,
                                        method: "POST",
                                        dataType: 'json',
                                        success: function (datos) {
                                            console.log(datos);
                                            limpiarModal();
                                            if (datos.codigo != 0) {
                                                $('.msjFinalEstilo').css('background-color', '#E91D1D');

                                            } else {
                                                $('.msjFinalEstilo').css('background-color', '#9EC944');
                                                document.getElementById('moodalInventario').style.display = 'none';
                                                document.getElementById('fade').style.display = 'none';
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
                            }
                        }
                    }
                }
            }
        }
    }
}