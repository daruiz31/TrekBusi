package com.tkbi.controladores;

import java.util.ArrayList;
import tkbi.DAO.alquilerDAO;
import tkbi.DAO.detalleSolicitudDAO;
import tkbi.DAO.solicitudProductoDAO;
import tkbi.DAO.tipoProductoDAO;
import tkbi.DAO.usuariosDAO;

/**
 *
 * @author Diego RM
 */
public class controlPeticiones {

    public boolean cancelarServicioCliente(int idSolicitud) {
        try {
            solicitudProductoDAO cancelacion = new solicitudProductoDAO();
            boolean validacion = cancelacion.cancelarServicioCliente(idSolicitud);
            return validacion;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO LA CANCELACION POR PARTE DEL CLIENTE ---> " + e);
            return false;
        }

    }

    public boolean solicitarServicioCliente(int idSolicitud) {
        try {
            solicitudProductoDAO solicitar = new solicitudProductoDAO();
            boolean validacion = solicitar.solicitarServicioCliente(idSolicitud);
            return validacion;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO LA CANCELACION POR PARTE DEL CLIENTE ---> " + e);
            return false;
        }

    }

    public boolean solicitarAlquilerDpCancelar(int id) {
        try {
            alquilerDAO solicitud = new alquilerDAO();
            boolean validarSolicitud = solicitud.solicitudPrimeroSolicitud(id);
            if (validarSolicitud) {
                alquilerDAO alquiler = new alquilerDAO();
                boolean validarAlquiler = alquiler.solicitudDespuesAlquiler(id);
                return validarAlquiler;
            }
            return false;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO SOLICITAR NUEVAMENTE PARTE DEL CLIENTE --> " + e);
            return false;
        }
    }

    public boolean solicitarProductoCliente(int idSolicitud) {
        try {
            detalleSolicitudDAO solicitar = new detalleSolicitudDAO();
            boolean validacion = solicitar.solicitarProductoCliente(idSolicitud);
            return validacion;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO LA CANCELACION POR PARTE DEL CLIENTE ---> " + e);
            return false;
        }

    }

    public boolean agregarServicioAdm(String nombreT, String descripcion) {
        try {
            tipoProductoDAO nuevoServ = new tipoProductoDAO();
            boolean validarServicio = nuevoServ.agregarServicioAdm(nombreT, descripcion);
            return validarServicio;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO AGREGAR SERVICIO POR ADMIN ---> " + e);
            return false;
        }
    }

    public boolean cambiarEstadoUser(int id, String estado) {
        try {
            usuariosDAO usuarios = new usuariosDAO();
            boolean cambiarEstado = usuarios.cambiarEstado(id, estado);
            return cambiarEstado;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO CAMBIAR ESTADO USER --->" + e);
            return false;
        }
    }

    public boolean cambiarRolAll(int id, int rol) {
        try {
            usuariosDAO userRol = new usuariosDAO();
            boolean tipoRol = userRol.cambiarRol(id, rol);
            return tipoRol;

        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO CAMBIAR ROL--->" + e);
            return false;
        }
    }

    public boolean consultarServiciosAgregar(String nombreServicio) {
        try {
            tipoProductoDAO servicios = new tipoProductoDAO();
            ArrayList allServicios = servicios.consultarServicioIngresado(nombreServicio);
            if (allServicios != null) {
                for (int i = 0; i < allServicios.size(); i++) {
                    if (allServicios.get(i).equals(nombreServicio)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO SERVICIOS QUE EXISTEN-->" + e);
            return false;
        }
    }

}
