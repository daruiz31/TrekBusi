/* 
 *  Autor: Diego RM
 */

var nuevaSesion = {
    iniciar: function () {
        $.ajax({
            url: 'sesionNueva',
            data: {},
            type: 'POST',
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                if (datos.codigo == 0) {
                    if (datos.estado != "Activo") {
                        alert("Tu cuenta de usuario ha sido desactivada. Si crees que es un error por favor contactate con nosotros. Gracias");
                        cerrarSesion.iniciar();
                        window.location.href = 'index.html';
                    } else {
                    }

                } else {
                    alert(datos.mensaje);
                    window.location.href = 'index.html';
                }

            },
        });

    },
}
var cerrarSesion = {
    iniciar: function () {
        $.ajax({
            url: 'cerrarSesion',
            data: {},
            type: 'POST',
            dataType: 'json',
            success: function (data) {
                console.log(data);
            }
        });
    },
}

