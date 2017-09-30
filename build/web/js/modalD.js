/* 
 * 
 *      Autor: Diego RM
 */
function modalMostrar() {

    $('#light').show();
    $('#fade').show();
    $('#mapContact').show();
}
function modalOcultar() {

    document.getElementById('light').style.display = 'none';
    document.getElementById('fade').style.display = 'none';
    $('#mapContact').hidde();

}
function modalReport() {
    $('#reportesModal').show();
//    $('#fade').show();
}
function modalReportCerrar() {
    document.getElementById('reportesModal').style.display = 'none';
//    document.getElementById('fade').style.display = 'none';
}

function msnConctM(msn) {
    $('#modal2').show();
    $('#fade').show();
    $('#msnCont').show();
    $('#respuestContacto').html(msn);
}

function modalAlquilerVer() {
    $('#cerrarNormal').show();
    $('#modal2').show();
    $('#fade').show();
    $('#alquilarDatos').show();

}
function modalAlquilerH() {
    document.getElementById('modal2').style.display = 'none';
    document.getElementById('fade').style.display = 'none';
    document.getElementById('alquilarDatos').style.display = 'none';
    $('#cerrarNormal').hide();
    $('#cerrarReload').hide();
}
function msnConctC() {
    document.getElementById('modal2').style.display = 'none';
    document.getElementById('fade').style.display = 'none';
    document.getElementById('msnCont').style.display = 'none';
    document.getElementById('msgEnd').style.display = 'none';
}

function msgFinal(msg) {
    $('#modal2').show();
    $('#fade').show();
    $('#msgEnd').show();
    $('#msgConctEnd').html(msg);
}

function modalInventario() {
    $('#moodalInventario').show();
    $('#fade').show();

}
function modalInventarioCerrar() {
    document.getElementById('moodalInventario').style.display = 'none';
    document.getElementById('fade').style.display = 'none';

}

function display() {
    document.getElementById('msnCont').style.display = 'none';
    document.getElementById('msgEnd').style.display = 'none';
    document.getElementById('msnContOp').style.display = 'none';

}

function closeReloadNav1() {
    window.location.href = "nav-admin.jsp";
}

function closeReloadSolip() {
    window.location.href = "solicitar-productos.jsp";
}

function closeReloadCliente() {
    window.location.href = "nav-cliente.jsp";
}

function cerrarNormal() {
    $('#cerrarNormal').show();
}
function cerrarReload() {
    $('#cerrarReload').show();
}

function limpiarModal() {
    $('#msnContOp').hide();
    $('#msgEnd').hide();
    $('#cerrarNormal').hide();
    $('#cerrarReload').hide();
}
function cerrarModal2() {
    document.getElementById('modal2').style.display = 'none';
    document.getElementById('fade').style.display = 'none';
}

function limModalSoliProducto() {
    $('#cerrarNormal').hide();
    $('#cerrarReload').hide();
}

// Parche 1.5

function limpiarNavCTablas() {

    $('#negociosServicios').html("");
    $('#negociosProductos').html("");
    $('#negociosAlquiler').html("");


}