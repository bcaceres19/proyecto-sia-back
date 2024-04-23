package com.gov.project.sia.service.input.impl;

import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.repository.UsuarioRepository;
import com.gov.project.sia.service.input.IUsuarioInputService;
import com.gov.project.sia.utils.exceptions.ErrorGeneralException;
import com.gov.project.sia.utils.mapper.UsuarioMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static com.gov.project.sia.utils.helper.Constantes.ERROR_GENERAL;

@Service
@RequiredArgsConstructor
@Log4j2
public class UsuarioInputService implements IUsuarioInputService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    @Override
    public void crearUsuario(UsuarioDto usuario) throws ErrorGeneralException {
        try {
            usuarioRepository.save(usuarioMapper.dtoToEntity(usuario));
        }catch (Exception ex){
            log.error(ex);
             throw new ErrorGeneralException(ERROR_GENERAL);
        }
    }
}
