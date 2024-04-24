package com.gov.project.sia.service.input.impl;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.ProductoDto;
import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.dto.VentaProductoDto;
import com.gov.project.sia.repository.InventarioRepository;
import com.gov.project.sia.repository.ProductoRepository;
import com.gov.project.sia.repository.VentaProductoRepository;
import com.gov.project.sia.repository.VentaRepository;
import com.gov.project.sia.service.input.IAccionesProductoService;
import com.gov.project.sia.utils.mapper.InventarioMapper;
import com.gov.project.sia.utils.mapper.ProductoMapper;
import com.gov.project.sia.utils.mapper.VentaMapper;
import com.gov.project.sia.utils.mapper.VentaProductoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

import static com.gov.project.sia.utils.helper.Constantes.CHARACTERS;

@Service
@RequiredArgsConstructor
@Log4j2
public class AccionesProductoService implements IAccionesProductoService {

    private final VentaProductoRepository ventaProductoRepository;

    private final VentaProductoMapper ventaProductoMapper;

    private final VentaRepository ventaRepository;

    private final VentaMapper ventaMapper;

    private final ProductoRepository productoRepository;

    private final ProductoMapper productoMapper;

    private final InventarioRepository inventarioRepository;

    private final InventarioMapper inventarioMapper;

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

    @Override
    @Transactional
    public boolean crearProducto(ProductoDto producto) {
        producto.setCodigoProducto(generarCodigoProducto());
        productoRepository.save(productoMapper.dtoToEntity(producto));
        InventarioDto inventario = inventarioMapper.inventarioEntityToInventarioDto(inventarioRepository.findById(producto.getIdInventarioFk().getIdInventario()).get());
        inventario.setStockProductoInventario(inventario.getStockProductoInventario() + 1);
        inventarioRepository.save(inventarioMapper.inventarioDtoToInventarioEntity(inventario));
        return true;
    }

    private String generarCodigoProducto(){
        StringBuilder codigo = new StringBuilder();
        SecureRandom random = new SecureRandom();
        do {
            codigo = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                int index = random.nextInt(CHARACTERS.length());
                codigo.append(CHARACTERS.charAt(index));
            }
        }while (productoRepository.existsByCodigoProducto(codigo.toString()));
        return codigo.toString();
    }

}
