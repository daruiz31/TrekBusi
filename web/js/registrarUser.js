var registroUsuarios = $('#registroCliente').on('click', function () {
    inputAlert = $('#inputAlert');
    divBtnGuardar = $('.divValueCont');
    var datosCliente = {};
    datosCliente.nombre1 = $('#txtnombre1').val();
    datosCliente.nombre2 = $('#txtnombre2').val();
    datosCliente.apellido1 = $('#txtapellido1').val();
    datosCliente.apellido2 = $('#txtapellido2').val();
    datosCliente.documento = $('#txtdocumento').val();
    datosCliente.contrasena = $('#txtcontra').val();
    datosCliente.correo = $('#txtcorreo').val();
    datosCliente.direccion = $('#txtdireccion').val();
    datosCliente.telefono = $('#txttelefono').val();
    datosCliente.pais = $('#paisSel').val();
    datosCliente.ciudad = $('#ciudadSel').val();
    datosCliente.vCorreo = $('#txtVcorreo').val();
    datosCliente.vContra = $('#txtVcontra').val();
    datosCliente.respuesta = $('#respuestaSegu').val();

    var minimoCaract = $('#txtcontra').val().length;


    var validacion = false;

    if (datosCliente.nombre1 == null || datosCliente.nombre1 == 0 || /^\s+$/.test(datosCliente.nombre1)) {
        msnConctM('Primer nombre.');
        inputAlert.html("<input placeholder=\"NOMBRE\" type=\"text\" class=\"alertInput\" onkeypress=\"return validar(event)\" />")
        divBtnGuardar.html("<input value=\"1\" id=\"btnValueId1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegCliente(this.id)\">");
        $('.alertInput').focus();
    } else {
        if (datosCliente.apellido1 == null || datosCliente.apellido1 == 0 || /^\s+$/.test(datosCliente.apellido1)) {
            msnConctM('Primer apellido.');
            inputAlert.html("<input placeholder=\"APELLIDO\" type=\"text\" class=\"alertInput\" onkeypress=\"return validar(event)\" />")
            divBtnGuardar.html("<input value=\"2\" id=\"btnValueId2\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegCliente(this.id)\">");
            $('.alertInput').focus();
        } else {
            if (datosCliente.documento == null || datosCliente.documento == 0 || /^\s+$/.test(datosCliente.documento)) {
                msnConctM('Ingresar documento.');
                inputAlert.html("<input placeholder=\"DOCUMENTO\" type=\"text\" class=\"alertInput\" onkeypress=\"ValidaSoloNumeros()\" />")
                divBtnGuardar.html("<input value=\"3\" id=\"btnValueId3\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegCliente(this.id)\">");
                $('.alertInput').focus();
            } else {
                if (datosCliente.contrasena == null || datosCliente.contrasena == 0 || /^\s+$/.test(datosCliente.contrasena)) {
                    msnConctM('Ingresar contraseña.');
                    inputAlert.html("<input placeholder=\"CONTRASEÑA\" type=\"password\" class=\"alertInput\" />")
                    divBtnGuardar.html("<input value=\"4\" id=\"btnValueId4\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegCliente(this.id)\">");
                    $('.alertInput').focus();
                } else {
                    if (datosCliente.contrasena != datosCliente.vContra) {


                        msgFinal('Las contraseñas no coinciden.');

                    } else {
                        if (minimoCaract < 8) {
                            msgFinal('Por seguridad tu contraseña debe tener mínimo 8 caracteres.');
                        } else {
                            if (datosCliente.correo == null || datosCliente.correo == 0 || /^\s+$/.test(datosCliente.correo)) {
                                msnConctM('Ingresar correo.');
                                inputAlert.html("<input placeholder=\"CORREO\" type=\"text\" class=\"alertInput\"  />")
                                divBtnGuardar.html("<input value=\"5\" id=\"btnValueId5\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegCliente(this.id)\">");
                                $('.alertInput').focus();
                            } else {
                                if (!/^[a-z-0-9\.\_\-]+@+[a-z]+\.+[a-z]/.test(datosCliente.correo)) {
                                    msnConctM('Correo incorrecto.');
                                    inputAlert.html("<input placeholder=\"ejemplo@gmail.com\" type=\"text\" class=\"alertInput\"  />")
                                    divBtnGuardar.html("<input value=\"11\" id=\"btnValueId11\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegCliente(this.id)\">");
                                    $('.alertInput').focus();
                                } else {

                                    if (datosCliente.correo != datosCliente.vCorreo) {

                                        validacion = false;
                                        msgFinal('Los correos no coinciden.');

                                    } else {
                                        if (datosCliente.direccion == null || datosCliente.direccion == 0 || /^\s+$/.test(datosCliente.direccion)) {
                                            msnConctM('Ingresar dirección.');
                                            inputAlert.html("<input placeholder=\"DIRECCIÓN\" type=\"text\" class=\"alertInput\"  />");
                                            divBtnGuardar.html("<input value=\"6\" id=\"btnValueId6\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegCliente(this.id)\">");
                                            $('.alertInput').focus();
                                        } else {
                                            if (datosCliente.telefono == null || datosCliente.telefono == 0 || /^\s+$/.test(datosCliente.telefono)) {
                                                msnConctM('Ingresar teléfono.');
                                                inputAlert.html("<input placeholder=\"TELÉFONO\" type=\"text\" class=\"alertInput\" onkeypress=\"ValidaSoloNumeros()\" />");
                                                divBtnGuardar.html("<input value=\"7\" id=\"btnValueId7\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegCliente(this.id)\">");
                                                $('.alertInput').focus();
                                            } else {
                                                if (datosCliente.pais == "Selecciona pais" || datosCliente.pais == 0 || /^\s+$/.test(datosCliente.pais)) {
                                                    msgFinal('Ingresar pais.');

                                                } else {
                                                    if (datosCliente.ciudad == null || datosCliente.ciudad == 0 || /^\s+$/.test(datosCliente.ciudad)) {

                                                        msgFinal('Ingresar ciudad.');


                                                    } else {
                                                        if (datosCliente.respuesta == null || datosCliente.respuesta == 0 || /^\s+$/.test(datosCliente.respuesta)) {
                                                            msnConctM('Ingresar respuesta.');
                                                            inputAlert.html("<input placeholder=\"RESPUESTA\" type=\"text\" class=\"alertInput\"  />")
                                                            divBtnGuardar.html("<input value=\"10\" id=\"btnValueId10\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegCliente(this.id)\">");
                                                            $('.alertInput').focus();

                                                        } else {
                                                            validacion = true;

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
        }
    }

    if (datosCliente.nombre2 == null || datosCliente.nombre2 == 0 || /^\s+$/.test(datosCliente.nombre2)) {

        datosCliente.nombre2 = "none";

    }
    if (datosCliente.apellido2 == null || datosCliente.apellido2 == 0 || /^\s+$/.test(datosCliente.apellido2)) {

        datosCliente.apellido2 = "none";

    }

    if (validacion == true) {

        $.ajax({
            url: 'registroCliente',
            data: datosCliente,
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                if (datos.codigo == 0) {
                    $('.msjFinalEstilo').css('background-color', '#9EC944');
                    msgFinal('Usuario creado con éxito, puede <a class=\"aLinkRegExito"\ onclick=\"exitoReg()\">iniciar sesión</a> cuando desee.');
                    document.getElementById('modlCerrar').style.display = 'none';



                }
                if (datos.codigo == -1) {
                    msgFinal('Error al registrar usuario, vuelva a intentarlo.');

                }
            },
            error: function (error) {

                console.log(error);
                alert('ERROR registrarUser' + error.responseText);
            }

        });
    }
});
function exitoReg() {
    window.location.href = 'index.html#/popup';

}
function alertRegCliente(id) {
    var opcion = document.getElementById(id).value;
    var dato = $('.alertInput').val();


    if (opcion == 1) {
        $('#txtnombre1').val(dato);
        $('#txtnombre1').focus();
    }
    if (opcion == 2) {
        $('#txtapellido1').val(dato);
        $('#txtapellido1').focus();
    }
    if (opcion == 3) {
        $('#txtdocumento').val(dato);
        $('#txtdocumento').focus();
    }
    if (opcion == 4) {
        $('#txtcontra').val(dato);
        $('#txtcontra').focus();
    }
    if (opcion == 5) {
        $('#txtcorreo').val(dato);
        $('#txtcorreo').focus();
    }
    if (opcion == 6) {
        $('#txtdireccion').val(dato);
        $('#txtdireccion').focus();
    }
    if (opcion == 7) {
        $('#txttelefono').val(dato);
        $('#txttelefono').focus();
    }
    if (opcion == 8) {
        $('#paisSel').val(dato);
        $('#paisSel').focus();
    }
    if (opcion == 9) {
        $('#ciudadSel').val(dato);
        $('#ciudadSel').focus();
    }
    if (opcion == 10) {
        $('#respuestaSegu').val(dato);
        $('#respuestaSegu').focus();
    }
    if (opcion == 11) {
        $('#txtcorreo').val(dato);
        $('#txtcorreo').focus();
    }
    msnConctC();
}

var registroClientes = $('#registroEmpresa').on('click', function () {
    inputAlert = $('#inputAlert');
    divBtnGuardar = $('.divValueCont');
    var datosCliente = {};
    datosCliente.nombre1 = $('#txtnombre1').val();
    datosCliente.nombre2 = $('#txtnombre2').val();
    datosCliente.apellido1 = $('#txtapellido1').val();
    datosCliente.documentoV = $('#txtRdocumento').val();
    datosCliente.documento = $('#txtdocumento').val();
    datosCliente.contrasena = $('#txtcontra').val();
    datosCliente.correo = $('#txtcorreo').val();
    datosCliente.direccion = $('#txtdireccion').val();
    datosCliente.telefono = $('#txttelefono').val();
    datosCliente.pais = $('#paisSel').val();
    datosCliente.ciudad = $('#ciudadSel').val();
    datosCliente.vCorreo = $('#txtVcorreo').val();
    datosCliente.vContra = $('#txtVcontra').val();
    datosCliente.respuesta = $('#respuestaSegu').val();

    var minimoCaract = $('#txtcontra').val().length;

    var validacion = false;
    var imgError1 = "<img src=\"imagenes/msn/error1.png\" id=\"imgError1\"/>";

    if (datosCliente.nombre1 == null || datosCliente.nombre1 == 0 || /^\s+$/.test(datosCliente.nombre1)) {

        msnConctM('Ingrese razón social');
        inputAlert.html("<input placeholder=\"NOMBRE\" type=\"text\" class=\"alertInput\" onkeypress=\"return validar(event)\" />");
        divBtnGuardar.html("<input value=\"1\" id=\"btnValueId1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegEmpresa(this.id)\">");
        $('.alertInput').focus();
    } else {
        if (datosCliente.nombre2 == null || datosCliente.nombre2 == 0 || /^\s+$/.test(datosCliente.nombre2)) {
            msnConctM('Ingrese su nombre');
            inputAlert.html("<input placeholder=\"NOMBRE\" type=\"text\" class=\"alertInput\" onkeypress=\"return validar(event)\" />");
            divBtnGuardar.html("<input value=\"2\" id=\"btnValueId2\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegEmpresa(this.id)\">");
            $('.alertInput').focus();
        } else {
            if (datosCliente.apellido1 == null || datosCliente.apellido1 == 0 || /^\s+$/.test(datosCliente.apellido1)) {
                msnConctM('Ingrese su apellido');
                inputAlert.html("<input placeholder=\"APELLIDO\" type=\"text\" class=\"alertInput\" onkeypress=\"return validar(event)\" />");
                divBtnGuardar.html("<input value=\"3\" id=\"btnValueId3\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegEmpresa(this.id)\">");
                $('.alertInput').focus();
            } else {
                if (datosCliente.documento == null || datosCliente.documento == 0 || /^\s+$/.test(datosCliente.documento)) {
                    msnConctM('Ingrese NIT empresarial');
                    inputAlert.html("<input placeholder=\"DOCUMENTO\" type=\"text\" class=\"alertInput\" onkeypress=\"ValidaSoloNumeros()\" />");
                    divBtnGuardar.html("<input value=\"4\" id=\"btnValueId4\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegEmpresa(this.id)\">");
                    $('.alertInput').focus();
                } else {
                    if (datosCliente.documento != datosCliente.documentoV) {
                        msgFinal('El NIT de la empresa no coincide en los campos del formulario.');
                    } else {
                        if (datosCliente.contrasena == null || datosCliente.contrasena == 0 || /^\s+$/.test(datosCliente.contrasena)) {
                            msnConctM('Ingrese una contraseña');
                            inputAlert.html("<input  placeholder=\"CONTRASEÑA\" type=\"password\" class=\"alertInput\"  />")
                            divBtnGuardar.html("<input value=\"5\" id=\"btnValueId5\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegEmpresa(this.id)\">");
                            $('.alertInput').focus();
                        } else {
                            if (minimoCaract < 8) {
                                msgFinal('Por seguridad tu contraseña debe tener mínimo 8 caracteres.');
                            } else {
                                if (datosCliente.contrasena != datosCliente.vContra) {
                                    msgFinal('Las contraseñas no coinciden.');

                                } else {
                                    if (datosCliente.correo == null || datosCliente.correo == 0 || /^\s+$/.test(datosCliente.correo)) {
                                        msnConctM('Ingrese su correo');
                                        inputAlert.html("<input placeholder=\"CORREO\" type=\"text\" class=\"alertInput\"  />");
                                        divBtnGuardar.html("<input value=\"6\" id=\"btnValueId6\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegEmpresa(this.id)\">");
                                        $('.alertInput').focus();
                                    } else {
                                        if (!/^[a-z-0-9\.\_\-]+@+[a-z]+\.+[a-z]/.test(datosCliente.correo)) {
                                            msnConctM('Un correo valido');
                                            inputAlert.html("<input placeholder=\"ejemplo@gmail.com\" type=\"text\" class=\"alertInput\"  />");
                                            divBtnGuardar.html("<input value=\"7\" id=\"btnValueId7\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegEmpresa(this.id)\">");
                                            $('.alertInput').focus();
                                        } else {

                                            if (datosCliente.correo != datosCliente.vCorreo) {
                                                msgFinal('Los correos no coinciden.');

                                            } else {
                                                if (datosCliente.direccion == null || datosCliente.direccion == 0 || /^\s+$/.test(datosCliente.direccion)) {
                                                    msnConctM('Ingrese una dirección');
                                                    inputAlert.html("<input placeholder=\"DIRECCIÓN\" type=\"text\" class=\"alertInput\" />");
                                                    divBtnGuardar.html("<input value=\"8\" id=\"btnValueId8\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegEmpresa(this.id)\">");
                                                    $('.alertInput').focus();
                                                } else {
                                                    if (datosCliente.telefono == null || datosCliente.telefono == 0 || /^\s+$/.test(datosCliente.telefono)) {
                                                        msnConctM('Ingresa un teléfono de contacto');
                                                        inputAlert.html("<input placeholder=\"TELÉFONO\" type=\"text\" class=\"alertInput\" onkeypress=\"ValidaSoloNumeros()\" />");
                                                        divBtnGuardar.html("<input value=\"9\" id=\"btnValueId9\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegEmpresa(this.id)\">");
                                                        $('.alertInput').focus();

                                                    } else {
                                                        if (datosCliente.pais == "Selecciona pais" || datosCliente.pais == 0 || /^\s+$/.test(datosCliente.pais)) {
                                                            msgFinal('Seleccione un pais.');
                                                        } else {
                                                            if (datosCliente.ciudad == null || datosCliente.ciudad == 0 || /^\s+$/.test(datosCliente.ciudad)) {
                                                                msgFinal('Seleccione una ciudad.');

                                                            } else {
                                                                if (datosCliente.respuesta == null || datosCliente.respuesta == 0 || /^\s+$/.test(datosCliente.respuesta)) {
                                                                    msnConctM('Respuesta seguridad');
                                                                    inputAlert.html("<input placeholder=\"Respuesta\" type=\"text\" class=\"alertInput\" />");
                                                                    divBtnGuardar.html("<input value=\"10\" id=\"btnValueId10\" class=\"btnValueCont\" type=image src=\"imagenes/msn/cursor.png\" alt=\"Guardar\" onclick=\"alertRegEmpresa(this.id)\">");
                                                                    $('.alertInput').focus();

                                                                } else {
                                                                    validacion = true;

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
                }
            }
        }
    }



    if (datosCliente.nombre2 == null || datosCliente.nombre2 == 0 || /^\s+$/.test(datosCliente.nombre2)) {

        datosCliente.nombre2 = "none";

    }
    if (datosCliente.apellido2 == null || datosCliente.apellido2 == 0 || /^\s+$/.test(datosCliente.apellido2)) {

        datosCliente.apellido2 = "none";

    }

    if (validacion == true) {

        $.ajax({
            url: 'registroEmpresa',
            data: datosCliente,
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                if (datos.codigo == 0) {
                    window.location.href = 'index.html#/popup';
                    alert("Usuario creado con exito, puedes iniciar sesion cuando desees. Gracias.");
                }
                if (datos.codigo == -1) {
                    alert("Error al registrar usuario, vuelva a intentarlo.");
                }
            },
            error: function (error) {

                console.log(error);
                alert('ERROR registrarUser' + error.responseText);
            }

        });
    }
});

function alertRegEmpresa(id) {
    var opcion = document.getElementById(id).value;
    var dato = $('.alertInput').val();



    if (opcion == 1) {
        $('#txtnombre1').val(dato);
    }
    if (opcion == 2) {
        $('#txtnombre2').val(dato);
    }
    if (opcion == 3) {
        $('#txtapellido1').val(dato);
    }
    if (opcion == 4) {
        $('#txtdocumento').val(dato);
    }
    if (opcion == 5) {
        $('#txtcontra').val(dato);
    }
    if (opcion == 6) {
        $('#txtcorreo').val(dato);
    }
    if (opcion == 7) {
        $('#txtcorreo').val(dato);
    }
    if (opcion == 8) {
        $('#txtdireccion'.val(dato));
    }
    if (opcion == 9) {
        $('#txttelefono').val(dato);
    }
    if (opcion == 10) {
        $('#respuestaSegu').val(dato);
    }

    msnConctC();
}