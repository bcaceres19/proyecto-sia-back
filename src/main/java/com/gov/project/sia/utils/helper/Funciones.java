package com.gov.project.sia.utils.helper;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.utils.enums.EstadoProductoEnum;
import com.gov.project.sia.utils.enums.EstadoVentaEnum;
import org.springframework.cglib.core.Local;

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
            }else if (clazz.equals(InventarioDto.class)){
                return (T) (InventarioDto) obj;
            }else if (clazz.equals(Short.class)){
                return (T) Short.valueOf(obj.toString());
            }
            else if(clazz.equals(LocalDate.class)){
                return (T) LocalDate.parse(obj.toString());
            } else if(clazz.equals(EstadoProductoEnum.class)){
                return (T) EstadoProductoEnum.valueOf(obj.toString());
            }else if(clazz.equals(EstadoVentaEnum.class)){
                return (T) EstadoVentaEnum.valueOf(obj.toString());
            }
        } catch (ClassCastException e) {
            throw new ClassCastException("Error de conversión de tipos");
        }
        return null;
    }
    public static Double calcularPrecio(Integer porcentaje, Double precioBase){
        Double precioPorcentaje  =(precioBase * porcentaje) / 100.0;
        return precioBase + precioPorcentaje;
    }

    public static LocalDate convertStringToLocalDate(String valor){
        return valor != null ?  LocalDate.parse(valor, DateTimeFormatter.ISO_DATE) : null;
    }

    public static String convertirLocalDateToString(LocalDate fecha){
        return fecha != null ? fecha.toString() : null;
    }

}
