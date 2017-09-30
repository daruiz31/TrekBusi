/* 
 * Autor:       Diego RM
 */

function clickHere() {
    var informacion = {};


    validar = $('#validacionContacto');
    inputAlert = $('#inputAlert');
    divBtnGuardar = $('.divValueCont');
    var validacion = $('#validacionContacto').val();



    informacion.nombre = $('#contactoNombre').val();
    informacion.apellido = $('#contactoApellido').val();
    informacion.telefono = $('#contactoTelefono').val();
    informacion.asunto = $('#contactoAsunto').val();
    informacion.correo = $('#contactoCorreo').val();
    informacion.descripcion = $('#contactoDescripcion').val();


    if (informacion.nombre == null || informacion.nombre == 0 || /^\s+$/.test(informacion.nombre)) {
        msnConctM("Ingresa tu nombre");
        inputAlert.html("<input placeholder=\"NOMBRE\" type=\"text\" class=\"alertInput\" onkeypress=\"return validar(event)\" />")
        divBtnGuardar.html("<input value=\"1\" id=\"btnValueId1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"valuAlert(this.id)\">");
        $('.alertInput').focus();
    } else {
        if (informacion.apellido == null || informacion.apellido == 0 || /^\s+$/.test(informacion.apellido)) {
            msnConctM("Ingresa tu apellido");
            inputAlert.html("<input placeholder=\"APELLIDO\" type=\"text\" class=\"alertInput\" onkeypress=\"return validar(event)\" />")
            divBtnGuardar.html("<input value=\"2\" id=\"btnValueId2\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"valuAlert(this.id)\">");
            $('.alertInput').focus();
        } else {
            if (informacion.telefono == null || informacion.telefono == 0 || /^\s+$/.test(informacion.telefono)) {
                msnConctM("Ingresa tu teléfono");
                inputAlert.html("<input placeholder=\"TELEFONO\" type=\"text\" class=\"alertInput\" onkeypress=\"ValidaSoloNumeros()\" />")
                divBtnGuardar.html("<input value=\"3\" id=\"btnValueId3\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"valuAlert(this.id)\">");
                $('.alertInput').focus();
            } else {
                if (informacion.asunto == null || informacion.asunto == 0 || /^\s+$/.test(informacion.asunto)) {
                    msnConctM("¿Cual es el asunto?");
                    inputAlert.html("<input placeholder=\"ASUNTO\" type=\"text\" class=\"alertInput\" />")
                    divBtnGuardar.html("<input value=\"4\" id=\"btnValueId4\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"valuAlert(this.id)\">");
                    $('.alertInput').focus();
                } else {
                    if (informacion.correo == null || informacion.correo == 0 || /^\s+$/.test(informacion.correos)) {
                        msnConctM("Ingresa un correo");
                        inputAlert.html("<input placeholder=\"CORREO\" type=\"text\" class=\"alertInput\" />")
                        divBtnGuardar.html("<input value=\"5\" id=\"btnValueId5\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"valuAlert(this.id)\">");
                        $('.alertInput').focus();
                    } else {
                        if (!/^[a-z-0-9\.\_\-]+@+[a-z]+\.+[a-z]/.test(informacion.correo)) {
                            msnConctM("Correo incorrecto");
                            inputAlert.html("<input placeholder=\"ejemplo1@example.com\" type=\"text\" class=\"alertInput\" />")
                            divBtnGuardar.html("<input value=\"5\" id=\"btnValueId5\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"valuAlert(this.id)\">");
                            $('.alertInput').focus();
                        } else {
                            if (informacion.descripcion == null || informacion.descripcion == 0 || /^\s+$/.test(informacion.descripcion)) {
                                msnConctM("Ingresa descripción");
                                inputAlert.html("<input placeholder=\"Descripción\" type=\"text\" class=\"alertInput\" />")
                                divBtnGuardar.html("<input value=\"6\" id=\"btnValueId6\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"valuAlert(this.id)\">");
                                $('.alertInput').focus();
                            } else {
                                if (validacion == null || validacion == 0 || /^\s+$/.test(validacion)) {
                                    msnConctM("Cuanto es 1 + 1 ?");
                                    inputAlert.html("<input placeholder=\"1 + 1 = ?\" type=\"text\" class=\"alertInput\" onkeypress=\"ValidaSoloNumeros()\" />")
                                    divBtnGuardar.html("<input value=\"7\" id=\"btnValueId7\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"valuAlert(this.id)\">");
                                    $('.alertInput').focus();
                                } else {
                                    if (validacion != 2) {
                                        msnConctM("1 + 1 no es " + validacion);
                                        inputAlert.html("<input placeholder=\"1 + 1 = ?\" type=\"text\" class=\"alertInput\" onkeypress=\"ValidaSoloNumeros()\" />")
                                        divBtnGuardar.html("<input value=\"7\" id=\"btnValueId7\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"valuAlert(this.id)\">");
                                        $('.alertInput').focus();
                                    } else {
                                        $.ajax({
                                            url: 'contactoes',
                                            data: informacion,
                                            type: "POST",
                                            dataType: 'json',
                                            success: function (datos) {
                                                console.log(datos);
                                                if (datos.codigo == 0) {
                                                    $('.msjFinalEstilo').css('background-color', '#9EC944');
                                                } else {
                                                    $('.msjFinalEstilo').css('background-color', '#E91D1D');
                                                }
                                                msgFinal(datos.mensaje);
                                            },
                                            error: function (error) {
                                                console.log(error);
                                                alert('ERROR DE AJAX');
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

function valuAlert(id) {

    var opcion = document.getElementById(id).value;
    var dato = $('.alertInput').val();
    nombre = $('#contactoNombre');
    apellido = $('#contactoApellido');
    telefono = $('#contactoTelefono');
    asunto = $('#contactoAsunto');
    correo = $('#contactoCorreo');
    descripcion = $('#contactoDescripcion');
    validr = $('#validacionContacto');
    if (opcion == 1) {
        nombre.val(dato);
    }
    if (opcion == 2) {
        apellido.val(dato);
    }
    if (opcion == 3) {
        telefono.val(dato);
    }
    if (opcion == 4) {
        asunto.val(dato);
    }
    if (opcion == 5) {
        correo.val(dato);
    }
    if (opcion == 6) {
        descripcion.val(dato);
    }
    if (opcion == 7) {
        validr.val(dato);
    }
    msnConctC();
}