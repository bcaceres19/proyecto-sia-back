package com.gov.project.sia.dto;

import lombok.Data;

@Data
public class ArbolDto {

    NodoArbolDto inicial;

    public ArbolDto() {
        this.inicial = null;
    }

    public void insertar(int valor){
        if(this.inicial == null){
            this.inicial = new NodoArbolDto(valor);
        }else{
            this.inicial.add(valor);
        }
    }

    public void dispararPreorden(){
        this.preorden(this.inicial);
    }

    public void preorden(NodoArbolDto nodo){
        if(nodo == null){
            return;
        }else {
            System.out.print(nodo.getValor()+ ",");
            preorden(nodo.getNodIzqu());
            preorden(nodo.getNodDercho());
        }
    }

    public void dispararInorden(){
        this.inorden(this.inicial);
    }

    public void inorden(NodoArbolDto nodo){
        if(nodo == null){
            return;
        }else {
            inorden(nodo.getNodIzqu());
            System.out.print(nodo.getValor()+ ",");
            inorden(nodo.getNodDercho());
        }
    }

    public void dispararPostOrden(){
        this.postOrden(this.inicial);
    }

    public void postOrden(NodoArbolDto nodo){
        if(nodo == null){
            return;
        }else {
            postOrden(nodo.getNodIzqu());
            postOrden(nodo.getNodDercho());
            System.out.print(nodo.getValor()+ ",");
        }
    }

    public NodoArbolDto getInicial() {
        return inicial;
    }

    public void setInicial(NodoArbolDto inicial) {
        this.inicial = inicial;
    }
}

