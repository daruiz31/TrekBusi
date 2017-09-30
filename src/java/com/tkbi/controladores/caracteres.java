package com.tkbi.controladores;

public class caracteres{

    public boolean caracteresEspeciales(String $cadena) {
        char[] cadena = $cadena.toLowerCase().toCharArray();
 
        //Compruebo la longitud
        if (cadena.length <= 6) {
            return false;
        }
        for (int i = 0; i < cadena.length; i++) {
            
            if (cadena[i] == ' '
                    || cadena[i] == '='
                    || cadena[i] == '?'
                    || cadena[i] == '+'
                    || cadena[i] == '*'
                    || cadena[i] == '-'
                    || cadena[i] == '%'
                    || cadena[i] == '/'
                    || cadena[i] == '.'
                    || cadena[i] == ','
                    || cadena[i] == ';'
                    || cadena[i] == '!'
                    || cadena[i] == '<'
                    || cadena[i] == '>'
                    || cadena[i] == ':') {
                return false;
            }
 
        }
        return true;
    }
    
}