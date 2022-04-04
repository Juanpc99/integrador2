package com.lenguageconquers.util;

import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.validator.routines.UrlValidator;

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

    public static int tiempoEntreFechas(Date fecha1, Date fecha2){
        return fecha2.getMonth() - fecha1.getMonth();
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

    public static boolean isExtensionValid(String archivo){
        boolean validExtension = false;
        if(FilenameUtils.getExtension(archivo).equals("pdf") ||
                FilenameUtils.getExtension(archivo).equals("zip") ||
                FilenameUtils.getExtension(archivo).equals("docx") ||
                FilenameUtils.getExtension(archivo).equals("txt")){
            return validExtension = true;
        }else {
            return validExtension = false;
        }
    }

    public static boolean validExtensionImg(String img){
        boolean isValid = false;
        if(FilenameUtils.getExtension(img).equals("png")||
                FilenameUtils.getExtension(img).equals("jpg") ||
                FilenameUtils.getExtension(img).equals("tiff")||
                FilenameUtils.getExtension(img).equals("jpge") ||
                FilenameUtils.getExtension(img).equals("gif") ||
                FilenameUtils.getExtension(img).equals("svg")){
            return isValid = true;
        }else{
            return isValid = false;
        }
    }

     public static boolean urlValidator(String url) {
        // Obteniendo UrlValidator
        UrlValidator defaultValidator = new UrlValidator();
        return defaultValidator.isValid(url);
    }

    public static boolean formatoCorreoValido(String correo) {
        boolean res = false;
        Pattern pat = Pattern.compile("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
        Matcher mat = pat.matcher(correo);
        if(mat.find()) {
            res = true;
        }
        return res;
    }




}
