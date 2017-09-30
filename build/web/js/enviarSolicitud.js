/*
 * Autor: Diego
 * 
 */

var registrarSolicitud = $('#enviarSolicitud').on('click', function () {
    inputAlert = $('#inputAlert');
    divBtnGuardar = $('.divValueCont');
    var datosSolicitud = {};
    datosSolicitud.tiposServicio = $('#tiposServicios').val();
    datosSolicitud.descripcionTip = $('#descripcion-tipo').val();
    datosSolicitud.fechaFin = $('#fechaSolicitud').val();
    datosSolicitud.presupuesto = $('#presupuestoMin').val();
    datosSolicitud.descripcionBreve = $('#descripcionD').val();
    var terminos = $('#aceptoTC');

    var tiposServicio = $('#tiposServicios');
    var fechaFin = $('#datepicker');
    var presupuesto = $('#presupuestoMin');
    var validar = false;
    if (datosSolicitud.tiposServicio == null || datosSolicitud.tiposServicio == 0 || /^\s+$/.test(datosSolicitud.tiposServicio) || datosSolicitud.tiposServicio == 'Seleccione producto') {
        msgFinal('Elige tipo de servicio.');
    } else {
        if (datosSolicitud.fechaFin == null || datosSolicitud.fechaFin == 0 || /^\s+$/.test(datosSolicitud.fechaFin)) {
            msgFinal('Elige fecha para el servicio.');
        } else {
            if (datosSolicitud.presupuesto == null || datosSolicitud.presupuesto == 0 || /^\s+$/.test(datosSolicitud.presupuesto)) {
                msnConctM('Ingresar presupuesto.');
                inputAlert.html("<input placeholder=\"PRESUPUESTO\" type=\"text\" class=\"alertInput\" onkeypress=\"ValidaSoloNumeros()\"  />")
                divBtnGuardar.html("<input value=\"1\" id=\"btnEnvia1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertSoliServicio()\">");
                $('.alertInput').focus();
            } else {
                if ($('input[name="aceptar-cond"]').is(':checked')) {
                    validar = true;
                } else {
                    msgFinal('Debes aceptar terminos y condiciones.');
                }
            }
        }
    }

    if (validar == true) {


        $.ajax({
            url: 'solicitarServicio',
            data: datosSolicitud,
            method: 'POST',
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                if (datos.codigo != 0) {
                    $('.msjFinalEstilo').css('background-color', '#E91D1D');
                } else {
                    $('.msjFinalEstilo').css('background-color', '#9EC944');

                }
                msgFinal(datos.mensaje);

            },
            error: function (error) {
                console.log(error);
                alert('ERROR enviar SOLICITUD' + error.responseText);
            }
        });
    }
});

function alertSoliServicio() {



    var dato = $('.alertInput').val();
    ;
    $('#presupuestoMin').val(dato);
    msnConctC();
}

