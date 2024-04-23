package com.gov.project.sia.service.input.impl;

import com.gov.project.sia.dto.PedidoDto;
import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.repository.PedidoRepository;
import com.gov.project.sia.repository.VentaRepository;
import com.gov.project.sia.service.input.IRegistrarPedidoService;
import com.gov.project.sia.utils.enums.EstadoVentaEnum;
import com.gov.project.sia.utils.mapper.PedidoMapper;
import com.gov.project.sia.utils.mapper.VentaMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;


import static com.gov.project.sia.utils.enums.EstadoPedidoEnum.*;
import static com.gov.project.sia.utils.helper.Constantes.*;

@Service
@RequiredArgsConstructor
 public class RegitrarPedidoService implements IRegistrarPedidoService {

    private final PedidoRepository pedidoRepository;

    private final PedidoMapper pedidoMapper;

    private final VentaRepository ventaRepository;

    private final VentaMapper ventaMapper;

    @Override
    @Transactional
    public Boolean aceptarPedido(PedidoDto pedidoIn) {
        PedidoDto pedido = pedidoMapper.entityTODto(pedidoRepository.findByCodigoPedido(pedidoIn.getCodigoPedido()));
        pedido.setEstadoPedido(A);
        pedidoRepository.save(pedidoMapper.pedidoDtoToPedidoEntity(pedido));
        VentaDto ventaDto = pedido.getIdVentaFk();
        ventaDto.setEstadoVenta(EstadoVentaEnum.A);
        ventaRepository.save(ventaMapper.ventaDtoToVentaEntity(ventaDto));
        return true;
    }

    @Override
    @Transactional
    public Boolean rechazarPedido(PedidoDto pedido) {
        PedidoDto pedidoDto = pedidoMapper.entityTODto(pedidoRepository.findByCodigoPedido(pedido.getCodigoPedido()));
        pedidoDto.setEstadoPedido(R);
        pedidoRepository.save(pedidoMapper.pedidoDtoToPedidoEntity(pedidoDto));
        VentaDto ventaDto = pedidoDto.getIdVentaFk();
        ventaDto.setEstadoVenta(EstadoVentaEnum.R);
        ventaRepository.save(ventaMapper.ventaDtoToVentaEntity(ventaDto));
        return true;
    }

    @Override
    public void iniciarPedido(VentaDto venta) {
        PedidoDto pedidoDto = new PedidoDto();
        String codigo = "";
        while (true){
            codigo = generarCodigo();
            if(!pedidoRepository.existsByCodigoPedido(codigo)){
                break;
            }
        }
        pedidoDto.setCodigoPedido(codigo);
        pedidoDto.setEstadoPedido(P);
        pedidoDto.setFechaInicioPedido(LocalDate.now());
        pedidoDto.setFechaVencimientoPedido(LocalDate.now().plusWeeks(3L));
        pedidoDto.setIdUsuarioFk(venta.getIdUsuarioFk());
        pedidoDto.setIdVentaFk(venta);
        pedidoRepository.save(pedidoMapper.pedidoDtoToPedidoEntity(pedidoDto));
    }

    private String generarCodigo(){
        StringBuilder codigo = new StringBuilder();
        SecureRandom random = new SecureRandom();
        codigo.append(LocalDate.now().getYear());

        // Generar código de 10 letras
        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            codigo.append(CHARACTERS.charAt(index));
        }

        return codigo.toString();
    }

}
