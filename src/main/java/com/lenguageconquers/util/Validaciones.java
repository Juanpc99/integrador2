package com.lenguageconquers.util;

public class Validaciones {


    public static boolean isIdNull(Long id){
        if(id == null){
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @Title: isStringLenght
     * @Description: TODO si la palabra es mayor que la longitud del atributo devuelve false
     * @param: @param palabra
     * @param: @param longitud
     * @param: @return
     * @return: boolean
     * @author Angela Acosta
     * @throws
     *
     */
    public static boolean isStringLenght(String palabra, int longitud) {
        boolean tam = false;
        if(palabra.length()>longitud) {
            tam = true;
        }else{
            tam = false;
        }
        return tam;
    }

}
