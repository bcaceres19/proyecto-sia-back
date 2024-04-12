package com.gov.project.sia.dto;

import lombok.Data;

@Data
public class NodoArbolDto {

    private Integer valor;
    private NodoArbolDto nodIzqu;
    private NodoArbolDto nodDercho;

    public NodoArbolDto(Integer valor) {
        this.valor = valor;
        this.nodIzqu = null;
        this.nodDercho = null;
    }

    public void add(int valor){
        if(valor < this.valor){
            //insertar lado izquierdo
            if(this.nodIzqu == null){
                this.nodIzqu = new NodoArbolDto(valor);
            }else{
                this.nodIzqu.add(valor);
            }
        }else{
            //insertar en lado derecho
            if(nodDercho == null){
                this.nodDercho = new NodoArbolDto(valor);
            }else{
                this.nodDercho.add(valor);
            }
        }
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public NodoArbolDto getNodIzqu() {
        return nodIzqu;
    }

    public void setNodIzqu(NodoArbolDto nodIzqu) {
        this.nodIzqu = nodIzqu;
    }

    public NodoArbolDto getNodDercho() {
        return nodDercho;
    }

    public void setNodDercho(NodoArbolDto nodDercho) {
        this.nodDercho = nodDercho;
    }
}
