/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkbi.vistas;

import com.google.gson.Gson;
import com.tkbi.controladores.controlPeticiones;
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

/**
 *
 * @author Diego RM
 */
@WebServlet(name = "admUserAdm", urlPatterns = {"/admUserAdm/cliente", "/admUserAdm/banear", "/admUserAdm/cambiarRol", "/admUserAdm/inactivos"})
public class admUserAdm extends HttpServlet {

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
            RespuestaServlet rptt = new RespuestaServlet();
            controlTablas tablas = new controlTablas();
            controlPeticiones peticion = new controlPeticiones();
            String obJSON = null;
            switch (accion) {
                case "cliente":
                    ArrayList clientes = tablas.todosLosUsuarios();
                    if (clientes != null) {
                        rptt.setCodigo(0);
                        rptt.setDatosResultado(clientes);
                    } else {
                        rptt.setCodigo(-1);
                        rptt.setMensaje("ERROR EN EL SERVLET");
                    }
                    obJSON = new Gson().toJson(rptt);

                    break;

                case "banear":
                    String idSt = request.getParameter("id");
                    String estado = request.getParameter("estado");
                    int idUser = Integer.parseInt(idSt);
                    boolean estadoPet = peticion.cambiarEstadoUser(idUser, estado);
                    if (estadoPet) {
                        rptt.setCodigo(0);
                        if (estado.equalsIgnoreCase("baneado")) {
                            rptt.setMensaje("Usuario baneado con éxito ");
                        }
                        if (estado.equalsIgnoreCase("activo")) {
                            rptt.setMensaje("Usuario activado con éxito ");
                        }

                    } else {
                        rptt.setCodigo(-1);
                        rptt.setMensaje("No se pudo cambiar estado " + estado + " al usuario");
                    }
                    obJSON = new Gson().toJson(rptt);

                    break;

                case "cambiarRol":
                    String idStr = request.getParameter("id");
                    String rolStr = request.getParameter("rol");
                    int id = Integer.parseInt(idStr);
                    int rol = Integer.parseInt(rolStr);
                    boolean rolPet = peticion.cambiarRolAll(id, rol);
                    if (rolPet) {
                        rptt.setCodigo(0);
                        rptt.setMensaje("Se cambio el rol exitosamente.");
                    } else {
                        rptt.setCodigo(-1);
                        rptt.setMensaje("Al paracer hubo un error.");
                    }
                    obJSON = new Gson().toJson(rptt);
                    break;
                    
                case "inactivos":
                     ArrayList inactivos = tablas.todosLosInactivos();
                    if (inactivos != null) {
                        rptt.setCodigo(0);
                        rptt.setDatosResultado(inactivos);
                    } else {
                        rptt.setCodigo(-1);
                        rptt.setMensaje("ERROR EN EL SERVLET");
                    }
                    obJSON = new Gson().toJson(rptt);
                    break;

            }
            out.println(obJSON);

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
