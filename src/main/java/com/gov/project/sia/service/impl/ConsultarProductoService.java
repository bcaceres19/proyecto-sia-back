package com.gov.project.sia.service.impl;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.OrquestadorDto;
import com.gov.project.sia.dto.ProductoRespuestaDto;
import com.gov.project.sia.repository.ProductoRepository;
import com.gov.project.sia.service.IConsultarProductoService;
import com.gov.project.sia.utils.enums.TipoOrdenamientoEnum;
import com.gov.project.sia.utils.mapper.ProductoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ConsultarProductoService implements IConsultarProductoService {

    private final ProductoRepository productoRepository;

    private final ProductoMapper productoMapper;


    @Override
    public List<ProductoRespuestaDto> buscarProductosInventario(TipoOrdenamientoEnum tipoOrdenamiento, Long idInventario) {
        List<ProductoRespuestaDto> listaInventario = productoRepository.consultarProductosInventario(idInventario).stream().map(productoMapper::objectToProductoRespuestaDto).toList();
        if(!listaInventario.isEmpty()){
            OrquestadorDto orquestadorDto = new OrquestadorDto();
            listaInventario.forEach(i -> orquestadorDto.insertar(i, ProductoRespuestaDto.class));
            List<Object> orquestadorDtos = new ArrayList<>();
            orquestadorDto.disparadorOrdenamiento(tipoOrdenamiento,orquestadorDtos);
            return  orquestadorDtos.stream().map(productoMapper::objectToInventarioDto).toList();
        }
        return null;
    }
}
