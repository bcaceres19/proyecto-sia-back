package com.gov.project.sia.service.input.impl;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.ProductoDto;
import com.gov.project.sia.repository.InventarioRepository;
import com.gov.project.sia.repository.ProductoRepository;
import com.gov.project.sia.service.input.IInventarioInputService;
import com.gov.project.sia.utils.enums.EstadoProductoEnum;
import com.gov.project.sia.utils.exceptions.ErrorGeneralException;
import com.gov.project.sia.utils.mapper.InventarioMapper;
import com.gov.project.sia.utils.mapper.ProductoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;

import static com.gov.project.sia.utils.helper.Constantes.*;
import static com.gov.project.sia.utils.helper.Constantes.CHARACTERS;

@Service
@RequiredArgsConstructor
@Log4j2
public class InventarioInputService implements IInventarioInputService  {
    private final InventarioRepository inventarioRepository;
    private final InventarioMapper inventarioMapper;
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public void crearInventarioProducto(InventarioDto inventario) throws ErrorGeneralException {
        try {
            Integer id = inventarioRepository.save(inventarioMapper.inventarioDtoToInventarioEntity(inventario)).getIdInventario();
            crearProductos(inventario.getPorcentajeAumentoPrecio(),
                    inventario.getPrecioProductoInventario(),
                    inventario.getStockProductoInventario(),
                    id,inventario.getFechaVencimiento());
        }catch (Exception ex){
            log.error(ex);
            throw new ErrorGeneralException(ERROR_GENERAL);
        }
    }

    private void crearProductos(Integer porcentage,
                                Double precioBase,
                                Integer stock,
                                Integer idInventario,
                                LocalDate fechaVencimiento){
        for(int i = 0; i<stock; i++){
            InventarioDto inventarioDto = new InventarioDto();
            inventarioDto.setIdInventario(idInventario);
            ProductoDto producto = new ProductoDto();
            producto.setCodigoProducto(generarCodigoProducto());
            producto.setEstadoProducto(EstadoProductoEnum.F);
            producto.setPrecioProducto(calcularPrecio(porcentage, precioBase));
            producto.setFechaVencimientoProducto(fechaVencimiento);
            producto.setIdInventarioFk(inventarioDto);
            productoRepository.save(productoMapper.dtoToEntity(producto));
        }
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

    private Double calcularPrecio(Integer porcentaje, Double precioBase){
        Double precioPorcentaje  =(precioBase * porcentaje) / 100.0;
        return precioBase + precioPorcentaje;
    }
}
