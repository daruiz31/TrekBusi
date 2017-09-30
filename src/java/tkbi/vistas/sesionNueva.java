/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkbi.vistas;

import com.google.gson.Gson;
import com.tkbi.controladores.controlUsuarios;
import com.tkbi.utilidades.sesion;
import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tkbi.VO.usuariosVO;

/**
 *
 * @author Diego RM
 */
@WebServlet(name = "sesionNueva", urlPatterns = {"/sesionNueva"})
public class sesionNueva extends HttpServlet {

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
            sesion nuevaSesion = new sesion();
            HttpSession nSession = request.getSession(false);
            if (nSession.getAttribute("usuario") != null) {
                String nombreUser = (String) nSession.getAttribute("usuario");
                int id = (Integer) nSession.getAttribute("iSeguD");
                String estado = (String) nSession.getAttribute("estado");
                controlUsuarios control = new controlUsuarios();
                usuariosVO usuTemporal = control.buscarID(id);
                if (usuTemporal != null) {
                    nuevaSesion.setCodigo(0);
                    nuevaSesion.setEstado(estado);
                    nuevaSesion.setNombreCompleto(nombreUser);
                    nuevaSesion.setiSegud(id);
                } else {
                    nuevaSesion.setCodigo(-2);
                    nuevaSesion.setMensaje("Error de seguridad: USUARIO NO IDENTIFICADO");
                }

            } else {
                nuevaSesion.setCodigo(-1);
                nuevaSesion.setMensaje("Debes iniciar sesión para ver el contenido");
            }
            String objSON = new Gson().toJson(nuevaSesion);
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
