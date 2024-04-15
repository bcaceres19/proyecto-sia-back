package com.gov.project.sia.service.impl;

import com.gov.project.sia.dto.OrquestadorPilaDto;
import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.dto.VentaProductoDto;
import com.gov.project.sia.repository.VentaProductoRepository;
import com.gov.project.sia.service.IConsultaVentaProductoService;
import com.gov.project.sia.utils.enums.EstadoVentaEnum;
import com.gov.project.sia.utils.mapper.VentaProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultarVentaProductoService implements IConsultaVentaProductoService {

    private final VentaProductoRepository ventaProductoRepository;

    private final VentaProductoMapper ventaProductoMapper;

    private List<VentaProductoDto> organizarPila(List<VentaProductoDto> pilaSinOrganizar){
        List<Object> pilaOrganizada = new ArrayList<>();
        OrquestadorPilaDto orquestadorPilaDto = new OrquestadorPilaDto();
        for(VentaProductoDto v : pilaSinOrganizar){
            orquestadorPilaDto.empujar(v.getIdVentaFk().getIdVenta(), v);
        }
        orquestadorPilaDto.listar(pilaOrganizada);
        return pilaOrganizada.stream().map(ventaProductoMapper::objectToVentaDto).toList();
    }

    @Override
    public List<VentaProductoDto> consultaVentaUsuarioSinConfirmar(Integer idUsuario) {
        return organizarPila(
                ventaProductoRepository.findAllByIdVentaFk_IdUsuarioFk_IdUsuarioAndIdVentaFk_EstadoVentaOrderByIdVentaFk_IdVentaAsc(idUsuario, EstadoVentaEnum.P)
                        .stream().map(ventaProductoMapper::ventaProductoEntityToventaProductoDto).toList());
    }

    @Override
    public List<VentaProductoDto> consultaVentaUsuarioConfirmar(Integer idUsuario) {
        return organizarPila(ventaProductoRepository.buscarVentasPendientesRevisionUsuario(idUsuario));
    }
}
