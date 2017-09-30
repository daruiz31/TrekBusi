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

import tkbi.VO.solicitudProductoVO;

public class solicitudProductoDAO extends conexion {

    public solicitudProductoDAO() {
        super();
    }

// Método registrar solicitad producto
    public void insertarSolicitudServicio(String descripcionB, String fecha, String nombre, float presupuesto, String estado, int idUsuario) throws SQLException {
        String sql = "INSERT INTO solicitudproducto(usuarios_idUsuarios,nombre,fechaServicio,presupuestoDis,estado,fechaPedido,descripcion,servicio) VALUES(?,?,?,?,?,?,?,?)";
        Calendar fechaPed = new GregorianCalendar();
        int año = fechaPed.get(Calendar.YEAR);
        int mes = fechaPed.get(Calendar.MONTH) + 1;
        int dia = fechaPed.get(Calendar.DAY_OF_MONTH);
        int hora = fechaPed.get(Calendar.HOUR_OF_DAY);
        String servicio = "Si";
        String fechaPedi = String.valueOf(dia + "/" + mes + "/" + año + " Hora: " + hora);
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            sentencia.setInt(1, idUsuario);
            sentencia.setString(2, nombre);
            sentencia.setString(3, fecha);
            sentencia.setFloat(4, presupuesto);
            sentencia.setString(5, estado);
            sentencia.setString(6, fechaPedi);
            sentencia.setString(7, descripcionB);
            sentencia.setString(8, servicio);
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.getCon().close();
        }

    }

    public ArrayList<solicitudProductoVO> consultarSolicitudServicio() throws SQLException {
        try {
            String sql = "SELECT * FROM solicitudproducto INNER JOIN usuarios ON usuarios.idUsuarios = solicitudproducto.usuarios_idUsuarios WHERE solicitudproducto.servicio = 'Si' and solicitudproducto.estado = 'Pendiente' ORDER BY `idSolicitud` DESC";
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<solicitudProductoVO> solicitudServicio = new ArrayList();

            while (resultado.next()) {
                solicitudProductoVO ingresarSoli = new solicitudProductoVO();
                ingresarSoli.setNombre(resultado.getString("nombre"));
                ingresarSoli.setDescripcion(resultado.getString("descripcion"));
                ingresarSoli.setEstado(resultado.getString("estado"));
                ingresarSoli.setFechaPedido(resultado.getString("fechaPedido"));
                ingresarSoli.setPresupuestoDisponible(resultado.getFloat("presupuestoDis"));
                ingresarSoli.setServicio(resultado.getString("servicio"));
                ingresarSoli.setUsuarios_idUsuarios(resultado.getInt("usuarios_idUsuarios"));
                ingresarSoli.setNombre_RazonSocial(resultado.getString("usuario"));
                ingresarSoli.setApellido1(resultado.getString("apellido1"));
                ingresarSoli.setDocumento_Nit(resultado.getString("nit_documento"));
                ingresarSoli.setTelefonos(resultado.getString("telefonos"));
                ingresarSoli.setCiudad(resultado.getString("ciudad"));
                ingresarSoli.setDireccion(resultado.getString("direccion"));
                ingresarSoli.setCorreos(resultado.getString("correos"));
                ingresarSoli.setIdSolicitud(resultado.getInt("idSolicitud"));
                solicitudServicio.add(ingresarSoli);
            }

            return solicitudServicio;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            this.getCon().close();
        }

    }

    public ArrayList<solicitudProductoVO> consultarSolicitudProducto() throws SQLException {
        try {
            String sql = "SELECT * FROM solicitudproducto INNER JOIN usuarios ON usuarios.idUsuarios = solicitudproducto.usuarios_idUsuarios WHERE solicitudproducto.servicio = 'No' and solicitudproducto.estado = 'Pendiente' ORDER BY `idSolicitud` DESC";
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<solicitudProductoVO> solicitudServicio = new ArrayList();

            while (resultado.next()) {
                solicitudProductoVO ingresarSoli = new solicitudProductoVO();
                ingresarSoli.setNombre(resultado.getString("nombre"));
                ingresarSoli.setDescripcion(resultado.getString("descripcion"));
                ingresarSoli.setEstado(resultado.getString("estado"));
                ingresarSoli.setFechaPedido(resultado.getString("fechaPedido"));
                ingresarSoli.setPresupuestoDisponible(resultado.getFloat("presupuestoDis"));
                ingresarSoli.setServicio(resultado.getString("servicio"));
                ingresarSoli.setUsuarios_idUsuarios(resultado.getInt("usuarios_idUsuarios"));
                ingresarSoli.setNombre_RazonSocial(resultado.getString("usuario"));
                ingresarSoli.setApellido1(resultado.getString("apellido1"));
                ingresarSoli.setDocumento_Nit(resultado.getString("nit_documento"));
                ingresarSoli.setTelefonos(resultado.getString("telefonos"));
                ingresarSoli.setCiudad(resultado.getString("ciudad"));
                ingresarSoli.setDireccion(resultado.getString("direccion"));
                ingresarSoli.setCorreos(resultado.getString("correos"));
                ingresarSoli.setIdSolicitud(resultado.getInt("idSolicitud"));
                solicitudServicio.add(ingresarSoli);
            }

            return solicitudServicio;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            this.getCon().close();
        }

    }

    public ArrayList<solicitudProductoVO> todoSolicitudProducto() throws SQLException {
        try {
            String sql = "SELECT * FROM solicitudproducto INNER JOIN usuarios ON usuarios.idUsuarios = solicitudproducto.usuarios_idUsuarios WHERE solicitudproducto.servicio = 'No' and solicitudproducto.estado != 'Pendiente' ORDER BY `idSolicitud` DESC";
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<solicitudProductoVO> solicitudServicio = new ArrayList();

            while (resultado.next()) {
                solicitudProductoVO ingresarSoli = new solicitudProductoVO();
                ingresarSoli.setNombre(resultado.getString("nombre"));
                ingresarSoli.setDescripcion(resultado.getString("descripcion"));
                ingresarSoli.setEstado(resultado.getString("estado"));
                ingresarSoli.setFechaPedido(resultado.getString("fechaPedido"));
                ingresarSoli.setPresupuestoDisponible(resultado.getFloat("presupuestoDis"));
                ingresarSoli.setServicio(resultado.getString("servicio"));
                ingresarSoli.setUsuarios_idUsuarios(resultado.getInt("usuarios_idUsuarios"));
                ingresarSoli.setNombre_RazonSocial(resultado.getString("usuario"));
                ingresarSoli.setApellido1(resultado.getString("apellido1"));
                ingresarSoli.setDocumento_Nit(resultado.getString("nit_documento"));
                ingresarSoli.setTelefonos(resultado.getString("telefonos"));
                ingresarSoli.setCiudad(resultado.getString("ciudad"));
                ingresarSoli.setDireccion(resultado.getString("direccion"));
                ingresarSoli.setCorreos(resultado.getString("correos"));
                ingresarSoli.setIdSolicitud(resultado.getInt("idSolicitud"));
                solicitudServicio.add(ingresarSoli);
            }

            return solicitudServicio;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            this.getCon().close();
        }

    }

    public ArrayList<solicitudProductoVO> consultarSolicitudAlquiler() throws SQLException {
        try {
            String sql = "SELECT * FROM solicitudproducto INNER JOIN usuarios ON usuarios.idUsuarios = solicitudproducto.usuarios_idUsuarios WHERE solicitudproducto.servicio = 'Alquiler' and solicitudproducto.estado = 'Pendiente' ORDER BY `idSolicitud` DESC";
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<solicitudProductoVO> solicitudServicio = new ArrayList();

            while (resultado.next()) {
                solicitudProductoVO ingresarSoli = new solicitudProductoVO();
                ingresarSoli.setNombre(resultado.getString("nombre"));
                ingresarSoli.setDescripcion(resultado.getString("descripcion"));
                ingresarSoli.setEstado(resultado.getString("estado"));
                ingresarSoli.setFechaPedido(resultado.getString("fechaPedido"));
                ingresarSoli.setPresupuestoDisponible(resultado.getFloat("presupuestoDis"));
                ingresarSoli.setServicio(resultado.getString("servicio"));
                ingresarSoli.setUsuarios_idUsuarios(resultado.getInt("usuarios_idUsuarios"));
                ingresarSoli.setNombre_RazonSocial(resultado.getString("usuario"));
                ingresarSoli.setApellido1(resultado.getString("apellido1"));
                ingresarSoli.setDocumento_Nit(resultado.getString("nit_documento"));
                ingresarSoli.setTelefonos(resultado.getString("telefonos"));
                ingresarSoli.setCiudad(resultado.getString("ciudad"));
                ingresarSoli.setDireccion(resultado.getString("direccion"));
                ingresarSoli.setCorreos(resultado.getString("correos"));
                ingresarSoli.setIdSolicitud(resultado.getInt("idSolicitud"));
                solicitudServicio.add(ingresarSoli);
            }

            return solicitudServicio;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            this.getCon().close();
        }

    }

    public int consultarUltimoRegistro() throws SQLException {
        try {
            int ultimoRegistro = 0;
            String sql = "SELECT MAX(idSolicitud) as idSolicitud from solicitudproducto";
            PreparedStatement sentencia = this.getCon().prepareStatement(sql);
            ResultSet resultado2 = sentencia.executeQuery();
            while (resultado2.next()) {
                ultimoRegistro = resultado2.getInt("idSolicitud");
            }

            return ultimoRegistro;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        } finally {
            this.getCon().close();
        }

    }

    // Método registrar solicitad producto
    public boolean comprarProducto(int iSeguD, String nombre, String descripcion, float total, int totalPro) throws SQLException {
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
            String serv = "No";
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

    public ArrayList<solicitudProductoVO> serviciosClienteBuy(int id) throws SQLException {
        String queryServicios = "SELECT * FROM solicitudproducto WHERE usuarios_idUsuarios = ? AND servicio = \"Si\" AND estado = \"Terminado\"";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(queryServicios);
            sentencia.setInt(1, id);
            ResultSet servicios = sentencia.executeQuery();
            ArrayList<solicitudProductoVO> serviciosALL = new ArrayList<>();

            while (servicios.next()) {
                solicitudProductoVO servicioBuy = new solicitudProductoVO();
                servicioBuy.setNombre(servicios.getString("nombre"));
                String descripcion = servicios.getString("descripcion");
                if (descripcion != null) {
                    servicioBuy.setDescripcion(servicios.getString("descripcion"));
                } else {
                    servicioBuy.setDescripcion(servicios.getString("Ninguna"));
                }
                String fechaAcor = servicios.getString("fechaServicio");
                if (fechaAcor != null) {
                    servicioBuy.setFechaServicio(servicios.getString("fechaServicio"));
                } else {
                    servicioBuy.setFechaServicio(servicios.getString("No se definio"));
                }
                servicioBuy.setFechaPedido(servicios.getString("fechaPedido"));
                servicioBuy.setEstado(servicios.getString("estado"));
                serviciosALL.add(servicioBuy);

            }
            if (serviciosALL.get(0).getNombre() == null) {
                return null;
            }
            return serviciosALL;
        } catch (Exception e) {
            System.out.println("ERROR CAPTURANDO INFORMACION SOLICITUD SERVICIOS COMPRADOS " + e);
            return null;
        } finally {
            this.getCon().close();
        }
    }

    public ArrayList<solicitudProductoVO> serviciosClienteTodos(int id) throws SQLException {
        String queryServiciosAll = "SELECT * FROM solicitudproducto WHERE usuarios_idUsuarios = ? AND servicio = \"Si\" AND estado != \"Terminado\"";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(queryServiciosAll);
            sentencia.setInt(1, id);
            ResultSet servicios = sentencia.executeQuery();
            ArrayList<solicitudProductoVO> serviciosALL = new ArrayList<>();

            while (servicios.next()) {
                solicitudProductoVO servicioBuy = new solicitudProductoVO();
                servicioBuy.setNombre(servicios.getString("nombre"));
                String descripcion = servicios.getString("descripcion");
                if (descripcion != null) {
                    servicioBuy.setDescripcion(servicios.getString("descripcion"));
                } else {
                    servicioBuy.setDescripcion(servicios.getString("Ninguna"));
                }
                String fechaAcor = servicios.getString("fechaServicio");
                if (fechaAcor != null) {
                    servicioBuy.setFechaServicio(servicios.getString("fechaServicio"));
                } else {
                    servicioBuy.setFechaServicio(servicios.getString("No se definio"));
                }
                servicioBuy.setFechaPedido(servicios.getString("fechaPedido"));
                servicioBuy.setEstado(servicios.getString("estado"));
                servicioBuy.setIdSolicitud(servicios.getInt("idSolicitud"));
                serviciosALL.add(servicioBuy);

            }
            if (serviciosALL.get(0).getNombre() == null) {
                return null;
            }
            return serviciosALL;
        } catch (Exception e) {
            System.out.println("ERROR CAPTURANDO INFORMACION SOLICITUD SERVICIOS COMPRADOS " + e);
            return null;
        } finally {
            this.getCon().close();
        }
    }

    public boolean cancelarServicioCliente(int idSolicitud) throws SQLException {
        String query = "UPDATE solicitudproducto SET estado = 'Cancelado' WHERE idSolicitud = ?";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(query);
            sentencia.setInt(1, idSolicitud);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR CANCELANDO SOLICITUD " + e);
            return false;
        } finally {
            this.getCon().close();
        }
    }

    public boolean solicitarServicioCliente(int idSolicitud) throws SQLException {
        String query = "UPDATE solicitudproducto SET estado = 'Pendiente' WHERE idSolicitud = ?";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(query);
            sentencia.setInt(1, idSolicitud);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR REENVIAR SOLICITUD " + e);
            return false;
        } finally {
            this.getCon().close();
        }
    }

    public boolean confirmarServicio(int idSolicitud) throws SQLException {
        String query = "UPDATE solicitudproducto SET estado = 'Confirmado' WHERE idSolicitud = ?";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(query);
            sentencia.setInt(1, idSolicitud);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR CONFIRMANDO SERVICIO " + e);
            return false;
        } finally {
            this.getCon().close();
        }
    }

    public boolean confirmarAlquiler(int idSolicitud) throws SQLException {
        String queryAlq = "UPDATE alquiler SET estado = 'Confirmado' WHERE solicitudProducto_idSolicitud = ?";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(queryAlq);
            sentencia.setInt(1, idSolicitud);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR CONFIRMANDO ALQUILER " + e);
            return false;
        } finally {
            this.getCon().close();
        }
    }
     public boolean denegarAlquiler(int idSolicitud) throws SQLException {
        String query = "UPDATE alquiler SET estado = 'Denegado' WHERE solicitudProducto_idSolicitud = ?";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(query);
            sentencia.setInt(1, idSolicitud);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR CONFIRMANDO ALQUILER " + e);
            return false;
        } finally {
            this.getCon().close();
        }
    }

    public boolean denegarServicio(int idSolicitud) throws SQLException {
        String query = "UPDATE solicitudproducto SET estado = 'Denegado' WHERE idSolicitud = ?";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(query);
            sentencia.setInt(1, idSolicitud);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR CONFIRMANDO SERVICIO " + e);
            return false;
        } finally {
            this.getCon().close();
        }
    }

    public boolean terminarSolicitud(int idSolicitud) throws SQLException {
        String query = "UPDATE solicitudproducto SET estado = 'Terminado' WHERE idSolicitud = ?";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(query);
            sentencia.setInt(1, idSolicitud);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR TERMINANDO LA SOLICITUD " + e);
            return false;
        } finally {
            this.getCon().close();
        }
    }
    public boolean terminarAlquiler(int idSolicitud) throws SQLException {
        String query = "UPDATE alquiler SET estado = 'Terminado' WHERE solicitudProducto_idSolicitud = ?";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(query);
            sentencia.setInt(1, idSolicitud);
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR TERMINANDO EL ALQUILER " + e);
            return false;
        } finally {
            this.getCon().close();
        }
    }

    public ArrayList<solicitudProductoVO> serviciosADMINTodos() throws SQLException {
        String queryServiciosAll = "SELECT solicitudproducto.idSolicitud, solicitudproducto.nombre, solicitudproducto.fechaServicio, solicitudproducto.presupuestoDis, solicitudproducto.estado, solicitudproducto.fechaPedido, solicitudproducto.descripcion, solicitudproducto.servicio, usuarios.usuario, usuarios.correos, usuarios.ciudad, usuarios.direccion, usuarios.telefonos FROM solicitudproducto INNER JOIN usuarios ON solicitudproducto.usuarios_idUsuarios = usuarios.idUsuarios WHERE solicitudproducto.estado != \"Pendiente\" AND solicitudproducto.servicio = \"Si\"";
        try {
            PreparedStatement sentencia = this.getCon().prepareStatement(queryServiciosAll);
            ResultSet servicios = sentencia.executeQuery();
            ArrayList<solicitudProductoVO> serviciosALL = new ArrayList<>();

            while (servicios.next()) {
                solicitudProductoVO servicioBuy = new solicitudProductoVO();
                servicioBuy.setNombre(servicios.getString("nombre"));
                String descripcion = servicios.getString("descripcion");
                if (descripcion != null) {
                    servicioBuy.setDescripcion(servicios.getString("descripcion"));
                } else {
                    servicioBuy.setDescripcion(servicios.getString("Ninguna"));
                }
                String fechaAcor = servicios.getString("fechaServicio");
                if (fechaAcor != null) {
                    servicioBuy.setFechaServicio(servicios.getString("fechaServicio"));
                } else {
                    servicioBuy.setFechaServicio(servicios.getString("No se definio"));
                }
                servicioBuy.setFechaPedido(servicios.getString("fechaPedido"));
                servicioBuy.setEstado(servicios.getString("estado"));
                servicioBuy.setIdSolicitud(servicios.getInt("idSolicitud"));
                servicioBuy.setNombre_RazonSocial(servicios.getString("usuario"));
                servicioBuy.setCorreos(servicios.getString("correos"));
                servicioBuy.setTelefonos(servicios.getString("telefonos"));
                servicioBuy.setCiudad(servicios.getString("ciudad"));
                servicioBuy.setDireccion(servicios.getString("direccion"));

                servicioBuy.setPresupuestoDisponible(servicios.getFloat("presupuestoDis"));
                serviciosALL.add(servicioBuy);

            }
            if (serviciosALL.get(0).getNombre() == null) {
                return null;
            }
            return serviciosALL;
        } catch (Exception e) {
            System.out.println("ERROR CAPTURANDO INFORMACION SOLICITUD SERVICIOS COMPRADOS " + e);
            return null;
        } finally {
            this.getCon().close();
        }
    }

}
