package com.gov.project.sia.controllers;

import com.gov.project.sia.dto.InventarioDto;
import com.gov.project.sia.dto.InventarioInputDto;
import com.gov.project.sia.dto.RespuestaGeneralDto;
import com.gov.project.sia.dto.UsuarioDto;
import com.gov.project.sia.service.input.IInventarioInputService;
import com.gov.project.sia.service.output.IConsultaInventarioService;
import com.gov.project.sia.utils.exceptions.ErrorGeneralException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventario")
@RequiredArgsConstructor
@Log4j2
public class InventarioController {

    private final IConsultaInventarioService iConsultaInventarioService;

    private final IInventarioInputService iInventarioInputService;

    @PostMapping("/consultar-inventario")
    public ResponseEntity<RespuestaGeneralDto> consultaInventario(
            @RequestBody InventarioInputDto inventarioInput
    ){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setListaData(iConsultaInventarioService.consultarInventario(inventarioInput.getTipoOrdenamiento(), inventarioInput.getInventariosRespuesta()));
        respuesta.setMensaje("Se consulto correctamente");
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/consultar-inventario-nombre")
    public ResponseEntity<RespuestaGeneralDto> consultarInventarioNombre(
            @RequestBody InventarioInputDto inventarioInput
    ){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setListaData(iConsultaInventarioService.consultarInventarioNombre(inventarioInput.getTipoOrdenamiento(), inventarioInput.getNombre()));
        respuesta.setMensaje("Se consulto correctamente");
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/verificar-creacion-inventario")
    public ResponseEntity<RespuestaGeneralDto> verificarCreacionInventario(
            @RequestParam("nombreInventario") String nombreInventario
    ){
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        respuesta.setStatus(Boolean.TRUE);
        respuesta.setData(iInventarioInputService.verificarCreacionInventario(nombreInventario));
        respuesta.setMensaje("Se valido correctamente");
        return ResponseEntity.ok(respuesta);
    }



    @PostMapping("/crear")
    public ResponseEntity<RespuestaGeneralDto> crearInventario(@RequestBody InventarioDto inventario) throws ErrorGeneralException {
        RespuestaGeneralDto respuesta = new RespuestaGeneralDto();
        try {
            iInventarioInputService.crearInventarioProducto(inventario);
            respuesta.setStatus(Boolean.TRUE);
            respuesta.setMensaje("Se creo correctamente");
            return ResponseEntity.ok(respuesta);
        }catch (Exception ex){
            log.error(ex);
            throw new ErrorGeneralException(ex.getMessage());
        }
    }

}
