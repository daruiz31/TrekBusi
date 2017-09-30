package com.tkbi.utilidades;

public class RespuestaProductos {
    private int codigo;
    private String mensaje;
    private Object datosResultado;

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

