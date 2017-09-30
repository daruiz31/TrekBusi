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
public class productoVO {

    private int idProducto;    
    private String nombre;
    private String descripcion;
    private String referencia;
    private String marca;
    private float valorUnitario;
    private String capacidad;
    private String estado;
    private int cantidad;
    private String foto;
    private String nombreTproducto;
    private int idTipoPro;

    public int getIdTipoPro() {
        return idTipoPro;
    }

    public void setIdTipoPro(int idTipoPro) {
        this.idTipoPro = idTipoPro;
    }
    
    

    public String getNombreTproducto() {
        return nombreTproducto;
    }

    public void setNombreTproducto(String nombreTproducto) {
        this.nombreTproducto = nombreTproducto;
    }   

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }   

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

  
}//Fin clase
