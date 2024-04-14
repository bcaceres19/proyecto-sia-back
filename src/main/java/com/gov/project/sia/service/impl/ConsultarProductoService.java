package com.gov.project.sia.service.impl;

import com.gov.project.sia.dto.OrquestadorDto;
import com.gov.project.sia.dto.ProductoDto;
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
public class ConsultarProductoService implements IConsultarProductoService {

    private final ProductoRepository productoRepository;

    private final ProductoMapper productoMapper;

    @Override
    public List<ProductoDto> consultarProductos() {
        return productoRepository.buscarProductos().stream().map(productoMapper::productoEntityToProductoDto).toList();
    }


}
