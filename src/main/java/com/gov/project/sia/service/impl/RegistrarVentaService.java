package com.gov.project.sia.service.impl;

import com.gov.project.sia.dto.*;
import com.gov.project.sia.repository.VentaPedidoRepository;
import com.gov.project.sia.repository.VentaRepository;
import com.gov.project.sia.service.IRegistrarVentaService;
import com.gov.project.sia.utils.mapper.VentaMapper;
import com.gov.project.sia.utils.mapper.VentaProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.gov.project.sia.utils.enums.EstadoVentaEnum.*;

@Service
@RequiredArgsConstructor
public class RegistrarVentaService implements IRegistrarVentaService {

    private final VentaRepository ventaRepository;

    private final VentaMapper ventaMapper;

    private final VentaPedidoRepository ventaPedidoRepository;

    private final VentaProductoMapper ventaProductoMapper;
    @Override
    public void crearVenta(VentaInDto ventaEntrada) {
        VentaDto ventaDto = new VentaDto();
        Double precioTotalVenta = ventaEntrada.getPrecioTotal();

        ventaDto.setCantidadVenta(ventaEntrada.getCantidadVenta().shortValue());
        ventaDto.setEstadoVenta(PENDIENTE);
        ventaDto.setPrecioTotalVenta(precioTotalVenta);
        ventaDto.setFechaVenta(LocalDate.now());
        ventaDto.setIdUsuarioFk(ventaEntrada.getUsuarioDto());
        ventaDto.setIdVenta(ventaRepository.save(ventaMapper.ventaDtoToVentaEntity(ventaDto)).getIdVenta());
        VentaProductoDto ventaProductoDto = new VentaProductoDto();
        ventaProductoDto.setIdVentaFk(ventaDto);
        for(ProductoDto producto : ventaEntrada.getProductoDto()){
            ventaProductoDto.setIdProductoFk(producto);
            ventaPedidoRepository.save(ventaProductoMapper.ventaProductoDtoToVentaProductoEntity(ventaProductoDto));
        }
    }

    @Override
    public void eliminarVenta(Integer idVenta) {
        ventaRepository.deleteById(idVenta);
    }

    @Override
    public void realizarVentaPedidoConfirmado(List<VentaDto> ventasConfirmar) {
        for(VentaDto venta : ventasConfirmar){
            venta.setEstadoVenta(ACEPTADO);
            ventaRepository.save(ventaMapper.ventaDtoToVentaEntity(venta));
        }
    }

    @Override
    public void realizarVentaPedidoRechazado(List<VentaDto> ventasRechazar) {
        for(VentaDto venta : ventasRechazar){
            venta.setEstadoVenta(RECHAZADO);
            ventaRepository.save(ventaMapper.ventaDtoToVentaEntity(venta));
        }
    }
}
