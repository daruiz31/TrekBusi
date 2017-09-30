package com.tkbi.utilidades;

import java.io.*;

/**
 *
 * @author Diego RM
 */
public class imagenes {

    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;

    //Constructor
    public imagenes() {

    }

    // Abrir un archivo de texto
    public String abrirTxt(File archivo) {
        String contenido = "";
        try {
            entrada = new FileInputStream(archivo);
            int assci;
            while ((assci = entrada.read()) != -1) {
                char caracter = (char) assci;
                contenido += caracter;
            }
        } catch (Exception e) {
        }
        return contenido;
    }

    // Guardar archivo de texto
    public String guardarTxt(File archivo, String contenido) {
        String respuesta = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);
            respuesta = "Se guardo el archivo";
        } catch (Exception e) {
        }
        return respuesta;
    }
    
    public byte[] abrirImg(File img){
        byte[] btImagenes = new byte[1024*100];
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(btImagenes);
        } catch (Exception e) {
        }
        return btImagenes;
    }
    
    public String guardarImg(File archivo, byte[] bytesImg){
        String respuesta = null;
        try {
            salida = new FileOutputStream(archivo);
            salida.write(bytesImg);
            respuesta = "Imagen guardada correctamente";
        } catch (Exception e) {
        }
        return respuesta;
    }

}
