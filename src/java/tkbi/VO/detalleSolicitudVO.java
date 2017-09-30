/**
 *
 * TrekBusi
 *
 * Autor : Diego Ruiz
 *
 *
 */
//Nombre del paquete
package tkbi.VO;

//Librerias importadas
//Inicio clase 
public class detalleSolicitudVO {

    private int idDetalleSolicitud;
    private int producto_idProducto;
    private int idSolicitud;
    private String foto;
    private float total;
    private String nombre;
    private String marca;
    private String descripcion;
    private String tipoProducto;
    private String fechaSolicitud ;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getIdDetalleSolicitud() {
        return idDetalleSolicitud;
    }

    public void setIdDetalleSolicitud(int idDetalleSolicitud) {
        this.idDetalleSolicitud = idDetalleSolicitud;
    }

    public int getProducto_idProducto() {
        return producto_idProducto;
    }

    public void setProducto_idProducto(int producto_idProducto) {
        this.producto_idProducto = producto_idProducto;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

}//Fin clase
