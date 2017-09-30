/* 
 *          Autor: Diego
 */

function imagenes() {
    var imagenes = new Array();
    var contador = 0;
    imagenes [0] = "imagenes/camsegu2.jpg";
    imagenes [1] = "imagenes/ups1.jpg";
    imagenes [2] = "imagenes/pc2.jpg";
    imagenes [3] = "imagenes/pc3.jpg";
    imagenes [4] = "imagenes/focop1.jpg";
    imagenes [5] = "imagenes/focop2.jpg";
    imagenes [6] = "imagenes/ups2.gif";

    setInterval(function () {
        var imagen = document.getElementById('miImagen');
        var actual = contador >= (imagenes.length - 1) ? 0 : contador + 1;
        imagen.src = imagenes[actual];
        contador = actual;
    }, 3000);
}

function accederServicios() {
    msgFinal('Primero inicia sesión.');
        


}
function mostrarContactenos(id) {      
    var boton = document.getElementById(id).value;   
    if (boton == 1) {
        $('#footerOcultoIndex').show();
        $('#contactanosmostrar').hide();
        $('#contactanosocultar').show();
    }else if(boton == 2){
        $('#footerOcultoIndex').hide();
        $('#contactanosmostrar').show();
        $('#contactanosocultar').hide();
    }else{
        alert('No esta capturando el value del botón');
    }
    

}
function solicitudDe(id){
    var boton = document.getElementById(id).value;
    
    if (boton == 1) {
        window.location.href = 'solicitarServicio.jsp';
    }else if(boton == 2){
        window.location.href = 'comprar-productos.jsp';
    }
}
function ValidaSoloNumeros() {
 if ((event.keyCode < 48) || (event.keyCode > 57)) 
  event.returnValue = false;
}
function validarSoloLetras() {
 if ((event.keyCode != 32) && (event.keyCode < 65) || (event.keyCode > 90) && (event.keyCode < 97) || (event.keyCode > 122))
  event.returnValue = false;
}