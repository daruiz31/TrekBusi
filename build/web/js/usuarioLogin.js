/* 
 *  Autor: Diego
 */

var vistaUsuarios = $('#btnIniciar').on('click', function () {

    var datosLogin = {};
    datosLogin.nombreUsuario = $('#correoLogin').val();
    var correo = $('#correoLogin').val();
    datosLogin.passwordUsuario = $('#passLogin').val();
    var rtaCorreo = $('#rtaLoginFC');
    var rtaPass = $('#rtaLoginFT');
    var cajaCorreo = $('#correoLogin');
    var cajaPass = $('#passLogin');
    var validar = false;
    if (datosLogin.nombreUsuario == null || datosLogin.nombreUsuario == 0 || /^\s+$/.test(datosLogin.nombreUsuario)) {
        rtaCorreo.html('Ingresa tu correo de contacto.');
        cajaCorreo.focus();
    } else {
        if (datosLogin.passwordUsuario == null || datosLogin.passwordUsuario == 0 || /^\s+$/.test(datosLogin.passwordUsuario)) {
            rtaPass.html('Ingresa tu contraseña.');
            cajaPass.focus();
        } else {
            if (/^[a-z-0-9\.\_\-]+@+[a-z]+\.+[a-z]/.test(correo)) {
                validar = true;
                rtaCorreo.html('');
            } else {
                rtaCorreo.html('Formato de correo incorrecto');
            }

        }
    }


    if (validar == true) {


        $.ajax({
            url: 'usuarios',
            data: datosLogin,
            type: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                if (datos.codigo == 0) {
                    if (datos.tipoUsuario == 1) {
                        window.location.href = 'nav-admin.jsp';
                    } else {
                        window.location.href = 'indexlog.jsp';
                    }
                } else {
                    msgFinal(datos.mensaje);
                }
            },
            error: function (error) {
                console.log(error);
                alert('ERROR DE AJAX');
            }
        });
    }
});



