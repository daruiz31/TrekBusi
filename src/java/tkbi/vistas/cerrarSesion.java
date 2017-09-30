/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkbi.vistas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego RM
 */
@WebServlet(name = "cerrarSesion", urlPatterns = {"/cerrarSesion"})
public class cerrarSesion extends HttpServlet {

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
            HttpSession session = request.getSession(false);
            if (session.getAttribute("usuario") != null) {
                
                session.removeAttribute("producto1");
                session.removeAttribute("producto2");
                session.removeAttribute("producto3");
                session.removeAttribute("producto4");
                session.removeAttribute("producto5");
                session.removeAttribute("producto6");
                session.removeAttribute("producto7");
                session.removeAttribute("producto8");
                session.removeAttribute("producto9");
                session.removeAttribute("iSeguD");
                session.removeAttribute("estado");                  
                session.removeAttribute("usuario");
                session.removeAttribute("productosAgregados");
                session.invalidate();
                response.sendRedirect("index.html");
            } else {
                session.removeAttribute("producto1");
                session.removeAttribute("producto2");
                session.removeAttribute("producto3");
                session.removeAttribute("producto4");
                session.removeAttribute("producto5");
                session.removeAttribute("producto6");
                session.removeAttribute("producto7");
                session.removeAttribute("producto8");
                session.removeAttribute("producto9");
                session.invalidate();
                response.sendRedirect("index.html");
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
