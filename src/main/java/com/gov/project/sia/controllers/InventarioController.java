package com.gov.project.sia.controllers;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.service.IConsultaInventarioService;
import com.gov.project.sia.utils.enums.TipoOrdenamientoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
@RequiredArgsConstructor
public class InventarioController {

    private final IConsultaInventarioService iConsultaInventarioService;

    @GetMapping("/buscar-productos")
    public ResponseEntity<List<InventarioDto>> buscarProductosInventario(
            @RequestParam("TipoOrdenamientoEnum") TipoOrdenamientoEnum tipoOrdenamientoEnum
    ){
        return ResponseEntity.ok(iConsultaInventarioService.buscarProductosInventario(tipoOrdenamientoEnum));
    }

}
