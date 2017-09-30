

function limpiarTodo() {

    $('#administrarUserADMIN').css('color', 'white');
    $('#baseDatosADMIN').css('color', 'white');
    $('#notificacionesADMIN').css('color', 'white');
    $('#programaADMINSel').css('color', 'white');
    // Tabla notificaciones de servicio
  


    // Divisiones notificaciones
    $('#solicitudProductoADMIN').hide();
    $('#solicitudServicioADMIN').hide();
    $('#buscadorNotifiServicios').hide();
    $('#buscadorNotifiProducto').hide();
    $('#solicitudAlquilerADMIN').hide();
    $('#buscadorNotifiAlquiler').hide();
    $('#solicitudReportesADMIN').hide();
    $('#buscadorNotifiReportes').hide();


    // Divisiones Base de datos    
    $('#registroProductoADMIN').hide();
    $('#buscadorBaseDproductos').hide();
    $('#registroServicioADMIN').hide();
    $('#buscadorBaseDservicios').hide();
    $('#baseDatosInventario').hide();
    $('#buscadorBaseDinventario').hide();
    $('#baseDatosActualizarProductos').hide();
    $('#buscadorBaseDAproductos').hide();
    $('#baseDatosActualizarServicios').hide();
    $('#buscadorBaseDAservicios').hide();
    $('#baseDatosSubirDocumentos').hide();
    $('#buscadorBaseDdoc').hide();

    $('#eliminarRegistros').hide();



    // Divisiones descargar archivos
    $('#archivosSubCliente').hide();
    $('#buscadorBDcliente').hide();
    $('#buscadorBDempresa').hide();
    $('#archivosSubEmpresa').hide();

    // Divisiones PROGRAMA
    $('#buscadorProgramaServicios').hide();
    $('#programaServicios').hide();
    $('#programaProductos').hide();
    $('#buscadorProgramaProductos').hide();
    $('#programaAlquiler').hide();
    $('#buscadorProgramaAlquiler').hide();
    $('#buscadorProgramaEstadistica').hide();
    $('#programaEstadisticas').hide();

    // Divisiones Administrar Usuarios
    $('#administrarCliente').hide();
    $('#buscadorUsuariosCliente').hide();
    $('#administrarEmpresas').hide();
    $('#buscadorUsuariosEmpresa').hide();
    $('#administrarEmpleados').hide();
    $('#buscadorUsuariosEmpleado').hide();
    $('#administrarInactivos').hide();
    
   
   // Limpiar tablas; 
    
   // Notificaciopnes
    $('#listaSolicitudProductos').html("");
    $('#listaSolicitudServicios').html("");
    $('#listaSolicitudAlquiler').html("");
    
    // Usuarios
    $('#administrarClien').html("");
    $('#listaAdmInactivo').html("");
    $('#listaEmplados').html("");
    $('#listaEmpresas').html("");
    
    // Programa
    $('#proTablaServi').html("");
    $('#programaTablaProductos').html("");
    
}


