package com.gov.project.sia.service.impl;

import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.dto.VentaDto;
import com.gov.project.sia.repository.VentaRepository;
import com.gov.project.sia.service.IConsultaVentaService;
import com.gov.project.sia.utils.mapper.VentaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ConsultarVentaService implements IConsultaVentaService {

    private final VentaRepository ventaRepository;

    private final VentaMapper ventaMapper;
    private List<VentaDto> organizarPila(List<VentaDto> pilaSinOrganizar){
        List<VentaDto> pilaOrganizada = new ArrayList<>();
        pilaOrganizada.addAll(pilaSinOrganizar.reversed());
        return pilaOrganizada;
    }

    @Override
    public List<VentaDto> consultaVentaUsuarioSinConfirmar(Integer usuarioDto) {
        return organizarPila(ventaRepository.findAllByIdUsuarioFk_IdUsuario(usuarioDto).stream().map(ventaMapper::VentaEntityToVentaDto).toList());
    }

    @Override
    public List<VentaDto> consultaVentaUsuarioConfirmar(Integer usuarioDto) {
        return organizarPila(ventaRepository.buscarVentasConfirmadasUsuario(usuarioDto));
    }
}
