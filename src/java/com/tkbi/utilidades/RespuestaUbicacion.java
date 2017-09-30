package com.tkbi.utilidades;

import java.util.ArrayList;

public class RespuestaUbicacion {

    public ArrayList paises() {

        ArrayList paises = new ArrayList();
        paises.add(0, "Colombia");
        paises.add(1, "Venezuela");
        paises.add(2, "Peru");
        paises.add(3, "Ecuador");
        paises.add(4, "Brasil");
        paises.add(5, "Argentina");
        paises.add(6, "Chile");
        paises.add(7, "Mexico");
        return paises;
    }
    
    public ArrayList ciudades(String pais){
        ArrayList ciudades = new ArrayList();
        if (pais.equalsIgnoreCase("Colombia")) {
            ciudades.add(0, "Bogotá");
            ciudades.add(1, "Tunja");
            ciudades.add(2, "Bucaramanga");
            ciudades.add(3, "Medellin");
            ciudades.add(4, "Cali");
            ciudades.add(5, "Barranquilla");
            ciudades.add(6, "Cartagena");
            ciudades.add(7, "Cúcuta");
            ciudades.add(8, "Soledad");
            ciudades.add(9, "Ibague");
            ciudades.add(10, "Ibague");
            ciudades.add(11, "Soacha");
            ciudades.add(12, "Villavicencio");
            ciudades.add(13, "Santa marta");
            ciudades.add(14, "Pereira");
            ciudades.add(15, "Bello");
            ciudades.add(16, "Valledupar");
            ciudades.add(17, "Monteria");
            ciudades.add(18, "Pasto");
            ciudades.add(19, "Buenaventura");
            ciudades.add(20, "Manizales");
            ciudades.add(21, "Neiva");
            ciudades.add(22, "Palmira");
            ciudades.add(23, "Armenia");
            ciudades.add(24, "Popayan");
            ciudades.add(25, "Sincelejo");
            ciudades.add(26, "Itagui");
            ciudades.add(27, "Rioacha");
            ciudades.add(28, "Florida Blanca");
            ciudades.add(29, "Envigado");
            ciudades.add(30, "Tulua");
            ciudades.add(31, "Tumaco");
            ciudades.add(32, "Dosquebradas");
            ciudades.add(33, "Barrancamermeja");
            ciudades.add(34, "Florencia");
            ciudades.add(35, "Yopal");
            ciudades.add(36, "Quibdo");
            ciudades.add(37, "Arauca");
            ciudades.add(38, "San andres");
            ciudades.add(39, "San jose de guaviare");
            ciudades.add(40, "Puerto Asis");
            ciudades.add(41, "Cajica");
            ciudades.add(42, "Zipaquira");
            ciudades.add(43, "Chia");
            ciudades.add(44, "Vichada");
            ciudades.add(45, "Tabio");
            ciudades.add(46, "Tenjo");
            ciudades.add(47, "Girardot");
            ciudades.add(48, "Barbosa");
            ciudades.add(49, "Acacias");
            ciudades.add(50, "Calarcá");
            ciudades.add(51, "Caldas");
            ciudades.add(52, "Madrid");
            ciudades.add(53, "Chiquinquira");
            ciudades.add(54, "Funza");
            ciudades.add(55, "La dorada");
            ciudades.add(56, "Candelaria");
            ciudades.add(57, "Espinal");
        }
        if (pais.equalsIgnoreCase("Venezuela")) {
            ciudades.add(0, "Caracas");
            ciudades.add(1, "");
            ciudades.add(2, "Bucaramanga");
            ciudades.add(3, "Medellin");
            ciudades.add(4, "Cali");
        }
        if (pais.equalsIgnoreCase("Peru")) {
            ciudades.add(0, "Lima");
            ciudades.add(1, "Tunja");
            ciudades.add(2, "Bucaramanga");
            ciudades.add(3, "Medellin");
            ciudades.add(4, "Cali");
        }
        if (pais.equalsIgnoreCase("Ecuador")) {
            ciudades.add(0, "Quito");
            ciudades.add(1, "Tunja");
            ciudades.add(2, "Bucaramanga");
            ciudades.add(3, "Medellin");
            ciudades.add(4, "Cali");
        }
        if (pais.equalsIgnoreCase("Brasil")) {
            ciudades.add(0, "Brasilia");
            ciudades.add(1, "Tunja");
            ciudades.add(2, "Bucaramanga");
            ciudades.add(3, "Medellin");
            ciudades.add(4, "Cali");
        }
        if (pais.equalsIgnoreCase("Argentina")) {
            ciudades.add(0, "Buenos aires");
            ciudades.add(1, "Tunja");
            ciudades.add(2, "Bucaramanga");
            ciudades.add(3, "Medellin");
            ciudades.add(4, "Cali");
        }
        if (pais.equalsIgnoreCase("Chile")) {
            ciudades.add(0, "Santiago de chile");
            ciudades.add(1, "Tunja");
            ciudades.add(2, "Bucaramanga");
            ciudades.add(3, "Medellin");
            ciudades.add(4, "Cali");
        }
        if (pais.equalsIgnoreCase("Mexico")) {
            ciudades.add(0, "Guadalajara");
            ciudades.add(1, "Tunja");
            ciudades.add(2, "Bucaramanga");
            ciudades.add(3, "Medellin");
            ciudades.add(4, "Cali");
        }
        
        return ciudades;
    }
}
