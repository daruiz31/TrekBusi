    <%-- 
    Document   : solicitarServicio
    Created on : 8/03/2016, 03:40:52 PM
    Author     : Diego RM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0" />
        <title>Solicitar servicio</title>
        <link rel="shortcut icon" href="imagenes/iconLogo64.png" type="image/png" />
        <link rel="stylesheet" href="fonts/style.css">
        <link rel="stylesheet" href="css/normalize.css" />
        <link rel="stylesheet" href="css/styles.css" />   
        <link href="css/scrollStyle.css" rel="stylesheet" type="text/css"/>
        <link href="fonts/stylesheetopensansSeflt.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="js/funciones.js" type="text/javascript"></script>     
        <script src="js/modalD.js" type="text/javascript"></script>
        <%
            if (session.getAttribute("usuario") == null) {
                response.sendRedirect("index.html#/popup");

            }
        %>
    </head>
    <body>
        <div id="fade" class="overlay"></div>

        <div id="modal2" class="modalContacto">
            <div class="modalCerrar" id="modlCerrar">
                <span><input type=image src="imagenes/msn/x.png" class="xModal" onclick="msnConctC()"></span>

            </div>
            <div class="mensajesContacto" id="msnCont">
                <img class="alertContc1" src="imagenes/msn/alert1.png" alt=""/><p id="respuestContacto" class="rptaCont"></p>
                <div class="inputContValue">
                    <div class="divValueCont"></div>
                    <p id="inputAlert"></p>


                </div>
            </div>
            <div class="mensajeFinal" id="msgEnd">
                <div class="msjFinalEstilo"></div>
                <p id="msgConctEnd"></p>
            </div>

        </div>

        <header class="header" id="idheader">
            <div class="bar-menu">
                <a><span class="icon-menu"></span></a>
            </div>
            <nav class="menu">
                
                <img id="logo-ing" src="imagenes/logo-ing.png" alt=""/>                
                <ul class="list">
                    <li><img class='logoGeneralInge' alt="" class="icon-house" class="icon" src="imagenes/logoinge.jpg" alt=""/></li>
                    <li><a href="indexlog.jsp" class="link-header"><img src="imagenes/internet.png" alt="" class="icon-house" class="icon">INICIO</a></li>
                    <li><a href="comprar-productos.jsp" class="link-header"><img src="imagenes/internet.png" alt="" class="icon-house" class="icon">COMPRAR PRODUCTOS</a></li>

                    <li class="option-menu">
                        <a class="padre-menu"><%=(String) session.getAttribute("usuario")%></a>
                    </li>
                    <li class="image-perfil-mod">
                        <a href="indexlog.jsp" class="perfil-image-mod"><img class="image-perfil" src="imagenes/avatar1.png" alt=""></a>
                    </li>
                </ul>	
            </nav>
        </header>

        <div class="bar-option hijo-menu">
            <ul class="bar-option-ul">
                         <%try {
                        HttpSession sesss = request.getSession();
                        int sess = (Integer) session.getAttribute("rol");

                        if (sess == 1 || sess == 4) {
                %><li id="cerrarSesion" class="options-menu-li"><a class="options-menu-perfil" href="nav-admin.jsp">Administrar</a></li> <%
                } if(sess != 1){
                    %><li class="options-menu-li"><a class="options-menu-perfil" href="nav-cliente.jsp">Opciones</a></li><%
                        }
                        if (sesss.getAttribute("producto1") != null || sesss.getAttribute("producto2") != null || sesss.getAttribute("producto3") != null || sesss.getAttribute("producto4") != null || sesss.getAttribute("producto5") != null || sesss.getAttribute("producto6") != null || sesss.getAttribute("producto7") != null || sesss.getAttribute("producto8") != null || sesss.getAttribute("producto9") != null && sess != 1) {
                    %><li id="cerrarSesion" class="options-menu-li"><a class="options-menu-perfil" href="solicitar-productos.jsp">Carrito</a></li> <%
                            }

                        } catch (NullPointerException exp) {

                        }%>
      
                <li class="options-menu-li"><a class="options-menu-perfil" href="cerrarSesion">Cerrar sesion</a></li>
            </ul>
        </div>
        
        

        <div class="solicitarServicioPosicion">

            <div class="seleccioneServ">
                <h2>Tipo de servicio:</h2>
                <select class="input_solicitarServ" id="tiposServicios" onchange="descripcion()"/>
            </div>


            
            <textarea style="margin-left: 10%; width: 52%;" id="descripcionD" class="descripcionD" placeholder="Descripcion breve" rows="5" maxlength="200"></textarea>
            <p id="describenosTuproblema">Describenos tu problema. </p><img class="wars" src="imagenes/msn/war1.png" alt=""/>
            
        </div>

                    <h2 class="fechaParaServicio">Fecha para el servicio:</h2>
        <input class="mod__input" id="fechaSolicitud" type="date" size="20" required/>






        <h2 class="title-description">Descripcion Del Servicio</h2>
        <p id="descripcion-tipo" class="text-description">Por favor seleccione la opcion que desea y nuestros tecnicos se comunicaron lo mas pronto posible para una mejor atencion.</p>



        <h2>Presupuesto Disponible</h2>
        <h1></h1> <input maxlength="9" id="presupuestoMin" class="mod__input" type="text" name="presu-max" onkeypress="ValidaSoloNumeros()" />
<input id="enviarSolicitud" class="enviarbut" type="submit" name="enviar-servicio" value="ENVIAR">  




        <ul class="list-items">
            <input style="margin-left: 20%;" id="aceptoTC" type="checkbox" name="aceptar-cond" size="12" required/> Acepto terminos y condiciones.
        </ul>

        
    </div>



    <script src="js/menu.js"></script>      

    <script type="text/javascript" src="js/jquery.popup.js"></script>
    <script src="js/fecha.js"></script>     
    <script>
            $(document).ready(function () {
                $('#tiposServicios').load("serviListar");
            })
    </script>
    <script>
        function descripcion() {
            var tipoServ = $('#tiposServicios').val();
            $('#descripcion-tipo').load("serviciosDescripcion", {tiposServicio: tipoServ});
        }
    </script>

    <script src="js/enviarSolicitud.js" type="text/javascript"></script>
</body>
</html>


