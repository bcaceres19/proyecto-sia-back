package com.gov.project.sia.service.impl;

import com.gov.project.sia.dto.*;
import com.gov.project.sia.repository.PedidoRepository;
import com.gov.project.sia.repository.VentaProductoRepository;
import com.gov.project.sia.service.IConsultaPedidoService;
import com.gov.project.sia.utils.mapper.PedidoMapper;
import com.gov.project.sia.utils.mapper.ProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaPedidoService implements IConsultaPedidoService {

    private final PedidoRepository pedidoRepository;

    private final VentaProductoRepository ventaProductoRepository;

    private final PedidoMapper pedidoMapper;

    private final ProductoMapper productoMapper;

    private List<RespuestaPedidoDto> organizarCola(List<RespuestaPedidoDto> colaSinOrganizar){
        List<Object> colaOrganizada = new ArrayList<>();
        ColaDto colaDto = new ColaDto();
        int indice = 1;
        for(RespuestaPedidoDto v : colaSinOrganizar){
            v.setProductos(ventaProductoRepository.buscarProductosVentas(v.getCodigoPedido()).stream().map(productoMapper::objectToProductoInventario).toList());
            colaDto.insertar(indice, v);
            indice++;
        }
        colaDto.mostrar(colaOrganizada);
        return colaOrganizada.stream().map(pedidoMapper::objectToRespuestaPedidoDto).toList();
    }

    @Override
    public List<RespuestaPedidoDto> buscarPedidosEstadoPendientes() {
        return organizarCola(pedidoRepository.buscarPedidosPendientes());
    }
}
