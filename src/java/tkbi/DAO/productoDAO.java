/**
 * TrekBusi Autor : Diego Ruiz
 */
//Nombre del paquete
package tkbi.DAO;

//Librerias importadas
import com.sun.xml.ws.tx.at.v10.types.PrepareResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tkbi.VO.productoVO;

//Inicio clase productoDAO
public class productoDAO extends conexion {

    // Inicio constructor
    public productoDAO() {
        super();
    }// Fin constructor

    // Método consultar producto
    public ArrayList<productoVO> consultar(int cantidadMuestra) throws SQLException {
        String sqlAll = "SELECT producto.nombre, tipo_producto.nombreT, producto.descripcion, producto.referencia, producto.marca, producto.valorUnitario, producto.capacidad, producto.estado, producto.imagen, producto.cantidad, producto.idProducto FROM producto INNER JOIN tipo_producto ON tipo_producto.idTipo_Producto = producto.tipo_producto_idTipoProducto LIMIT ?,9";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(sqlAll);
            sentencia.setInt(1, cantidadMuestra);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<productoVO> productosAll = new ArrayList<>();

            while (resultado.next()) {
                productoVO producto = new productoVO();
                producto.setNombreTproducto(resultado.getString("nombreT"));
                int cantidad = resultado.getInt("cantidad");
                if (cantidad != 0) {
                    producto.setCantidad(resultado.getInt("cantidad"));
                } else {
                    producto.setCantidad(0000);
                }
                String capacidad = resultado.getString("capacidad");
                if (capacidad != null) {
                    producto.setCapacidad(resultado.getString("capacidad"));
                } else {
                    producto.setCapacidad("Vacio");
                }
                producto.setDescripcion(resultado.getString("descripcion"));
                producto.setEstado(resultado.getString("estado"));
                String foto = resultado.getString("imagen");
                if (foto != null) {
                    producto.setFoto(resultado.getString("imagen"));
                } else {
                    producto.setFoto("Foto predeterminada");
                }

                producto.setIdProducto(resultado.getInt("idProducto"));
                String marca = resultado.getString("marca");
                if (marca != null) {
                    producto.setMarca(resultado.getString("marca"));
                } else {
                    producto.setMarca("Desconocida");
                }

                producto.setNombre(resultado.getString("nombre"));
                String referencia = resultado.getString("referencia");
                if (referencia != null) {
                    producto.setReferencia(resultado.getString("referencia"));
                } else {
                    producto.setReferencia("Desconocida");
                }

                float valorU = resultado.getFloat("valorUnitario");
                if (valorU != 0 && valorU > 0) {
                    producto.setValorUnitario(resultado.getFloat("valorUnitario"));
                } else {
                    producto.setValorUnitario(0000);
                }
                productosAll.add(producto);

            }
            return productosAll;
        } catch (Exception e) {
            return null;
        } finally {
            this.getCon().close();
        }

    }

    public void ingresarProductoADMIN(int idTipoProducto, String nombre, String descripcion, String referencia, String marca, float valorUnitario, String capacidad, String estado, String cantidad, String imagen) throws SQLException {

        try {
            String sql = "INSERT INTO producto(tipo_producto_idTipoProducto,nombre,descripcion,referencia,marca,valorUnitario,capacidad, estado, cantidad, imagen) VALUES(?,?,?,?,?,?,?,?,?,?)";
            String img = imagen;
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            sentencia.setInt(1, idTipoProducto);
            sentencia.setString(2, nombre);
            sentencia.setString(3, descripcion);
            sentencia.setString(4, referencia);
            sentencia.setString(5, marca);
            sentencia.setFloat(6, valorUnitario);
            sentencia.setString(7, capacidad);
            sentencia.setString(8, estado);
            sentencia.setString(9, cantidad);
            sentencia.setString(10, img);
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.getCon().close();
        }

    }

    // Método consultar producto
    public productoVO consultarPorSegur(int iSeguD) throws SQLException {
        try {
            String sql = "SELECT producto.nombre, tipo_producto.nombreT, producto.descripcion, producto.referencia, producto.marca, producto.valorUnitario, producto.capacidad, producto.estado, producto.imagen, producto.cantidad, producto.idProducto FROM producto INNER JOIN tipo_producto ON tipo_producto.idTipo_Producto = producto.tipo_producto_idTipoProducto where producto.idProducto = ?";
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            sentencia.setInt(1, iSeguD);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                productoVO producto = new productoVO();
                producto.setNombreTproducto(resultado.getString("nombreT"));
                int cantidad = resultado.getInt("cantidad");
                if (cantidad != 0) {
                    producto.setCantidad(resultado.getInt("cantidad"));
                } else {
                    producto.setCantidad(0000);
                }
                String capacidad = resultado.getString("capacidad");
                if (capacidad != null) {
                    producto.setCapacidad(resultado.getString("capacidad"));
                } else {
                    producto.setCapacidad("Vacio");
                }
                producto.setDescripcion(resultado.getString("descripcion"));
                producto.setEstado(resultado.getString("estado"));
                String foto = resultado.getString("imagen");
                if (foto != null) {
                    producto.setFoto(resultado.getString("imagen"));
                } else {
                    producto.setFoto("Foto predeterminada");
                }

                producto.setIdProducto(resultado.getInt("idProducto"));
                String marca = resultado.getString("marca");
                if (marca != null) {
                    producto.setMarca(resultado.getString("marca"));
                } else {
                    producto.setMarca("Desconocida");
                }

                producto.setNombre(resultado.getString("nombre"));
                String referencia = resultado.getString("referencia");
                if (referencia != null) {
                    producto.setReferencia(resultado.getString("referencia"));
                } else {
                    producto.setReferencia("Desconocida");
                }

                float valorU = resultado.getFloat("valorUnitario");
                if (valorU != 0 && valorU > 0) {
                    producto.setValorUnitario(resultado.getFloat("valorUnitario"));
                } else {
                    producto.setValorUnitario(0000);
                }
                return producto;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.getCon().close();
        }
        return null;

    }//Fin método consultar productos por id

    public ArrayList<productoVO> consultarMarca() throws SQLException {
        try {
            String sql = "SELECT DISTINCT(marca) FROM producto";
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<productoVO> listasMarcas = new ArrayList<>();

            while (resultado.next()) {
                productoVO marca = new productoVO();
                marca.setMarca(resultado.getString("marca"));
                listasMarcas.add(marca);
            }

            return listasMarcas;
        } catch (Exception e) {
            System.out.println(e);

            return null;
        } finally {
            this.getCon().close();
        }

    }//Fin método consultar pro marca

    public ArrayList<productoVO> consultarReferencia() throws SQLException {
        try {
            String sql = "SELECT DISTINCT(referencia) FROM producto";
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<productoVO> listasReferencia = new ArrayList<>();

            while (resultado.next()) {
                productoVO referencia = new productoVO();
                referencia.setReferencia(resultado.getString("referencia"));
                listasReferencia.add(referencia);
            }
            this.getCon().close();
            return listasReferencia;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            this.getCon().close();
        }

    }//Fin método marca

    public ArrayList<productoVO> inventario() throws SQLException {
        String queryInventario = "SELECT producto.idProducto,producto.nombre,producto.descripcion,producto.referencia,producto.marca,producto.valorUnitario,producto.capacidad,producto.estado,producto.imagen, tipo_producto.nombreT FROM producto INNER JOIN tipo_producto ON producto.tipo_producto_idTipoProducto = tipo_producto.idTipo_Producto";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(queryInventario);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<productoVO> inventario = new ArrayList<>();
            while (resultado.next()) {
                productoVO producto = new productoVO();
                producto.setIdProducto(resultado.getInt("idProducto"));
                producto.setNombreTproducto(resultado.getString("nombreT"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setDescripcion(resultado.getString("descripcion"));
                producto.setReferencia(resultado.getString("referencia"));
                producto.setMarca(resultado.getString("marca"));
                producto.setValorUnitario(resultado.getFloat("valorUnitario"));
                producto.setCapacidad(resultado.getString("capacidad"));
                producto.setEstado(resultado.getString("estado"));
                producto.setFoto(resultado.getString("imagen"));
                inventario.add(producto);
            }
            return inventario;
        } catch (Exception e) {
            System.out.println("ERROR LISTANDO INVENTARIO " + e);
            return null;
        } finally {
            this.getCon().close();
        }
    }

    public ArrayList<productoVO> inventarioActPoner(int idProducto) throws SQLException {
        String queryInventario = "SELECT producto.idProducto,producto.nombre,producto.descripcion,producto.referencia,producto.marca,producto.valorUnitario,producto.capacidad,producto.estado,producto.imagen, tipo_producto.nombreT, tipo_producto.idTipo_Producto FROM producto INNER JOIN tipo_producto ON producto.tipo_producto_idTipoProducto = tipo_producto.idTipo_Producto WHERE producto.IdProducto = ?";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(queryInventario);
            sentencia.setInt(1, idProducto);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<productoVO> inventario = new ArrayList<>();
            while (resultado.next()) {
                productoVO producto = new productoVO();
                producto.setIdProducto(resultado.getInt("idProducto"));
                producto.setNombreTproducto(resultado.getString("nombreT"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setDescripcion(resultado.getString("descripcion"));
                producto.setReferencia(resultado.getString("referencia"));
                producto.setMarca(resultado.getString("marca"));
                producto.setValorUnitario(resultado.getFloat("valorUnitario"));
                producto.setCapacidad(resultado.getString("capacidad"));
                producto.setEstado(resultado.getString("estado"));
                producto.setFoto(resultado.getString("imagen"));
                producto.setIdTipoPro(resultado.getInt("idTipo_Producto"));
                inventario.add(producto);
            }
            return inventario;
        } catch (Exception e) {
            System.out.println("ERROR LISTANDO INVENTARIO " + e);
            return null;
        } finally {
            this.getCon().close();
        }
    }
    
    public boolean actualizarInvtProducto(String nombre, String marca, String estado, String referencia, String descripcion, String capacidad,float valorU,int idProducto, int tipoPro) throws SQLException{
        String queryActInvt = "UPDATE producto SET nombre = ?,descripcion = ?,referencia = ?,marca = ?,valorUnitario = ?,capacidad = ?,estado = ?,tipo_producto_idTipoProducto = ? WHERE idProducto = ? ";        
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(queryActInvt);
            sentencia.setString(1, nombre);
            sentencia.setString(2, descripcion);
            sentencia.setString(3, referencia);
            sentencia.setString(4, marca);
            sentencia.setFloat(5, valorU);
            sentencia.setString(6, capacidad);
            sentencia.setString(7, estado);
            sentencia.setInt(8, tipoPro);
            sentencia.setInt(9, idProducto);
            sentencia.executeUpdate();
            return true;            
        } catch (Exception e) {
            System.out.println("ERRO ACTUALIZANDO PRODUCTO DESDE EL INVENTARIO-->"+e);
            return false;
        }finally{
            this.getCon().close();
        }
    }

}//Fin clase productoDAO
