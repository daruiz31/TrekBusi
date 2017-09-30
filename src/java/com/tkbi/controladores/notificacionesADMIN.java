package com.tkbi.controladores;

import java.util.ArrayList;
import tkbi.DAO.solicitudProductoDAO;
import tkbi.VO.solicitudProductoVO;

public class notificacionesADMIN{
    
    public ArrayList<solicitudProductoVO> listarSoliServicios(){
        try {
            solicitudProductoDAO dao = new solicitudProductoDAO();
            ArrayList<solicitudProductoVO> listaNotifiServ = dao.consultarSolicitudServicio();            
            return listaNotifiServ;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public ArrayList<solicitudProductoVO> listarSoliProductos(){
        try {
            solicitudProductoDAO dao = new solicitudProductoDAO();
            ArrayList<solicitudProductoVO> listaNotifiServ = dao.consultarSolicitudProducto();            
            return listaNotifiServ;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList<solicitudProductoVO> listarSoliAlquiler(){
        try {
            solicitudProductoDAO dao = new solicitudProductoDAO();
            ArrayList<solicitudProductoVO> listaNotifiServ = dao.consultarSolicitudAlquiler();
            return listaNotifiServ;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
}