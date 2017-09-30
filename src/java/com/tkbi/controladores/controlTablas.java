
package com.tkbi.controladores;

import java.util.ArrayList;
import tkbi.DAO.solicitudProductoDAO;
import tkbi.DAO.usuariosDAO;
import tkbi.VO.solicitudProductoVO;
import tkbi.VO.usuariosVO;

/**
 *
 * @author Diego RM
 */
public class controlTablas {
    public ArrayList<solicitudProductoVO> listarServiciosBuy(int id){
        try {
            solicitudProductoDAO dao = new solicitudProductoDAO();
            ArrayList<solicitudProductoVO> serviciosBuy = dao.serviciosClienteBuy(id);
            if (serviciosBuy != null) {
                return serviciosBuy;
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO LISTA SERVICIOS COMPRADOS ---> " + e);
            return null;
        }
    }
    
    public ArrayList<solicitudProductoVO> listarServiciosAll(int id){
        try {
            solicitudProductoDAO dao = new solicitudProductoDAO();
            ArrayList<solicitudProductoVO> serviciosBuy = dao.serviciosClienteTodos(id);
            if (serviciosBuy != null) {
                return serviciosBuy;
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO LISTA SERVICIOS COMPRADOS ---> " + e);
            return null;
        }
    }
    
    public ArrayList<solicitudProductoVO> adminServiciosAll(){
        try {
            solicitudProductoDAO dao = new solicitudProductoDAO();
            ArrayList<solicitudProductoVO> serviciosBuy = dao.serviciosADMINTodos();
            if (serviciosBuy != null) {
                return serviciosBuy;
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO LISTA TODOS LOS SERVICIOS ---> " + e);
            return null;
        }
    }
    
    public ArrayList<usuariosVO> todosLosUsuarios(){
        try {
            usuariosDAO dao = new usuariosDAO();
            ArrayList<usuariosVO> lista = dao.listarAllUsu();
            if (lista != null) {
               return lista;
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO LISTA TODOS LOS USUARIOS ---> " + e);
            return null;
        }
    }
    public ArrayList<usuariosVO> todosLosInactivos(){
        try {
            usuariosDAO dao = new usuariosDAO();
            ArrayList<usuariosVO> lista = dao.listarInactivos();
            if (lista != null) {
               return lista;
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO LISTA TODOS LOS USUARIOS ---> " + e);
            return null;
        }
    }
}
