/* 
 *      Autor: Diego RM
 */

function eliminarRegistros(){
    limpiarRegistroElm();
    var opcion = $('#selecDeleteReg').val();
    if (opcion == 1) {
        $('#eliminarUsuarios').show();
    }
    if (opcion == 2) {
        $('#eliminarProductos').show();
    }
    if (opcion == 3) {
        $('#eliminarServicios').show();
    }
    if (opcion == 4) {
        $('#eliminarTipoProduc').show();
    }
    if (opcion == 5) {
        $('#eliminarSolicitudProd').show();
    }
    if (opcion == 6) {
        $('#eliminarAlquiler').show();
    }
    if (opcion == 7) {
        $('#eliminarDetalleT').show();
    }
}

function limpiarRegistroElm(){
    $('#eliminarDetalleT').hide();
    $('#eliminarUsuarios').hide();
    $('#eliminarProductos').hide();
    $('#eliminarServicios').hide();
    $('#eliminarTipoProduc').hide();
    $('#eliminarSolicitudProd').hide();
    $('#eliminarAlquiler').hide();
}



