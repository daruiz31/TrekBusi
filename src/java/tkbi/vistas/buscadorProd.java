/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkbi.vistas;

import com.tkbi.controladores.controlProductos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tkbi.DAO.tipoProductoDAO;
import tkbi.VO.productoVO;
import tkbi.VO.tipoProductoVO;

/**
 *
 * @author Diego RM
 */
@WebServlet(name = "buscadorProd", urlPatterns = {"/buscadorProd/tipoPro", "/buscadorProd/marca", "/buscadorProd/referencia"})
public class buscadorProd extends HttpServlet {

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
            tipoProductoDAO dao = new tipoProductoDAO();
            switch (accion) {
                case "tipoPro":
                    try {
                        ArrayList<tipoProductoVO> tipoPro = dao.consultarProductos();
                        out.println("<option value=''>Tipo producto</option>");
                        for (int i = 0; i < tipoPro.size(); i++) {
                            out.printf("<option value=\"%d\">%2s</option>", tipoPro.get(i).getIdTipo_producto(), tipoPro.get(i).getNombre());
                            
                        }
                        out.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    break;

                case "marca":
                    controlProductos contrl = new controlProductos();                    
                    try {
                        ArrayList<productoVO> marcas = contrl.consultarMarca();
                        out.println("<option value=''>Marcas</option>");
                        for (int i = 0; i < marcas.size(); i++) {
                            out.printf("<option value='%1s'>%2s</option>", marcas.get(i).getMarca(), marcas.get(i).getMarca());
                        }
                        out.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    break;
                    
                case "referencia":
                    controlProductos contrl2 = new controlProductos();                    
                    try {
                        ArrayList<productoVO> referencia = contrl2.consultarReferencia();
                        out.println("<option value=''>Referencias</option>");
                        for (int i = 0; i < referencia.size(); i++) {
                            out.printf("<option value='%1s'>%2s</option>", referencia.get(i).getReferencia(), referencia.get(i).getReferencia());
                        }
                        out.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
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
