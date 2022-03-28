package com.lenguageconquers.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static boolean isNumeric(String word) {
        boolean ret = false;
        Pattern pat = Pattern.compile("[^0-9',.\\s]");
        Matcher mat = pat.matcher(word);
        if (!mat.find()) {
            ret = true;
        }
        return ret;
    }

}
