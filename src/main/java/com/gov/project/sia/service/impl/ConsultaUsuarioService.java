package com.gov.project.sia.service.impl;

import com.gov.project.sia.repository.UsuarioRepository;
import com.gov.project.sia.service.IConsultaUsuarioService;
import com.gov.project.sia.utils.exceptions.ErrorGeneralException;
import com.gov.project.sia.utils.helper.Constantes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaUsuarioService implements IConsultaUsuarioService {

    private final  UsuarioRepository usuarioRepository;

    @Override
    public Boolean existeUsuario(String email, String password) throws ErrorGeneralException {
        if(email != null && password != null){
            return usuarioRepository.existsByEmailAndContraseina(email, password);
        }
        throw new ErrorGeneralException(Constantes.ERROR_INICIO_SESION);
    }
}
