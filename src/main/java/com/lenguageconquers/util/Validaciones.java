package com.lenguageconquers.util;

public class Validaciones {

    public static void validarObligatorio(Object valor, String mensaje) throws Exception {
        if (valor == null) {
            throw new Exception(mensaje);
        }
    }

    public static boolean isIdNull(Long id){
        if(id == null){
            return true;
        }else{
            return false;
        }
    }
}
