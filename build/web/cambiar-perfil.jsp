<%-- 
    Document   : cambiar-perfil
    Created on : 8/03/2016, 05:51:44 PM
    Author     : Sebastian Garzón
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0" />        
        <title><%=(String) session.getAttribute("usuario")%></title>
        <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/jquery.popup.css" type="text/css">
        <link rel="stylesheet" href="fonts/style.css">
        <link rel="stylesheet" href="css/normalize.css" />
        <link rel="stylesheet" href="css/styles.css" />
        
        <%
            if (session.getAttribute("usuario") == null) {
                response.sendRedirect("index.html");
            }
        %>
    </head>
    <body>
        <header class="header" id="idheader">
            <div class="bar-menu">
                <a><span class="icon-menu"></span></a>
            </div>
            <nav class="menu">
                <ul class="list">
                    <li><a href="indexlog.jsp" class="link-header"><img src="imagenes/internet.png" alt="" class="icon-house" class="icon">INICIO</a></li>

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
                <li class="options-menu-li"><a class="options-menu-perfil" href="nav-cliente.jsp">Perfil</a></li>
                <li class="options-menu-li"><a class="options-menu-perfil" href="cambiar-perfil.jsp">Configuración</a></li>
                <li class="options-menu-li"><a class="options-menu-perfil" href="cerrarSesion">Cerrar sesion</a></li>
            </ul>
        </div>
        <div class="header-regis">

            <section  class="registro">

                <h1 class="title-nuevo-perfil">Cambiar contrasena y Correo</h1>
                <div class="formulario">
                    <div class="list1">
                        <ul class="list-items">
                            <div class="nuevo-perfil">
                                <li>
                                    <input id="campo1" name="nombre" type="text" placeholder="Contrasena nueva"  class="mod__input" />
                                </li>
                                <li>
                                    <input id="campo2" name="NumeroC" type="text" placeholder="Repetir Contrasena"  class="mod__input"/>
                                </li>   
                                <li>               
                                    <input id="campo4" name="verpass" type="text" placeholder="Correo Nuevo" class="mod__input"/>
                                </li>
                                <li>
                                    <input id="campo5" name="email" type="text" placeholder="Repetir Correo" class="mod__input"/>
                                </li>
                            </div>
                            <div class="button-item">
                                <input class="enviarbut" type="submit" value="Enviar Formulario">
                                <input class="enviarbut" type="submit" value="Cambiar Imagen">
                            </div>
                        </ul>
                    </div>
                </div>
        </div>
    </section>

    
    <script src="js/menu.js"></script>

    
    <script type="text/javascript" src="js/jquery.popup.js"></script>

    <script type="text/javascript">
        $(function () {
            $(".js__p_start, .js__p_another_start").simplePopup();
        });

    </script>
</body>
</html>
