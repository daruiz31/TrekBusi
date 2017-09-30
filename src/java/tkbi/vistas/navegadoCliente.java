/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkbi.vistas;

import com.google.gson.Gson;
import com.tkbi.controladores.controlPeticiones;

import com.tkbi.controladores.controlProductos;
import com.tkbi.controladores.controlTablas;
import com.tkbi.controladores.controlUsuarios;
import com.tkbi.utilidades.RespuestaServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tkbi.VO.alquilerVO;
import tkbi.VO.detalleSolicitudVO;
import tkbi.VO.solicitudProductoVO;
import tkbi.VO.usuariosVO;

/**
 *
 * @author Diego RM
 */
@WebServlet(name = "navegadoCliente", urlPatterns = {"/navegadoCliente/infoUser", "/navegadoCliente/actualizarPerfil", "/navegadoCliente/eliminar", "/navegadoCliente/listarBuyproductos", "/navegadoCliente/listarBuyservicios", "/navegadoCliente/listarServiciosNegocio", "/navegadoCliente/cancelarServicio", "/navegadoCliente/solicitarServicio", "/navegadoCliente/todosProductos", "/navegadoCliente/cancelarProductos", "/navegadoCliente/solicitarProducto", "/navegadoCliente/todosAlquiler", "/navegadoCliente/cancelarAlqProductos", "/navegadoCliente/solicitarAlquiler", "/navegadoCliente/listarBuyAlquiler"})
public class navegadoCliente extends HttpServlet {

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
            HttpSession user = request.getSession(false);
            String rutaServlet = request.getRequestURI();
            String accion = rutaServlet.substring(rutaServlet.lastIndexOf("/") + 1);
            int id = (int) user.getAttribute("iSeguD");
            RespuestaServlet rpta = new RespuestaServlet();
            controlUsuarios control = new controlUsuarios();
            switch (accion) {
                case "infoUser":
                    usuariosVO usuario = control.buscarID(id);
                    String objJSON = new Gson().toJson(usuario);
                    out.println(objJSON);
                    break;

                case "actualizarPerfil":
                    String nombre1 = request.getParameter("nombre1");
                    String nombreUsuario = request.getParameter("usuario");
                    String nombre2 = request.getParameter("nombre2");
                    String pais = request.getParameter("pais");
                    String ciudad = request.getParameter("ciudad");
                    String documento = request.getParameter("documento");
                    String apellido1 = request.getParameter("apellido1");
                    String apellido2 = request.getParameter("apellido2");
                    String direccion = request.getParameter("direccion");
                    String telefono = request.getParameter("telefono");

                    boolean estadoActualizar = control.controlActualizar(nombre1, nombreUsuario, nombre2, pais, ciudad, documento, apellido1, apellido2, direccion, telefono, id);
                    if (estadoActualizar) {
                        rpta.setCodigo(0);
                        rpta.setMensaje("Modificación exitosa");
                    } else {
                        rpta.setCodigo(-1);
                        rpta.setMensaje("Fallo al enviar los datos");
                    }
                    String objJSON2 = new Gson().toJson(rpta);
                    out.println(objJSON2);
                    break;

                case "eliminar":
                    controlUsuarios controlEliminar = new controlUsuarios();
                    boolean eliminar = controlEliminar.eliminarUsuarioCliente(id);
                    if (eliminar) {
                        rpta.setCodigo(0);
                        rpta.setMensaje("Vuelve pronto, te estaremos esperando.");
                    } else {
                        rpta.setCodigo(-1);
                        rpta.setMensaje("Lo siento no puedo eliminarte de mis registros.");
                    }
                    String objJSON3 = new Gson().toJson(rpta);
                    out.println(objJSON3);
                    break;

                case "listarBuyproductos":

                    controlProductos controlComprasCliente = new controlProductos();
                    ArrayList<detalleSolicitudVO> detalle = controlComprasCliente.productosComprados(id);
                    if (detalle != null) {
                        rpta.setCodigo(0);
                        rpta.setDatosResultado(detalle);

                    } else {
                        rpta.setCodigo(-1);
                        rpta.setMensaje("No has adquirido productos");
                    }
                    String proBuy = new Gson().toJson(rpta);
                    out.println(proBuy);
                    break;

                case "listarBuyservicios":
                    controlTablas serviciosBuy = new controlTablas();
                    ArrayList<solicitudProductoVO> servicios = serviciosBuy.listarServiciosBuy(id);
                    if (servicios != null) {
                        rpta.setCodigo(0);
                        rpta.setDatosResultado(servicios);
                    } else {
                        rpta.setCodigo(-1);
                        rpta.setMensaje("No has adquirido ningun servicio");
                    }
                    String servBuy = new Gson().toJson(rpta);
                    out.println(servBuy);

                    break;

                case "listarServiciosNegocio":
                    controlTablas serviciosAll = new controlTablas();
                    ArrayList<solicitudProductoVO> serviciosTodos = serviciosAll.listarServiciosAll(id);
                    if (serviciosTodos != null) {
                        rpta.setCodigo(0);
                        rpta.setDatosResultado(serviciosTodos);
                    } else {
                        rpta.setCodigo(-1);
                        rpta.setMensaje("No has adquirido ningun servicio");
                    }
                    String servAll = new Gson().toJson(rpta);
                    out.println(servAll);
                    break;

                case "cancelarServicio":
                    String iSeguD = request.getParameter("solicitud");
                    int idSolicitud = Integer.parseInt(iSeguD);
                    controlPeticiones cancelar = new controlPeticiones();
                    boolean validacion = cancelar.cancelarServicioCliente(idSolicitud);
                    if (validacion) {
                        rpta.setCodigo(0);
                        rpta.setMensaje("La solicitud ha sido cancelada");
                    } else {
                        rpta.setCodigo(-1);
                        rpta.setMensaje("No se puede cancelar la solicitud");
                    }
                    String msnCancelado = new Gson().toJson(rpta);
                    out.println(msnCancelado);
                    break;

                case "solicitarServicio":
                    String iSe = request.getParameter("solicitud");
                    int idSolicitudSoli = Integer.parseInt(iSe);
                    controlPeticiones solicitar = new controlPeticiones();
                    boolean validacionSoli = solicitar.solicitarServicioCliente(idSolicitudSoli);
                    if (validacionSoli) {
                        rpta.setCodigo(0);
                        rpta.setMensaje("Gracias por confiar en nosotros nos comunicaremos contigo lo mas pronto posible");
                    } else {
                        rpta.setCodigo(-1);
                        rpta.setMensaje("No se puede solicitar el servicio");
                    }
                    String msnSolicitado = new Gson().toJson(rpta);
                    out.println(msnSolicitado);
                    break;
                case "solicitarAlquiler":
                    String idAlquilerSoli = request.getParameter("solicitud");
                    int idSolicitudAlquilerF = Integer.parseInt(idAlquilerSoli);
                    controlPeticiones solicitarAlquilerCancelado = new controlPeticiones();
                    boolean validacionSolicitudAlquiler = solicitarAlquilerCancelado.solicitarAlquilerDpCancelar(idSolicitudAlquilerF);
                    if (validacionSolicitudAlquiler) {
                        rpta.setCodigo(0);
                        rpta.setMensaje("Gracias por confiar en nosotros nos comunicaremos contigo lo mas pronto posible");
                    } else {
                        rpta.setCodigo(-1);
                        rpta.setMensaje("No se puede solicitar el servicio");
                    }
                    String msnSolicitadoAlq = new Gson().toJson(rpta);
                    out.println(msnSolicitadoAlq);
                    break;

                case "todosProductos":
                    controlProductos contar = new controlProductos();
                    int contador = contar.detallesEnSolicitudes(id);
                    if (contador == -1) {
                        rpta.setCodigo(-1);
                        rpta.setMensaje("No has adquirido productos");
                    } else {
                        controlProductos controlClienteProductos = new controlProductos();
                        ArrayList<detalleSolicitudVO> productosALL = controlClienteProductos.productosTodos(id);
                        if (productosALL != null) {
                            rpta.setCodigo(0);
                            rpta.setContador(contador);
                            rpta.setDatosResultado(productosALL);

                        } else {
                            rpta.setCodigo(-1);
                            rpta.setMensaje("No has adquirido productos");
                        }

                    }
                    String proAll = new Gson().toJson(rpta);
                    out.println(proAll);
                    break;
                    
                case "todosAlquiler":
                    controlProductos controlAlquiler = new controlProductos();
                    ArrayList<alquilerVO> alquileres = controlAlquiler.alquilerTodos(id);
                    if (alquileres != null) {
                        rpta.setCodigo(0);
                        rpta.setDatosResultado(alquileres);

                    } else {
                        rpta.setCodigo(-1);
                        rpta.setMensaje("No has adquirido productos en alquiler");
                    }

                    String alquilerAll = new Gson().toJson(rpta);
                    out.println(alquilerAll);
                    break;
                    
                case "cancelarProductos":
                    String detalleIseguD = request.getParameter("solicitud");
                    int idDetalle = Integer.parseInt(detalleIseguD);
                    controlProductos cancelarProducto = new controlProductos();
                    boolean validacionCP = cancelarProducto.cancelarProducto(idDetalle);
                    if (validacionCP) {
                        rpta.setCodigo(0);
                        rpta.setMensaje("Has cancelado la solicitud del(os) producto");
                    } else {
                        rpta.setCodigo(-1);
                        rpta.setMensaje("No se puede cancelar el producto");
                    }
                    String cancelPro = new Gson().toJson(rpta);
                    out.println(cancelPro);
                    break;
                    
                case "cancelarAlqProductos":
                    String alquilerIDsolicitud = request.getParameter("solicitud");
                    int idAlquilerSolicitud = Integer.parseInt(alquilerIDsolicitud);
                    controlProductos cancelarProductoAlquilado = new controlProductos();
                    boolean validacionAlquiler = cancelarProductoAlquilado.cancelarProductoAlquilado(idAlquilerSolicitud);
                    if (validacionAlquiler) {
                        rpta.setCodigo(0);
                        rpta.setMensaje("Has cancelado el alquiler del producto");
                    } else {
                        rpta.setCodigo(-1);
                        rpta.setMensaje("No se puede cancelar el producto");
                    }
                    String cancelProAlq = new Gson().toJson(rpta);
                    out.println(cancelProAlq);
                    break;

                case "solicitarProducto":
                    String detalleID = request.getParameter("solicitud");
                    int idDetalle2 = Integer.parseInt(detalleID);
                    controlPeticiones controlPet = new controlPeticiones();
                    boolean solicitarProducto = controlPet.solicitarProductoCliente(idDetalle2);
                    if (solicitarProducto) {
                        rpta.setCodigo(0);
                        rpta.setMensaje("Gracias por confiar en nosotros, nos comunicaremos contigo lo mas rapido que podamos");
                    } else {
                        rpta.setCodigo(-1);
                        rpta.setMensaje("No se puede solicitar el producto");
                    }
                    String soliPro = new Gson().toJson(rpta);
                    out.println(soliPro);
                    break;
                    
                case "listarBuyAlquiler":
                    controlProductos alquilerParaUser = new controlProductos();
                    ArrayList<alquilerVO> alquileresUserX = alquilerParaUser.alquierTerminado(id);
                    if (alquileresUserX != null) {
                        rpta.setCodigo(0);
                        rpta.setDatosResultado(alquileresUserX);
                    }else{
                        rpta.setCodigo(-1);
                        rpta.setMensaje("No se ha podido listar los alquileres terminados");
                    }
                    String todosAlquiler = new Gson().toJson(rpta);
                    out.println(todosAlquiler);
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
