package com.gov.project.sia.utils.exceptions;

public class ErrorGeneralException extends Exception{
    public ErrorGeneralException(String mensaje){
        super(mensaje);
    }

    public ErrorGeneralException(String mensaje, Throwable cause){
        super(mensaje, cause);
    }
}
