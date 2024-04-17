package com.gov.project.sia.service.impl;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.OrquestadorDto;
import com.gov.project.sia.dto.ProductoDto;
import com.gov.project.sia.dto.ProductoRespuestaDto;
import com.gov.project.sia.repository.ProductoRepository;
import com.gov.project.sia.service.IConsultarProductoService;
import com.gov.project.sia.utils.enums.TipoOrdenamientoEnum;
import com.gov.project.sia.utils.mapper.ProductoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ConsultarProductoService implements IConsultarProductoService {

    private final ProductoRepository productoRepository;

    private final ProductoMapper productoMapper;

    @Override
    public List<ProductoRespuestaDto> consultarProductos(TipoOrdenamientoEnum tipoOrdenamientoEnum) {
        List<ProductoRespuestaDto> listaRespuesta = productoRepository.buscarProductos().stream().map(productoMapper::objetctToProductoRespuesta).toList();
        if(!listaRespuesta.isEmpty()){
            OrquestadorDto orquestadorDto = new OrquestadorDto();
            List<Integer> numeros = new ArrayList<>();
            for(int i = 1; i<= listaRespuesta.size(); i++){
                numeros.add(i);
            }
            Collections.shuffle(numeros);
            log.error(numeros);
            int indice = 0;
            for(Integer numero : numeros){
                orquestadorDto.insertar(listaRespuesta.get(indice), ProductoRespuestaDto.class, numero);
                indice++;
            }
            List<Object> orquestadorDtos = new ArrayList<>();
            orquestadorDto.disparadorOrdenamiento(tipoOrdenamientoEnum,orquestadorDtos);
            List<ProductoRespuestaDto> resultado = orquestadorDtos.stream().map(productoMapper::objectToProducto).toList();
            return resultado;
        }
        return listaRespuesta;
    }


}
