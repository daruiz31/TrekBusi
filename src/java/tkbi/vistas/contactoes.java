/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkbi.vistas;

import com.google.gson.Gson;
import com.tkbi.utilidades.RespuestaServlet;
import com.tkbi.utilidades.correos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego RM
 */
@WebServlet(name = "contactoes", urlPatterns = {"/contactoes"})
public class contactoes extends HttpServlet {

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
            RespuestaServlet rta = new RespuestaServlet();
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String telefono = request.getParameter("telefono");
            String asunto = request.getParameter("asunto");
            String correo = request.getParameter("correo");
            String descripcion = request.getParameter("descripcion");
            
            String usuario = nombre + " " + apellido + " te envió un mensaje";
            String contenido = "Asunto: " + asunto + "\n " + nombre + " " + apellido + "\n " +  "Telefono: " + telefono + "\nCorreo: " + correo + "\n" + descripcion + "\nEnvió masivo por: TrekBusi";
            correos contacto = new correos();
            boolean validar = contacto.enviarMail(usuario, contenido);
            if (validar) {
                rta.setCodigo(0);
                rta.setMensaje("Correo enviado correctamente.");
            }else{
                rta.setCodigo(-1);
                rta.setMensaje("Lo sentimos no se pudo enviar.");
            }
            String objson = new Gson().toJson(rta);
            out.println(objson);
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
