<%-- 
    Document   : comprar-productos
    Created on : 8/03/2016, 03:39:26 PM
    Author     : Sebastian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />    
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0" />
        <title>Comprar productos</title>
        <link rel="shortcut icon" href="imagenes/iconLogo64.png" type="image/png" />
        <link href="fonts/stylesheetopensansSeflt.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/jquery.popup.css" type="text/css">
        <link rel="stylesheet" href="fonts/style.css">
        <link rel="stylesheet" href="css/font-awesome-4.5.0/css/font-awesome.css">
        <link rel="stylesheet" href="css/normalize.css" />
        <link rel="stylesheet" href="css/styles.css" />        
        <link href="css/scrollStyle.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="js/modalD.js" type="text/javascript"></script>
        <script src="js/productos.js" type="text/javascript"></script>

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

        </div>
        <header class="header" id="idheader">
            <div class="bar-menu">
                <a><span class="icon-menu"></span></a>
            </div>
            <nav class="menu">
                <ul class="list">
                    <li><a href="indexlog.jsp" class="link-header"><img src="imagenes/internet.png" alt="" class="icon-house" class="icon">INICIO</a></li>
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
                        HttpSession sesss = request.getSession();
                        int sess = (Integer) session.getAttribute("rol");

                        if (sess == 1 || sess == 4) {
                %><li id="cerrarSesion" class="options-menu-li"><a class="options-menu-perfil" href="nav-admin.jsp">Administrar</a></li> <%
                    }
                    if (sess != 1) {
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
    </div>
    <div class="modal-container">



        <div class="popup js__another_popup js__slide_top">
            <a href="#" class="p_close js__p_close" title="Закрыть">
                <span></span><span></span>
            </a>

            <div class="p_content">

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

        <section class="sol-service">
            <div class="info-header-buy">
                <div class="mod-info-buy">
                    <a><span class="fa fa-bars"></span></a>
                    <h2 class="title-info-header-buy">SOLICITA TUS PRODUCTOS <a href="solicitar-productos.jsp" class="lickSolicitarPro">AQUÍ</a></h2>
                    <span style="margin-left: 10%;">
                        <button id="produc-Atras" value="1" onclick="atrasProducto(this.id)">Anterior</button><button id="produc-Atras2" value="2" onclick="atrasProducto(this.id)">Anterior</button><button id="produc-Siguiente" value="1" onclick="siguienteProducto(this.id)">Siguiente</button><button id="produc-Siguiente2" value="2" onclick="siguienteProducto(this.id)">Siguiente</button>
                    </span>
                    <div class="info-buy-rigth">
                        <i class="fa fa-cart-arrow-down"></i>
                        <span class="total">Total: $<label style="color: green;" id="totalAgregado">000</label>                   

                        </span>
                    </div>
                </div>
                <br/>


            </div>



            <!-- Navegador de busqueda -->

            <nav id="admin-menu" class="menuad">
                <div class="menu-half">
                    <ul class="menu-combos menu-combos-mod">
                        <li class="menu-admin-items">
                            <h5 class="title-nav-admin">TIPO DE PRODUCTO</h5>

                            <select id="tipoProBuscProducto" class="bucProduct" onchange="">

                            </select>

                        </li>
                        <li class="menu-admin-items">
                            <h5 class="title-nav-admin">MARCA</h5>

                            <select id="marcaBuscProducto" class="bucProduct" onchange="">

                            </select>

                        </li>                                
                        <li class="menu-admin-items">
                            <h5 class="title-nav-admin">REFERENCIA</h5>

                            <select id="referenciaBuscProducto" class="bucProduct" onchange="">

                            </select>                                    
                        </li>

                        <li class="menu-admin-items button-item">
                            <form action="solicitar-productos.jsp" method="POST">
                                <input id="solicitarProductos" class="enviarbut" type="submit" name="enviar-producto" value="Solicitar">
                            </form>
                        </li>

                    </ul>
                </div>
            </nav>
    </div>
</div>	
</section>

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
                                <button id="btnFichatecnica1" type="button" name="fichaTenica" value="1" class="btnsProducts header-b js__p_another_start" onclick="fichaTecnica(this.id)">Ficha Técnica</button>
                                <button id="btnAgregarC1" class="btnsProducts" value="1" title="Agregar al carrito de compras" onclick="agregarCarrito(this.id)">Agregar</button>
                            </div>  
                        </div>
                        <div class="item-product-buy" id="agregado2">
                            <img id="imgPro2">
                            <div class="info-product-buy">
                                <h4 id="nombrePro2" class="title-info-product"> </h4><h4 id="precioU2" class="precioU"></h4><h6 id="secuD2" class="precioUS"></h6>
                                <button id="btnFichatecnica2" type="button" name="fichaTenica" value="2" class="btnsProducts header-b js__p_another_start" onclick="fichaTecnica(this.id)">Ficha Técnica</button>
                                <button id="btnAgregarC2" class="btnsProducts" value="2" title="Agregar al carrito de compras" onclick="agregarCarrito(this.id)">Agregar</button>

                            </div>
                        </div>
                        <div class="item-product-buy" id="agregado3">
                            <img id="imgPro3">
                            <div class="info-product-buy">
                                <h4 id="nombrePro3" class="title-info-product"></h4><h4 id="precioU3" class="precioU"></h4><h6 id="secuD3" class="precioUS"></h6>
                                <button id="btnFichatecnica3" type="submit" value="3" class="btnsProducts header-b js__p_another_start" onclick="fichaTecnica(this.id)">Ficha Técnica</button>
                                <button id="btnAgregarC3" class="btnsProducts" value="3" title="Agregar al carrito de compras" onclick="agregarCarrito(this.id)">Agregar</button>
                            </div>
                        </div>
                    </div>
                    <div class="category2">
                        <div class="item-product-buy" id="agregado4">
                            <img id="imgPro4"/>
                            <div class="info-product-buy">
                                <h4 id="nombrePro4" class="title-info-product"> </h4><h4 id="precioU4" class="precioU"> </h4><h6 id="secuD4" class="precioUS"></h6>
                                    <button id="btnFichatecnica4" type="submit" value="4" class="btnsProducts header-b js__p_another_start" onclick="fichaTecnica(this.id)">Ficha Técnica</button>
                                    <button id="btnAgregarC4" class="btnsProducts" value="4" title="Agregar al carrito de compras" onclick="agregarCarrito(this.id)">Agregar</button>
                            </div>
                        </div>
                        <div class="item-product-buy" id="agregado5">
                            <img id="imgPro5"/>
                            <div class="info-product-buy">
                                <h4 id="nombrePro5" class="title-info-product"></h4><h4 id="precioU5" class="precioU"> </h4><h6 id="secuD5" class="precioUS"></h6>
                                <button id="btnFichatecnica5" type="submit" value="5" class="btnsProducts header-b js__p_another_start" onclick="fichaTecnica(this.id)">Ficha Técnica</button>
                                <button id="btnAgregarC5" class="btnsProducts" value="5" title="Agregar al carrito de compras" onclick="agregarCarrito(this.id)">Agregar</button>
                            </div>
                        </div>
                        <div class="item-product-buy" id="agregado6">
                            <img id="imgPro6" alt="">
                            <div class="info-product-buy">
                                <h4 id="nombrePro6" class="title-info-product"></h4><h4 id="precioU6" class="precioU"> </h4><h6 id="secuD6" class="precioUS"></h6>
                                <button id="btnFichatecnica6" type="submit" value="6" class="btnsProducts header-b js__p_another_start" onclick="fichaTecnica(this.id)">Ficha Técnica</button>
                                <button id="btnAgregarC6" class="btnsProducts" value="6" title="Agregar al carrito de compras" onclick="agregarCarrito(this.id)">Agregar</button>
                            </div>
                        </div>
                    </div>
                    <div class="category3">
                        <div class="item-product-buy" id="agregado7">
                            <img id="imgPro7" alt="">
                            <div class="info-product-buy">
                                <h4 id="nombrePro7" class="title-info-product"></h4><h4 id="precioU7" class="precioU"> </h4><h6 id="secuD7" class="precioUS"></h6>
                                <button id="btnFichatecnica7" type="submit" value="7" class="btnsProducts header-b js__p_another_start" onclick="fichaTecnica(this.id)">Ficha Técnica</button>
                                <button id="btnAgregarC7" class="btnsProducts" value="7" title="Agregar al carrito de compras" onclick="agregarCarrito(this.id)">Agregar</button>
                            </div>
                        </div>
                        <div class="item-product-buy" id="agregado8">
                            <img id="imgPro8"/>
                            <div class="info-product-buy">
                                <h4 id="nombrePro8" class="title-info-product"></h4><h4 id="precioU8" class="precioU"> </h4><h6 id="secuD8" class="precioUS"></h6>
                                <button id="btnFichatecnica8" type="submit" value="8" class="btnsProducts header-b js__p_another_start" onclick="fichaTecnica(this.id)">Ficha Técnica</button>
                                <button id="btnAgregarC8" class="btnsProducts" value="8" title="Agregar al carrito de compras" onclick="agregarCarrito(this.id)">Agregar</button> 
                            </div>
                        </div>
                        <div class="item-product-buy" id="agregado9">
                            <img id="imgPro9"/>
                            <div class="info-product-buy">
                                <h4 id="nombrePro9" class="title-info-product"></h4><h4 id="precioU9" class="precioU"> </h4><h6 id="secuD9" class="precioUS"></h6>
                                <button id="btnFichatecnica9" type="submit" value="9" class="btnsProducts header-b js__p_another_start" onclick="fichaTecnica(this.id)">Ficha Técnica</button>
                                <button id="btnAgregarC9" class="btnsProducts" value="9" title="Agregar al carrito de compras" onclick="agregarCarrito(this.id)">Agregar</button>
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


<script src="js/fecha.js">
</script>                   

<script type="text/javascript">
    $(document).ready(function () {
        listarProductos.iniciar();
    })

</script>
<script>
    $(document).ready(function () {
        $('#tipoProBuscProducto').load("buscadorProd/tipoPro");
    })
</script>
<script>
    $(document).ready(function () {
        $('#marcaBuscProducto').load("buscadorProd/marca");
    })
</script>
<script>
    $(document).ready(function () {
        $('#referenciaBuscProducto').load("buscadorProd/referencia");
    })
</script>

</body>
</html>
