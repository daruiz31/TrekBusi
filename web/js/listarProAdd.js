/*
 *  Autor:  Diego RM
 */

var solicitarAllProductos = {
    iniciarList: function () {

        $.ajax({
            url: 'comprarProductos/listar',
            data: {},
            method: "POST",
            dataType: 'json',
            success: function (datos) {
                console.log(datos);

                var imgPosi = new Array($('#imgPro1'), $('#imgPro2'), $('#imgPro3'), $('#imgPro4'), $('#imgPro5'), $('#imgPro6'), $('#imgPro7'), $('#imgPro8'), $('#imgPro9'));
                var nombrePosi = new Array($('#nombrePro1'), $('#nombrePro2'), $('#nombrePro3'), $('#nombrePro4'), $('#nombrePro5'), $('#nombrePro6'), $('#nombrePro7'), $('#nombrePro8'), $('#nombrePro9'));
                var precioPosi = new Array($('#precioU1'), $('#precioU2'), $('#precioU3'), $('#precioU4'), $('#precioU5'), $('#precioU6'), $('#precioU7'), $('#precioU8'), $('#precioU9'));
                var contN = new Array();
                var contValorU = new Array();
                var contProcod = new Array();
                var contTipoPro = new Array();
                var contDescripcion = new Array();
                var contReferencia = new Array();
                var contMarca = new Array();
                var contCapacidad = new Array();
                var contEstado = new Array();
                var contImg = new Array();
                var idProducto = new Array();
                var toProductoPosi = $('#rta-tiProduc');
                var marcaPosi = $('#rta-marca');
                var referenciaPosi = $('#rta-referencia');
                var capacidadPosi = $('#rta-capacidad');
                var descripcionPosi = $('#rta-descripcion');
                var estadoPosi = $('#rta-estado');
                
                $.each(datos, function(i, items){
                    
                    
                });

            },
        });




    },
}


