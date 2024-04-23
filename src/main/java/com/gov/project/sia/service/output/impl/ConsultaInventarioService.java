package com.gov.project.sia.service.output.impl;

import com.gov.project.sia.dto.InventarioRespuestaDto;
import com.gov.project.sia.dto.OrquestadorDto;
import com.gov.project.sia.repository.InventarioRepository;
import com.gov.project.sia.service.output.IConsultaInventarioService;
import com.gov.project.sia.utils.enums.TipoOrdenamientoEnum;
import com.gov.project.sia.utils.mapper.InventarioMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ConsultaInventarioService implements IConsultaInventarioService {

    private final InventarioRepository inventarioRepository;

    private final InventarioMapper inventarioMapper;

    @Override
    public List<InventarioRespuestaDto> consultarInventario(TipoOrdenamientoEnum tipoOrdenamientoEnum, List<InventarioRespuestaDto> inventarioActual) {
        List<InventarioRespuestaDto> listaRespuesta;
        if(inventarioActual.isEmpty()){
            listaRespuesta = inventarioRepository.buscarInventario().stream().map(inventarioMapper::objectListToInventarioRespuestaDto).toList();
        }else{
            listaRespuesta = inventarioActual;
        }
        return ordenamiento(listaRespuesta,tipoOrdenamientoEnum);
    }

    @Override
    public List<InventarioRespuestaDto> consultarInventarioNombre(TipoOrdenamientoEnum tipoOrden, String nombre) {
        List<InventarioRespuestaDto> listaRespuesta = inventarioRepository.buscarInventarioNombre(nombre);
        return ordenamiento(listaRespuesta,tipoOrden);
    }

    private List<InventarioRespuestaDto> ordenamiento(List<InventarioRespuestaDto> listaRespuesta, TipoOrdenamientoEnum tipoOrdenamientoEnum){
        if(!listaRespuesta.isEmpty()){
            OrquestadorDto orquestadorDto = new OrquestadorDto();
            List<Integer> numeros = new ArrayList<>();
            for(InventarioRespuestaDto inventario : listaRespuesta){
                numeros.add(inventario.getIdInventario());
            }
            Collections.shuffle(numeros);
            for(Integer numero : numeros){
                InventarioRespuestaDto inventarioRespuesta =listaRespuesta.stream().filter(objeto -> objeto.getIdInventario().equals(numero)).findFirst().get();
                inventarioMapper.objectListToDetalleInventario(inventarioRepository.buscarDetalleInventario(inventarioRespuesta.getIdInventario()).get(0),inventarioRespuesta);
                orquestadorDto.insertar(inventarioRespuesta, InventarioRespuestaDto.class);
            }
            List<Object> orquestadorDtos = new ArrayList<>();
            orquestadorDto.disparadorOrdenamiento(tipoOrdenamientoEnum,orquestadorDtos);
            List<InventarioRespuestaDto> resultado = orquestadorDtos.stream().map(inventarioMapper::objectToInventarioRespuestaDto).toList();
            return resultado;
        }
        return listaRespuesta;
    }



}
