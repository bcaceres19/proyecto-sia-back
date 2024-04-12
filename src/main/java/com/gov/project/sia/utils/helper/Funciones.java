package com.gov.project.sia.utils.helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Funciones {

    public static <T> T checkType(Object obj, Class<T> clazz) {
        if (Objects.isNull(obj)) {
            return null;
        }
        try {
            if(clazz.equals(Long.class)){
                return (T) Long.valueOf(obj.toString());
            } else if (clazz.equals(String.class)) {
                return (T) String.valueOf(obj);
            } else if (clazz.equals(Integer.class)) {
                return (T) Integer.valueOf(obj.toString());
            }else if (clazz.equals(Double.class)){
                return (T) Double.valueOf(obj.toString());
            }
        } catch (ClassCastException e) {
            throw new ClassCastException("Error de conversión de tipos");
        }
        return null;
    }

    public static LocalDate convertStringToLocalDate(String valor){
        return valor != null ?  LocalDate.parse(valor, DateTimeFormatter.ISO_DATE) : null;
    }

    public static String convertirLocalDateToString(LocalDate fecha){
        return fecha != null ? fecha.toString() : null;
    }

}
