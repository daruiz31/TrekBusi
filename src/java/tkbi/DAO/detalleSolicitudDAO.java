package tkbi.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tkbi.VO.detalleSolicitudVO;

public class detalleSolicitudDAO extends conexion{

    public detalleSolicitudDAO() {
        super();
    }
    
    public boolean insetarDetalleSolicitud(int idProducto, int idSolicitud) throws SQLException{
        try {
            String sql = "INSERT INTO detallesolicitud(producto_idProducto, solicitud_idSolicitud)VALUES(?,?)";
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            sentencia.setInt(1, idProducto);
            sentencia.setInt(2, idSolicitud);
            sentencia.executeUpdate();
            sentencia.close();
                    
            return true;
        } catch (Exception e) {
            System.out.println("ERROR AL INSERTAR DETALLE DE SOLICITUD ---> " + e);
            return false;
        }finally{
            this.getCon().close();
        }        
    }
    
    public ArrayList<detalleSolicitudVO> listarProductosBuy(int id) throws SQLException{
        String query1 = "SELECT producto.imagen, tipo_producto.nombreT, producto.nombre, producto.marca, producto.descripcion, producto.valorUnitario, solicitudproducto.fechaPedido, solicitudproducto.usuarios_idUsuarios FROM producto INNER JOIN detallesolicitud ON detallesolicitud.producto_idProducto = producto.idProducto INNER JOIN solicitudproducto ON detallesolicitud.solicitud_idSolicitud = solicitudproducto.idSolicitud INNER JOIN tipo_producto ON producto.tipo_producto_idTipoProducto = tipo_producto.idTipo_Producto WHERE solicitudproducto.usuarios_idUsuarios = ? AND solicitudproducto.estado = \"Terminado\"";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(query1);
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<detalleSolicitudVO> productosAll = new ArrayList<>();
            
            while (resultado.next()){
                detalleSolicitudVO productoBuy = new detalleSolicitudVO();
                productoBuy.setFoto(resultado.getString("imagen"));
                productoBuy.setTipoProducto(resultado.getString("nombreT"));
                productoBuy.setNombre(resultado.getString("nombre"));
                productoBuy.setMarca(resultado.getString("marca"));
                productoBuy.setDescripcion(resultado.getString("descripcion"));
                productoBuy.setTotal(resultado.getFloat("valorUnitario"));
                productoBuy.setFechaSolicitud(resultado.getString("fechaPedido"));
                productosAll.add(productoBuy);
            }
            return productosAll;
        } catch (Exception e) {
            System.out.println("ERROR CAPTURANDO INFORMACION LISTAR PRODUCTOS COMPRADOS " + e);
            return null;
        }finally{
            this.getCon().close();
        }
    }
    
    public ArrayList<detalleSolicitudVO> listarProductosTodos(int id) throws SQLException{
        String query1 = "SELECT producto.imagen, tipo_producto.nombreT, producto.nombre, producto.marca, producto.descripcion, producto.valorUnitario, solicitudproducto.fechaPedido, solicitudproducto.usuarios_idUsuarios, solicitudproducto.estado, solicitudproducto.idSolicitud, detallesolicitud.idDetalleSolicitud FROM producto INNER JOIN detallesolicitud ON detallesolicitud.producto_idProducto = producto.idProducto INNER JOIN solicitudproducto ON detallesolicitud.solicitud_idSolicitud = solicitudproducto.idSolicitud INNER JOIN tipo_producto ON producto.tipo_producto_idTipoProducto = tipo_producto.idTipo_Producto WHERE solicitudproducto.usuarios_idUsuarios = ? AND solicitudproducto.estado != \"Terminado\"";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(query1);
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<detalleSolicitudVO> productosAll = new ArrayList<>();
            
            while (resultado.next()){
                detalleSolicitudVO productoBuy = new detalleSolicitudVO();
                productoBuy.setFoto(resultado.getString("imagen"));
                productoBuy.setTipoProducto(resultado.getString("nombreT"));
                productoBuy.setNombre(resultado.getString("nombre"));
                productoBuy.setMarca(resultado.getString("marca"));
                productoBuy.setDescripcion(resultado.getString("descripcion"));
                productoBuy.setTotal(resultado.getFloat("valorUnitario"));
                productoBuy.setFechaSolicitud(resultado.getString("fechaPedido"));
                productoBuy.setEstado(resultado.getString("estado"));
                productoBuy.setIdSolicitud(resultado.getInt("idSolicitud"));
                productoBuy.setIdDetalleSolicitud(resultado.getInt("idDetalleSolicitud"));
                productosAll.add(productoBuy);
            }
            return productosAll;
        } catch (Exception e) {
            System.out.println("ERROR CAPTURANDO INFORMACION LISTAR PRODUCTOS COMPRADOS " + e);
            return null;
        }finally{
            this.getCon().close();
        }
    }
    

    
    public int  DetalleEnSolicitud(int id) throws SQLException {
        try {
            int contador = 0;
            String sql = "SELECT COUNT(solicitudproducto.idSolicitud) AS contador FROM solicitudproducto INNER JOIN detallesolicitud ON detallesolicitud.solicitud_idSolicitud = solicitudproducto.idSolicitud WHERE solicitudproducto.usuarios_idUsuarios = ? AND solicitudproducto.estado != \"Terminado\"";
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            sentencia.setInt(1, id);
            ResultSet resultado2 = sentencia.executeQuery();
            while (resultado2.next()) {
                contador = resultado2.getInt("contador");
            }

            return contador;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        } finally {
            this.getCon().close();
        }
    }
    
    public boolean cancelarProductoCliente(int idSolicitud) throws SQLException{
        String query = "UPDATE solicitudproducto INNER JOIN detallesolicitud ON detallesolicitud.solicitud_idSolicitud = solicitudproducto.idSolicitud SET solicitudproducto.estado = \"Cancelado\" WHERE detallesolicitud.idDetalleSolicitud = ?";
        try {
        PreparedStatement sentencia = this.getCon().prepareStatement(query);
        sentencia.setInt(1, idSolicitud);
        sentencia.executeUpdate();
        return true;
        } catch (Exception e) {
            System.out.println("ERROR CANCELANDO PRODUCTO " +e);
            return false;
        }finally{
            this.getCon().close();
        }
    }
    
    public boolean solicitarProductoCliente(int idSolicitud) throws SQLException{
        String query = "UPDATE solicitudproducto INNER JOIN detallesolicitud ON detallesolicitud.solicitud_idSolicitud = solicitudproducto.idSolicitud SET solicitudproducto.estado = \"Pendiente\" WHERE detallesolicitud.idDetalleSolicitud = ?";
        try {
        PreparedStatement sentencia = this.getCon().prepareStatement(query);
        sentencia.setInt(1, idSolicitud);
        sentencia.executeUpdate();
        return true;
        } catch (Exception e) {
            System.out.println("ERROR CANCELANDO PRODUCTO " +e);
            return false;
        }finally{
            this.getCon().close();
        }
    }
}
