<%-- 
    Document   : nav-cliente
    Created on : 8/03/2016, 05:53:20 PM
    Author     : Diego RM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title><%=(String) session.getAttribute("usuario")%></title>
        <link rel="shortcut icon" href="imagenes/iconLogo64.png" type="image/png" />   
        <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>

        <script src="js/permisos.js" type="text/javascript"></script>
        <script src="js/solicitarProductos.js" type="text/javascript"></script>
        <link rel="shortcut icon" href="imagenes/iconLogo64.png" type="image/png" />        
        <link rel="stylesheet" href="fonts/style.css">
        <link rel="stylesheet" href="css/font-awesome-4.5.0/css/font-awesome.css" />
        <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
        <link href="css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/paginacion.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/normalize.css" />
        <link rel="stylesheet" href="css/styles.css" />
        <link href="css/scrollStyle.css" rel="stylesheet" type="text/css"/>
        <script src="js/modalD.js" type="text/javascript"></script>
        <link href="css/modal.css" rel="stylesheet" type="text/css"/>
        <%
            if (session.getAttribute("usuario") == null) {
                response.sendRedirect("index.html");
            }
        %>
    </head>
    <body>
         <div id="fade" class="overlay"></div>
        <div id="light" class="modal">
            <div class="modalCerrar">
                <span><input type=image src="imagenes/msn/x.png" class="xModal" onclick="modalOcultar()"></span>

            </div>
            <div class="msnProductoAdd" id="msnProAdd">
                <label id="rtaMsnProductNew" class="titulosModal1">Solo se admiten formatos JPG, PNG, JPEG </label>              

            </div>
        </div>
        <div id="modal2" class="modalContacto">
            <div class="modalCerrar" id="modlCerrar">
                <span><input type=image src="imagenes/msn/x.png" class="xModal" id="cerrarNormal" onclick="msnConctC()"></span>
                <span><input type=image src="imagenes/msn/x.png" class="xModal" id="cerrarReload" onclick="closeReloadCliente()"></span>

            </div>
         
            <div class="mensajeFinal" id="msgEnd">
                <div class="msjFinalEstilo"></div>
                <p id="msgConctEnd"></p>
            </div>
            <div class="mensajesOpcion" id="msnContOp">
                <p id="respuestContacto" class="rptaCont"></p>
                <div class="inputContValue">
                    <div class="divValueBtn1"></div>
                    <div class="divValueBtn2"></div>
                    <p id="inputAlert"></p>


                </div>
            </div>

        </div>
    <header class="header" id="idheader">
        <div class="bar-menu">
            <a><span class="icon-menu"></span></a>
        </div>
        <nav class="menu">

            <ul class="list">
                <li><img class='logoGeneralInge' alt="" class="icon-house" class="icon" src="imagenes/logoinge.jpg" alt=""/></li>
                <li><a href="indexlog.jsp" class="link-header"><img src="imagenes/internet.png" alt="" class="icon-house" class="icon">INICIO</a></li>

                <li class="option-menu">
                    <a class="padre-menu"><%=(String) session.getAttribute("usuario")%></a>
                </li>
                <li class="image-perfil-mod">
                    <a class="perfil-image-mod"><img class="image-perfil" src="imagenes/avatar1.png" alt=""></a>
                </li>
            </ul>	
        </nav>
    </header>


    <div class="bar-option hijo-menu">
        <ul class="bar-option-ul">
            <%try {
                    int sess = (Integer) session.getAttribute("iSeguD");

            %><li class="options-menu-li"><a class="options-menu-perfil" href="nav-cliente.jsp">Opciones</a></li><%                if (session.getAttribute("producto1") != null && sess != 1) {
            %><li id="cerrarSesion" class="options-menu-li"><a class="options-menu-perfil" href="solicitar-productos.jsp">Carrito</a></li> <%
                    }

                } catch (NullPointerException exp) {

                }%>

            <li class="options-menu-li"><a class="options-menu-perfil" href="cerrarSesion">Cerrar sesion</a></li>
        </ul>
    </div>


    <body class="body-mod">
        <div class="opcionesImagenes">
            <img id="archivosImagen" src="imagenes/msn/archivos.png" alt=""/>
            <img id="negocioImagen" src="imagenes/msn/negocios.png" alt=""/>
            <img id="pedidosImagen" src="imagenes/msn/pedidos.png" alt=""/>


        </div>
        <div class="container-cliente">
            <div class="header-cliente">

                <div class="options-cliente"></div>
            </div>
            <nav id="cliente-menu" class="menuadCliente">
                <input alt="Seguimiento" value="1" type="image" src="imagenes/msn/archivos.png" class="opcionesCliente" id="archivosPerfil" onclick="servicios(this.id)">
                <input alt="Tienda virtual" value="2" type="image" src="imagenes/msn/tienda.png" class="opcionesCliente" id="tiendaPerfil" onclick="servicios(this.id)">
                <input alt="Mis pedidos" value="3" type="image" src="imagenes/msn/pedidos.png" class="opcionesCliente" id="pedidosPerfil" onclick="servicios(this.id)">
                <input alt="Mis negocios" value="4" type="image" src="imagenes/msn/negocios.png" class="opcionesCliente" id="negociosPerfil" onclick="servicios(this.id)">
            </nav>
        </div>	
        <div class="contenidoCliente">
            <div id="mostrarSeguimiento" class="seguimientoCliente">
                <h3 class="titulosCliente">Configuración:</h3>
                <button value="1" class="btnMenuAlterno" id="perfilCliente" onclick="seguimiento(this.id)">Perfil</button>
                <div class="menuAlterno">

                </div>


                <div class="perfilCliente">
                    <img id="alertRTA" src="imagenes/msn/war1.png" alt=""/><p id="rtaActualizar"></p>

                    <div id="verDatosCliente">
                        <div class="ladoIzquierdoCliente">
                            <div id="informacionCliente">                               
                                <h4 class="descripcionPerfil">Primer nombre</h4>
                                <p class="datosPerfil" id="datoPrimerN">Dato</p>
                                <h4 class="descripcionPerfil">Nombre de usuario</h4>
                                <p class="datosPerfil" id="datoNombreUser">Dato</p>
                                <h4 class="descripcionPerfil">Telefonos</h4>
                                <p class="datosPerfil" id="datoTelefono1">Dato</p>
                                <p class="datosPerfil" id="datoTelefono2">Dato</p>
                                <p class="datosPerfil" id="datoTelefono3">Dato</p>



                            </div>
                            <div id="modificarCliente">                                
                                <h4 class="descripcionPerfil">Primer nombre</h4>
                                <input class="cajasPerfil" type="text" placeholder="Primer nombre" id="nombre1">
                                <h4 class="descripcionPerfil">Nombre de usuario</h4>
                                <input class="cajasPerfil" type="text" placeholder="Usuario" id="usuario">
                                <h4 class="descripcionPerfil">Telefonos</h4>
                                <input class="cajasPerfil" type="text" placeholder="Telefono Contacto" id="telefono1">
                                <br>
                                <br>
                                <input class="cajasPerfil" type="text" placeholder="Telefono Fijo" id="telefono2">
                                <br>
                                <br>
                                <input class="cajasPerfil" type="text" placeholder="Telefono Celular" id="telefono3">


                            </div>
                        </div>
                        <div class="ladoDerecho">
                            <div id="informacionCliente2">
                                <h4 class="descripcionPerfil">Segundo nombre</h4>
                                <p class="datosPerfil" id="datoSegunUser">Dato</p>
                                <h4 class="descripcionPerfil">Pais</h4>
                                <p class="datosPerfil" id="datoPais">Dato</p>
                                <h4 class="descripcionPerfil">Documento</h4>
                                <p class="datosPerfil" id="datoDocumento">Dato</p>  





                            </div>
                            <div id="modificarCliente2">         
                                <h4 class="descripcionPerfil">Segundo nombre</h4>
                                <input class="cajasPerfil" type="text" placeholder="Segundo nombre" id="nombre2">

                                <h4 class="descripcionPerfil">Pais</h4>
                                <select class="cajasPerfil" class="selectPERFILmod" id="paisSel" onchange="ciudadSelect()"></select>
                                <h4 class="descripcionPerfil">Documento/Nit</h4>
                                <input class="cajasPerfil" type="text" placeholder="Numero identificacion" id="documentoNit">

                            </div>
                        </div>
                        <div class="derecha2">
                            <div id="informacionCliente3">
                                <h4 class="descripcionPerfil">Primer apellido</h4>
                                <p class="datosPerfil" id="datoPrimerA">Dato</p>
                                <h4 class="descripcionPerfil">Ciudad</h4>
                                <p class="datosPerfil" id="datoCiudad">Dato</p>
                            </div>
                            <div id="modificarCliente3">
                                <h4 class="descripcionPerfil">Primer apellido</h4>
                                <input class="cajasPerfil" type="text" placeholder="Primer apellido" id="apellido1">
                                <h4 class="descripcionPerfil">Ciudad</h4>
                                <select class="cajasPerfil" class="mod_input" id="ciudadSel"/></select>

                            </div>
                        </div>
                        <div class="derecha3">
                            <div id="informacionCliente4">
                                <h4 class="descripcionPerfil">Segundo apellido</h4>
                                <p class="datosPerfil" id="datoSegunA">Dato</p>
                                <h4 class="descripcionPerfil">Direccion</h4>
                                <p class="datosPerfil" id="datoDireccion">Dato</p>
                            </div>
                            <div id="modificarCliente4">
                                <h4 class="descripcionPerfil">Segundo apellido</h4>
                                <input class="cajasPerfil" type="text" placeholder="Segundo apellido" id="apellido2">
                                <h4 class="descripcionPerfil">Direccion</h4>
                                <input class="cajasPerfil" type="text" placeholder="Direccion" id="direccion">
                            </div>
                        </div>

                    </div>
                    <div class="botonesPerfil">
                        <button value="1" class="btnsPerfil" id="modificarPerfil" onclick="perfil(this.id)">Modificar</button>
                        <button value="3" class="btnsPerfil" id="modificarPerfilatras" onclick="perfil(this.id)">Volver</button>
                        <button value="2" class="btnsPerfil" id="eliminarPerfil" onclick="perfil(this.id)">Eliminar cuenta</button>
                        <button value="4" class="btnsPerfil" id="actualizarPerfil" onclick="perfil(this.id)">Actualizar</button>
                    </div>

                </div>
            </div>

            <div class="productosCliente" id="productosMostrar">
                <h3 class="titulosCliente">Mis compras:</h3>
                <button value="1" class="btnMenuAlterno" id="carritoCliente" onclick="productosCliente(this.id)">Alquiler</button>

                <button value="2" class="btnMenuAlterno" id="solicitudesProcliente" onclick="productosCliente(this.id)">Productos</button>

                <button value="3" class="btnMenuAlterno" id="solicitudesSevcliente" onclick="productosCliente(this.id)">Servicios</button>
                <div class="menuAlterno">

                </div>
                <div class="carritoCliente">
                    <table class="estiloTablasCliente" id="productosClienteAlquiler">
                        <thead>
                            <tr>
                                <th>Fecha pedido</th>
                                <th>Fecha inicio</th>
                                <th>Fecha fin</th>
                                <th>Producto</th>
                                <th>Descripcion</th>
                                <th>Costo</th>
                                

                            </tr>
                        </thead>
                    </table>

                </div>
                <div class="productosAdquiridos">
                    <table class="estiloTablasCliente" id="productosClienteBuy">
                        <thead>
                            <tr>
                                <th>Producto</th>
                                <th>Tipo producto</th>
                                <th>Nombre</th>
                                <th>Marca</th>
                                <th>Descripcion</th>
                                <th>Costo</th>
                                <th>Fecha compra</th>

                            </tr>
                        </thead>
                    </table>
                </div>
                <div class="serviciosAdquiridos">

                    <table class="estiloTablasCliente" id="serviciosClienteBuy">
                        <thead>
                            <tr>
                                <th>Servicio</th>
                                <th>Descripcion</th>
                                <th>Fecha acordada</th>
                                <th>Fecha pedido</th>
                                <th>Estado</th>
                            </tr>
                        </thead>
                    </table>

                </div>
            </div>

            <div class="pedidosCliente" id="pedidosMostrar">
                <h3 class="titulosCliente">Negocios:</h3>
                <button value="3" class="btnMenuAlterno" id="productosAlquil" onclick="negocioCliente(this.id)">Alquiler</button>
                <button value="1" class="btnMenuAlterno" id="serviciosCliente" onclick="negocioCliente(this.id)">Servicios</button>
                <button value="2" class="btnMenuAlterno" id="productosProcliente" onclick="negocioCliente(this.id)">Productos</button>
                
                <div class="menuAlterno">

                </div>
                <div class="negociosServicios">
                    <table class="estiloTablasCliente" id="pNegociosServicios">
                        <thead>
                            <tr>
                                <th>Servicio</th>
                                <th>Descripcion</th>
                                <th>Fecha acordada</th>
                                <th>Fecha peticion</th>
                                <th>Estado</th>
                                <th>Información</th>

                            </tr>
                        </thead>
                        <tbody id="negociosServicios">

                        </tbody>
                    </table>
                </div>
                <div class="negociosProductos">
                    <table class="estiloTablasCliente" id="pNegociosProductos">
                        <thead>
                            <tr>
                                <th>Producto</th>
                                <th>Nombre</th>
                                <th>Marca</th>                            
                                <th>Descripcion</th>
                                <th>Costo</th>
                                <th>Fecha compra</th>
                                <th>Estado</th>
                                <th>Información</th>

                            </tr>
                        </thead>
                        <tbody id="negociosProductos">

                        </tbody>
                    </table>
                </div>
                 <div class="negociosAlquiler">
                    <table class="estiloTablasCliente" id="pNegociosAlquiler">
                        <thead>
                            <tr>
                                <th>Producto</th>     
                                <th>Descripcion</th>
                                <th>Costo</th>
                                <th>Fecha solicitud</th>
                                <th>Fecha inicio</th>
                                <th>Fecha fin</th>
                                <th>Estado</th>
                                <th>Información</th>
                            </tr>
                        </thead>
                        <tbody id="negociosAlquiler">

                        </tbody>
                    </table>
                </div>


            </div>

        </div>
        <script src="js/menu.js"></script>
        <script src="js/navCliente.js" type="text/javascript"></script>
        <script>
                    $(document).ready(function pais() {
                        $('#paisSel').load("ubicacion");
                    })
        </script>
        <script>
            function ciudadSelect() {
                var paisSelect = $('#paisSel').val();
                $('#ciudadSel').load("ubicacionSel", {paisSelec: paisSelect});
            }
        </script>
        <script type="text/javascript">
            $(document).ready(function () {
                listarAgregados.iniciar();
            })
        </script>

    </body>
</html>
