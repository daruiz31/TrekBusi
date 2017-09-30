package tkbi.vistas;

import com.google.gson.Gson;
import com.tkbi.controladores.controlUsuarios;
import com.tkbi.utilidades.RespuestaServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tkbi.VO.usuariosVO;
import com.tkbi.utilidades.sesion;
import org.apache.commons.codec.digest.DigestUtils;

@WebServlet(name = "usuarios", urlPatterns = {"/usuarios"})
public class UsuariosVISTA extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String usuario = request.getParameter("nombreUsuario");
            String password = request.getParameter("passwordUsuario");
            String iSeguD = DigestUtils.md5Hex(password);
            controlUsuarios control = new controlUsuarios();
            usuariosVO usuTemporal = control.verificarLoginUsuarios(usuario, iSeguD);
            RespuestaServlet respuesta = new RespuestaServlet();
            HttpSession session = request.getSession();
            String nombreUser;
            if (usuTemporal != null) {
                if (usuTemporal.getIdRol() == 2 || usuTemporal.getIdRol() == 4) {
                    nombreUser = usuTemporal.getNombre_RazonSocial() + " " + usuTemporal.getApellido1();
                } else if (usuTemporal.getIdRol() == 3) {
                    nombreUser = usuTemporal.getNombre_RazonSocial();
                } else {
                    nombreUser = "Administración";
                }
                sesion nuevaSesion = new sesion();
                nuevaSesion.setNombreCompleto(nombreUser);
                nuevaSesion.setEstado(usuTemporal.getEstado());
                nuevaSesion.setiSegud(usuTemporal.getIdRol());
                respuesta.setCodigo(0);
                respuesta.setMensaje("OK");
                respuesta.setDatosResultado(usuTemporal);
                respuesta.setUsuario(usuTemporal.getNombre_RazonSocial());
                respuesta.setTipoUsuario(usuTemporal.getIdRol());
                session.setAttribute("rol", usuTemporal.getIdRol());
                session.setAttribute("usuario", nombreUser);
                session.setAttribute("iSeguD", usuTemporal.getIdUsuarios());
                session.setAttribute("estado", usuTemporal.getEstado());
                

            } else {
                respuesta.setCodigo(-1);
                respuesta.setMensaje("Datos incorrectos");
                respuesta.setDatosResultado(null);
            }

            String objSON = new Gson().toJson(respuesta);
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
        return "Acceso de usuario";
    }// </editor-fold>

}
