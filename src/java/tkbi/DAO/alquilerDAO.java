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
import java.util.Calendar;
import java.util.GregorianCalendar;
import tkbi.VO.alquilerVO;

//Inicio clase alquilerDAO
public class alquilerDAO extends conexion {

    public alquilerDAO() {
        super();
    }

    public boolean cancelarPrimeroSolicitud(int id) throws SQLException {
        String queryAlquiler = "UPDATE solicitudproducto SET estado = 'Cancelado' WHERE idSolicitud = ?";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(queryAlquiler);
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR CANCELANDO PRIMERO SOLICITUD ANTES DE ALQUIELER -->" + e);
            return false;
        } finally {
            this.getCon().close();
        }
    }

    public boolean cancelarDespuesAlquiler(int id) throws SQLException {
        String queryAlquiler = "UPDATE alquiler SET estado = 'Cancelado' WHERE solicitudProducto_idSolicitud = ?";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(queryAlquiler);
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR CANCELANDO PRIMERO SOLICITUD ANTES DE ALQUIELER -->" + e);
            return false;
        } finally {
            this.getCon().close();
        }
    }
     public boolean solicitudPrimeroSolicitud(int id) throws SQLException {
        String queryAlquiler = "UPDATE solicitudproducto SET estado = 'Pendiente' WHERE idSolicitud = ?";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(queryAlquiler);
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR CANCELANDO PRIMERO SOLICITUD ANTES DE ALQUIELER -->" + e);
            return false;
        } finally {
            this.getCon().close();
        }
    }
    public boolean solicitudDespuesAlquiler(int id) throws SQLException {
        String queryAlquiler = "UPDATE alquiler SET estado = 'Pendiente' WHERE solicitudProducto_idSolicitud = ?";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(queryAlquiler);
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR CANCELANDO PRIMERO SOLICITUD ANTES DE ALQUIELER -->" + e);
            return false;
        } finally {
            this.getCon().close();
        }
    }

    // Método registrar solicitad producto
    public boolean alquilarProducto(int iSeguD, String nombre, String descripcion, float total, int totalPro) throws SQLException {
        try {
            String sql = "INSERT INTO solicitudproducto(usuarios_idUsuarios,nombre,presupuestoDis,estado,fechaPedido,descripcion, servicio) VALUES(?,?,?,?,?,?,?)";
            Calendar fechaPed = new GregorianCalendar();
            int año = fechaPed.get(Calendar.YEAR);
            int mes = fechaPed.get(Calendar.MONTH) + 1;
            int dia = fechaPed.get(Calendar.DAY_OF_MONTH);
            int hora = fechaPed.get(Calendar.HOUR_OF_DAY);
            String totalP = String.valueOf(totalPro);
            descripcion += totalP + "; ";
            String estado = "Pendiente";
            String serv = "Alquiler";
            String fechaPedi = String.valueOf(dia + "/" + mes + "/" + año + " Hora: " + hora);
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            sentencia.setInt(1, iSeguD);
            sentencia.setString(2, nombre);
            sentencia.setFloat(3, total);
            sentencia.setString(4, estado);
            sentencia.setString(5, fechaPedi);
            sentencia.setString(6, descripcion);
            sentencia.setString(7, serv);
            sentencia.executeUpdate();
            sentencia.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            this.getCon().close();
        }

    }

    public boolean insertarSolicitudAlquiler(int idSolicitud, String fechaInicio, String fechaFin, float costo) throws SQLException {
        try {
            String sql = "INSERT INTO alquiler(solicitudProducto_idSolicitud,fechaInicio,fechaFin,costo,estado)VALUES(?,?,?,?,?)";
            Calendar fechaPed = new GregorianCalendar();
            String estado = "Pendiente";
            int año = fechaPed.get(Calendar.YEAR);
            int mes = fechaPed.get(Calendar.MONTH);
            int dia = fechaPed.get(Calendar.DAY_OF_MONTH);
            int hora = fechaPed.get(Calendar.HOUR_OF_DAY);

            String fechaPedi = String.valueOf(dia + "/" + mes + "/" + año + " Hora: " + hora);
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            sentencia.setInt(1, idSolicitud);
            sentencia.setString(2, fechaInicio);
            sentencia.setString(3, fechaFin);
            sentencia.setFloat(4, costo);
            sentencia.setString(5, estado);

            sentencia.executeUpdate();
            sentencia.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            this.getCon().close();
        }

    }

    public ArrayList<alquilerVO> listarAllAlquilerAdmin() throws SQLException {
        String listarQuery = "SELECT alquiler.idAlquiler,alquiler.fechaInicio,alquiler.fechaFin,alquiler.costo,alquiler.estado,usuarios.correos, solicitudproducto.idSolicitud,solicitudproducto.nombre,solicitudproducto.fechaPedido,solicitudproducto.descripcion, usuarios.idUsuarios,usuarios.nombre_razon,usuarios.apellido1,usuarios.ciudad,usuarios.direccion,usuarios.telefonos FROM alquiler INNER JOIN solicitudproducto ON alquiler.solicitudProducto_idSolicitud = solicitudproducto.idSolicitud INNER JOIN usuarios ON solicitudproducto.usuarios_idUsuarios = usuarios.idUsuarios ORDER BY alquiler.idAlquiler DESC";
        ArrayList<alquilerVO> alquilerAll = new ArrayList<>();

        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(listarQuery);
            ResultSet listaRta = sentencia.executeQuery();
            while (listaRta.next()) {
                alquilerVO alquiler = new alquilerVO();
                alquiler.setCiudad(listaRta.getString("ciudad"));
                alquiler.setDireccion(listaRta.getString("direccion"));
                alquiler.setTelefono(listaRta.getString("telefonos"));
                alquiler.setCorreo(listaRta.getString("correos"));
                String nombre1 = listaRta.getString("nombre_razon");
                String apellido1 = listaRta.getString("apellido1");
                String nUsuario = nombre1 + " " + apellido1;
                alquiler.setUsuario(nUsuario);
                alquiler.setDescripcion(listaRta.getString("descripcion"));
                alquiler.setEstado(listaRta.getString("estado"));
                alquiler.setFechaPedido(listaRta.getString("fechaPedido"));
                alquiler.setCosto(listaRta.getFloat("costo"));
                alquiler.setNombreSolicitud(listaRta.getString("nombre"));
                alquiler.setIdSolicitud(listaRta.getInt("idSolicitud"));
                alquiler.setIdAlquiler(listaRta.getInt("idAlquiler"));
                alquiler.setFechaFin(listaRta.getString("fechaFin"));
                alquiler.setFechaInicio(listaRta.getString("fechaInicio"));
                alquilerAll.add(alquiler);
            }
            return alquilerAll;

        } catch (Exception e) {
            System.out.println("ERROR CONSULTANDO ALQUILER ---> " + e);
            return null;
        } finally {
            this.getCon().close();
        }
    }

    public ArrayList<alquilerVO> listarAlquilerTodos(int id) throws SQLException {
        String query1 = "SELECT alquiler.idAlquiler, alquiler.fechaInicio,alquiler.fechaFin,alquiler.costo, solicitudproducto.fechaPedido, solicitudproducto.estado,solicitudproducto.descripcion, solicitudproducto.nombre, solicitudproducto.idSolicitud FROM alquiler INNER JOIN solicitudproducto ON alquiler.solicitudProducto_idSolicitud = solicitudproducto.idSolicitud WHERE solicitudproducto.usuarios_idUsuarios = ?";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(query1);
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<alquilerVO> alquilerAll = new ArrayList<>();

            while (resultado.next()) {
                alquilerVO alqBuy = new alquilerVO();
                alqBuy.setNombreProducto(resultado.getString("nombre"));
                alqBuy.setDescripcion(resultado.getString("descripcion"));
                alqBuy.setIdSolicitud(resultado.getInt("idSolicitud"));
                alqBuy.setEstado(resultado.getString("estado"));
                alqBuy.setFechaPedido(resultado.getString("fechaPedido"));
                alqBuy.setFechaFin(resultado.getString("fechaFin"));
                alqBuy.setFechaInicio(resultado.getString("fechaInicio"));
                alqBuy.setCosto(resultado.getFloat("costo"));
                alqBuy.setIdAlquiler(resultado.getInt("idAlquiler"));
                alquilerAll.add(alqBuy);
            }
            return alquilerAll;
        } catch (Exception e) {
            System.out.println("ERROR CAPTURANDO INFORMACION LISTAR PRODUCTOS COMPRADOS " + e);
            return null;
        } finally {
            this.getCon().close();
        }
    }
    
    public ArrayList<alquilerVO> alquilerTerminado(int id) throws SQLException{
        String listarTerminado = "SELECT alquiler.fechaInicio,alquiler.fechaFin,alquiler.costo,solicitudproducto.nombre,solicitudproducto.descripcion,solicitudproducto.estado, solicitudproducto.fechaPedido FROM alquiler INNER JOIN solicitudproducto ON alquiler.solicitudProducto_idSolicitud = solicitudproducto.idSolicitud WHERE solicitudproducto.usuarios_idUsuarios = ? AND solicitudproducto.estado = 'Terminado'";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(listarTerminado);
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<alquilerVO> alquileresAll = new ArrayList<>();
            while(resultado.next()){
                alquilerVO alquiler = new alquilerVO();
                alquiler.setFechaFin(resultado.getString("fechaFin"));
                alquiler.setFechaInicio(resultado.getString("fechaInicio"));
                alquiler.setFechaPedido(resultado.getString("fechaPedido"));
                alquiler.setNombreProducto(resultado.getString("nombre"));
                alquiler.setCosto(resultado.getFloat("costo"));
                alquiler.setDescripcion(resultado.getString("descripcion"));
                alquiler.setEstado(resultado.getString("estado"));
                alquileresAll.add(alquiler);
            }
            return alquileresAll;
        } catch (Exception e) {
            System.out.println("ERROR CONSULTANDO ALQUILERES TERMINADOS -->"+e);
            return null;
        }
    }

}//Fin clase alquilerDAO


