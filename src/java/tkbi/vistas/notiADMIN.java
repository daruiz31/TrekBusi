/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkbi.vistas;

import com.google.gson.Gson;
import com.tkbi.controladores.notificacionesADMIN;
import com.tkbi.utilidades.RespuestaProductos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego RM
 */
@WebServlet(name = "notiADMIN", urlPatterns = {"/notiADMIN/productos", "/notiADMIN/alquiler", "/notiADMIN/newReport"})
public class notiADMIN extends HttpServlet {

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
            RespuestaProductos rptt = new RespuestaProductos();
            switch (accion) {
                case "productos":
                    notificacionesADMIN controlador = new notificacionesADMIN();
                    ArrayList solicitudNotiServicios = controlador.listarSoliProductos();
                    if (solicitudNotiServicios != null) {
                        rptt.setCodigo(0);
                        rptt.setDatosResultado(solicitudNotiServicios);
                        rptt.setMensaje("Estos son los productos que se solicitan");

                    } else if (solicitudNotiServicios == null) {
                        rptt.setCodigo(-1);
                        rptt.setMensaje("No se encontraron nuevas solicitudes");
                    }

                    break;

                case "alquiler":
                    notificacionesADMIN controladorAlquiler = new notificacionesADMIN();
                    ArrayList solicitudNotiAlquiler = controladorAlquiler.listarSoliAlquiler();
                    if (solicitudNotiAlquiler != null) {
                        rptt.setCodigo(0);
                        rptt.setDatosResultado(solicitudNotiAlquiler);
                        rptt.setMensaje("Estos son los productos de alquiler que se solicitan");

                    } else if (solicitudNotiAlquiler == null) {
                        rptt.setCodigo(-1);
                        rptt.setMensaje("No se encontraron nuevas solicitudes");
                    }

                    break;
            }
            String objJSON1 = new Gson().toJson(rptt);
            out.println(objJSON1);

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
