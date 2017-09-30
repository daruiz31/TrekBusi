/**

*                   TrekBusi
      
*         Autor :  Diego Ruiz

**/

//Nombre del paquete
package tkbi.VO;

//Librerias importadas



//Inicio clase tipoProductoVO
public class tipoProductoVO {
    
    private int idTipo_producto;
    private String nombre;
    private String descripcion;
    private String suministro;

    public int getIdTipo_producto() {
        return idTipo_producto;
    }

    public void setIdTipo_producto(int idTipo_producto) {
        this.idTipo_producto = idTipo_producto;
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

    public String getSuministro() {
        return suministro;
    }

    public void setSuministro(String suministro) {
        this.suministro = suministro;
    }
    
    

}//Fin clase tipoProductoVO