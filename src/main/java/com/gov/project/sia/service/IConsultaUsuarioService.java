package com.gov.project.sia.service;

import com.gov.project.sia.utils.exceptions.ErrorGeneralException;

public interface IConsultaUsuarioService {

    Boolean existeUsuario(String email, String password) throws ErrorGeneralException;

}
