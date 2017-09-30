/**

*                   TrekBusi
      
*         Autor :  Diego Ruiz

**/

//Nombre del paquete
package tkbi.VO;

//Librerias importadas




//Inicio clase 
public class solicitudProductoVO {
    
    private int idSolicitud;
    private int usuarios_idUsuarios;
    private String nombre;
    private String fechaPedido;
    private float presupuestoDisponible;    
    private String estado;    
    private String descripcion;
    private String servicio;
    private String nombre_RazonSocial;
    private String apellido1;
    private String documento_Nit;
    private String ciudad;
    private String telefonos;
    private String direccion;
    private String correos;    
    private String fechaServicio;
    private String apellido2;
   
    // Parche
    private String fechaInicio;
    private String fechaFin;
    private int alquiler;

    public int getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
    

    public String getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(String fechaServicio) {
        this.fechaServicio = fechaServicio;
    }        

    public String getCorreos() {
        return correos;
    }

    public void setCorreos(String correos) {
        this.correos = correos;
    }  
    

    public String getNombre_RazonSocial() {
        return nombre_RazonSocial;
    }

    public void setNombre_RazonSocial(String nombre_RazonSocial) {
        this.nombre_RazonSocial = nombre_RazonSocial;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getDocumento_Nit() {
        return documento_Nit;
    }

    public void setDocumento_Nit(String documento_Nit) {
        this.documento_Nit = documento_Nit;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }      
    
    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    } 
    
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getUsuarios_idUsuarios() {
        return usuarios_idUsuarios;
    }

    public void setUsuarios_idUsuarios(int usuarios_idUsuarios) {
        this.usuarios_idUsuarios = usuarios_idUsuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public float getPresupuestoDisponible() {
        return presupuestoDisponible;
    }

    public void setPresupuestoDisponible(float presupuestoDisponible) {
        this.presupuestoDisponible = presupuestoDisponible;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

}//Fin clase 