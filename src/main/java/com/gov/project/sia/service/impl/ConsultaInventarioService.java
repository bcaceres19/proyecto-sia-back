package com.gov.project.sia.service.impl;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.OrquestadorDto;
import com.gov.project.sia.repository.InventarioRepository;
import com.gov.project.sia.service.IConsultaInventarioService;
import com.gov.project.sia.utils.enums.TipoOrdenamientoEnum;
import com.gov.project.sia.utils.mapper.InventarioMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Log4j2
public class ConsultaInventarioService implements IConsultaInventarioService {

    private final InventarioRepository inventarioRepository;

    private final InventarioMapper inventarioMapper;

    @Override
    public List<InventarioDto>  buscarProductosInventario(TipoOrdenamientoEnum tipoOrdenamiento) {
        List<InventarioDto> listaInventario = inventarioRepository.consultarProductosInventario().stream().map(inventarioMapper::objectToInventarioDto).toList();
        if(!listaInventario.isEmpty()){
            OrquestadorDto orquestadorDto = new OrquestadorDto();
            listaInventario.forEach(i -> orquestadorDto.insertar(i, InventarioDto.class));
            List<Object> orquestadorDtos = new ArrayList<>();
            orquestadorDto.disparadorOrdenamiento(tipoOrdenamiento,orquestadorDtos);
            List<InventarioDto> resultado = orquestadorDtos.stream().map(inventarioMapper::objectToInventarioDto).toList();
            return resultado;
        }
        return null;
    }
}
