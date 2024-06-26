package com.gov.project.sia.dto;

import lombok.Data;

@Data
public class AyudanteOrquestadorDto{

    private Integer valor;
    private Object objeto;
    private AyudanteOrquestadorDto nodIzqu;
    private AyudanteOrquestadorDto nodDercho;
    private AyudanteOrquestadorDto siguiente;

    public AyudanteOrquestadorDto(Integer valor, Object objeto) {
        this.valor = valor;
        this.objeto = objeto;
        this.nodIzqu = null;
        this.nodDercho = null;
    }

    public void AyudanteOrquestadorDtoPila(){
        this.valor = 0;
        this.siguiente = null;
    }

    public void add(int valor,Object objeto){
        if(valor < this.valor){
            if(this.nodIzqu == null){
                this.nodIzqu = new AyudanteOrquestadorDto(valor,objeto);
            }else{
                this.nodIzqu.add(valor,objeto);
            }
        }else{
            //insertar en lado derecho
            if(nodDercho == null){
                this.nodDercho = new AyudanteOrquestadorDto(valor,objeto);
            }else{
                this.nodDercho.add(valor,objeto);
            }
        }
    }
}
