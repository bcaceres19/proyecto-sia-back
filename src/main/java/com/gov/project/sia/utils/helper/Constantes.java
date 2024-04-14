package com.gov.project.sia.utils.helper;

import java.time.format.DateTimeFormatter;

public class Constantes {
    public static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int CODE_LENGTH = 10; // Longitud del código de letras
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static final String ERROR_INICIO_SESION = "Inicio de sesión fallido: verifica tus credenciales e intenta de nuevo.";

}
