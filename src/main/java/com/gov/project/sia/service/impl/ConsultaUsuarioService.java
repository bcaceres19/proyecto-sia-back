package com.gov.project.sia.service.impl;

import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.entity.UsuarioEntity;
import com.gov.project.sia.repository.UsuarioRepository;
import com.gov.project.sia.service.IConsultaUsuarioService;
import com.gov.project.sia.utils.exceptions.ErrorGeneralException;
import com.gov.project.sia.utils.helper.Constantes;
import com.gov.project.sia.utils.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaUsuarioService implements IConsultaUsuarioService {

    private final  UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;
    @Override
    public UsuarioDto existeUsuario(String email, String password) throws ErrorGeneralException {
        if(email != null && password != null){
            return usuarioMapper.entityToDto(usuarioRepository.findByEmailAndContraseina(email, password));
        }
        throw new ErrorGeneralException(Constantes.ERROR_INICIO_SESION);
    }
}
