<%-- 
    Document   : indexlog
    Created on : 8/03/2016, 03:36:11 PM
    Author     : Diego Ruiz
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Inicio</title>
        <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="js/permisos.js" type="text/javascript"></script>
        <script type="text/javascript">
            nuevaSesion.iniciar();
        </script>
        <script src="js/validaciones.js" type="text/javascript"></script>
        <link rel="shortcut icon" href="imagenes/iconLogo64.png" type="image/png" />
        <link rel="stylesheet" href="css/jquery.popup.css" type="text/css">
        <link rel="stylesheet" href="fonts/style.css">	
        <link rel="stylesheet" href="css/normalize.css" />
        <link rel="stylesheet" href="css/styles.css" />     
        <link href="css/scrollStyle.css" rel="stylesheet" type="text/css"/>        
        <script src="js/funciones.js" type="text/javascript"></script>       
        <link href="fonts/stylesheetopensansSeflt.css" rel="stylesheet" type="text/css"/>
    </head>
    <body onload="imagenes()">
        <div id="fade" class="overlay"></div>
        <div id="light" class="modal">
            <div class="modalCerrar">
                <span><input type=image src="imagenes/msn/x.png" class="xModal" onclick="modalOcultar()"></span>

            </div>
            <div class="mapaContacto" id="mapContact">
                <label class="titulosModal1">Rampicentro</label>
                <label class="subTitulosModal1">Oficina 3 - 03</label>

                <p><iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2812.108799016295!2d-74.0734460810089!3d4.6079127466289584!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0000000000000000%3A0x4461cdbd0548d931!2sRAMPICENTRO!5e0!3m2!1ses!2sco!4v1463013623913" width="600" height="300" frameborder="0" style="border:0" allowfullscreen></iframe></p>
            </div>

        </div>
        <div id="modal2" class="modalContacto">
            <div class="modalCerrar">
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

        <img src="imagenes/camsegu2.jpg" alt="imagen1" id="miImagen" />       
        <header class="header" id="idheader">
            <div class="bar-menu">
                <a><span class="icon-menu"></span></a>
            </div>
            <nav class="menu">

                <ul class="list">
                    <li><img class="logoGeneralInge" src="imagenes/logoinge.jpg" alt=""/></li>
                    <li><a href="#header" class="link-header"><img src="imagenes/internet.png" alt="" class="icon-house" class="icon">INICIO</a></li>
                    
                    <li><a href="#services" class="section-services"><img src="imagenes/gear.png" alt="" class="icon-house" class="icon">SERVICIOS</a></li>
                    <li><a href="#products" class="link-products"><img src="imagenes/business.png" alt="" class="icon-house" class="icon">PRODUCTOS</a></li>
                    <li><a href="#somos" class="somos-link"><img src="imagenes/computer.png" alt="" class="icon-house" class="icon">QUIENES SOMOS</a></li>
                    <div class="list-item">
                    </div>

                    <li class="option-menu">
                        <a class="padre-menu"><%=(String) session.getAttribute("usuario")%></a>
                    </li>
                    <li class="image-perfil-mod">
                        <a href="indexlog.jsp" class="perfil-image-mod"><img id="avatarUser" class="image-perfil" src="imagenes/avatar1.png" alt=""></a>
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
                } if(sess != 1) {
                    %><li class="options-menu-li"><a class="options-menu-perfil" href="nav-cliente.jsp">Opciones</a></li><%
                        }
                        if (sesss.getAttribute("producto1") != null || sesss.getAttribute("producto2") != null || sesss.getAttribute("producto3") != null || sesss.getAttribute("producto4") != null || sesss.getAttribute("producto5") != null || sesss.getAttribute("producto6") != null || sesss.getAttribute("producto7") != null || sesss.getAttribute("producto8") != null || sesss.getAttribute("producto9") != null && sess != 1) {
                    %><li id="cerrarSesion" class="options-menu-li"><a class="options-menu-perfil" href="solicitar-productos.jsp">Carrito</a></li> <%
                            }

                        } catch (NullPointerException exp) {

                        }%>
                <li id="cerrarSesion" class="options-menu-li"><a class="options-menu-perfil" href="cerrarSesion">Cerrar sesion</a></li>

            </ul>
        </div>

        <div id="header" class="info-header info-header2">
            <h1 class="title-header"></h1>
            <p class="text-header">Somos <b id="ingearDIGI">INGEAR</b> la mejor respuesta a sus necesidades.
                Solicita ahora mismo la asesoría sobre nuestros productos y servicios.</p>
            
        </div>

        </section>    <section id="services" class="section-servicios">
            <h1 class="title-services">SERVICIOS</h1>
            <div class="container-services">
<!--                <div class="image-services">
                    <img src="imagenes/transporte.jpg" alt="" class="img__mod">
                </div>-->
                <div class="image-services">
                    <img src="imagenes/transporte.jpg" alt="" class="img__mod2">
                </div>
                <div class="info-services">
                    <h2 class="title-info-services">Nuestros servicios</h2>
                    <p class="text-services">Le asistimos técnicamente en MANTENIMIENTO PREVENTIVO-CORRECTIVO, a todo tipo de equipos 
                    y/o sistemas electrónicos de: IMPRESIÓN (Fotocopiadoras análogas y digitales, Impresoras de inyección, Plotter,
                    láser y matriz de punto) COMUNICACIÓN (Centrales de Citofonía, Centrales Telefónicas de oficina, faxes,
                    teléfonos inalámbricos y convencionales, montaje y readecuación de strip, ampliación de redes internas),
                    COMPUTACIÓN (PC’s, Redes estructuradas, Hardware, Software) SEGURIDAD (Circuito Cerrado de TV.,
                    Control de Acceso, Detección de Incendio, Alarma por Intrusión y/o robo);  lo que mantendrá sus estándares de
                    funcionalidad en el mejor nivel, reduciendo así retrasos en sus procesos de ejecución, producción, control y muestra
                    de resultado final.</p>
                    <br>




                    <button value="1" class="button-services" id="solicitudservicio" onclick="solicitudDe(this.id)">Accede para solicitar tu servicio</button>
                </div>

            </div>
        </section>
        
        
        
          <section id="products"class="section-products">
         
            <div class="info-products">
                <p class="text-products">Nuestros productos se entregan con la total confiabilidad y calidad hacia el usuario garantizandole la satisfaccion que se merece.</p>
            </div>            
            <button value="2" class="header-b js__p_start button-services button-mod-center" id="btnSoliciEstilo-p" onclick="solicitudDe(this.id)">Solicita tu producto</button>
             <div
                class="image-products">
                <img src="imagenes/camara.jpg" alt="" class="imgs__">
                <img src="imagenes/Tinta.jpg" alt="" class="imgs__">
                <img src="imagenes/impresora.jpg" alt="" class="imgs__">
                <img src="imagenes/ofimatico.jpg" alt="" class="imgs__">

            </div>
        </section>

    <section id="somos" class="section-somos">
            <h1 class="title-somos">QUIENES SOMOS</h1>
            <p class="text-somos"></p>
            <div class="textos-vision">
                <div class="info-vision">
                    <h3 class="title-info-vision">VISIÓN</h3>
                    <p class="text-infoCont">INGEAR, en el año 2020 estará consolidada y
                        posicionada como una de las 10 mejores empresas de la ciudad de 
                        Bogotá cuyo objeto social es el suministro de bienes y servicios 
                        en nivel tecnológico ejecutados en el ámbito de la contratación 
                        con entidades públicas y/o privadas.</p>
                     <h3 class="title-info-mision">MISIÓN</h3>
                    <p class="text-infoCont">con responsabilidad, seriedad y honestidad al momento de 
                        intervenir un equipo o sistema y/o perfeccionar un contrato, otorga soluciones 
                        calificadas e idóneas con excelente asesoría y un servicio ágil y 
                        oportuno a nuestros clientes, lo que garantizará tanto en el presente
                        como en el futuro inmediato, estabilidad y perfecto funcionamiento a sus 
                        equipos de IMPRESIÓN, COMUNICACIÓN, COMPUTACION Y SEGURIDAD.</p>
                </div>
                
            </div>
           
        </section>
        
        <br/>
        <br/>
        
        <div class="proveedores">
            
            <label class="distriAuto">Distribuidor autorizado</label>
            <img src="imagenes/proveedores/ricoh.png" alt=""/>
            <img src="imagenes/proveedores/samsumg.png" alt=""/>
            <img src="imagenes/proveedores/toshi.jpg" alt=""/>
            <img src="imagenes/proveedores/elvovo.jpg" alt=""/>
            <img src="imagenes/proveedores/hp.png" alt=""/>
        </div>

        <footer>

            <div class="title-footer">
                <button id="contactanosocultar" class="ContIndex" value="2" onclick="mostrarContactenos(this.id)">Contáctenos</button><button id="contactanosmostrar" class="ContIndex" value="1" onclick="mostrarContactenos(this.id)">Contáctenos</button>
            </div>

            <div id="footerOcultoIndex">

                <div class="formulario-footer1">
                    <p class="titulos-footer2"><label class="labelContact">Nombre</label>
                        <input maxlength="20" id="contactoNombre" type="text" name="nombre-footer" class="cajasfooter" placeholder="*Nombre" onkeypress="return validar(event)"  required />
                    </p>
                    <p class="titulos-footer2"><label class="labelContact">Apellido</label>
                        <input maxlength="20" id="contactoApellido" type="text" name="apellido-footer" class="cajasfooter" placeholder="*Apellido" onkeypress="return validar(event)" required />
                    </p>


                    <p class="titulos-footer2"><label class="labelContact">Teléfono</label>
                        <input maxlength="10"  id="contactoTelefono" type="text" name="telefono-footer" class="cajasfooter" placeholder="*Teléfono" onkeypress="ValidaSoloNumeros()" required />
                    </p>
                    <p  class="titulos-footer2">&nbsp;&nbsp;<label class="labelContact">Asunto</label>
                        <input maxlength="50" id="contactoAsunto" type="text" name="asunto-footer" class="cajasfooter" placeholder="*Asunto" required />    
                    </p>
                </div>
                <div class="formulario-footer2">
                    <p class="titulos-footer2"><label class="labelContact">Correo</label>
                        <input maxlength="30" id="contactoCorreo" type="email" name="correo" class="cajasfooter" placeholder="*Correo Electronico" required />
                    </p>

                    <p class="titulos-footer2"><label class="labelContact2">Descripción</label>
                        <textarea id="contactoDescripcion" name="description"  class="areaContact" placeholder="Agrega una descripcion"></textarea>
                    </p>

                    1+1= <input maxlength="5" type="number" id="validacionContacto" onkeypress="ValidaSoloNumeros()"/>


                    <input onclick="clickHere()" type="submit" name="enviar-footer" class="contacto-footer" id="footerEnviar">
                </div>
                <div class="formulario-footer3">

                    <label class="infoContact"><u>Ing. Luis F. Pinzón</u></label>
                    <br/>
                    <label class="infoContact">PBX: 6066777</label>
                    <br/>
                    <label class="infoContact">Cra. 10 #20-39, Bogotá</label>
                    <label class="infoContact">Oficina 3-03 <a class="verMapa" onclick="modalMostrar()">Ver mapa</a></label>

                </div>
            </div>




        </footer>
        <div class="logoTrekConct"><img src="imagenes/logo2.png" alt=""/>&REG;</div>




        <script src="js/jquery.slides.js" type="text/javascript"></script>
        <script>
                        (function () {
                            $(".image-products").slidesjs({
                            });
                        })();
        </script>


        <script src="js/menu.js"></script>



        <script type="text/javascript" src="js/jquery.popup.js"></script>
        <script src="js/modalD.js" type="text/javascript"></script>
        <script src="js/contacto.js" type="text/javascript"></script>
        <script type="text/javascript">
                        $(function () {
                            $(".js__p_start, .js__p_another_start").simplePopup();
                        });

        </script>
    </body>
</html>


