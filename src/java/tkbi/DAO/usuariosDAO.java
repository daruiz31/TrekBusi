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
import org.apache.commons.codec.digest.DigestUtils;
import tkbi.VO.usuariosVO;

//Inicio clase usuariosDAO
public class usuariosDAO extends conexion {

    // Inicio constructor
    public usuariosDAO() {
        super();
    }// Fin constructor

    // Método consultarUsuario por correo   
    public usuariosVO consultarUsuario(String correo, String contrasena) throws SQLException {
        try {
            String sql = "SELECT * FROM usuarios where correos = ? and contrasena = ?";
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            sentencia.setString(1, correo);
            sentencia.setString(2, contrasena);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                usuariosVO usuarios = new usuariosVO();
                usuarios.setIdUsuarios(resultado.getInt("idUsuarios"));
                usuarios.setContrasena(resultado.getString("contrasena"));
                usuarios.setCorreos(resultado.getString("correos"));
                usuarios.setNombre_RazonSocial(resultado.getString("nombre_razon"));
                usuarios.setApellido1(resultado.getString("apellido1"));
                String apellido2 = resultado.getString("apellido2");
                if (apellido2 != null) {
                    usuarios.setApellido2(apellido2);
                } else {
                    usuarios.setApellido2("Nulo");
                }
                String nombre2 = resultado.getString("nombre2");
                if (nombre2 != null) {
                    usuarios.setNombre2(resultado.getString("nombre2"));
                } else {
                    usuarios.setNombre2("Nulo");
                }
                usuarios.setCiudad(resultado.getString("ciudad"));
                usuarios.setDireccion(resultado.getString("direccion"));
                usuarios.setDocumento_Nit(resultado.getString("nit_documento"));
                usuarios.setEstado(resultado.getString("estado"));
                usuarios.setFechaCreacion(resultado.getString("fechaCreacion"));
                usuarios.setPais(resultado.getString("pais"));
                usuarios.setTelefonos(resultado.getString("telefonos"));
                usuarios.setRespuestaSeguridad(resultado.getString("respuestaSeguridad"));
                usuarios.setUsuario(resultado.getString("usuario"));
                usuarios.setIdRol(resultado.getInt("roles_idRoles"));
                
                return usuarios;
                
            }
            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.getCon().close();
        }
        return null;
    }// Fin método consultarUsuario

    // Método consultarUsuario por nombre 
    public usuariosVO consultarUsuarioNombre(String nombre) throws SQLException {
        try {
            String sql = "SELECT * FROM usuarios where usuario = ?";
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            sentencia.setString(1, nombre);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                usuariosVO usuarios = new usuariosVO();
                usuarios.setIdUsuarios(resultado.getInt("idUsuarios"));
                usuarios.setContrasena(resultado.getString("contrasena"));
                usuarios.setCorreos(resultado.getString("correos"));
                usuarios.setNombre_RazonSocial(resultado.getString("nombre_razon"));
                usuarios.setApellido1(resultado.getString("apellido1"));
                usuarios.setApellido2(resultado.getString("apellido2"));
                usuarios.setNombre2(resultado.getString("nombre2"));
                usuarios.setCiudad(resultado.getString("ciudad"));
                usuarios.setDireccion(resultado.getString("direccion"));
                usuarios.setDocumento_Nit(resultado.getString("nit_documento"));
                usuarios.setEstado(resultado.getString("estado"));
                usuarios.setFechaCreacion(resultado.getString("fechaCreacion"));
                usuarios.setPais(resultado.getString("pais"));
                usuarios.setTelefonos(resultado.getString("telefonos"));
                usuarios.setRespuestaSeguridad(resultado.getString("respuestaSeguridad"));
                usuarios.setUsuario(resultado.getString("usuario"));
                usuarios.setIdRol(resultado.getInt("roles_idRoles"));
                
                return usuarios;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.getCon().close();
        }
        
        return null;
    }// Fin método consultarUsuarioNombre

    public void registroCliente(String usu, String pass, String correo, String respuestaSegu, String fechaCreacion, String estado, String nombre_razon, String nombre2, String apellido1, String apellido2, String pais, String nit_documento, String ciudad, String direccion, String telefono, int idRol) throws SQLException {
        
        String iSeguD = DigestUtils.md5Hex(pass);
        
        try {
            
            String sql = "INSERT INTO usuarios(roles_idRoles,usuario,contrasena,correos,respuestaSeguridad,fechaCreacion,estado,nombre_razon,nombre2,apellido1,apellido2,pais,nit_documento,ciudad,direccion,telefonos) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            sentencia.setInt(1, idRol);
            sentencia.setString(2, usu);
            sentencia.setString(3, iSeguD);
            sentencia.setString(4, correo);
            sentencia.setString(5, respuestaSegu);
            sentencia.setString(6, fechaCreacion);
            sentencia.setString(7, estado);
            sentencia.setString(8, nombre_razon);
            sentencia.setString(9, nombre2);
            sentencia.setString(10, apellido1);
            sentencia.setString(11, apellido2);
            sentencia.setString(12, pais);
            sentencia.setString(13, nit_documento);
            sentencia.setString(14, ciudad);
            sentencia.setString(15, direccion);
            sentencia.setString(16, telefono);
            sentencia.executeUpdate();
            sentencia.close();
            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.getCon().close();
        }
        
    }// Fin método registrarCliente

    // Método consultarUsuario por correo   
    public usuariosVO consultarUsuarioID(int id) throws SQLException {
        try {
            String sql = "SELECT * FROM usuarios where idUsuarios = ?";
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                usuariosVO usuarios = new usuariosVO();
                usuarios.setIdUsuarios(resultado.getInt("idUsuarios"));
                usuarios.setContrasena(resultado.getString("contrasena"));
                usuarios.setCorreos(resultado.getString("correos"));
                usuarios.setNombre_RazonSocial(resultado.getString("nombre_razon"));
                usuarios.setApellido1(resultado.getString("apellido1"));
                String apellido2 = resultado.getString("apellido2");
                if (apellido2 != null) {
                    usuarios.setApellido2(apellido2);
                } else {
                    usuarios.setApellido2("Nulo");
                }
                String nombre2 = resultado.getString("nombre2");
                if (nombre2 != null) {
                    usuarios.setNombre2(resultado.getString("nombre2"));
                } else {
                    usuarios.setNombre2("Nulo");
                }
                usuarios.setCiudad(resultado.getString("ciudad"));
                usuarios.setDireccion(resultado.getString("direccion"));
                usuarios.setDocumento_Nit(resultado.getString("nit_documento"));
                usuarios.setEstado(resultado.getString("estado"));
                usuarios.setFechaCreacion(resultado.getString("fechaCreacion"));
                usuarios.setPais(resultado.getString("pais"));
                usuarios.setTelefonos(resultado.getString("telefonos"));
                usuarios.setRespuestaSeguridad(resultado.getString("respuestaSeguridad"));
                usuarios.setUsuario(resultado.getString("usuario"));
                usuarios.setIdRol(resultado.getInt("roles_idRoles"));
                
                return usuarios;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.getCon().close();
        }
        return null;
    }// Fin método consultarUsuario

    public boolean actualizarUsuarioID(String nombre1, String usuario, String nombre2, String pais, String ciudad, String documento, String apellido1, String apellido2, String direccion, String telefono, int id) throws SQLException {
        try {
            String sqlQuery = "UPDATE usuarios SET usuario = ?, nombre_razon = ?, nombre2 = ?, apellido1 = ?, apellido2 = ?, pais = ?, ciudad = ?, direccion = ?, telefonos = ? WHERE idUsuarios = ?";
            
            PreparedStatement sentencia = this.getCon().prepareStatement(sqlQuery);
            sentencia.setString(1, usuario);
            sentencia.setString(2, nombre1);
            sentencia.setString(3, nombre2);
            sentencia.setString(4, apellido1);
            sentencia.setString(5, apellido2);
            sentencia.setString(6, pais);
            sentencia.setString(7, ciudad);
            sentencia.setString(8, direccion);
            sentencia.setString(9, telefono);
            sentencia.setInt(10, id);
            
            sentencia.executeUpdate();
            
            return true;
        } catch (Exception e) {
            System.out.println("ERROR ACTUALIZANDO DATOS DE USUARIO " + e);
            return false;
        } finally {
            this.getCon().close();
        }
    }
    
    public boolean eliminarUsuxCliente(int idCliente) throws SQLException {
        try {
            String querySql = "UPDATE usuarios SET estado = 'eliminarxc' WHERE idUsuarios = ?";
            PreparedStatement sentencia = this.getCon().prepareStatement(querySql);
            sentencia.setInt(1, idCliente);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            this.getCon().close();
        }
        
    }
    
    public ArrayList<usuariosVO> listarAllUsu() throws SQLException {
        
//        String queryUser = "SELECT DISTINCT usuarios.nombre_razon, usuarios.nombre2, usuarios.apellido1, usuarios.apellido2, usuarios.correos, usuarios.telefonos, usuarios.estado, usuarios.nit_documento, usuarios.ciudad, usuarios.pais, usuarios.idUsuarios, usuarios.direccion, COUNT(solicitudproducto.idSolicitud) AS solicitudes, roles.tipoRol FROM usuarios INNER JOIN solicitudproducto ON solicitudproducto.usuarios_idUsuarios = usuarios.idUsuarios INNER JOIN roles ON usuarios.roles_idRoles = roles.idRoles GROUP BY usuarios.idUsuarios";
        String queryUser = "SELECT DISTINCT usuarios.nombre_razon, usuarios.nombre2, usuarios.apellido1, usuarios.apellido2, usuarios.correos, usuarios.telefonos, usuarios.estado, usuarios.nit_documento, usuarios.ciudad, usuarios.pais, usuarios.idUsuarios, usuarios.direccion, COUNT(solicitudproducto.idSolicitud) AS solicitudes, roles.tipoRol FROM usuarios INNER JOIN solicitudproducto ON solicitudproducto.usuarios_idUsuarios = usuarios.idUsuarios INNER JOIN roles ON usuarios.roles_idRoles = roles.idRoles GROUP BY usuarios.idUsuarios";
        try {
            PreparedStatement sentence = this.getCon().prepareStatement(queryUser);
            ResultSet result = sentence.executeQuery();
            ArrayList<usuariosVO> usuarios = new ArrayList<>();
            while (result.next()) {
                usuariosVO user = new usuariosVO();
                String nombre1 = result.getString("nombre_razon");
                String nombre2 = result.getString(("nombre2"));
                if (nombre2 == null || nombre2.equals(" ")) {
                    nombre2 = "Ninguno";
                }
                user.setUsuario(nombre1 + " " + nombre2);
                String apellido1 = result.getString("apellido1");
                String apellido2 = result.getString("apellido2");
                if (apellido2 == null || apellido2.equals(" ")) {
                    apellido2 = "Ninguno";
                }
                user.setApellido1(apellido1 + " " + apellido2);
                user.setCorreos(result.getString("correos"));
                user.setTelefonos(result.getString("telefonos"));
                user.setEstado(result.getString("estado"));
                user.setDocumento_Nit(result.getString("nit_documento"));
                user.setCiudad(result.getString("ciudad"));
                user.setPais(result.getString("pais"));
                user.setIdUsuarios(result.getInt("idUsuarios"));
                user.setDireccion(result.getString("direccion"));
                user.setSolicitudes(result.getInt("solicitudes"));
                user.setTipoUser(result.getString("tipoRol"));
                usuarios.add(user);
            }
            return usuarios;
        } catch (Exception e) {
            System.out.println("ERROR LISTANDO TODOS LOS USUARIOS " + e);
            return null;
        }
    }
    
     public ArrayList<usuariosVO> listarInactivos() throws SQLException {
        
//        String queryUser = "SELECT DISTINCT usuarios.nombre_razon, usuarios.nombre2, usuarios.apellido1, usuarios.apellido2, usuarios.correos, usuarios.telefonos, usuarios.estado, usuarios.nit_documento, usuarios.ciudad, usuarios.pais, usuarios.idUsuarios, usuarios.direccion, COUNT(solicitudproducto.idSolicitud) AS solicitudes, roles.tipoRol FROM usuarios INNER JOIN solicitudproducto ON solicitudproducto.usuarios_idUsuarios = usuarios.idUsuarios INNER JOIN roles ON usuarios.roles_idRoles = roles.idRoles GROUP BY usuarios.idUsuarios";
        String queryUser = "SELECT roles.tipoRol, usuarios.nombre_razon, usuarios.nombre2, usuarios.apellido1, usuarios.apellido2, usuarios.correos, usuarios.telefonos, usuarios.estado, usuarios.nit_documento, usuarios.ciudad, usuarios.pais, usuarios.idUsuarios, usuarios.direccion FROM usuarios INNER JOIN roles ON usuarios.roles_idRoles = roles.idRoles WHERE roles.idRoles != 1";
        try {
            PreparedStatement sentence = this.getCon().prepareStatement(queryUser);
            ResultSet result = sentence.executeQuery();
            ArrayList<usuariosVO> usuarios = new ArrayList<>();
            while (result.next()) {
                usuariosVO user = new usuariosVO();
                String nombre1 = result.getString("nombre_razon");
                String nombre2 = result.getString(("nombre2"));
                if (nombre2 == null || nombre2.equals(" ")) {
                    nombre2 = "Ninguno";
                }
                user.setUsuario(nombre1 + " " + nombre2);
                String apellido1 = result.getString("apellido1");
                String apellido2 = result.getString("apellido2");
                if (apellido2 == null || apellido2.equals(" ")) {
                    apellido2 = "Ninguno";
                }
                user.setApellido1(apellido1 + " " + apellido2);
                user.setCorreos(result.getString("correos"));
                user.setTelefonos(result.getString("telefonos"));
                user.setEstado(result.getString("estado"));
                user.setDocumento_Nit(result.getString("nit_documento"));
                user.setCiudad(result.getString("ciudad"));
                user.setPais(result.getString("pais"));
                user.setIdUsuarios(result.getInt("idUsuarios"));
                user.setDireccion(result.getString("direccion"));                
                user.setTipoUser(result.getString("tipoRol"));
                usuarios.add(user);
            }
            return usuarios;
        } catch (Exception e) {
            System.out.println("ERROR LISTANDO TODOS LOS USUARIOS " + e);
            return null;
        }
    }
    
    public boolean cambiarEstado(int id, String estado){
        
        try {
            String queryEstado = "UPDATE usuarios SET estado = ? WHERE idUsuarios = ?";
            PreparedStatement sentencia = this.getCon().prepareStatement(queryEstado);
            sentencia.setString(1, estado);
            sentencia.setInt(2, id);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR CAMBIANDO ESTADO USUARIO --> " +e);
            return false;
        }
    }
    
    public boolean cambiarRol(int id, int rol){
        try {
            String queryRol = "UPDATE usuarios SET roles_idRoles = ? WHERE idUsuarios = ?";
            PreparedStatement sentencia = this.getCon().prepareStatement(queryRol);
            sentencia.setInt(1, rol);
            sentencia.setInt(2, id);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR CAMBIANDO ROL DE USUARIO -->" +e);
            return false;
        }
    }
}//Fin clase usuariosDAO
