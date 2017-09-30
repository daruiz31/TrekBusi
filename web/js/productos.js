/* 
 *      Autor: Diego
 */
limite = 0;
contador = 0;

var listarProductos = {
    
    contN: new Array(),
    contValorU: new Array(),
    contProcod: new Array(),
    contTipoPro: new Array(),
    contDescripcion: new Array(),
    contReferencia: new Array(),
    contMarca: new Array(),
    contCapacidad: new Array(),
    contEstado: new Array(),
    contImg: new Array(),
    idProducto: new Array(),
    iniciar: function (contadorLimite) {
        limpiarDisplay()
        var isecuD = new Array($('#secuD1'), $('#secuD2'), $('#secuD3'), $('#secuD4'), $('#secuD5'), $('#secuD6'), $('#secuD7'), $('#secuD8'), $('#secuD9'));
        var imgPosi = new Array($('#imgPro1'), $('#imgPro2'), $('#imgPro3'), $('#imgPro4'), $('#imgPro5'), $('#imgPro6'), $('#imgPro7'), $('#imgPro8'), $('#imgPro9'));
        var nombrePosi = new Array($('#nombrePro1'), $('#nombrePro2'), $('#nombrePro3'), $('#nombrePro4'), $('#nombrePro5'), $('#nombrePro6'), $('#nombrePro7'), $('#nombrePro8'), $('#nombrePro9'));
        var precioPosi = new Array($('#precioU1'), $('#precioU2'), $('#precioU3'), $('#precioU4'), $('#precioU5'), $('#precioU6'), $('#precioU7'), $('#precioU8'), $('#precioU9'));
        var display = new Array($('#agregado1'), $('#agregado2'), $('#agregado3'), $('#agregado4'), $('#agregado5'), $('#agregado6'), $('#agregado7'), $('#agregado8'), $('#agregado9'));
        var contadorPOST = {};
        contadorPOST.contar = contadorLimite;
        $.ajax({
            url: 'productos',
            data: contadorPOST,
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);
                $.each(datos, function (i, nomArr) {
                    if (nomArr.estado != "No Disponible") {
                        display[i].show();
                        listarProductos.contN[i] = nomArr.nombre;
                        listarProductos.contValorU[i] = nomArr.valorUnitario;
                        listarProductos.contProcod[i] = nomArr.idProducto;
                        listarProductos.contTipoPro[i] = nomArr.nombreTproducto;
                        listarProductos.contDescripcion[i] = nomArr.descripcion;
                        listarProductos.contReferencia[i] = nomArr.referencia;
                        listarProductos.contMarca[i] = nomArr.marca;
                        listarProductos.contCapacidad[i] = nomArr.capacidad;
                        listarProductos.contEstado[i] = nomArr.estado;
                        listarProductos.contImg[i] = nomArr.foto;
                        listarProductos.idProducto[i] = nomArr.idProducto;

                        nombrePosi[i].html(nomArr.nombre);
                        precioPosi[i].html(nomArr.valorUnitario);
                        imgPosi[i].attr('src', nomArr.foto);
                        isecuD[i].html(nomArr.idProducto);
                    }

                });



            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error);
            }
        });
    },
}

function agregarCarrito(id) {
    var itemNumero = document.getElementById(id).value;

    divBtnGuardar = $('.divValueBtn1');
    divBtnCancelar = $('.divValueBtn2');
    msnConctM('¿Deseas agregar este producto al carrito?');
    divBtnGuardar.html("<input value=\"" + itemNumero + "\" id=\"aggBtn" + itemNumero + "\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"aggCarrAdd(this.id)\">");
    divBtnCancelar.html("<input value=\"1\" id=\"btnValueId1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc2.png\" alt=\"Guardar\" onclick=\"msnConctC()\">");

}

function aggCarrAdd(id) {
    cerrarModal2();
    var itemNumero = document.getElementById(id).value;
    var totalAgregadoPosi = $('#totalAgregado');
    var ttAdd = document.getElementById('totalAgregado').innerHTML;
    var resultado;
    var num;
    var iSeguD;
    if (itemNumero == 1) {
        var precio = document.getElementById('precioU1').innerHTML;
        iSeguD = document.getElementById('secuD1').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar + precioInt);
        num = 1;
    }
    if (itemNumero == 2) {
        var precio = document.getElementById('precioU2').innerHTML;
        iSeguD = document.getElementById('secuD2').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar + precioInt);
        num = 2;
    }
    if (itemNumero == 3) {
        var precio = document.getElementById('precioU3').innerHTML;
        iSeguD = document.getElementById('secuD3').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar + precioInt);
        num = 3;
    }
    if (itemNumero == 4) {
        var precio = document.getElementById('precioU4').innerHTML;
        iSeguD = document.getElementById('secuD4').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar + precioInt);
        num = 4;
    }
    if (itemNumero == 5) {
        var precio = document.getElementById('precioU5').innerHTML;
        iSeguD = document.getElementById('secuD5').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar + precioInt);
        num = 5;
    }
    if (itemNumero == 6) {
        var precio = document.getElementById('precioU6').innerHTML;
        iSeguD = document.getElementById('secuD6').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar + precioInt);
        num = 6;
    }
    if (itemNumero == 7) {
        var precio = document.getElementById('precioU7').innerHTML;
        iSeguD = document.getElementById('secuD7').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar + precioInt);
        num = 7;
    }
    if (itemNumero == 8) {
        var precio = document.getElementById('precioU8').innerHTML;
        iSeguD = document.getElementById('secuD8').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar + precioInt);
        num = 8;
    }
    if (itemNumero == 9) {
        var precio = document.getElementById('precioU9').innerHTML;
        iSeguD = document.getElementById('secuD9').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar + precioInt);
        num = 9;
    }

    totalAgregadoPosi.html(resultado);
    itemsAgregados(iSeguD, num);

}

function itemsAgregados(id, itemNum) {

    var informacion = {};
    informacion.iSeguD = id;
    informacion.numItem = itemNum;
    $.ajax({
        url: 'comprarProductos/comprar',
        dataType: 'json',
        method: 'POST',
        data: informacion,
        success: function (datos) {
            console.log(datos);
            msnConctC();

            if (datos.codigo != 0) {
                $('.msjFinalEstilo').css('background-color', '#E91D1D');

            } else {
                $('.msjFinalEstilo').css('background-color', '#9EC944');

            }
            msgFinal(datos.mensaje + " <a id=\"linkSolicitaYa\" href=\"solicitar-productos.jsp\">Solicitalo aquí</a>");
        }
    });
}


function siguienteProducto(id) {
    var opcion = document.getElementById(id).value;
    var contador = 0;
    var isecuD = new Array($('#secuD1'), $('#secuD2'), $('#secuD3'), $('#secuD4'), $('#secuD5'), $('#secuD6'), $('#secuD7'), $('#secuD8'), $('#secuD9'));
    var imgPosi = new Array($('#imgPro1'), $('#imgPro2'), $('#imgPro3'), $('#imgPro4'), $('#imgPro5'), $('#imgPro6'), $('#imgPro7'), $('#imgPro8'), $('#imgPro9'));
    var nombrePosi = new Array($('#nombrePro1'), $('#nombrePro2'), $('#nombrePro3'), $('#nombrePro4'), $('#nombrePro5'), $('#nombrePro6'), $('#nombrePro7'), $('#nombrePro8'), $('#nombrePro9'));
    var precioPosi = new Array($('#precioU1'), $('#precioU2'), $('#precioU3'), $('#precioU4'), $('#precioU5'), $('#precioU6'), $('#precioU7'), $('#precioU8'), $('#precioU9'));
    for (var i = 0; i < 9; i++) {
        imgPosi[i].removeAttr("src");
        nombrePosi[i].html("");
        precioPosi[i].html("");
        isecuD[i].html("");
    }
    if (opcion == 1) {
        limpiarDisplay()
        $('#produc-Siguiente2').show();
        $('#produc-Atras2').show();
        $('#produc-Siguiente').hide();
        $('#produc-Atras').hide();
        contador = 9;
    }

    if (opcion == 2) {
        limpiarDisplay()
        contador = 18;
    }
    listarProductos.iniciar(contador);

}
function atrasProducto(id) {
    var opcion = document.getElementById(id).value;
    var isecuD = new Array($('#secuD1'), $('#secuD2'), $('#secuD3'), $('#secuD4'), $('#secuD5'), $('#secuD6'), $('#secuD7'), $('#secuD8'), $('#secuD9'));
    var imgPosi = new Array($('#imgPro1'), $('#imgPro2'), $('#imgPro3'), $('#imgPro4'), $('#imgPro5'), $('#imgPro6'), $('#imgPro7'), $('#imgPro8'), $('#imgPro9'));
    var nombrePosi = new Array($('#nombrePro1'), $('#nombrePro2'), $('#nombrePro3'), $('#nombrePro4'), $('#nombrePro5'), $('#nombrePro6'), $('#nombrePro7'), $('#nombrePro8'), $('#nombrePro9'));
    var precioPosi = new Array($('#precioU1'), $('#precioU2'), $('#precioU3'), $('#precioU4'), $('#precioU5'), $('#precioU6'), $('#precioU7'), $('#precioU8'), $('#precioU9'));
    for (var i = 0; i < 9; i++) {
        imgPosi[i].removeAttr("src");
        nombrePosi[i].html("");
        precioPosi[i].html("");
        isecuD[i].html("");
    }
    var contador = 0;
    if (opcion == 1) {
        contador = 0;
    }
    if (opcion == 2) {
        contador = 9;
        $('#produc-Siguiente2').hide();
        $('#produc-Atras2').hide();
        $('#produc-Siguiente').show();
        $('#produc-Atras').show();
        limpiarDisplay()
    }

    listarProductos.iniciar(contador);

}

function fichaTecnica(id) {
    var toProductoPosi = $('#rta-tiProduc');
    var marcaPosi = $('#rta-marca');
    var referenciaPosi = $('#rta-referencia');
    var capacidadPosi = $('#rta-capacidad');
    var descripcionPosi = $('#rta-descripcion');
    var estadoPosi = $('#rta-estado');
    var boton = document.getElementById(id).value;


    if (boton == 1) {
        toProductoPosi.html(listarProductos.contTipoPro[0]);
        marcaPosi.html(listarProductos.contMarca[0]);
        referenciaPosi.html(listarProductos.contReferencia[0]);
        capacidadPosi.html(listarProductos.contCapacidad[0]);
        descripcionPosi.html(listarProductos.contDescripcion[0]);
        estadoPosi.html(listarProductos.contEstado[0]);
    }
    if (boton == 2) {
        toProductoPosi.html(listarProductos.contTipoPro[1]);
        marcaPosi.html(listarProductos.contMarca[1]);
        referenciaPosi.html(listarProductos.contReferencia[1]);
        capacidadPosi.html(listarProductos.contCapacidad[1]);
        descripcionPosi.html(listarProductos.contDescripcion[1]);
        estadoPosi.html(listarProductos.contEstado[1]);
    }
    if (boton == 3) {
        toProductoPosi.html(listarProductos.contTipoPro[2]);
        marcaPosi.html(listarProductos.contMarca[2]);
        referenciaPosi.html(listarProductos.contReferencia[2]);
        capacidadPosi.html(listarProductos.contCapacidad[2]);
        descripcionPosi.html(listarProductos.contDescripcion[2]);
        estadoPosi.html(listarProductos.contEstado[2]);
    }
    if (boton == 4) {
        toProductoPosi.html(listarProductos.contTipoPro[3]);
        marcaPosi.html(listarProductos.contMarca[3]);
        referenciaPosi.html(listarProductos.contReferencia[3]);
        capacidadPosi.html(listarProductos.contCapacidad[3]);
        descripcionPosi.html(listarProductos.contDescripcion[3]);
        estadoPosi.html(listarProductos.contEstado[3]);
    }
    if (boton == 5) {
        toProductoPosi.html(listarProductos.contTipoPro[4]);
        marcaPosi.html(listarProductos.contMarca[4]);
        referenciaPosi.html(listarProductos.contReferencia[4]);
        capacidadPosi.html(listarProductos.contCapacidad[4]);
        descripcionPosi.html(listarProductos.contDescripcion[4]);
        estadoPosi.html(listarProductos.contEstado[4]);
    }
    if (boton == 6) {
        toProductoPosi.html(listarProductos.contTipoPro[5]);
        marcaPosi.html(listarProductos.contMarca[5]);
        referenciaPosi.html(listarProductos.contReferencia[5]);
        capacidadPosi.html(listarProductos.contCapacidad[5]);
        descripcionPosi.html(listarProductos.contDescripcion[5]);
        estadoPosi.html(listarProductos.contEstado[5]);
    }
    if (boton == 7) {
        toProductoPosi.html(listarProductos.contTipoPro[6]);
        marcaPosi.html(listarProductos.contMarca[6]);
        referenciaPosi.html(listarProductos.contReferencia[6]);
        capacidadPosi.html(listarProductos.contCapacidad[6]);
        descripcionPosi.html(listarProductos.contDescripcion[6]);
        estadoPosi.html(listarProductos.contEstado[6]);
    }
    if (boton == 8) {
        toProductoPosi.html(listarProductos.contTipoPro[7]);
        marcaPosi.html(listarProductos.contMarca[7]);
        referenciaPosi.html(listarProductos.contReferencia[7]);
        capacidadPosi.html(listarProductos.contCapacidad[7]);
        descripcionPosi.html(listarProductos.contDescripcion[7]);
        estadoPosi.html(listarProductos.contEstado[7]);
    }
    if (boton == 9) {
        toProductoPosi.html(listarProductos.contTipoPro[8]);
        marcaPosi.html(listarProductos.contMarca[8]);
        referenciaPosi.html(listarProductos.contReferencia[8]);
        capacidadPosi.html(listarProductos.contCapacidad[8]);
        descripcionPosi.html(listarProductos.contDescripcion[8]);
        estadoPosi.html(listarProductos.contEstado[8]);
    }
}
function limpiarDisplay() {
    var display = new Array($('#agregado1'), $('#agregado2'), $('#agregado3'), $('#agregado4'), $('#agregado5'), $('#agregado6'), $('#agregado7'), $('#agregado8'), $('#agregado9'));
    for (var i = 0; i < 9; i++) {
        display[i].hide();
    }
}