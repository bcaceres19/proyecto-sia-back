package com.gov.project.sia.service.output.impl;

import com.gov.project.sia.dto.OrquestadorPilaDto;
import com.gov.project.sia.dto.VentaProductoDto;
import com.gov.project.sia.dto.VentaProductoRespuestaDto;
import com.gov.project.sia.repository.VentaProductoRepository;
import com.gov.project.sia.service.output.IConsultaVentaProductoService;
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

    private VentaProductoRespuestaDto organizarPila(List<VentaProductoDto> pilaSinOrganizar){
        List<Object> pilaOrganizada = new ArrayList<>();
        VentaProductoRespuestaDto ventaProductoRespuestaDto = new VentaProductoRespuestaDto();
        OrquestadorPilaDto orquestadorPilaDto = new OrquestadorPilaDto();
        for(VentaProductoDto v : pilaSinOrganizar){
            orquestadorPilaDto.empujar(v.getIdVentaProducto(), v);
        }
        orquestadorPilaDto.listar(pilaOrganizada);
        for(Object objeto : pilaOrganizada){
            ventaProductoMapper.objectToVentaProductoRespuestaDto(objeto, ventaProductoRespuestaDto);
        }
        return ventaProductoRespuestaDto;
    }

    @Override
    public VentaProductoRespuestaDto consultaVentaUsuarioSinConfirmar(Integer idUsuario) {
        return organizarPila(
                ventaProductoRepository.buscarVentasNuevasUsuario(idUsuario));
    }

    @Override
    public VentaProductoRespuestaDto consultaVentaUsuarioConfirmar(Integer idUsuario) {
        return organizarPila(ventaProductoRepository.buscarVentasPendientesRevisionUsuario(idUsuario));
    }
}
