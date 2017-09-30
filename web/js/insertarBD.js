/* 
 *      Autor: Diego RM
 */

function registrarProductos() {


    var datosProducto = {};
    datosProducto.tipoProducto = $("#tipoProductoADMIN").val();
    datosProducto.estado = $("#estadoProducto").val();
    datosProducto.nombre = $("#nombreProductoFIN").val();
    var nombre = $("#nombreProductoFIN").val();
    datosProducto.referencia = $('#referenciaProducto').val();
    datosProducto.marca = $('#marcaProducto').val();
    datosProducto.valorU = parseFloat($('#valorUproducto').val());
    datosProducto.capacidad = $('#capacidadProducto').val();
    datosProducto.cantidad = $('#cantidadProducto').val();
    datosProducto.descripcion = $('#descripcionProducto').val();
    var confimar = confirm("¿Quieres agregar " + nombre + " a la lista de tus productos?");

    if (confimar) {
        $.ajax({
            url: 'registrarProductos',
            data: datosProducto,
            method: 'POST',
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                if (datos.codigo == 0) {
                    alert(datos.mensaje);
                    window.location.href = 'nav-admin.jsp';
                } else {
                    alert(datos.mensaje);
                }

            },
            error: function (error) {
                console.log(error);
                alert('ERROR enviar inserción AJAX' + error.responseText);
            }
        });
    }


}

function registrarServicio() {
    limpiarModal();

    var datosServicio = {};
    datosServicio.nombre = $('#nombreServicio1').val();
    datosServicio.descripcion = $('#descripcionServicio1').val();
    var confirmar = false;
    if (datosServicio.nombre == null || datosServicio.nombre == 0 || /^\s+$/.test(datosServicio.nombre)) {
        msgFinal("Falta nombre del servicio");
        cerrarNormal();
    } else {
        if (datosServicio.descripcion == null || datosServicio.descripcion == 0 || /^\s+$/.test(datosServicio.descripcion)) {
            msgFinal("Falta descripción del servicio");
            cerrarNormal();
        } else {
            $.ajax({
                url: 'peticionesADMIN/agregarServicioAdm',
                data: datosServicio,
                method: 'POST',
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
                    alert('ERROR enviar inserción AJAX' + error.responseText);
                }
            });
        }
    }
}

