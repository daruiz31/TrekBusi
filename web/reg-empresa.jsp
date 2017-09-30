<%-- 
    Document   : reg-empresa
    Created on : 10/04/2016, 01:37:57 PM
    Author     : Diego RM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0" />
        <title>Registro cliente</title>
        <link rel="shortcut icon" href="imagenes/iconLogo64.png" type="image/png" />
        <link rel="stylesheet" href="css/jquery.popup.css" type="text/css">
        <link rel="stylesheet" href="fonts/style.css">
        <link rel="stylesheet" href="css/font-awesome-4.5.0/css/font-awesome.css">
        <link rel="stylesheet" href="css/normalize.css" />
        <link rel="stylesheet" href="css/styles.css" />
        <link href="fonts/stylesheetopensansSeflt.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="js/modalD.js" type="text/javascript"></script>


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
                <img class='logoGeneralInge' src="imagenes/logoinge.jpg" alt=""/>
                <ul class="list">
                    <li><img class='logoGeneralInge' alt="" class="icon-house" class="icon" src="imagenes/logoinge.jpg" alt=""/></li>                    
                    <li><a href="index.html" class="link-header"><img src="imagenes/internet.png" alt="" class="icon-house" class="icon">VOLVER</a></li>
                    <div class="list-item">
                        <li class="item-hover"><a class="header-b js__p_start" href="">Acceder</a></li>
                        <li class="item-hover"><a class="header-b js__p_another_start" href="">Registrarme</a></li>
                    </div>
                    </li>
                </ul>	
            </nav>
        </header>       


        <div class="modal-container">


            <div class="p_body js__p_body js__fadeout"></div>

            <div class="popup js__popup js__slide_top">
                <a href="#" class="p_close js__p_close" title="Cerrar">
                    <span></span><span></span>
                </a>              
                <div class="p_contentLogin">
                    <p class="inicioTextSesion">Iniciar sesión</p>

                </div>

                <div class="correoLogin">
                    <label class="loginLabel">Correo:</label><label class="rtaLoginF" id="rtaLoginFC"></label>
                    <p class="parrafoLogin"><img class="imgsLogin" src="imagenes/msn/emial.png" alt=""/>  <input id="correoLogin" name="correo" type="email" placeholder="Correo"  class="input-registro" required    /> </p>

                </div>

                <div class="contraLogin">
                    <label class="loginLabel">Contraseña:  </label><label class="rtaLoginF" id="rtaLoginFT"></label>
                    <p class="parrafoLogin"><img class="imgsLogin" src="imagenes/msn/key1.png" alt=""/>  <input id="passLogin" name="contraseñareg" type="password" placeholder="Contraseña" required/></p>
                </div>
                <div class="buttonLogin">
                    <button id="btnIniciar" class="send-button__regis">Entrar</button>
                </div>
                <img src="imagenes/logo2.png" alt="" id="logoTrekBusi"/>
            </div>

            <div class="popup js__another_popup js__slide_top">
                <a href="#" class="p_close js__p_close" title="Закрыть">
                    <span></span><span></span>
                </a>
                <div class="p_contentLogin">
                    <p class="inicioTextSesion">Registratre como</p>
                </div>

                <div class="registrateComo">
                    <div class="image image1">
                        <span class="mod-icons-reg"><i class="fa fa-user"></i></span>
                    </div>
                    <div class="image image2">
                        <span class="mod-icons-reg"><i class="fa fa-building"></i></span>
                    </div>
                    <div class="button-modal">
                        <button class="button-content__modal"><a class="link-modal" href="reg-cliente.jsp">Cliente</a></button>
                        <button class="button-content__modal mod__button2"><a  class="link-modal" href="reg-empresa.jsp">Empresa</a></button>
                    </div>
                </div>
            </div>
        </div>

        <section  class="registro">
            <br>
            <br>
            <h1 class="title-registro"><b>Registrate como empresa</b></h1>
            <div class="formulario">
                <div class="list1">
                    <ul class="list-items list-items-mod1">
                        <center>
                            <p id="validacionClie"></p>

                            <p id="validacionClie2"></p>
                        </center>
                        <div class="list-mod-li"><li>
                                <p><label class="Label">Razón social: </label></p> 
                                <input maxlength="30" id="txtnombre1" name="nombre1" type="text" placeholder="Razón Social"  class="mod__input" required onkeypress="return validar(event)" autofocus/>
                            </li>
                            <li>
                                <p><label class="Label">Nombre Contacto: </label></p>
                                <input maxlength="20" id="txtnombre2" name="Nombre2" type="text" placeholder="Nombre Contacto"  class="mod__input" onkeypress="return validar(event)" />
                            </li>
                            <li>
                                <p><label class="Label">Apellido Contacto: </label></p>
                                <input maxlength="20" id="txtapellido1" name="Apellido1" type="text" placeholder="Apellido Contacto"  class="mod__input" onkeypress="return validar(event)" required/>
                            </li>
                        </div>
                        <div class="list-mod-li">
                            <li>               
                                <p><label class="Label">Código de empresa(Nit): </label></p>
                                <input maxlength="20" id="txtdocumento" name="DocIdentity" type="text" placeholder="Nit" class="mod__input" onkeypress="return numeros(nu)" required/>
                            </li>
                            <li>               
                                <p><label class="Label">Repetir (Nit): </label></p>
                                <input maxlength="20" id="txtRdocumento" name="DocIdentity" type="text" placeholder="Nit" class="mod__input" onkeypress="return numeros(nu)" required/>
                            </li>
                            <li>
                                <p><label class="Label">Contraseña: </label></p>
                                <input maxlength="30" id="txtcontra" name="passWord" type="password" placeholder="Contraseña" class="mod__input" required />
                            </li></div>
                        <div class="list-mod-li"><li>
                                <p><label class="Label">Repetir contraseña: </label></p>
                                <input maxlength="30" id="txtVcontra" name="Vcontra" type="password" placeholder="Verificar contraseña" class="mod__input" onfocus="activarBoton()" required />
                            </li>
                            <li>
                                <p><label class="Label">Correo: </label></p>
                                <input maxlength="50" id="txtcorreo" name="Correo" type="email" placeholder="Correo" class="mod__input" required/>
                            </li>
                            <li>
                                <p><label class="Label">Repetir correo: </label></p>
                                <input maxlength="50" id="txtVcorreo" name="Vcorreo" type="email" placeholder="Verificar Correo" class="mod__input" onfocus="activarBoton()" required/>
                            </li>
                        </div>
                        <div class="list-mod">
                            <li>   
                                <p><label class="Label">Direccion Empresa: </label></p>
                                <input maxlength="50" id="txtdireccion" name="direccion" type="text" placeholder="Direccion" class="mod__input" required />
                            </li>
                            <li>
                                <p><label class="Label">Telefono Contacto: </label></p>
                                <input maxlength="15" id="txttelefono" name="telefono" type="text" placeholder="Telefono" class="mod__input" onkeypress="ValidaSoloNumeros()" required/>
                            </li> 
                            <li>
                                <p><label class="Label">Respuesta seguridad: </label></p>
                                <input maxlength="50" id="respuestaSegu" name="respuestaSeg" type="text" placeholder="Respuesta seguridad" class="mod__input" onfocus="descripcionPregu()"/>

                            </li>
                        </div>
                        <div class="list-mod">

                            <p id="infoRt"></p>
                        </div>
                        <div class="list-mod">                     
                            <li>
                                <p><label class="Label">Pais: </label></p>
                                <select class="mod__input" id="paisSel" onchange="ciudadSelect()"/>
                                </select>

                            </li>
                            <li>
                                <p><label class="Label">Ciudad: </label></p>
                                <select class="mod_input" id="ciudadSel"/>
                                </select>
                            </li>

                        </div>


                    </ul>  
                    <div class="button-item2">
                        <input id="registroEmpresa" class="enviarbut" type="submit" value="Enviar">

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
        <script src="js/usuarioLogin.js" type="text/javascript"></script>
        <script src="js/validaciones.js" type="text/javascript"></script>
        <script src="js/registrarUser.js" type="text/javascript"></script>
        <script src="js/funciones.js" type="text/javascript"></script>
    </body>
</html>

