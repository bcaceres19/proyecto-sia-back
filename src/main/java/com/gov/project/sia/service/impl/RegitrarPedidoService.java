package com.gov.project.sia.service.impl;

import com.gov.project.sia.dto.PedidoDto;
import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.dto.VentaProductoDto;
import com.gov.project.sia.repository.PedidoRepository;
import com.gov.project.sia.repository.VentaPedidoRepository;
import com.gov.project.sia.service.IRegistrarPedidoService;
import com.gov.project.sia.utils.mapper.PedidoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.List;

import static com.gov.project.sia.utils.enums.EstadoPedidoEnum.ACEPTADO;
import static com.gov.project.sia.utils.enums.EstadoPedidoEnum.PENDIENTE;
import static com.gov.project.sia.utils.helper.Constantes.*;

@Service
@RequiredArgsConstructor
public class RegitrarPedidoService implements IRegistrarPedidoService {

    private final PedidoRepository pedidoRepository;

    private final PedidoMapper pedidoMapper;


    @Override
    public void aceptarPedido(List<PedidoDto> pedidos) {
        for(PedidoDto pedido : pedidos){
            pedido.setEstadoPedido(ACEPTADO);
            pedidoRepository.save(pedidoMapper.pedidoDtoToPedidoEntity(pedido));
        }
    }

    @Override
    public void iniciarPedido(List<VentaDto> ventas) {
        PedidoDto pedidoDto = new PedidoDto();
        for(VentaDto venta : ventas){
            String codigo = "";
            while (true){
                codigo = generarCodigo();
                if(!pedidoRepository.existsByCodigoPedido(codigo)){
                    break;
                }
            }
            pedidoDto.setCodigoPedido(codigo);
            pedidoDto.setEstadoPedido(PENDIENTE);
            pedidoDto.setFechaInicioPedido(LocalDate.now());
            pedidoDto.setFechaVencimientoPedido(LocalDate.now().plusWeeks(3L));
            pedidoDto.setIdUsuarioFk(venta.getIdUsuarioFk());
            pedidoDto.setIdVentaFk(venta);
            pedidoRepository.save(pedidoMapper.pedidoDtoToPedidoEntity(pedidoDto));
        }

    }

    private String generarCodigo(){
        StringBuilder codigo = new StringBuilder();
        SecureRandom random = new SecureRandom();

        // Agregar la fecha actual en el formato deseado
        LocalDate fechaActual = LocalDate.now();
        String fechaFormateada = fechaActual.format(DATE_FORMAT);
        codigo.append(fechaFormateada);

        // Generar código de 10 letras
        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            codigo.append(CHARACTERS.charAt(index));
        }

        return codigo.toString();
    }

}
