/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkbi.vistas;

import com.google.gson.Gson;
import com.tkbi.controladores.controlProductos;
import com.tkbi.utilidades.RespuestaProductos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tkbi.DAO.alquilerDAO;
import tkbi.DAO.solicitudProductoDAO;
import tkbi.VO.productoVO;

/**
 *
 * @author Diego RM
 */
@WebServlet(name = "comprarProductos", urlPatterns = {"/comprarProductos/comprar", "/comprarProductos/listar", "/comprarProductos/insertar", "/comprarProductos/alquilar", "/comprarProductos/eliminar"})
public class comprarProductos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession sesionNueva = request.getSession(false);
            String rutaServlet = request.getRequestURI();
            String accion = rutaServlet.substring(rutaServlet.lastIndexOf("/") + 1);
            RespuestaProductos respuesta = new RespuestaProductos();

            String productos = "Productos";

            switch (accion) {
                case "comprar":
                    String buyPro = request.getParameter("iSeguD");
                    String numeroItm = request.getParameter("numItem");
                    int contItem = Integer.parseInt(numeroItm);
                    String agg1 = (String) sesionNueva.getAttribute("producto1");
                    String agg2 = (String) sesionNueva.getAttribute("producto2");
                    String agg3 = (String) sesionNueva.getAttribute("producto3");
                    String agg4 = (String) sesionNueva.getAttribute("producto4");
                    String agg5 = (String) sesionNueva.getAttribute("producto5");
                    String agg6 = (String) sesionNueva.getAttribute("producto6");
                    String agg7 = (String) sesionNueva.getAttribute("producto7");
                    String agg8 = (String) sesionNueva.getAttribute("producto8");
                    String agg9 = (String) sesionNueva.getAttribute("producto9");
                    respuesta.setCodigo(0);
                    if (agg1 == null) {
                        sesionNueva.setAttribute("producto1", buyPro);
                        respuesta.setMensaje("Primer producto agregado con éxito.");
                    } else {
                        if (agg2 == null) {
                            sesionNueva.setAttribute("producto2", buyPro);
                            respuesta.setMensaje("Segundo pruducto agregado con éxito.");
                        } else {
                            if (agg3 == null) {
                                sesionNueva.setAttribute("producto3", buyPro);
                                respuesta.setMensaje("Tercer pruducto agregado con éxito.");
                            } else {
                                if (agg4 == null) {
                                    sesionNueva.setAttribute("producto4", buyPro);
                                    respuesta.setMensaje("Cuarto pruducto agregado con éxito.");
                                } else {
                                    if (agg5 == null) {
                                        sesionNueva.setAttribute("producto5", buyPro);
                                        respuesta.setMensaje("Quinto pruducto agregado con éxito.");
                                    } else {
                                        if (agg6 == null) {
                                            sesionNueva.setAttribute("producto6", buyPro);
                                            respuesta.setMensaje("Sexto pruducto agregado con éxito.");
                                        } else {
                                            if (agg7 == null) {
                                                sesionNueva.setAttribute("producto7", buyPro);
                                                respuesta.setMensaje("Septimo pruducto agregado con éxito.");
                                            } else {
                                                if (agg8 == null) {
                                                    sesionNueva.setAttribute("producto8", buyPro);
                                                    respuesta.setMensaje("Octavo pruducto agregado con éxito.");
                                                } else {
                                                    if (agg9 == null) {
                                                        sesionNueva.setAttribute("producto9", buyPro);
                                                        respuesta.setMensaje("Noveno pruducto agregado con éxito.");
                                                    } else {
                                                        respuesta.setCodigo(-1);
                                                        respuesta.setMensaje("Has alcanzado el máximo de items en el carrito.");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    String objJSON = new Gson().toJson(respuesta);
                    out.println(objJSON);
                    break;
                case "listar":
                    controlProductos traer = new controlProductos();
                    ArrayList<productoVO> productosAgregados = new ArrayList<>();
                    String pro1 = (String) sesionNueva.getAttribute("producto1");
                    String pro2 = (String) sesionNueva.getAttribute("producto2");
                    String pro3 = (String) sesionNueva.getAttribute("producto3");
                    String pro4 = (String) sesionNueva.getAttribute("producto4");
                    String pro5 = (String) sesionNueva.getAttribute("producto5");
                    String pro6 = (String) sesionNueva.getAttribute("producto6");
                    String pro7 = (String) sesionNueva.getAttribute("producto7");
                    String pro8 = (String) sesionNueva.getAttribute("producto8");
                    String pro9 = (String) sesionNueva.getAttribute("producto9");
                    int cont = 0;
                    int[] Item = new int[9];

                    if (pro1 != null) {

                        Item[0] = Integer.parseInt(pro1);

                    } else {
                        Item[0] = -1;
                    }
                    if (pro2 != null) {

                        Item[1] = Integer.parseInt(pro2);

                    } else {
                        Item[1] = -1;
                    }
                    if (pro3 != null) {

                        Item[2] = Integer.parseInt(pro3);

                    } else {
                        Item[2] = -1;
                    }
                    if (pro4 != null) {

                        Item[3] = Integer.parseInt(pro4);

                    } else {
                        Item[3] = -1;
                    }
                    if (pro5 != null) {

                        Item[4] = Integer.parseInt(pro5);

                    } else {
                        Item[4] = -1;
                    }
                    if (pro6 != null) {

                        Item[5] = Integer.parseInt(pro6);

                    } else {
                        Item[5] = -1;
                    }

                    if (pro7 != null) {

                        Item[6] = Integer.parseInt(pro7);

                    } else {
                        Item[6] = -1;
                    }
                    if (pro8 != null) {

                        Item[7] = Integer.parseInt(pro8);

                    } else {
                        Item[7] = -1;
                    }
                    if (pro9 != null) {

                        Item[8] = Integer.parseInt(pro9);

                    } else {
                        Item[8] = -1;
                    }
                    for (int i = 0; i < 9; i++) {
                        if (Item[i] >= 0) {
                            productoVO productoAgregado = traer.listarAgregadosCarrito(Item[i]);
                            if (productoAgregado != null) {
                                productosAgregados.add(productoAgregado);
                            }
                        }
                    }
                    String objJSON2 = new Gson().toJson(productosAgregados);
                    out.println(objJSON2);

                    break;

                case "insertar":
                    controlProductos traer2 = new controlProductos();
                    RespuestaProductos respuestaB = new RespuestaProductos();
                    String pro1B = (String) sesionNueva.getAttribute("producto1");
                    String pro2B = (String) sesionNueva.getAttribute("producto2");
                    String pro3B = (String) sesionNueva.getAttribute("producto3");
                    String pro4B = (String) sesionNueva.getAttribute("producto4");
                    String pro5B = (String) sesionNueva.getAttribute("producto5");
                    String pro6B = (String) sesionNueva.getAttribute("producto6");
                    String pro7B = (String) sesionNueva.getAttribute("producto7");
                    String pro8B = (String) sesionNueva.getAttribute("producto8");
                    String pro9B = (String) sesionNueva.getAttribute("producto9");
                    int iUsuario = (int) sesionNueva.getAttribute("iSeguD");

                    String total = request.getParameter("total");
                    float totalB = Float.parseFloat(total);
                    String nombre = "";
                    String descripcion = "";

                    int contB = 0;
                    int[] ItemB = new int[9];

                    if (pro1B != null) {

                        ItemB[0] = Integer.parseInt(pro1B);

                    } else {
                        ItemB[0] = -1;
                    }
                    if (pro2B != null) {

                        ItemB[1] = Integer.parseInt(pro2B);

                    } else {
                        ItemB[1] = -1;
                    }
                    if (pro3B != null) {

                        ItemB[2] = Integer.parseInt(pro3B);

                    } else {
                        ItemB[2] = -1;
                    }
                    if (pro4B != null) {

                        ItemB[3] = Integer.parseInt(pro4B);

                    } else {
                        ItemB[3] = -1;
                    }
                    if (pro5B != null) {

                        ItemB[4] = Integer.parseInt(pro5B);

                    } else {
                        ItemB[4] = -1;
                    }
                    if (pro6B != null) {

                        ItemB[5] = Integer.parseInt(pro6B);

                    } else {
                        ItemB[5] = -1;
                    }

                    if (pro7B != null) {

                        ItemB[6] = Integer.parseInt(pro7B);

                    } else {
                        ItemB[6] = -1;
                    }
                    if (pro8B != null) {

                        ItemB[7] = Integer.parseInt(pro8B);

                    } else {
                        ItemB[7] = -1;
                    }
                    if (pro9B != null) {

                        ItemB[8] = Integer.parseInt(pro9B);

                    } else {
                        ItemB[8] = -1;
                    }
                    int ultimoRegistro;
                    int[] idProducto = new int[9];
                    boolean detalleSolicitud = false;
                    for (int i = 0; i < 9; i++) {
                        if (ItemB[i] >= 0) {
                            contB++;
                            productoVO productoAgregado2 = traer2.listarAgregadosCarrito(ItemB[i]);
                            if (productoAgregado2 != null) {
                                nombre += " " + productoAgregado2.getNombreTproducto() + ", ";
                                descripcion += " Nombre: " + productoAgregado2.getNombre() + ", Referencia: " + productoAgregado2.getReferencia() + ", Marca: " + productoAgregado2.getMarca() + " ";
                                idProducto[i] = productoAgregado2.getIdProducto();
                            }
                        }
                    }

                    solicitudProductoDAO solicitar = new solicitudProductoDAO();
                    try {

                        boolean validar = solicitar.comprarProducto(iUsuario, nombre, descripcion, totalB, contB);
                        if (validar) {
                            for (int i = 0; i < 9; i++) {
                                if (ItemB[i] >= 0) {
                                    controlProductos control = new controlProductos();
                                    solicitudProductoDAO solicitudUlt = new solicitudProductoDAO();
                                    ultimoRegistro = solicitudUlt.consultarUltimoRegistro();
                                    if (ultimoRegistro >= 0) {
                                        detalleSolicitud = control.insertarDetalleSolicitud(idProducto[i], ultimoRegistro);
                                    }

                                }
                            }
                            if (detalleSolicitud) {
                                respuestaB.setCodigo(0);
                                respuestaB.setMensaje("Gracias por confiar en nosotros, te llamaremos lo mas pronto posible para confirmar tu COMPRA.");
                                sesionNueva.removeAttribute("producto1");
                                sesionNueva.removeAttribute("producto2");
                                sesionNueva.removeAttribute("producto3");
                                sesionNueva.removeAttribute("producto4");
                                sesionNueva.removeAttribute("producto5");
                                sesionNueva.removeAttribute("producto6");
                                sesionNueva.removeAttribute("producto7");
                                sesionNueva.removeAttribute("producto8");
                                sesionNueva.removeAttribute("producto9");
                            } else {
                                respuesta.setCodigo(-1);
                                respuestaB.setMensaje("Error al insertar detalle de solicitud.");
                            }

                        } else {
                            respuesta.setCodigo(-1);
                            respuestaB.setMensaje("Error al enviar la peticiòn, vuelve a intentarlo.");
                        }

                    } catch (Exception e) {
                        respuesta.setCodigo(-1);
                        respuestaB.setMensaje("Error al enviar la peticiòn, vuelve a intentarlo.");
                    }

                    String objJSON3 = new Gson().toJson(respuestaB);
                    out.println(objJSON3);
                    break;

                case "eliminar":
                    HttpSession sesion = request.getSession();
                    String id = request.getParameter("iSeguD");
                    String numtItem = request.getParameter("numItem");
                    boolean productoCarro = true;
                    int eliminarI = 0;
                    String[] delete = new String[8];
                    try {
                        delete[0] = (String) sesionNueva.getAttribute("producto1");
                        delete[1] = (String) sesionNueva.getAttribute("producto2");
                        delete[2] = (String) sesionNueva.getAttribute("producto3");
                        delete[3] = (String) sesionNueva.getAttribute("producto4");
                        delete[4] = (String) sesionNueva.getAttribute("producto5");
                        delete[5] = (String) sesionNueva.getAttribute("producto6");
                        delete[6] = (String) sesionNueva.getAttribute("producto7");
                        delete[7] = (String) sesionNueva.getAttribute("producto8");
                        delete[8] = (String) sesionNueva.getAttribute("producto9");
                    } catch (Exception e) {
                        System.out.println("HAY CAMPOS VACIOS (NULL) -> " + e);
                    }

                    while (productoCarro) {
                        if (id.equals(delete[eliminarI])) {
                            productoCarro = false;
                            respuesta.setMensaje("Producto eliminado con éxito");
                        }
                        eliminarI++;
                    }

                    if (eliminarI == 1) {
                        sesion.removeAttribute("producto1");
                    }
                    if (eliminarI == 2) {
                        sesion.removeAttribute("producto2");
                    }
                    if (eliminarI == 3) {
                        sesion.removeAttribute("producto3");
                    }
                    if (eliminarI == 4) {
                        sesion.removeAttribute("producto4");
                    }
                    if (eliminarI == 5) {
                        sesion.removeAttribute("producto5");
                    }
                    if (eliminarI == 6) {
                        sesion.removeAttribute("producto6");
                    }
                    if (eliminarI == 7) {
                        sesion.removeAttribute("producto7");
                    }
                    if (eliminarI == 8) {
                        sesion.removeAttribute("producto8");
                    }
                    String rtEliminar = new Gson().toJson(respuesta);
                    out.println(rtEliminar);
                    break;

                case "alquilar":
                    controlProductos traer3 = new controlProductos();
                    String pro1A = (String) sesionNueva.getAttribute("producto1");
                    String pro2A = (String) sesionNueva.getAttribute("producto2");
                    String pro3A = (String) sesionNueva.getAttribute("producto3");
                    String pro4A = (String) sesionNueva.getAttribute("producto4");
                    String pro5A = (String) sesionNueva.getAttribute("producto5");
                    String pro6A = (String) sesionNueva.getAttribute("producto6");
                    String pro7A = (String) sesionNueva.getAttribute("producto7");
                    String pro8A = (String) sesionNueva.getAttribute("producto8");
                    String pro9A = (String) sesionNueva.getAttribute("producto9");
                    int iUsuarioA = (int) sesionNueva.getAttribute("iSeguD");
                    RespuestaProductos respuestaA = new RespuestaProductos();

                    String totalA2 = request.getParameter("total");
                    float totalA = Float.parseFloat(totalA2);
                    String nombreA = "";
                    String descripcionA = "";
                    int contA = 0;

                    int[] ItemA = new int[9];

                    if (pro1A != null) {

                        ItemA[0] = Integer.parseInt(pro1A);

                    } else {
                        ItemA[0] = -1;
                    }
                    if (pro2A != null) {

                        ItemA[1] = Integer.parseInt(pro2A);

                    } else {
                        ItemA[1] = -1;
                    }
                    if (pro3A != null) {

                        ItemA[2] = Integer.parseInt(pro3A);

                    } else {
                        ItemA[2] = -1;
                    }
                    if (pro4A != null) {

                        ItemA[3] = Integer.parseInt(pro4A);

                    } else {
                        ItemA[3] = -1;
                    }
                    if (pro5A != null) {

                        ItemA[4] = Integer.parseInt(pro5A);

                    } else {
                        ItemA[4] = -1;
                    }
                    if (pro6A != null) {

                        ItemA[5] = Integer.parseInt(pro6A);

                    } else {
                        ItemA[5] = -1;
                    }

                    if (pro7A != null) {

                        ItemA[6] = Integer.parseInt(pro7A);

                    } else {
                        ItemA[6] = -1;
                    }
                    if (pro8A != null) {

                        ItemA[7] = Integer.parseInt(pro8A);

                    } else {
                        ItemA[7] = -1;
                    }
                    if (pro9A != null) {

                        ItemA[8] = Integer.parseInt(pro9A);

                    } else {
                        ItemA[8] = -1;
                    }
                    for (int i = 0; i < 9; i++) {
                        if (ItemA[i] >= 0) {
                            contA++;
                            productoVO productoAgregado2 = traer3.listarAgregadosCarrito(ItemA[i]);
                            if (productoAgregado2 != null) {
                                nombreA += " " + productoAgregado2.getNombreTproducto() + ", ";
                                descripcionA += " Nombre: " + productoAgregado2.getNombre() + ", Referencia: " + productoAgregado2.getReferencia() + ", Marca: " + productoAgregado2.getMarca() + " ";
                            }
                        }
                    }
                    alquilerDAO alquilar = new alquilerDAO();
                    try {

                        boolean validarA = alquilar.alquilarProducto(iUsuarioA, nombreA, descripcionA, totalA, contA);
                        if (validarA) {

                            String fechaInicio = request.getParameter("fechaInicio");
                            String fechaFin = request.getParameter("fechaFin");
                            solicitudProductoDAO daoAlquiler = new solicitudProductoDAO();
                            int idSolci = daoAlquiler.consultarUltimoRegistro();
                            alquilerDAO producto = new alquilerDAO();
                            boolean solicitud = producto.insertarSolicitudAlquiler(idSolci, fechaInicio, fechaFin, totalA);
                            if (solicitud) {
                                respuestaA.setCodigo(0);
                                respuestaA.setMensaje("Gracias por confiar en nosotros, te llamaremos lo mas pronto posible para confirmar tu ALQUILER.");
                                sesionNueva.removeAttribute("producto1");
                                sesionNueva.removeAttribute("producto2");
                                sesionNueva.removeAttribute("producto3");
                                sesionNueva.removeAttribute("producto4");
                                sesionNueva.removeAttribute("producto5");
                                sesionNueva.removeAttribute("producto6");
                                sesionNueva.removeAttribute("producto7");
                                sesionNueva.removeAttribute("producto8");
                                sesionNueva.removeAttribute("producto9");
                            } else {
                                respuestaA.setCodigo(-1);
                                respuestaA.setMensaje("Error al ingresar ALQUILER, vuelve a intentarlo.");
                            }

                        } else {
                            respuestaA.setCodigo(-1);
                            respuestaA.setMensaje("Error al ingresar SOLICITUD, vuelve a intentarlo.");
                        }

                    } catch (Exception e) {
                        respuestaA.setCodigo(-1);
                        respuestaA.setMensaje("Error al enviar la peticiòn, vuelve a intentarlo.");
                    }
                    String objJSON4 = new Gson().toJson(respuestaA);
                    out.println(objJSON4);
                    break;

            }

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
