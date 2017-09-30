
package com.tkbi.utilidades;

/**
 *
 * @author Diego RM
 */
public class sesion {
    
    private String nombreCompleto;
    private int iSegud;
    private String estado;
    private int codigo;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }       

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }  
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getiSegud() {
        return iSegud;
    }

    public void setiSegud(int iSegud) {
        this.iSegud = iSegud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
