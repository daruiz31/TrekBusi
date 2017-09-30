/**
 *
 * TrekBusi
 *
 * Autor : Diego Ruiz
 *
 *
 */
//Nombre del paquete
package tkbi.DAO;

//Librerias importadas
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tkbi.VO.tipoProductoVO;

//Inicio clase usuariosDAO
public class tipoProductoDAO extends conexion {

    // Inicio constructor
    public tipoProductoDAO() {
        super();
    }// Fin constructor

    // Método consultar producto
    public ArrayList<tipoProductoVO> consultar() throws SQLException {
        try {
            String sql = "SELECT * FROM producto tipo_producto";
        PreparedStatement sentencia = this.getCon().prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        ArrayList<tipoProductoVO> listasProductos = new ArrayList<>();

        if(resultado.next()) {
            tipoProductoVO tipoPro = new tipoProductoVO();
            tipoPro.setDescripcion(resultado.getString("descripcion"));
            tipoPro.setIdTipo_producto(resultado.getInt("idTipo_Producto"));
            tipoPro.setNombre(resultado.getString("nombre"));
            tipoPro.setSuministro(resultado.getString("suministro"));
        }
       
        return listasProductos;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            this.getCon().close();
        }
        
    }//Fin método consultar productos

    public ArrayList<tipoProductoVO> consultarServicio() throws SQLException {
        try {
            String sql = "SELECT * FROM tipo_producto WHERE servicio = 'Si'";
        PreparedStatement sentencia = this.getCon().prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        ArrayList<tipoProductoVO> listasProductos = new ArrayList<>();

        while (resultado.next()) {
            tipoProductoVO tipoPro = new tipoProductoVO();
            tipoPro.setDescripcion(resultado.getString("descripcion"));
            tipoPro.setIdTipo_producto(resultado.getInt("idTipo_Producto"));
            tipoPro.setNombre(resultado.getString("nombreT"));
            tipoPro.setSuministro(resultado.getString("servicio"));
            listasProductos.add(tipoPro);
        }
        
        return listasProductos;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            this.getCon().close();
        }
        
        
    }//Fin método consultar productos

    public tipoProductoVO descripcionServicio(String tiposServicio) throws SQLException {
        try {
            String sql = "SELECT descripcion FROM tipo_producto WHERE nombreT = ?";
        PreparedStatement sentencia = this.getCon().prepareStatement(sql);
        sentencia.setString (1, tiposServicio);
        ResultSet resultado = sentencia.executeQuery();
        tipoProductoVO tipoPro = new tipoProductoVO();
        if (resultado.next()) {
            tipoPro.setDescripcion(resultado.getString("descripcion"));
        }else{
            tipoPro.setDescripcion("Elige una opción.");
        }
       
        return tipoPro;
        } catch (Exception e) {
            return null;
        }finally{
            this.getCon().close();
        }
        
    }
    
    public ArrayList<tipoProductoVO> consultarProductos() throws SQLException {
        try {
            String sql = "SELECT * FROM tipo_producto WHERE servicio = 'No'";
        PreparedStatement sentencia = this.getCon().prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        ArrayList<tipoProductoVO> listasProductos = new ArrayList<>();

        while (resultado.next()) {
            tipoProductoVO tipoPro = new tipoProductoVO();
            tipoPro.setDescripcion(resultado.getString("descripcion"));
            tipoPro.setIdTipo_producto(resultado.getInt("idTipo_Producto"));
            tipoPro.setNombre(resultado.getString("nombreT"));
            tipoPro.setSuministro(resultado.getString("servicio"));
            listasProductos.add(tipoPro);
        }
        return listasProductos;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            this.getCon().close();
        }
        
    }//Fin método consultar productos
    
    public boolean agregarServicioAdm(String nombreT, String descripcion) throws SQLException{
        String insert = "INSERT INTO tipo_producto(nombreT,descripcion,servicio)VALUES(?,?,'Si')";
        
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(insert);
            sentencia.setString(1, nombreT);
            sentencia.setString(2, descripcion);
            sentencia.executeUpdate();
            sentencia.close();                   
            return true;
        } catch (Exception e) {
            System.out.println("ERROR INSERTANDO NUEVO SERVICIO POR ADMIN " + e);
            return false;
        }finally{
            this.getCon().close();
        }
    }
    
    public ArrayList consultarServicioIngresado(String nombreServicio) throws SQLException{
        String buscar = "SELECT nombreT FROM tipo_producto";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(buscar);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList nombreServicios = new ArrayList();
            while(resultado.next()){
                nombreServicios.add(resultado.getString("nombreT"));
                
            }
            return nombreServicios;
        } catch (Exception e) {
            System.out.println("ERROR BUSCANDO COINCIDENCIAS POR EL NOMBRE DEL SERVICIO");
            return null;
        }finally{
            this.getCon().close();
        }        
    }


}//Fin clase productoDAO
