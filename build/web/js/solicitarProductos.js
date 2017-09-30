/* 
 * Autor: Diego RM
 */

var listarAgregados = {
    iniciar: function () {
        $.ajax({
            url: 'comprarProductos/listar',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);


                var isecuD = new Array($('#secuD1'), $('#secuD2'), $('#secuD3'), $('#secuD4'), $('#secuD5'), $('#secuD6'), $('#secuD7'), $('#secuD8'), $('#secuD9'));
                var imgPosi = new Array($('#imgPro1'), $('#imgPro2'), $('#imgPro3'), $('#imgPro4'), $('#imgPro5'), $('#imgPro6'), $('#imgPro7'), $('#imgPro8'), $('#imgPro9'));
                var nombrePosi = new Array($('#nombrePro1'), $('#nombrePro2'), $('#nombrePro3'), $('#nombrePro4'), $('#nombrePro5'), $('#nombrePro6'), $('#nombrePro7'), $('#nombrePro8'), $('#nombrePro9'));
                var precioPosi = new Array($('#precioU1'), $('#precioU2'), $('#precioU3'), $('#precioU4'), $('#precioU5'), $('#precioU6'), $('#precioU7'), $('#precioU8'), $('#precioU9'));
                var display = new Array($('#agregado1'), $('#agregado2'), $('#agregado3'), $('#agregado4'), $('#agregado5'), $('#agregado6'), $('#agregado7'), $('#agregado8'), $('#agregado9'));
                var toProductoPosi = $('#rta-tiProduc');
                var marcaPosi = $('#rta-marca');
                var referenciaPosi = $('#rta-referencia');
                var capacidadPosi = $('#rta-capacidad');
                var descripcionPosi = $('#rta-descripcion');
                var estadoPosi = $('#rta-estado');
                var contN = new Array();
                var contValorU = new Array();
                var contProcod = new Array();
                var contTipoPro = new Array();
                var contDescripcion = new Array();
                var contReferencia = new Array();
                var contMarca = new Array();
                var contCapacidad = new Array();
                var contEstado = new Array();
                var contadorGlobal = 9;
                var countArray = 0;
                var contImg = new Array();
                var idProducto = new Array();
                var total = 0;
                var posiTotal = $('#totalAgregado');

                $.each(datos, function (i, nomArr) {
                    display[i].show();
                    contN[i] = nomArr.nombre;
                    contValorU[i] = nomArr.valorUnitario;
                    contProcod[i] = nomArr.idProducto;
                    contTipoPro[i] = nomArr.nombreTproducto;
                    contDescripcion[i] = nomArr.descripcion;
                    contReferencia[i] = nomArr.referencia;
                    contMarca[i] = nomArr.marca;
                    contCapacidad[i] = nomArr.capacidad;
                    contEstado[i] = nomArr.estado;
                    contImg[i] = nomArr.foto;
                    idProducto[i] = nomArr.idProducto;
                    if (i <= contadorGlobal) {
                        nombrePosi[i].html(contN[(countArray)]);
                        precioPosi[i].html(contValorU[(countArray)]);
                        nombrePosi[i].val(contProcod[(countArray)]);
                        imgPosi[i].attr('src', contImg[countArray]);
                        imgPosi[i] = nomArr.foto;
                        countArray++;
                        isecuD[i].html(idProducto[i]);
                        total += contValorU[i];
                    }

                });
                posiTotal.html(total);



            },
            error: function (error) {
                console.log(error);
                alert('ERROR' + error.responseText);

            }
        });
    },
}

function comprarFinal() {
    limpiarModal();
    var ttAdd = {};
    ttAdd.total = document.getElementById('totalAgregado').innerHTML;
    $.ajax({
        url: 'comprarProductos/insertar',
        method: "POST",
        dataType: 'json',
        data: ttAdd,
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
        }
    });

}


function alquilarFinal() {   
    
    var ttAdd2 = {};
    ttAdd2.total = document.getElementById('totalAgregado').innerHTML;
    ttAdd2.fechaInicio = $('#fechaSolicitud1').val();
    ttAdd2.fechaFin = $('#fechaSolicitud2').val();
    $('#fichaTecPOPUD').hide();
    $('#alquilarDatos').show();
    var validar = false;
    if (ttAdd2.fechaInicio == null || ttAdd2.fechaInicio == 0 || /^\s+$/.test(ttAdd2.fechaInicio) || ttAdd2.fechaInicio == 'mm/dd/aaaa') {
        $('#fechaRespuestAlquiler').html('Elige la fecha inicial del alquiler.');
        $('#fechaSolicitud1').focus();
    } else {
        if (ttAdd2.fechaFin == null || ttAdd2.fechaFin == 0 || /^\s+$/.test(ttAdd2.fechaFin) || ttAdd2.fechaFin == 'mm/dd/aaaa') {
        $('#fechaRespuestAlquiler').html('Elige la fecha final del alquiler.');
            $('#fechaSolicitud2').focus();

        } else {
            $.ajax({
                url: 'comprarProductos/alquilar',
                method: "POST",
                dataType: 'json',
                data: ttAdd2,
                success: function (datos) {
                    modalAlquilerH();
                    console.log(datos);
                    if (datos.codigo != 0) {
                        $('.msjFinalEstilo').css('background-color', '#E91D1D');
                        cerrarNormal();
                        
                    } else {
                        $('.msjFinalEstilo').css('background-color', '#9EC944');
                        cerrarReload();
                    }
                    msgFinal(datos.mensaje);


                }
            });
        }
    }

}
function eliminarCarritoMd(idX) {
    var itemNumero = document.getElementById(idX).value;
    limpiarModal();
    $('#msnContOp').show();
    cerrarNormal();
    divBtnGuardar = $('.divValueBtn1');
    divBtnCancelar = $('.divValueBtn2');
    msnConctM('¿Seguro que quieres eliminar este producto?');
    divBtnGuardar.html("<input value=\"" + itemNumero + "\" id=\"aggBtn" + itemNumero + "\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc1.png\" alt=\"Guardar\" onclick=\"eliminarCarrito(" + itemNumero + ")\" \">");
    divBtnCancelar.html("<input value=\"1\" id=\"btnValueId1\" class=\"btnValueCont\" type=image src=\"imagenes/msn/acc2.png\" alt=\"Guardar\" onclick=\"msnConctC()\">");
}
function eliminarCarrito(id) {
    var itemNumero = id;

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
        resultado = (totalPagar - precioInt);
        num = 1;
    }
    if (itemNumero == 2) {
        var precio = document.getElementById('precioU2').innerHTML;
        iSeguD = document.getElementById('secuD2').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar - precioInt);
        num = 2;
    }
    if (itemNumero == 3) {
        var precio = document.getElementById('precioU3').innerHTML;
        iSeguD = document.getElementById('secuD3').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar - precioInt);
        num = 3;
    }
    if (itemNumero == 4) {
        var precio = document.getElementById('precioU4').innerHTML;
        iSeguD = document.getElementById('secuD4').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar - precioInt);
        num = 4;
    }
    if (itemNumero == 5) {
        var precio = document.getElementById('precioU5').innerHTML;
        iSeguD = document.getElementById('secuD5').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar - precioInt);
        num = 5;
    }
    if (itemNumero == 6) {
        var precio = document.getElementById('precioU6').innerHTML;
        iSeguD = document.getElementById('secuD6').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar - precioInt);
        num = 6;
    }
    if (itemNumero == 7) {
        var precio = document.getElementById('precioU7').innerHTML;
        iSeguD = document.getElementById('secuD7').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar - precioInt);
        num = 7;
    }
    if (itemNumero == 8) {
        var precio = document.getElementById('precioU8').innerHTML;
        iSeguD = document.getElementById('secuD8').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar - precioInt);
        num = 8;
    }
    if (itemNumero == 9) {
        var precio = document.getElementById('precioU9').innerHTML;
        iSeguD = document.getElementById('secuD9').innerHTML;
        var totalPagar = parseFloat(ttAdd);
        var precioInt = parseFloat(precio);
        resultado = (totalPagar - precioInt);
        num = 9;
    }

    totalAgregadoPosi.html(resultado);
    itemsListar(iSeguD, num);
}

function itemsListar(id, itemNum) {
    limpiarModal();
    var informacion = {};
    informacion.iSeguD = id;
    informacion.numItem = itemNum;
    $.ajax({
        url: 'comprarProductos/eliminar',
        dataType: 'json',
        method: 'POST',
        data: informacion,
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
            cerrarReload();
        }

    });
}


