package com.tkbi.utilidades;

public class RespuestaServlet {
    private int codigo;
    private String mensaje;
    private Object datosResultado;
    private String usuario;
    private int tipoUsuario;
    private String estado;
    private int contador;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }      

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getDatosResultado() {
        return datosResultado;
    }

    public void setDatosResultado(Object datosResultado) {
        this.datosResultado = datosResultado;
    }
}
