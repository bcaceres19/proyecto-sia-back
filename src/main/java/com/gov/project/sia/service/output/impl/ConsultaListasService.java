package com.gov.project.sia.service.output.impl;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.InventarioRespuestaDto;
import com.gov.project.sia.dto.RolDto;
import com.gov.project.sia.dto.TipoProductoDto;
import com.gov.project.sia.repository.InventarioRepository;
import com.gov.project.sia.repository.RolRepository;
import com.gov.project.sia.repository.TipoProductoRepository;
import com.gov.project.sia.service.output.IConsultaListasService;
import com.gov.project.sia.utils.enums.EstadoProductoEnum;
import com.gov.project.sia.utils.mapper.RolMapper;
import com.gov.project.sia.utils.mapper.TipoProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaListasService implements IConsultaListasService {


    private final RolMapper rolMapper;

    private final RolRepository rolRepository;

    private final TipoProductoRepository tipoProductoRepository;

    private final TipoProductoMapper tipoProductoMapper;

    private final InventarioRepository inventarioRepository;

    @Override
    public List<RolDto> consultarRolesUsuario() {
        return rolRepository.findAll().stream().map(rolMapper::entityToDto).toList();
    }

    @Override
    public List<TipoProductoDto> consultarTiposProductos() {
        return tipoProductoRepository.findAll().stream().map(tipoProductoMapper::entityToDto).toList();
    }

    @Override
    public List<InventarioRespuestaDto> consultarTiposInventarios() {
        return inventarioRepository.consultarTiposInventario();
    }

    @Override
    public List<String> consultarEstadoProductos() {
        List<String> arregloEstados = new ArrayList<>();
        for(EstadoProductoEnum estado : EstadoProductoEnum.values()) {
            arregloEstados.add(estado.getTextoSalida());
        }
        return arregloEstados;
    }
}
