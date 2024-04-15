package com.gov.project.sia.dto;

import com.gov.project.sia.utils.enums.TipoOrdenamientoEnum;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Objects;

@Data
@Log4j2
public class OrquestadorDto {

    private AyudanteOrquestadorDto inicial;

    private Integer tamanioPila;

    public OrquestadorDto() {
        this.inicial = null;
    }

    public <T> void insertar(Object objeto, Class<T> clazz){
        try{
            if(clazz.equals(InventarioDto.class)){
                InventarioDto inventarioDto = (InventarioDto) objeto;
                addData(inventarioDto.getIdInventario(),inventarioDto);
            }else if(clazz.equals(Integer.class)){
                addData((Integer) objeto, null) ;
            }
        }catch (ClassCastException ex){
            throw new ClassCastException(ex.getMessage());
        }
    }

    private void addData(Integer valor, Object object){
        if(this.inicial == null){
            this.inicial = new AyudanteOrquestadorDto(valor,object);
        }else{
            this.inicial.add(valor, object);
        }
    }


    public void disparadorOrdenamiento(TipoOrdenamientoEnum tipoOrdenamientoEnum, List<Object> listaObjetos){

        switch (tipoOrdenamientoEnum){
            case INORDEN -> inorden(this.inicial,listaObjetos);
            case POST_ORDEN -> postOrden(this.inicial,listaObjetos);
            case PRE_ORDEN -> preorden(this.inicial,listaObjetos);
        }
    }


    public void inorden(AyudanteOrquestadorDto nodo, List<Object> listaObjetos){
        if(nodo != null) {
            inorden(nodo.getNodIzqu(), listaObjetos);
            listaObjetos.add(nodo.getObjeto());
            inorden(nodo.getNodDercho(), listaObjetos);
        }
    }
    public void postOrden(AyudanteOrquestadorDto nodo, List<Object> listaObjetos){
        if(nodo != null){
            postOrden(nodo.getNodIzqu(),  listaObjetos);
            postOrden(nodo.getNodDercho(),  listaObjetos);
            listaObjetos.add(nodo.getObjeto());
        }
    }

    public void preorden(AyudanteOrquestadorDto nodo, List<Object> listaObjetos){
        if(nodo != null) {
            listaObjetos.add(nodo.getObjeto());
            preorden(nodo.getNodIzqu(), listaObjetos);
            preorden(nodo.getNodDercho(),listaObjetos);
        }
    }

}

