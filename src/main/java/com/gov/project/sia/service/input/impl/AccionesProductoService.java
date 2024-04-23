package com.gov.project.sia.service.input.impl;

import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.dto.VentaProductoDto;
import com.gov.project.sia.repository.VentaProductoRepository;
import com.gov.project.sia.repository.VentaRepository;
import com.gov.project.sia.service.input.IAccionesProductoService;
import com.gov.project.sia.utils.mapper.VentaMapper;
import com.gov.project.sia.utils.mapper.VentaProductoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AccionesProductoService implements IAccionesProductoService  {

    private final VentaProductoRepository ventaProductoRepository;

    private final VentaProductoMapper ventaProductoMapper;

    private final VentaRepository ventaRepository;

    private final VentaMapper ventaMapper;

    @Override
    @Transactional
    public boolean eliminarProductoVenta(Integer idVentaProducto) {
        VentaProductoDto ventaProducto = ventaProductoMapper.ventaProductoEntityToventaProductoDto(ventaProductoRepository.findByIdVentaProducto(idVentaProducto));
        VentaDto ventaDto = ventaProducto.getIdVentaFk();
        ventaDto.setCantidadVenta((short)(ventaDto.getCantidadVenta()-1));
        ventaDto.setPrecioTotalVenta(ventaDto.getPrecioTotalVenta() - ventaProducto.getIdProductoFk().getPrecioProducto());
        ventaProductoRepository.deleteByIdVentaProducto(idVentaProducto);
        ventaRepository.save(ventaMapper.ventaDtoToVentaEntity(ventaDto));
        return true;
    }
}
