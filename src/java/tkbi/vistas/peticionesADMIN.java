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
import com.tkbi.utilidades.RespuestaServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tkbi.VO.alquilerVO;
import tkbi.VO.productoVO;
import tkbi.VO.solicitudProductoVO;

/**
 *
 * @author Diego RM
 */
@WebServlet(name = "peticionesADMIN", urlPatterns = {"/peticionesADMIN/confirmar", "/peticionesADMIN/denegar", "/peticionesADMIN/programaServicios", "/peticionesADMIN/agregarServicioAdm", "/peticionesADMIN/programaProductos", "/peticionesADMIN/programaAlquiler", "/peticionesADMIN/terminar", "/peticionesADMIN/confirmarAlquiler", "/peticionesADMIN/terminarAlq","/peticionesADMIN/inventario", "/peticionesADMIN/inventarioActMostrar", "/peticionesADMIN/inventarioActualizar"})
public class peticionesADMIN extends HttpServlet {

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
            String rutaServlet = request.getRequestURI();
            String accion = rutaServlet.substring(rutaServlet.lastIndexOf("/") + 1);
            RespuestaServlet respuestas = new RespuestaServlet();

            switch (accion) {
                case "confirmar":
                    String iSegud = request.getParameter("solicitud");
                    int idSolicitud = Integer.parseInt(iSegud);
                    controlProductos confirmar = new controlProductos();
                    boolean confirmacion = confirmar.confirmarServcio(idSolicitud);
                    if (confirmacion) {
                        respuestas.setCodigo(0);
                        respuestas.setMensaje("Has confirmado la solicitud, por favor comunicate con el cliente");
                    } else {
                        respuestas.setCodigo(-1);
                        respuestas.setMensaje("No se puede confirmar la solicitud.");
                    }
                    String objRta = new Gson().toJson(respuestas);
                    out.println(objRta);
                    break;
                case "confirmarAlquiler":
                    String idSolicitud10 = request.getParameter("solicitud");
                    int idSolicitudF = Integer.parseInt(idSolicitud10);
                    controlProductos confirmarAlquiler = new controlProductos();
                    boolean confirAlq = confirmarAlquiler.confirmarAlquiler(idSolicitudF);
                    if (confirAlq) {
                        respuestas.setCodigo(0);
                        respuestas.setMensaje("Has confirmado el alquiler, por favor comunicate con el cliente");
                    } else {
                        respuestas.setCodigo(-1);
                        respuestas.setMensaje("No se puede confirmar el alquiler.");
                    }
                    String objRtaAlq = new Gson().toJson(respuestas);
                    out.println(objRtaAlq);
                    break;
                case "denegar":
                    String iSegud2 = request.getParameter("solicitud");
                    String alquilersn = request.getParameter("opcion");
                    int alquilerFnSn = Integer.parseInt(alquilersn);
                    boolean alquilerTambien = false;
                    if (alquilerFnSn == 3) {
                        alquilerTambien = true;
                    }
                    int idSolicitud2 = Integer.parseInt(iSegud2);
                    controlProductos denegar = new controlProductos();
                    boolean denegacion = denegar.denegarServcio(idSolicitud2);
                    if (denegacion) {
                        respuestas.setCodigo(0);
                        respuestas.setMensaje("Has rechazado la solicitud, puedes modificar la solicitud en tu programa");
                    } else {
                        respuestas.setCodigo(-1);
                        respuestas.setMensaje("No se puede denegar la solicitud.");
                    }
                    if (alquilerTambien) {
                        boolean alquilarDeng = denegar.denegarAlquiler(idSolicitud2);
                        if (alquilarDeng) {
                            respuestas.setCodigo(0);
                            respuestas.setMensaje("Has rechazado el alquiler, puedes modificar la solicitud en tu programa");
                        } else {
                            respuestas.setCodigo(-1);
                            respuestas.setMensaje("No se puede denegar el alquiler.");
                        }
                    }
                    String objRtaDenegar = new Gson().toJson(respuestas);
                    out.println(objRtaDenegar);
                    break;

                case "programaServicios":
                    controlTablas serviciosAdmin = new controlTablas();
                    ArrayList<solicitudProductoVO> serviciosAll = serviciosAdmin.adminServiciosAll();
                    if (serviciosAll != null) {
                        respuestas.setCodigo(0);
                        respuestas.setDatosResultado(serviciosAll);
                    } else {
                        respuestas.setCodigo(-1);
                        respuestas.setMensaje("NO HAY NINGUN DATO, INFO: SERVLET");
                    }
                    String allService = new Gson().toJson(respuestas);
                    out.println(allService);
                    break;

                case "agregarServicioAdm":
                    String nombreT = request.getParameter("nombre");
                    String descripcion = request.getParameter("descripcion");
                    controlPeticiones verificar = new controlPeticiones();
                    boolean son = verificar.consultarServiciosAgregar(nombreT);
                    if (son) {

                        controlPeticiones nuevoServicio = new controlPeticiones();
                        boolean servicioAgregado = nuevoServicio.agregarServicioAdm(nombreT, descripcion);
                        if (servicioAgregado) {
                            respuestas.setCodigo(0);
                            respuestas.setMensaje("Servicio agregado con exito");
                        } else {
                            respuestas.setCodigo(-1);
                            respuestas.setMensaje("No se pudo agregar el servicio, vuelve a intentarlo");
                        }
                    } else {
                        respuestas.setCodigo(-1);
                        respuestas.setMensaje("El servicio ya existe.");
                    }
                    String nuevoService = new Gson().toJson(respuestas);
                    out.println(nuevoService);
                    break;

                case "programaProductos":
                    controlProductos listarAllproductos = new controlProductos();
                    ArrayList<solicitudProductoVO> productosAll = listarAllproductos.todosProductosAdm();
                    if (productosAll != null) {
                        respuestas.setCodigo(0);
                        respuestas.setDatosResultado(productosAll);
                    } else {
                        respuestas.setCodigo(-1);
                        respuestas.setMensaje("ERROR CAPTURANDO DATOS SOLICITUDES DE PRODUCTOS");
                    }
                    String programaPro = new Gson().toJson(respuestas);
                    out.println(programaPro);
                    break;

                case "programaAlquiler":
                    RespuestaServlet rptAlquiler = new RespuestaServlet();
                    controlProductos listarAlquiler = new controlProductos();
                    ArrayList<alquilerVO> listaAlquiler = listarAlquiler.todosAlquiler();
                    if (listaAlquiler != null) {
                        rptAlquiler.setCodigo(0);
                        rptAlquiler.setDatosResultado(listaAlquiler);
                    } else {

                        rptAlquiler.setCodigo(-1);
                        rptAlquiler.setMensaje("No se puede listar los alquileres");
                    }
                    String programaAlquiler = new Gson().toJson(rptAlquiler);
                    out.println(programaAlquiler);
                    break;

                case "terminar":
                    String iSoli = request.getParameter("solicitud");
                    int idSolicitudTermino = Integer.parseInt(iSoli);
                    controlProductos terminar = new controlProductos();
                    boolean soliTerminar = terminar.terminarSolicitud(idSolicitudTermino);
                    if (soliTerminar) {
                        respuestas.setCodigo(0);
                        respuestas.setMensaje("Has terminado la solicitud.");
                    } else {
                        respuestas.setCodigo(-1);
                        respuestas.setMensaje("No se puede terminar la solicitud.");
                    }
                    String objTerminar = new Gson().toJson(respuestas);
                    out.println(objTerminar);

                    break;

                case "terminarAlq":
                    String iSoliTerminar = request.getParameter("solicitud");
                    int idSolicitudTerminoAlq = Integer.parseInt(iSoliTerminar);
                    controlProductos terminarAlq = new controlProductos();
                    boolean finalAlq = terminarAlq.terminarAlquiler(idSolicitudTerminoAlq);
                    if (finalAlq) {
                        respuestas.setCodigo(0);
                        respuestas.setMensaje("Has terminado el alquiler.");
                    } else {
                        respuestas.setCodigo(-1);
                        respuestas.setMensaje("No se puede terminar el alquiler.");
                    }
                    String objTerminarAlq = new Gson().toJson(respuestas);
                    out.println(objTerminarAlq);

                    break;
                    
                case "inventario":                    
                    
                    controlProductos productosInventario = new controlProductos();
                    ArrayList<productoVO> inventario = productosInventario.controlInventario();
                    if (inventario != null) {
                        respuestas.setCodigo(0);
                        respuestas.setDatosResultado(inventario);
                    }else{
                        respuestas.setCodigo(-1);
                        respuestas.setMensaje("No se pudo listar el inventario");
                    }
                    String objInventario = new Gson().toJson(respuestas);
                    out.println(objInventario);
                    break;
                    
                case "inventarioActMostrar":
                    String iSegudProducto = request.getParameter("idProducto");
                    int idProductoF = Integer.parseInt(iSegudProducto);
                    controlProductos act = new controlProductos();
                    ArrayList<productoVO> productoInfo = act.controlInventarioActProducto(idProductoF);
                    if (productoInfo != null) {
                        respuestas.setCodigo(0);
                        respuestas.setDatosResultado(productoInfo);
                    }else{
                        respuestas.setCodigo(-1);
                        respuestas.setMensaje("No se pudo traer información del producto seleccionado");
                    }
                    String objInventarioAct = new Gson().toJson(respuestas);
                    out.println(objInventarioAct);
                    break;
                    
                case "inventarioActualizar":
                    String idProductoFl = request.getParameter("idProducto");
                    int idProductoFinal = Integer.parseInt(idProductoFl);
                    String nombreProductoF = request.getParameter("nombreProducto");
                    String tipoProF = request.getParameter("tipoProducto");
                    int tipoProFinal = Integer.parseInt(tipoProF);
                    String estadoF = request.getParameter("estado");
                    String marcaF = request.getParameter("marca");
                    String referenciaF = request.getParameter("referencia");
                    String descripcionF = request.getParameter("descripcion");
                    String valorUF = request.getParameter("valorU");
                    float valorUFinal = Float.parseFloat(valorUF);
                    String capacidadF = request.getParameter("capacidad");
                    controlProductos controlAct = new controlProductos();
                    boolean validarActualizar = controlAct.actualizarIvtFinal(nombreProductoF,marcaF,estadoF,referenciaF,descripcionF,capacidadF,valorUFinal,idProductoFinal,tipoProFinal);
                    if (validarActualizar) {
                        respuestas.setCodigo(0);
                        respuestas.setMensaje("Producto actualizado con éxito");
                    }else{
                        respuestas.setCodigo(-1);
                        respuestas.setMensaje("Error al actualizar el producto");
                    }
                    String objActInvtFl = new Gson().toJson(respuestas);
                    out.println(objActInvtFl);
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
