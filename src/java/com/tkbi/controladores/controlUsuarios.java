/**
 *
 * TrekBusi
 *
 * Autor : Diego Ruiz
 *
 *
 */
//Nombre del paquete
package com.tkbi.controladores;

//Librerias importadas
import tkbi.DAO.usuariosDAO;
import tkbi.VO.usuariosVO;

//Inicio clase controlUsuarios
public class controlUsuarios {

    //Inicio método verificarLoginUsuario    
    public usuariosVO verificarLoginUsuarios(String correo, String pass) {
        try {
            usuariosDAO dao = new usuariosDAO();
            usuariosVO usuTemporal = dao.consultarUsuario(correo, pass);
            if (usuTemporal != null) {
                if (usuTemporal.getContrasena().equals(pass)) {
                    return usuTemporal;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error 001 al consultar usuario " + e);
            return null;
        }

    }// Fin mpetodo verificarLoginUsuarios   

    public usuariosVO buscarID(int id) {
        try {
            usuariosDAO dao = new usuariosDAO();
            usuariosVO usuTemporal = dao.consultarUsuarioID(id);
            if (usuTemporal != null) {
                return usuTemporal;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error 001 al consultar usuario por iseguD " + e);
            return null;
        }
    }

    public boolean controlActualizar(String nombre1, String usuario, String nombre2, String pais, String ciudad, String documento, String apellido1, String apellido2, String direccion, String telefono, int id) {
        try {
            usuariosDAO userActualizar = new usuariosDAO();
            boolean actualizar = userActualizar.actualizarUsuarioID(nombre1, usuario, nombre2, pais, ciudad, documento, apellido1, apellido2, direccion, telefono, id);
            if (actualizar != false) {
                return actualizar;
            }
            return false;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO DATOS DE ACTUALIZANCIÓN DE USUARIO" + e);
            return false;
        }

    }

    public boolean eliminarUsuarioCliente(int idCliente) {
        try {
            usuariosDAO dao = new usuariosDAO();
            boolean validacionEliminar = dao.eliminarUsuxCliente(idCliente);
            return validacionEliminar;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}//Fin servlet controlUsuarios
