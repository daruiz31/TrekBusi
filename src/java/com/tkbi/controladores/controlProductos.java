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
import java.util.ArrayList;
import tkbi.DAO.alquilerDAO;
import tkbi.DAO.detalleSolicitudDAO;
import tkbi.DAO.productoDAO;
import tkbi.DAO.solicitudProductoDAO;
import tkbi.DAO.tipoProductoDAO;
import tkbi.VO.alquilerVO;
import tkbi.VO.detalleSolicitudVO;

import tkbi.VO.productoVO;
import tkbi.VO.solicitudProductoVO;
import tkbi.VO.tipoProductoVO;

//Inicio clase controlProductos
public class controlProductos {

    // Listar tipos de servicio
    public ArrayList<tipoProductoVO> consultarTipoServicio() {
        try {
            tipoProductoDAO dao = new tipoProductoDAO();
            ArrayList<tipoProductoVO> listaTipoServicio = dao.consultarServicio();
            return listaTipoServicio;
        } catch (Exception e) {
            System.out.println("Error consultando tipo servicio" + e);
            return null;
        }
    }

    public ArrayList<productoVO> consultarMarca() {
        try {
            productoDAO dao = new productoDAO();
            ArrayList<productoVO> listaTipoServicio = dao.consultarMarca();
            return listaTipoServicio;
        } catch (Exception e) {
            System.out.println("Error consultando marca" + e);
            return null;
        }
    }

    public ArrayList<productoVO> consultarReferencia() {
        try {
            productoDAO dao = new productoDAO();
            ArrayList<productoVO> listaTipoServicio = dao.consultarReferencia();
            return listaTipoServicio;
        } catch (Exception e) {
            System.out.println("Error consultando referencia" + e);
            return null;
        }
    }

    public ArrayList<tipoProductoVO> consultarTipoProducto() {
        try {
            tipoProductoDAO dao = new tipoProductoDAO();
            ArrayList<tipoProductoVO> listaTipoServicio = dao.consultarProductos();
            return listaTipoServicio;
        } catch (Exception e) {
            System.out.println("Error consultando tipo servicio" + e);
            return null;
        }
    }

    public tipoProductoVO traerDescripcion(String tipoServicio) {
        try {
            tipoProductoDAO dao = new tipoProductoDAO();
            tipoProductoVO tipoPro = dao.descripcionServicio(tipoServicio);
            if (tipoPro != null) {
                return tipoPro;
            } else {
                System.out.println("Error al obtener descripción");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error capturando la descripcion" + e);
            return null;
        }
    }

    public ArrayList<productoVO> listarAllProductos(int consultar) {
        try {
            productoDAO dao = new productoDAO();
            ArrayList<productoVO> listaProductos = dao.consultar(consultar);
            return listaProductos;
        } catch (Exception e) {
            System.out.println("Error de filtro 1 " + e);
            return null;

        }
    }

    public productoVO listarAgregadosCarrito(int iSeguD) {
        try {
            productoDAO dao = new productoDAO();
            productoVO productoAgregado = dao.consultarPorSegur(iSeguD);
            return productoAgregado;
        } catch (Exception e) {
            System.out.println("Error consultando tipo servicio" + e);
            return null;
        }
    }

    public solicitudProductoVO nuevaSolicitudProductos(int contador, int[] codigos) {
        try {
            productoDAO dao = new productoDAO();
            return null;
        } catch (Exception e) {
            System.out.println("Error consultando tipo servicio" + e);
            return null;
        }
    }

    public boolean insertarDetalleSolicitud(int idProducto, int idSolicitud) {
        try {
            detalleSolicitudDAO dao = new detalleSolicitudDAO();
            boolean validacion = dao.insetarDetalleSolicitud(idProducto, idSolicitud);
            return validacion;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO INSERTAR DETALLE SOLICITUD ---> " + e);
            return false;
        }
    }

    public ArrayList<detalleSolicitudVO> productosComprados(int id) {
        try {
            detalleSolicitudDAO daoDetalleCompra = new detalleSolicitudDAO();
            ArrayList<detalleSolicitudVO> productosBuy = daoDetalleCompra.listarProductosBuy(id);
            return productosBuy;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO PRODUCTOS COMPRADOS ---> " + e);
            return null;
        }
    }

    public ArrayList<detalleSolicitudVO> productosTodos(int id) {
        try {
            detalleSolicitudDAO daoDetalleCompra = new detalleSolicitudDAO();
            ArrayList<detalleSolicitudVO> productosBuy = daoDetalleCompra.listarProductosTodos(id);
            return productosBuy;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO PRODUCTOS COMPRADOS ---> " + e);
            return null;
        }
    }

    public ArrayList<alquilerVO> alquilerTodos(int id) {
        try {
            alquilerDAO allAlquileres = new alquilerDAO();
            ArrayList<alquilerVO> alquilerBuy = allAlquileres.listarAlquilerTodos(id);
            return alquilerBuy;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO TODOS LOS ALQUILERES DEL USUARIO X ---> " + e);
            return null;
        }
    }

    public int detallesEnSolicitudes(int id) {
        try {
            detalleSolicitudDAO daoContar = new detalleSolicitudDAO();
            int contador = daoContar.DetalleEnSolicitud(id);
            return contador;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO PRODUCTOS SOLICITADOS EN DETALLE ---> " + e);
            return -1;
        }
    }

    public boolean cancelarProducto(int idDetalle) {
        try {
            detalleSolicitudDAO cancelarProducto = new detalleSolicitudDAO();
            boolean validacion = cancelarProducto.cancelarProductoCliente(idDetalle);
            return validacion;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO CANCELAR PRODUCTO CLIENTE ---> " + e);
            return false;
        }
    }

    public boolean cancelarProductoAlquilado(int idSoli) {
        try {
            alquilerDAO productosAlquilado = new alquilerDAO();
            boolean validarAlquiler = productosAlquilado.cancelarPrimeroSolicitud(idSoli);
            if (validarAlquiler) {
                alquilerDAO estado = new alquilerDAO();
                boolean validarCancelar = estado.cancelarDespuesAlquiler(idSoli);
                return validarCancelar;
            }

            return false;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO CANCELAR PRODUCTO CLIENTE ---> " + e);
            return false;
        }
    }

    public boolean confirmarServcio(int idSolicitud) {
        try {
            solicitudProductoDAO confirmarServicio = new solicitudProductoDAO();
            boolean validarConfirmar = confirmarServicio.confirmarServicio(idSolicitud);
            return validarConfirmar;

        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO CONFIRMAR SERVICIO ---> " + e);
            return false;
        }
    }

    public boolean confirmarAlquiler(int idSolicitud) {
        try {
            solicitudProductoDAO confirmarAlq = new solicitudProductoDAO();
            boolean validarConfirmar = confirmarAlq.confirmarServicio(idSolicitud);
            if (validarConfirmar) {
                solicitudProductoDAO alquilarF = new solicitudProductoDAO();
                boolean confirmarAlquiler = alquilarF.confirmarAlquiler(idSolicitud);
                return confirmarAlquiler;
            }
            return false;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO CONFIRMAR SERVICIO ---> " + e);
            return false;
        }
    }

    public boolean denegarAlquiler(int idSolicitud) {
        try {
            solicitudProductoDAO confirmarAlq = new solicitudProductoDAO();

            boolean confirmarAlquiler = confirmarAlq.denegarAlquiler(idSolicitud);
            return confirmarAlquiler;

        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO CONFIRMAR SERVICIO ---> " + e);
            return false;
        }
    }

    public boolean denegarServcio(int idSolicitud) {
        try {
            solicitudProductoDAO confirmarServicio = new solicitudProductoDAO();
            boolean validarDenegar = confirmarServicio.denegarServicio(idSolicitud);
            return validarDenegar;

        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO CONFIRMAR SERVICIO ---> " + e);
            return false;
        }
    }

    public boolean terminarSolicitud(int idSolicitud) {
        try {
            solicitudProductoDAO terminarSolicitud = new solicitudProductoDAO();
            boolean validarDenegar = terminarSolicitud.terminarSolicitud(idSolicitud);
            return validarDenegar;

        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO CONFIRMAR SERVICIO ---> " + e);
            return false;
        }
    }

    public boolean terminarAlquiler(int idSolicitud) {
        try {
            solicitudProductoDAO terminarSolicitud = new solicitudProductoDAO();
            boolean validarDenegar = terminarSolicitud.terminarSolicitud(idSolicitud);
            if (validarDenegar) {
                solicitudProductoDAO alqTerminar = new solicitudProductoDAO();
                boolean alqTFinal = alqTerminar.terminarAlquiler(idSolicitud);
                return alqTFinal;
            }
            return false;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO CONFIRMAR SERVICIO ---> " + e);
            return false;
        }
    }

    public ArrayList<solicitudProductoVO> todosProductosAdm() {
        try {
            solicitudProductoDAO dao = new solicitudProductoDAO();
            ArrayList<solicitudProductoVO> productos = dao.todoSolicitudProducto();
            return productos;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO LISTAR SOLICITUDES PRODUCTOS ADMIN ---> " + e);
            return null;
        }
    }

    public ArrayList<alquilerVO> todosAlquiler() {
        try {
            alquilerDAO daoAlquiler = new alquilerDAO();
            ArrayList<alquilerVO> alquilerAll = daoAlquiler.listarAllAlquilerAdmin();
            if (alquilerAll != null) {
                return alquilerAll;
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR LISTANDO ALQUILER PARA ADMIN ---> " + e);
            return null;
        }
    }

    public ArrayList<alquilerVO> alquierTerminado(int id) {
        try {
            alquilerDAO listar = new alquilerDAO();
            ArrayList<alquilerVO> alquileres = listar.alquilerTerminado(id);
            if (alquileres != null) {
                return alquileres;
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO LISTAR ALQUILERES PARA USUARIO--->"+e);
            return null;
        }
    }
    
    public ArrayList<productoVO> controlInventario(){
        try {
            productoDAO productos = new productoDAO();
            ArrayList<productoVO> inventario = productos.inventario();
            if (inventario != null) {
                return inventario;
            }else{
                return null;
            }
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO INVENTARIO PARA ADMIN--->"+e);
            return null;
        }
    }
    
    public ArrayList<productoVO> controlInventarioActProducto(int id){
        try {
            productoDAO productos = new productoDAO();
            ArrayList<productoVO> inventario = productos.inventarioActPoner(id);
            if (inventario != null) {
                return inventario;
            }else{
                return null;
            }
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO INVENTARIO PARA ADMIN--->"+e);
            return null;
        }
    }
    
    public boolean actualizarIvtFinal(String nombre, String marca, String estado, String referencia, String descripcion, String capacidad,float valorU,int idProducto, int tipoPro){
        try {
            productoDAO actualizar = new productoDAO();
            boolean vActualizar = actualizar.actualizarInvtProducto(nombre, marca, estado, referencia, descripcion, capacidad, valorU, idProducto, tipoPro);
            return vActualizar;
        } catch (Exception e) {
            System.out.println("ERROR CONTROLANDO ACTUALIZAR PRODUCTO");
            return false;
        }
    }
}// Fin clase controlProductos
