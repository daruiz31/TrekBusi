<%-- 
    Document   : nav-admin
    Created on : 8/03/2016, 05:46:05 PM 
    Author     : Diego Ruiz
--%>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.*" %>
<%@ page import="java.io.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Administrador</title>
        <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <link href="fonts/stylesheetopensansSeflt.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="js/limpiarNavAdmin.js" type="text/javascript"></script>
        <script src="js/permisos.js" type="text/javascript"></script>
        <script src="js/modalD.js" type="text/javascript"></script>
        <link href="css/modal.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="imagenes/iconLogo64.png" type="image/png" />
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/normalize.css" />        
        <script src="js/validaciones.js" type="text/javascript"></script>
        <script src="js/funciones.js" type="text/javascript"></script>
        <link href="css/tablas.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="menu2_files/css3menu1/style.css" type="text/css" /><style type="text/css">._css3m{display:none}</style>

        <%
            try {
                int sess = (Integer) session.getAttribute("rol");

                if (session.getAttribute("usuario") == null) {
                    response.sendRedirect("index.html");
                } else {
                    if (sess == 2 || sess == 3) {
                        response.sendRedirect("indexlog.jsp");
                    }
                }

            } catch (NullPointerException exp) {
                response.sendRedirect("indexlog.jsp");
            }

        %>

    </head>
    <body ontouchstart="">
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
                <span><input type=image src="imagenes/msn/x.png" class="xModal" id="cerrarReload" onclick="closeReloadNav1()"></span>

            </div>
            <!--            <div class="mensajesContacto" id="msnCont">
                            <img class="alertContc1" src="imagenes/msn/alert1.png" alt=""/><p id="respuestContacto" class="rptaCont"></p>
                            <div class="inputContValue">
                                <div class="divValueCont"></div>
                                <p id="inputAlert"></p>
            
            
                            </div>
                        </div>-->
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


        <div class="modalReportes" id="reportesModal">
            <div class="modalCerrar2">
                <span><input type=image src="imagenes/msn/x.png" class="xModal2" onclick="modalReportCerrar()"></span>

            </div>
            <label id="txtReporteOpt">Generar reporte con estado:</label>
            <a target="_blank" id="txtReporteGt" href="http://localhost:8080/Proyecto/filtroReportes/solicitudEstado?estado=Terminado">Terminado</a>
            <a target="_blank" id="txtReporteGt" href="http://localhost:8080/Proyecto/filtroReportes/solicitudEstado?estado=Confirmado">Confirmado</a>
            <a target="_blank" id="txtReporteGt" href="http://localhost:8080/Proyecto/filtroReportes/solicitudEstado?estado=Denegado">Denegado</a>

        </div>


        <div id="moodalInventario" class="ModalInventarioActualizar">
            <div class="modalCerrar" id="modlCerrar">
                <span><input type=image src="imagenes/msn/x.png" class="xModal" id="cerrarNormalInv" onclick="modalInventarioCerrar()"></span>

            </div>
            <div class="inventarioArreglo">Actualizar</div>
            <div class="cajasmodalinventario1">
                <label  id="labelInventarioAc">Tipo producto</label>
                <select class="input-inventario-productos" id="tipoProductoADMIN" name="tipoProducto" ></select>
                <label id="labelInventarioAc">Estado</label>
                <select class="input-inventario-productos" name="estado" class="" id="estadoProducto" >
                    <option value="Disponible">Disponible</option>
                    <option value="No Disponible">No Disponible</option>
                    <option value="Agotado">Agotado</option>
                    <option value="En peticion">En petición</option>
                </select>
                <label id="labelInventarioAc">Nombre</label>
                <input class="input-inventario-productos" type="text" id="nombreInventario" placeholder="Nombre producto"/>
            </div>
            <div class="cajasmodalinventario2">
                <label id="labelInventarioAc">Marca</label>
                <input class="input-inventario-productos" type="text" id="marcaInventario" placeholder="Marca"/>
                <label id="labelInventarioAc">Referencia</label>
                <input class="input-inventario-productos" type="text" id="referenciaInventario" placeholder="Referencia"/>

                <label id="labelInventarioAc">Valor unitario</label>
                <input class="input-inventario-productos" type="number" id="valorUInventario" placeholder="Valor unidad"/>

            </div>
            <div class="cajasmodalinventario3">
                <label id="labelInventarioAc">Descripción</label>
                <textarea class="input-inventario-productos" id="descripcionInventario" placeholder="Descripción"> </textarea>

                <label id="labelInventarioAc">Capacidad</label>
                <textarea class="input-inventario-productos" id="capacidadInventario" placeholder="Capacidad"> </textarea>
            </div>

            <div id="posicionBtnInvt"></div>
        </div>

        <div class="opcionesADMIN">
            <input type="checkbox" id="css3menu-switcher" class="c3m-switch-input">
            <ul id="css3menu1" class="topmenu">
                <li class="switch"><label onclick="" for="css3menu-switcher"></label></li>
                <li class="toplast"><a href="#" style="height:23px;line-height:23px;"><span>NOTIFICACIONES</span></a>
                    <ul>

                        <li><a onclick="mostrarNotificacion(2)">Productos</a></li>
                        <li><a onclick="mostrarNotificacion(1)">Servicios</a></li>
                        <li><a onclick="mostrarNotificacion(3)">Alquiler</a></li>
                    </ul>
                </li>


        </div>
        <div class="opcionesADMIN2">
            <input type="checkbox" id="css3menu-switcher" class="c3m-switch-input">
            <ul id="css3menu1" class="topmenu">
                <li class="switch"><label onclick="" for="css3menu-switcher"></label></li>
                <li class="toplast"><a href="#" style="height:23px;line-height:23px;"><span>PROGRAMA</span></a>
                    <ul>

                        <li><a onclick="programaADMIN(2)">Producto</a></li>
                        <li><a onclick="programaADMIN(1)">Servicio</a></li>
                        <li><a onclick="programaADMIN(3)">Alquiler</a></li>

                    </ul>
                </li>


        </div>
        <%try {
                HttpSession sesss = request.getSession();
                int sess = (Integer) session.getAttribute("rol");

                if (sess == 1) {
        %>
        <div class="opcionesADMIN3">
            <input type="checkbox" id="css3menu-switcher" class="c3m-switch-input">
            <ul id="css3menu1" class="topmenu">
                <li class="switch"><label onclick="" for="css3menu-switcher"></label></li>
                <li class="toplast"><a href="#" style="height:23px;line-height:23px;"><span>USUARIOS</span></a>

                    <ul>
                        <li><a onclick="mostrarAdministrar(1)">Cliente</a></li>
                        <li><a onclick="mostrarAdministrar(2)">Empresa</a></li>
                        <li><a onclick="mostrarAdministrar(3)">Empleado</a></li>
                        <li><a onclick="mostrarAdministrar(4)">Todos</a></li>
                    </ul>
                </li>
        </div>
        <%
                }

            } catch (NullPointerException exp) {

            }%>
        <%try {
                HttpSession sesss = request.getSession();
                int sess = (Integer) session.getAttribute("rol");

                if (sess == 1) {
        %>
        <div class="opcionesADMIN4">
            <input type="checkbox" id="css3menu-switcher" class="c3m-switch-input">
            <ul id="css3menu1" class="topmenu">
                <li class="switch"><label onclick="" for="css3menu-switcher"></label></li>
                <li class="toplast"><a href="#" style="height:23px;line-height:23px;"><span>BASE DE DATOS</span></a>

                    <ul>
                        <li><a onclick="mostrarBaseDatos(1)">Productos</a></li>
                        <li><a onclick="mostrarBaseDatos(3)">Registrar producto</a></li>
                        <li><a onclick="mostrarBaseDatos(2)">Registrar servicio</a></li>
                        <!--<li><a onclick="mostrarBaseDatos(5)">Actualizar producto</a></li>-->
                        <!--<li><a onclick="mostrarBaseDatos(4)">Actualizar servicio</a></li>-->
                        <!--<li><a onclick="mostrarBaseDatos(7)">Eliminar registros</a></li>-->
                    </ul>
                </li>
        </div>
        <%
                }

            } catch (NullPointerException exp) {

            }%>



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



        <div class="contenidoGlobalAdmin">


            <div class="ADMIN" id="programaADMIN">
                <div id="programaServicios">
                    <h1 class="titulosAdmin">PROGRAMA</h1>/<h1 class="titulosAdmin">Lista solicitudes de servicio</h1>
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                    <table id="paginacion1">

                        <thead>
                            <tr>
                                <th>Usuario</th>
                                <th>Correo</th>
                                <th>Telefono</th>
                                <th>Servicio</th>
                                <th>Descripcion</th>
                                <th>Fecha solicitada</th>
                                <th>Fecha pedido</th>
                                <th>Presupuesto</th>
                                <th>Ciudad</th>
                                <th>Direccion</th>
                                <th>Estado</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody id="proTablaServi">

                        </tbody>


                    </table>
                </div>
                <div id="programaProductos">
                    <h1 class="titulosAdmin">PROGRAMA</h1>/<h1 class="titulosAdmin">Lista productos solicitados</h1>
                    <input class="btnReportEst" onclick="modalReport()" type="image" src="imagenes/msn/book.png">
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                    <table id="paginacion2">
                        <thead>
                            <tr id="titulosTabla">                                
                                <th>Usuario</th>
                                <th>Correo</th>
                                <th>Telefono</th>
                                <th>Producto</th>
                                <th>Descripcion</th>
                                <th>Ciudad</th>
                                <th>Direccion</th>
                                <th>Neto</th>
                                <th>Fecha pedido</th>
                                <th>Estado</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody id="programaTablaProductos">

                        </tbody>
                    </table>
                </div>

                <div id="programaAlquiler">
                    <h1 class="titulosAdmin">PROGRAMA</h1>/<h1 class="titulosAdmin">Lista alquileres solicitados</h1>
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                    <table class="estiloTablasAdmin" id="paginacion3">
                        <thead>
                            <tr>                                
                                <th>Usuario</th>
                                <th>Correo</th>
                                <th>Telefono</th>
                                <th>Ciudad</th>
                                <th>Producto(s)</th>
                                <th>Descripcion</th>
                                <th>Costo</th>
                                <th>Direccion</th>
                                <th>Fecha inicio</th>
                                <th>Fecha fin</th>
                                <th>Fecha pedidon</th>
                                <th>Estado</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody id="programaTablaAlquiler">

                        </tbody>
                    </table>
                </div>
                <div id="programaEstadisticas">
                    <h1>Balance general</h1>
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                </div>

            </div>
            <div class="ADMIN" id="notiADMIN">
                <div id="solicitudServicioADMIN">
                    <h1 class="titulosAdmin">NOTIFICACIONES</h1>/<h1 class="titulosAdmin">Nuevas solicitudes para adquirir servicios.</h1>
                    <br>
                    <table class="estiloTablasAdmin" id="pNotiServicios" >
                        <thead>
                            <tr>
                                <th>Nombre usuario</th>
                                <th>Correo</th>
                                <th>Telefono</th>
                                <th>Tipo servicio</th>
                                <th>Descripcion</th>                                
                                <th>Fecha pedido</th>
                                <th>Presupuesto mínimo</th>
                                <th>Ciudad</th>
                                <th>Opcion</th>

                            </tr>
                        </thead>
                        <tbody id="listaSolicitudServicios">

                        </tbody>
                    </table>
                </div>
                <div id="solicitudProductoADMIN">
                    <h1 class="titulosAdmin">NOTIFICACIONES</h1>/<h1 class="titulosAdmin">Nuevas solicitudes para adquirir productos.</h1>
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                    <table id="pNotiProductos" class="estiloTablasAdmin">
                        <thead>
                            <tr>
                                <th>Nombre usuario</th>
                                <th>Correo</th>
                                <th>Telefono</th>
                                <th>Tipo Productos</th>                                
                                <th>Productos</th>
                                <th>Fecha pedido</th>
                                <th>Total</th>
                                <th>Ciudad</th>
                                <th>Opcion</th>
                            </tr>
                        </thead>
                        <tbody id="listaSolicitudProductos">

                        </tbody>
                    </table>
                </div>
                <div id="solicitudAlquilerADMIN">
                    <h1 class="titulosAdmin">NOTIFICACIONES</h1>/<h1 class="titulosAdmin">Nuevas solicitudes para alquiler productos.</h1>
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                    <table id="pNotiAlquiler" class="estiloTablasAdmin">
                        <thead>
                            <tr>

                                <th>Nombre usuario</th>
                                <th>Correo</th>
                                <th>Telefono</th>
                                <th>Producto</th>                                                                
                                <th>Descripcion</th>
                                <th>Fecha pedido</th>
                                <th>Total</th>
                                <th>Ciudad</th>                                
                                <th>Opciones</th>                                
                            </tr>
                        </thead>
                        <tbody id="listaSolicitudAlquiler">

                        </tbody>
                    </table>
                </div>
                <div id="solicitudReportesADMIN">
                    <h1 class="titulosAdmin">Reportes.</h1>
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                    <table id="listaReportes" class="estiloTablasAdmin">
                        <thead>
                            <tr>
                                <th>Tipo de reporte</th>
                                <th>Fecha reporte</th>
                                <th>Reporte</th>                                
                            </tr>
                        </thead>
                    </table>
                </div>

            </div>
            <div class="ADMIN" id="administrarUsers">
                <div id="administrarCliente">
                    <h1 class="titulosAdmin">USUARIOS</h1>/<h1 class="titulosAdmin">Información clientes.</h1>
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                    <table id="pAdministrarClien" class="estiloTablasAdmin">
                        <thead>
                            <tr>
                                <th>Nombre completo</th>
                                <th>Apellido completo</th>
                                <th>Correo</th>
                                <th>Telefono</th>
                                <th>Estado</th>                                                                
                                <th>Documento</th>
                                <th>Ciudad</th>
                                <th>Pais</th>                                
                                <th>Direcion</th>
                                <th>Solicitudes realizadas</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody id="administrarClien">

                        </tbody>
                    </table>

                </div>
                <div id="administrarEmpresas">
                    <h1 class="titulosAdmin">USUARIOS</h1>/<h1 class="titulosAdmin">Información de empresas.</h1>
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                    <table id="pAdministrarEmpre" class="estiloTablasAdmin">
                        <thead>
                            <tr>
                                <th>Razón social</th>
                                <th>Usuario contacto</th>
                                <th>Correo</th>
                                <th>Telefono</th>
                                <th>Estado</th>                                                                
                                <th>Nit</th>
                                <th>Ciudad</th>
                                <th>Pais</th>                                
                                <th>Direcion</th>
                                <th>Solicitudes realizadas</th>                                
                                <th>Opciones</th>                                
                            </tr>
                        </thead>
                        <tbody id="listaEmpresas">

                        </tbody>
                    </table>
                </div>
                <div id="administrarEmpleados">
                    <h1 class="titulosAdmin">USUARIOS</h1>/<h1 class="titulosAdmin">Información empleados.</h1>
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                    <table id="pAdministrarEmpl" class="estiloTablasAdmin">
                        <thead>
                            <tr>
                                <th>Nombre completo</th>
                                <th>Apellido completo</th>
                                <th>Correo</th>
                                <th>Telefono</th>
                                <th>Estado</th>                                                                
                                <th>Documento</th>
                                <th>Ciudad</th>
                                <th>Pais</th>                                
                                <th>Direcion</th>                                
                                <th>Solicitudes realizadas</th>                                
                                <th>Opciones</th>                                
                            </tr>
                        </thead>
                        <tbody id="listaEmplados">

                        </tbody>
                    </table>
                </div>
                <div id="administrarInactivos">
                    <h1 class="titulosAdmin">USUARIOS</h1>/<h1 class="titulosAdmin">Todos los usuarios.</h1>
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                    <table id="pAdministrarInactivos" class="estiloTablasAdmin">
                        <thead>
                            <tr>
                                <th>Nombre completo</th>
                                <th>Apellido completo</th>
                                <th>Correo</th>
                                <th>Telefono</th>
                                <th>Estado</th>                                                                
                                <th>Documento</th>
                                <th>Ciudad</th>
                                <th>Pais</th>                                
                                <th>Direcion</th>                                
                                <th>Rol</th>                                
                                <th>Opciones</th>                                
                            </tr>
                        </thead>
                        <tbody id="listaAdmInactivo">

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="ADMIN" id="baseDeDatos">
                <div id="baseDatosInventario">
                    <h1 class="titulosAdmin">BASE DE DATOS</h1>/<h1 class="titulosAdmin">Todos los productos.</h1>
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                    <table id="pInventario" class="estiloTablasAdmin">
                        <thead>
                            <tr>
                                <th>Tipo producto</th>
                                <th>Nombre</th>
                                <th>Marca</th>
                                <th>Referencia</th>
                                <th>Descripción</th>                                                                
                                <th>Valor unitario</th>
                                <th>Capacidad</th>
                                <th>Estado</th>                                
                                <th>Imagen</th>                                
                                <th>Opciones</th>                                
                            </tr>
                        </thead>
                        <tbody id="inventarioBD">

                        </tbody>
                    </table>
                </div>

                <div id="registroServicioADMIN">                   
                    <h1 class="titulosAdmin">BASE DE DATOS</h1>/<h1 class="titulosAdmin">Registrar nuevo servicio</h1>
                    <ul class="insertProducts">                        

                        <li class="listaRegADMIN">
                            <h2 class="title-description1">Nombre servicio</h2>
                            <input id="nombreServicio1" class="mod__input" type="text" name="nombreServicio"/>
                        </li>
                        <li class="listaRegADMIN">
                            <h2>Descripción</h2>
                            <textarea id="descripcionServicio1" rows="10"></textarea>
                        </li>		

                        <div class="button-itemADMIN2"> 
                            <input style="margin-left: -2%;" id="enviarRegistroProductos" class="enviarbut" type="submit" id="registrarServicio" onclick="registrarServicio()" value="ENVIAR">
                        </div>
                </div>

                <div id="registroProductoADMIN">                   
                    <h1 class="titulosAdmin">BASE DE DATOS</h1>/<h1 class="titulosAdmin">Registrar nuevo producto</h1>
                    <br/>
                    <div class="contenedorInsert">
                        <form name="formularioNuevoProducto" method="POST" enctype='multipart/form-data' action="registrarProductos">
                            <div id="contenedorInIzquierda">


                                <p class="title-pro-new">Tipo producto<p>
                                    <select class="" id="tipoProductoADMIN" name="tipoProducto" ></select>


                                <p class="title-pro-new">Estado</p>
                                <select name="estado" class="" id="estadoProducto" >
                                    <option value="Disponible">Disponible</option>
                                    <option value="Agotado">Agotado</option>
                                    <option value="En peticion">En petición</option>
                                </select>


                                <p class="title-pro-new">Nombre producto</p>
                                <input name="nombre" id="nombreProductoFIN" class="regProduct" type="text" onkeypress="return validar(event)"  required  />

                                <p class="title-pro-new">Referencia</p>
                                <input name="referencia" id="referenciaProducto" class="regProduct" type="text"  required />

                                <p class="title-pro-new">Marca</p>
                                <input  id="marcaProducto" class="regProduct" type="text" name="marca" onkeypress="return validar(event)" required />
                                <br/>
                                <br/>
                                <br/>

                                <p class="title-pro-new">Imagen</p><input class="examinarArchivo" type="file" name="imagenProducto" value="upload" required="">


                                <div class="button-itemADMIN"> 
                                    <input id="enviarRegistroProductos" class="enviarbut" type="submit" name="enviar-nuevo-producto" value="ENVIAR">
                                </div>

                            </div>

                            <div id="contenedorInDerecha">
                                <p class="title-pro-new">Valor unitario</p>
                                <input id="valorUproducto" class="regProduct" type="text" name="valorU" required maxlength="8" onkeypress="ValidaSoloNumeros()" />

                                <p class="title-pro-new">Capacidad<p>
                                    <input id="capacidadProducto" class="regProduct" type="text" name="capacidad" required />

                                <p class="title-pro-new">Cantidad</p>
                                <input id="cantidadProducto" class="regProduct" type="text" name="cantidad" required maxlength="5" />

                                <p class="title-pro-new">Descripcion</p>
                                <textarea name="descripcion" id="descripcionProducto" rows="6" required=""></textarea>


                            </div>

                        </form>
                    </div>
                </div>
                <div id="baseDatosActualizarProductos">
                    <h1 class="titulosAdmin">BASE DE DATOS</h1>/<h1 class="titulosAdmin">Actualizar productos.</h1>
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                    <table id="actualizarProductos" class="estiloTablasAdmin">
                        <thead>
                            <tr>
                                <th>Tipo producto</th>
                                <th>Nombre</th>
                                <th>Marca</th>
                                <th>Referencia</th>
                                <th>Descripción</th>                                                                
                                <th>Valor unitario</th>
                                <th>Capacidad</th>
                                <th>Estado</th>                                
                                <th>Cantidad</th>                                
                            </tr>
                        </thead>
                    </table>
                </div>                
                <div id="baseDatosActualizarServicios">
                    <h1 class="titulosAdmin">Actualizar servicios.</h1>
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                    <table id="ActualizarServicios" class="estiloTablasAdmin">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Descripciòn</th>                                
                            </tr>
                        </thead>
                    </table>
                </div>


                <div id="eliminarRegistros">
                    <div class="msnError-wars">
                        <p id="msnEliminar"><%--<img id="imgWar2" src="imagenes/msn/war2.png" alt=""/>--%>&nbsp; <b>¡Atención!</b>, si el registro esta asociado con otro, debes eliminar primero el registro que no es dependiente.</p>
                    </div>
                    <h1 class="titulosAdmin">Eliminar registros.</h1>
                    <br>
                    <label>Click en cualquier columna para organizar.</label>
                    <select id="selecDeleteReg" class="deleteRegs" onclick="eliminarRegistros()">
                        <option value="0">Opciones</option>
                        <option value="1">Usuarios</option>
                        <option value="2">Productos</option>
                        <option value="3">Servicios</option>
                        <option value="4">Tipo productos</option>
                        <option value="5">Solicitud producto</option>
                        <option value="6">Alquiler</option>
                        <option value="7">Detalles de pedido</option>

                    </select>
                    <br>
                    <br>
                    <br>
                    <br>

                    <div id="eliminarUsuarios">
                        <table id="eliminarUsuariosT" class="estiloTablasAdmin">
                            <thead>
                                <tr>
                                    <th>Radio Button</th>
                                    <th>Usuario</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Correos</th>
                                    <th>Telefono</th>                                                                
                                    <th>Paiso</th>
                                    <th>Ciudad</th>
                                    <th>Dirección</th>                                
                                    <th>No. Identificación</th>                                
                                    <th>Estado</th>                                
                                </tr>
                            </thead>
                        </table>

                    </div>                    


                    <div id="eliminarProductos">
                        <table id="eliminarProductosT" class="estiloTablasAdmin">
                            <thead>
                                <tr>
                                    <th>Radio Button</th>
                                    <th>Producto</th>
                                    <th>Nombre</th>
                                    <th>Referencia</th>
                                    <th>Marca</th>
                                    <th>Descripción</th>                                                                
                                    <th>Capacidad</th>
                                    <th>Valor unitario</th>
                                    <th>Estado</th>                                

                                </tr>
                            </thead>
                        </table>

                    </div>

                    <div id="eliminarServicios">
                        <table id="eliminarServiciosT" class="estiloTablasAdmin">
                            <thead>
                                <tr>
                                    <th>Radio Button</th>
                                    <th>Nombre</th>
                                    <th>Descripcion</th>                                   

                                </tr>
                            </thead>
                        </table>
                    </div>


                    <div id="eliminarTipoProduc">
                        <table id="eliminarTipoProducT" class="estiloTablasAdmin">
                            <thead>
                                <tr>
                                    <th>Radio Button</th>
                                    <th>Nombre</th>
                                    <th>Descripción</th>

                                </tr>
                            </thead>
                        </table>
                    </div>

                    <div id="eliminarSolicitudProd">
                        <table id="eliminarSoliProdT" class="estiloTablasAdmin">
                            <thead>
                                <tr>
                                    <th>Radio Button</th>
                                    <th>Usuario</th>
                                    <th>Nombre</th>
                                    <th>Descripcion</th>
                                    <th>Fecha para ejecución</th>
                                    <th>Fecha pedido</th>                                                                
                                    <th>Total/Presupuesto</th>
                                    <th>Estado</th>

                                </tr>
                            </thead>
                        </table>

                    </div>

                    <div id="eliminarAlquiler">
                        <table id="eliminarAlquilerT" class="estiloTablasAdmin">
                            <thead>
                                <tr>
                                    <th>Radio Button</th>
                                    <th>Usuario</th>
                                    <th>Nombre</th>
                                    <th>Fecha inicio</th>
                                    <th>Fecha fin </th>
                                    <th>Fecha pedido</th>                                                                
                                    <th>Costo</th>
                                    <th>Estado</th>

                                </tr>
                            </thead>
                        </table>
                    </div>
                    <div id="eliminarDetalle">
                        <table id="eliminarDetalleT" class="estiloTablasAdmin">
                            <thead>
                                <tr>
                                    <th>Radio Button</th>
                                    <th>Usuario</th>
                                    <th>Producto</th>                                    
                                    <th>Nombre</th>
                                    <th>Referencia</th>
                                    <th>Fecha pedido</th>
                                    <th>Estado</th>                                                                

                                </tr>
                            </thead>
                        </table>
                    </div>

                </div>

            </div>
        </div>
        <div class="bar-option hijo-menu">
            <ul class="bar-option-ul">

                <li class="options-menu-li"><a class="options-menu-perfil" href="nav-admin.jsp">Administrar</a></li>

                <li class="options-menu-li"><a class="options-menu-perfil" href="cerrarSesion">Cerrar sesión</a></li>
            </ul>
        </div>
        <div id="fade" class="overlay"></div>>
        <div id="light" class="modal">

        </div>

        .
        <script src="js/menu.js"></script>        


        <script src="js/insertarBD.js" type="text/javascript"></script>    
        <script src="js/descargarArchivos.js" type="text/javascript"></script>
        <script src="js/programaADMIN.js" type="text/javascript"></script>
        <script src="js/notificacionesADMIN.js" type="text/javascript"></script>     
        <script src="js/paginacion.js" type="text/javascript"></script>
        <script src="js/administrarUsuADMIN.js" type="text/javascript"></script>
        <script src="js/baseDatosADMIN.js" type="text/javascript"></script>
        <script src="js/navAdmin.js" type="text/javascript"></script>


        <script>
                        $(document).ready(function () {
                            $('#tipoProductoADMIN').load("buscadorProd/tipoPro");
                        })
        </script>

    </body>
</html>
