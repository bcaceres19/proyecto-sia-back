package com.gov.project.sia.service.input;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.utils.exceptions.ErrorGeneralException;

public interface IInventarioInputService {

    void crearInventarioProducto(InventarioDto inventario) throws ErrorGeneralException;

    Boolean verificarCreacionInventario(String nombreProducto);

}
