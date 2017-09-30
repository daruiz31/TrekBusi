/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkbi.vistas;

import com.google.gson.Gson;

import com.tkbi.utilidades.RespuestaServlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import tkbi.DAO.productoDAO;
import org.apache.commons.io.*;

/**
 *
 * @author Diego RM
 */
@WebServlet(name = "registrarProductos", urlPatterns = {"/registrarProductos"})
public class registrarProductos extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RespuestaServlet rpta = new RespuestaServlet();
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            String tipoProducto = "", estado = "", nombre = "", referencia = "", marca = "", capacidad = "", cantidad = "", descripcion = "", img = "", valorUS = "";
            float valorU = 0;
            boolean validar = false;
            int coutMoment = 0;
            List items = upload.parseRequest(request);

            for (Object item : items) {
                FileItem uploaded = (FileItem) item;

                if (!uploaded.isFormField()) {
                    if (uploaded.getContentType().equals("image/jpeg") || uploaded.getContentType().equals("image/png")
                            || uploaded.getContentType().equals("image/jpg") || uploaded.getContentType().equals("image/gif")
                            || uploaded.getContentType().equals("image/bmp")) {
                        img = "imagenes/productos/" + uploaded.getName();
                        File fichero = new File(getServletContext().getRealPath("/imagenes/productos") + File.separator + uploaded.getName());
                        uploaded.write(fichero);
                        validar = true;
                    } else {
                        
                    }
                    // No es campo de formulario, guardamos el fichero en algún sitio

                } else {
                    // Es un campo de formulario
                    if (coutMoment == 0) {
                        tipoProducto = uploaded.getString();
                    }
                    if (coutMoment == 1) {
                        estado = uploaded.getString();

                    }
                    if (coutMoment == 2) {
                        nombre = uploaded.getString();

                    }
                    if (coutMoment == 3) {
                        referencia = uploaded.getString();

                    }
                    if (coutMoment == 4) {
                        marca = uploaded.getString();
                    }
                    if (coutMoment == 6) {
                        valorUS = uploaded.getString();

                    }
                    if (coutMoment == 7) {
                        capacidad = uploaded.getString();

                    }
                    if (coutMoment == 8) {

                        cantidad = uploaded.getString();
                    }
                    if (coutMoment == 9) {

                        descripcion = uploaded.getString();
                    }

                    coutMoment++;
                }

            }
            if (validar == true) {
                int idProducto = Integer.parseInt(tipoProducto);
                try {
                    valorU = Float.parseFloat(valorUS);
                    productoDAO productos = new productoDAO();
                    productos.ingresarProductoADMIN(idProducto, nombre, descripcion, referencia, marca, valorU, capacidad, estado, cantidad, img);
                    rpta.setCodigo(0);
                    rpta.setMensaje("Producto agregado correctamente");
                } catch (Exception e) {
                    System.out.println("ERROR INSERTANDO PRODUCTOS ---> " + e);
                    rpta.setCodigo(-1);
                    rpta.setMensaje("ERROR AGREGANDO PRODUCTO");

                }
                response.sendRedirect("nav-admin.jsp");
            } else {

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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(registrarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(registrarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
