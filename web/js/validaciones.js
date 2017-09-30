var validarContra = $('#txtcorreo').on('click', function () {
    var contra = $('#txtcontra').val();
    var vContra = $('#txtVcontra').val();
    var rta = $('#validacionClie');
    var rtaV = $('#validacionClie2');
    var caja1 = $('#txtVcontra');
    var boton = $('#registroCliente');


    if (contra != vContra) {
        rta.html('Las contraseñas no coinciden');
        caja1.focus();
        boton.attr("disabled", true);

    }
    if (contra == vContra) {
        rtaV.html('Las contraseñas coinciden');
        rta.html('');
        boton.attr("disabled", false);      
        
    }


});

var validarCorreo = $('#txtdireccion').on('click', function () {
    var rtaV = $('#validacionClie2');
    var correo = $('#txtcorreo').val();
    var vCorreo = $('#txtVcorreo').val();
    var rta = $('#validacionClie');
    var caja1 = $('#txtVcorreo');
    var boton = $('#registroCliente');

    if (correo != vCorreo) {
        rta.html('Los correos no coinciden.');
        caja1.focus();
        boton.attr("disabled", true);
    }
    if (correo == vCorreo) {
        rtaV.html('Los correos coinciden.');
        rta.html('');
        boton.attr("disabled", false);
    }


});

function validar(e) {
tecla = (document.all) ? e.keyCode : e.which;
if (tecla==8) return true;
patron =/[A-Za-z\s]/;
te = String.fromCharCode(tecla);
return patron.test(te);
}

function descripcionPregu(){
    var rta = $('#infoRt');
    rta.html('Ingresa una respuesta de seguridad sobre la pregunta que quieras, esto se usa simplemente como un parametro de seguridad. Gracias...');
}

function activarBoton(){
    var boton = $('#registroCliente');
    boton.attr("disabled", false);     
    
}




