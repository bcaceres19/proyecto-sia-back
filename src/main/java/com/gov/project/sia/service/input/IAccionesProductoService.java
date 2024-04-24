package com.gov.project.sia.service.input;

import com.gov.project.sia.dto.ProductoDto;

public interface IAccionesProductoService {

    boolean eliminarProductoVenta(Integer idVentaProducto);

    boolean crearProducto(ProductoDto producto);

}
