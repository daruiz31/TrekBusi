/* 
 *  Autor:  Diego RM
 */

function mostrarDescargas() {
    var opcion = document.getElementById("DescargarArchivos").value;
    limpiarTodo();

    if (opcion == 1) {        
        $('#archivosSubCliente').show();
        $('#buscadorBDcliente').show();

    } else if (opcion == 2) {
        
        $('#archivosSubEmpresa').show();
        $('#buscadorBDempresa').show();
    }
}

