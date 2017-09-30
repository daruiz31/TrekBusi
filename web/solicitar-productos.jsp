<%-- 
    Document   : solicitar-productos
    Created on : 16-abr-2016, 13:21:19
    Author     : Diego RM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0" />
    <title>Validar compras</title>
    <link rel="shortcut icon" href="imagenes/iconLogo64.png" type="image/png" />


    <link rel="stylesheet" href="fonts/style.css">
    <link rel="stylesheet" href="css/font-awesome-4.5.0/css/font-awesome.css">
    <link rel="stylesheet" href="css/normalize.css" />
    <link rel="stylesheet" href="css/styles.css" />       
    <link href="fonts/stylesheetopensansSeflt.css" rel="stylesheet" type="text/css"/>
    <link href="css/scrollStyle.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>    

    <script src="js/solicitarProductos.js" type="text/javascript"></script>
    <script src="js/modalD.js" type="text/javascript"></script>
    <%
        if (session.getAttribute("usuario") == null) {
            response.sendRedirect("index.html#/popup");
        }
        if (session.getAttribute("producto1") == null && session.getAttribute("producto2") == null && session.getAttribute("producto3") == null && session.getAttribute("producto4") == null && session.getAttribute("producto5") == null && session.getAttribute("producto6") == null && session.getAttribute("producto7") == null && session.getAttribute("producto8") == null && session.getAttribute("producto9") == null) {
            response.sendRedirect("comprar-productos.jsp");
        }
    %>      



</head>
<body>
    <div id="fade" class="overlay"></div>

    <div id="modal2" class="modalContacto">
        <div class="modalCerrar" id="modlCerrar">

            <span><input type=image src="imagenes/msn/x.png" class="xModal" id="cerrarNormal" onclick="msnConctC()"></span>
            <span><input type=image src="imagenes/msn/x.png" class="xModal" id="cerrarReload" onclick="closeReloadSolip()"></span>

        </div>
        <div class="mensajesOpcion" id="msnContOp">
            <p id="respuestContacto" class="rptaCont"></p>
            <div class="inputContValue">
                <div class="divValueBtn1"></div>
                <div class="divValueBtn2"></div>
                <p id="inputAlert"></p>


            </div>
        </div>

        <div class="mensajeFinal" id="msgEnd">
            <div class="msjFinalEstilo"></div>
            <p id="msgConctEnd"></p>
        </div>
        <div class="mensajeAlquiler" id="alquilarDatos">

            <p class="alquilerFechas">Inicio Alquiler:<input class="" id="fechaSolicitud1" type="date" size="20" required/></p>

            <p class="alquilerFechas">Fin Alquiler:<input class="" id="fechaSolicitud2" type="date" size="20" required/></p>

            <input id="solicitarProductosFINAL" class="btnAlquilerFinal" type="submit" name="enviar-producto" value="ALQUILAR" onclick="alquilarFinal()">
            <p id="fechaRespuestAlquiler"></p>
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
                <li><a href="comprar-productos.jsp" class="link-header"><img src="imagenes/internet.png" alt="" class="icon-house" class="icon">COMPRAR PRODUCTO</a></li>                
                <li><a href="solicitarServicio.jsp" class="link-header"><img src="imagenes/internet.png" alt="" class="icon-house" class="icon">SOLICITAR SERVICIO</a></li>

                <li class="option-menu">
                    <a class="padre-menu"><%=(String) session.getAttribute("usuario")%></a>
                </li>
                <li class="image-perfil-mod">
                    <a href="index.html" class="perfil-image-mod"><img class="image-perfil" src="imagenes/avatar1.png" alt=""></a>
                </li>
            </ul>	
        </nav>
    </header>
    <div class="bar-option hijo-menu">
        <ul class="bar-option-ul">
            <%try {
                    int sess = (Integer) session.getAttribute("rol");

                    if (sess == 1 || sess == 4) {
            %><li id="cerrarSesion" class="options-menu-li"><a class="options-menu-perfil" href="nav-admin.jsp">Administrar</a></li> <%
                }
                if (sess != 1) {
                %><li class="options-menu-li"><a class="options-menu-perfil" href="nav-cliente.jsp">Opciones</a></li><%
                        }

                    } catch (NullPointerException exp) {
                        
                    }%>
            <li class="options-menu-li"><a class="options-menu-perfil" href="cerrarSesion">Cerrar sesión</a></li>
        </ul>
    </div>
    <!-- ################################################################################
                                    
    <!-- Popup Ficha <-->

    <div class="header-regis">
        <nav>
            <ul class="registro-items">
                <li class="registro-names registro-names-repeat1">
                    <a class="header-b js__p_another_start" >Login</a>
                </li>
                <li class="registro-names registro-names-repeat2 ">
                    <a class="header-b js__p_start" >Sign up</a>
                </li>
            </ul>
        </nav>
    </div>

    <div class="modal-container">



        <div class="popup js__another_popup js__slide_top">
            <a href="#" class="p_close js__p_close" title="Закрыть">
                <span></span><span></span>
            </a>

            <div class="p_content" id="fichaTecPOPUD">

                <!-- Ficha Técnica -->
                <h1 class="title-modal-buy">Ficha Técnica</h1>

                <div class="info-modal-buy">

                    <h5 id="buy-tiProduc" class="title-ftec">Tipo de producto:</h5>
                    <p id="rta-tiProduc" class="fTenicaPro"></p>
                    <h5 id="buy-marca" class="title-ftec">Marca:</h5>
                    <p id="rta-marca" class="fTenicaPro"></p>
                    <h5 id="buy-referencia" class="title-ftec">Referencia:</h5>
                    <p id="rta-referencia" class="fTenicaPro"></p>
                    <h5 id="buy-capacidad" class="title-ftec">Capacidad:</h5>
                    <p id="rta-capacidad" class="fTenicaPro"></p>
                    <h5 id="buy-descripcion" class="title-ftec">Descripcion:</h5>
                    <p id="rta-descripcion" class="fTenicaPro"></p>
                    <h5 id="buy-estado" class="title-ftec">Estado:</h5>
                    <p id="rta-estado" class="fTenicaPro"></p>

                </div>
            </div>

        </div>

        <!-- Barra contadora -->
        <div class="info-header-buy">        
            <div class="info-buy-rigth">
                <i class="fa fa-cart-arrow-down"></i>
                <span class="total">Total: $<label style="color: green;" id="totalAgregado">000</label>                   

                </span>

                <br/>


            </div>

            <input id="solicitarProductosFINAL" class="enviarbut2" type="submit" name="enviar-producto" value="COMPRAR" onclick="comprarFinal()">
            <input id="solicitarProductosFINAL" class="enviarbut3" type="submit" name="enviar-producto" value="ALQUILAR" onclick="modalAlquilerVer()">

        </div>
    </div>	


    <!-- Visor de productos -->

    <section class="products-buy" style="margin-top: 12%;">
        <div class="container-buy">
            <div class="containerbuy-mod">
                <div class="title-buy">
                    <div class="products-buy-images">
                        <div class="category1">
                            <div class="item-product-buy" id="agregado1">
                                <img id="imgPro1">
                                <div class="info-product-buy">
                                    <h4 id="nombrePro1" class="title-info-product"></h4> <h4 id="precioU1" class="precioU"></h4><h6 id="secuD1" class="precioUS"></h6>

                                    <button id="btnAgregarC1" class="btnsProducts" value="1" title="Remover del carrito de compras" onclick="eliminarCarritoMd(this.id)">Remover</button>
                                </div>
                            </div>
                            <div class="item-product-buy" id="agregado2">
                                <img id="imgPro2">
                                <div class="info-product-buy">
                                    <h4 id="nombrePro2" class="title-info-product"> </h4><h4 id="precioU2" class="precioU"></h4><h6 id="secuD2" class="precioUS"></h6>

                                    <button id="btnAgregarC2" class="btnsProducts" value="2" title="Agregar del carrito de compras" onclick="eliminarCarritoMd(this.id)">Remover</button>

                                </div>
                            </div>
                            <div class="item-product-buy" id="agregado3">
                                <img id="imgPro3">
                                <div class="info-product-buy">
                                    <h4 id="nombrePro3" class="title-info-product"></h4><h4 id="precioU3" class="precioU"></h4><h6 id="secuD3" class="precioUS"></h6>

                                    <button id="btnAgregarC3" class="btnsProducts" value="3" title="Remover del carrito de compras" onclick="eliminarCarritoMd(this.id)">Remover</button>
                                </div>
                            </div>
                        </div>
                        <div class="category2">
                            <div class="item-product-buy" id="agregado4">
                                <img id="imgPro4"/>
                                <div class="info-product-buy">
                                    <h4 id="nombrePro4" class="title-info-product"> </h4><label><h4 id="precioU4" class="precioU"> </h4><h6 id="secuD4" class="precioUS"></h6>

                                        <button id="btnAgregarC4" class="btnsProducts" value="4" title="Remover del carrito de compras" onclick="eliminarCarritoMd(this.id)">Remover</button>
                                </div>
                            </div>
                            <div class="item-product-buy" id="agregado5">
                                <img id="imgPro5"/>
                                <div class="info-product-buy">
                                    <h4 id="nombrePro5" class="title-info-product"></h4><h4 id="precioU5" class="precioU"> </h4><h6 id="secuD5" class="precioUS"></h6>

                                    <button id="btnAgregarC5" class="btnsProducts" value="5" title="Remover del carrito de compras" onclick="eliminarCarritoMd(this.id)">Remover</button>
                                </div>
                            </div>
                            <div class="item-product-buy" id="agregado6">
                                <img id="imgPro6" alt="">
                                <div class="info-product-buy">
                                    <h4 id="nombrePro6" class="title-info-product"></h4><h4 id="precioU6" class="precioU"> </h4><h6 id="secuD6" class="precioUS"></h6>

                                    <button id="btnAgregarC6" class="btnsProducts" value="6" title="Remover carrito de compras" onclick="eliminarCarritoMd(this.id)">Remover</button>
                                </div>
                            </div>
                        </div>
                        <div class="category3">
                            <div class="item-product-buy" id="agregado7">
                                <img id="imgPro7" alt="">
                                <div class="info-product-buy">
                                    <h4 id="nombrePro7" class="title-info-product"></h4><h4 id="precioU7" class="precioU"> </h4><h6 id="secuD7" class="precioUS"></h6>

                                    <button id="btnAgregarC7" class="btnsProducts" value="7" title="Remover del carrito de compras" onclick="eliminarCarritoMd(this.id)">Remover</button>
                                </div>
                            </div>
                            <div class="item-product-buy" id="agregado8">
                                <img id="imgPro8"/>
                                <div class="info-product-buy">
                                    <h4 id="nombrePro8" class="title-info-product"></h4><h4 id="precioU8" class="precioU"> </h4><h6 id="secuD8" class="precioUS"></h6>

                                    <button id="btnAgregarC8" class="btnsProducts" value="8" title="Remover del carrito de compras" onclick="eliminarCarritoMd(this.id)">Remover</button> 
                                </div>
                            </div>
                            <div class="item-product-buy" id="agregado9">
                                <img id="imgPro9"/>
                                <div class="info-product-buy" >
                                    <h4 id="nombrePro9" class="title-info-product"></h4><h4 id="precioU9" class="precioU"> </h4><h6 id="secuD9" class="precioUS"></h6>

                                    <button id="btnAgregarC9" class="btnsProducts" value="9" title="Remover del carrito de compras" onclick="eliminarCarritoMd(this.id)">Remover</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </section>

    <script src="js/menu.js"></script>


    <script type="text/javascript" src="js/jquery.popup.js"></script>
    <script src="js/fecha.js">
    </script>
    <script type="text/javascript">
        $(document).ready(function () {
            listarAgregados.iniciar();
        })
    </script>

    <script src="js/fecha.js">
    </script>                   

</body>
</html>
