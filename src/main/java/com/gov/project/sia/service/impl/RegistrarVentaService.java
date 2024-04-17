package com.gov.project.sia.service.impl;

import com.gov.project.sia.dto.*;
import com.gov.project.sia.repository.ProductoRepository;
import com.gov.project.sia.repository.VentaProductoRepository;
import com.gov.project.sia.repository.VentaRepository;
import com.gov.project.sia.service.IRegistrarVentaService;
import com.gov.project.sia.utils.mapper.ProductoMapper;
import com.gov.project.sia.utils.mapper.VentaMapper;
import com.gov.project.sia.utils.mapper.VentaProductoMapper;
import jakarta.transaction.Transactional;
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

    private final VentaProductoRepository ventaProductoRepository;

    private final VentaProductoMapper ventaProductoMapper;

    private  final ProductoRepository productoRepository;

    private  final ProductoMapper productoMapper;

    private  final RegitrarPedidoService regitrarPedidoService;

    @Override
    @Transactional
    public void crearVenta(ProductoDto producto) {
        List<Object[]> objetos = ventaRepository.bucarVentaUsuario(producto.getIdUsuarioInsercion());
        ProductoDto productoDto  = productoMapper.productoEntityToProductoDto(productoRepository.findByCodigoProducto(producto.getCodigoProducto()));
        VentaDto ventaDto;
        if(!objetos.isEmpty()){
            ventaDto = objetos.stream().map(ventaMapper::objectToVentaDto).toList().get(0);
            ventaDto.setPrecioTotalVenta(ventaDto.getPrecioTotalVenta()+productoDto.getPrecioProducto());
            ventaDto.setCantidadVenta((short) (ventaDto.getCantidadVenta()+1));
        }else{
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setIdUsuario(producto.getIdUsuarioInsercion());
            ventaDto = new VentaDto();
            Double precioTotalVenta = productoDto.getPrecioProducto();
            ventaDto.setPrecioTotalVenta(precioTotalVenta);
            ventaDto.setCantidadVenta(Short.valueOf(1 + ""));
            ventaDto.setIdUsuarioFk(usuarioDto);
        }
        ventaDto.setFechaVenta(LocalDate.now());
        ventaDto.setEstadoVenta(P);
        ventaDto.setIdVenta(ventaRepository.save(ventaMapper.ventaDtoToVentaEntity(ventaDto)).getIdVenta());
        VentaProductoDto ventaProductoDto = new VentaProductoDto();
        ventaProductoDto.setIdVentaFk(ventaDto);
        ventaProductoDto.setIdProductoFk(producto);
        ventaProductoRepository.save(ventaProductoMapper.ventaProductoDtoToVentaProductoEntity(ventaProductoDto));

    }

    @Override
    public void eliminarVenta(Integer idVenta) {
        ventaRepository.deleteById(idVenta);
    }

    @Override
    @Transactional
    public void realizarVentaPedidoConfirmado(VentaDto ventaConfirmada) {
        VentaDto ventaDto = ventaMapper.VentaEntityToVentaDto(ventaRepository.findByIdVenta(ventaConfirmada.getIdVenta()));
        ventaDto.setEstadoVenta(T);
        ventaRepository.save(ventaMapper.ventaDtoToVentaEntity(ventaDto));
        regitrarPedidoService.iniciarPedido(ventaDto);
    }

    @Override
    public void realizarVentaPedidoRechazado(List<VentaDto> ventasRechazar) {
        for(VentaDto venta : ventasRechazar){
            venta.setEstadoVenta(R);
            ventaRepository.save(ventaMapper.ventaDtoToVentaEntity(venta));
        }
    }
}
