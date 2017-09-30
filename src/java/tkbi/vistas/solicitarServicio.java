/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkbi.vistas;

import com.google.gson.Gson;
import com.tkbi.utilidades.RespuestaServlet;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tkbi.DAO.solicitudProductoDAO;
import tkbi.DAO.usuariosDAO;

import tkbi.VO.usuariosVO;

/**
 *
 * @author Diego RM
 */
@WebServlet(name = "solicitarServicio", urlPatterns = {"/solicitarServicio"})
public class solicitarServicio extends HttpServlet {

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
            HttpSession sesion = request.getSession();
            String descripcion = request.getParameter("descripcionTip");
            String fechaIni = request.getParameter("fechaFin");
            String nombreServ = request.getParameter("tiposServicio");
            float presuMin = Float.parseFloat(request.getParameter("presupuesto"));
            String descripcionBreve = request.getParameter("descripcionBreve");
            String estado = "Pendiente";
            HttpSession session = request.getSession();
            String nombreUser = (String) session.getAttribute("usuario");
            usuariosDAO dao = new usuariosDAO();
            int idUsuario = (int) sesion.getAttribute("iSeguD");

            RespuestaServlet rptt = new RespuestaServlet();
            try {
                solicitudProductoDAO daoProducto = new solicitudProductoDAO();
                daoProducto.insertarSolicitudServicio(descripcionBreve, fechaIni, nombreServ, presuMin, estado, idUsuario);
                rptt.setCodigo(0);
                rptt.setMensaje("Solicitud éxitosa, nos pondremos en contacto. Gracias");
                rptt.setTipoUsuario(idUsuario);
            } catch (Exception e) {
                rptt.setCodigo(-1);
                rptt.setMensaje("Lo sentimos, ha ocurrido un error en el servidor, vuelve a intentarlo");
                rptt.setDatosResultado(null);
            }
            String objSON = new Gson().toJson(rptt);
            out.println(objSON);

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
