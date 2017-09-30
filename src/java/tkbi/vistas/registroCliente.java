/*
 Autor: Diego
 */
package tkbi.vistas;

import com.google.gson.Gson;
import com.tkbi.utilidades.RespuestaServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tkbi.DAO.usuariosDAO;

/**
 *
 * @author Diego RM
 */
@WebServlet(name = "registroCliente", urlPatterns = {"/registroCliente"})
public class registroCliente extends HttpServlet {

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
            RespuestaServlet respuesta = new RespuestaServlet();

            HttpSession session = request.getSession();
            String nombre1 = request.getParameter("nombre1");
            String nombre2 = request.getParameter("nombre2");
            String apellido1 = request.getParameter("apellido1");
            String apellido2 = request.getParameter("apellido2");
            String documento = request.getParameter("documento");
            String contrasena = request.getParameter("contrasena");
            String correo = request.getParameter("correo");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String pais = request.getParameter("pais");
            String ciudad = request.getParameter("ciudad");
            String vContra = request.getParameter("vContra");
            String vCorreo = request.getParameter("vCorreo");
            String respuestaSegu = request.getParameter("respuesta");
            String estado = "Activo";
            Calendar fechaPed = new GregorianCalendar();
            int año = fechaPed.get(Calendar.YEAR);
            int mes = fechaPed.get(Calendar.MONTH);
            int dia = fechaPed.get(Calendar.DAY_OF_MONTH);
            int hora = fechaPed.get(Calendar.HOUR_OF_DAY);
            String fechaCreacion = String.valueOf(dia + "/" + mes + "/" + año + " Hora: " + hora);
            int idRol = 2;
            String nUsuario = nombre1 + " " + apellido1;
            String usu = nombre1 + " " + apellido1;
            usuariosDAO ingresarInfo = new usuariosDAO();

            respuesta.setEstado("Activo");
            respuesta.setUsuario(nUsuario);

            try {
                ingresarInfo.registroCliente(usu,contrasena, correo, respuestaSegu, fechaCreacion, estado, nombre1, nombre2, apellido1, apellido2, pais, documento, ciudad, direccion, telefono, idRol);
                respuesta.setMensaje("Usuario registrado con exito");
                respuesta.setCodigo(0);               

            } catch (Exception e) {
                respuesta.setMensaje("Error al registrar usuario");
                respuesta.setCodigo(-1);

            }
            String objson = new Gson().toJson(respuesta);
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
