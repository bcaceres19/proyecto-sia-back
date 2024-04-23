package com.gov.project.sia.service.input;

import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.utils.exceptions.ErrorGeneralException;

public interface IUsuarioInputService {

    void crearUsuario(UsuarioDto usuario) throws ErrorGeneralException;

}
