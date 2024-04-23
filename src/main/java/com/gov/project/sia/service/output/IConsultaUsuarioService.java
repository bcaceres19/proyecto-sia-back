package com.gov.project.sia.service.output;

import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.utils.exceptions.ErrorGeneralException;

public interface IConsultaUsuarioService {

    UsuarioDto existeUsuario(String email, String password) throws ErrorGeneralException;

}
