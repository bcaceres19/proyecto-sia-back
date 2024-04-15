package com.gov.project.sia.dto;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Objects;

@Data
@Log4j2
public class OrquestadorPilaDto {

    private NodoPilaDto cima;

    public OrquestadorPilaDto() {
        this.cima = null;
    }

    //Metodo para saber cuando la pila esta vacia
    public boolean estaVacia(){
        return cima == null;
    }

    //Metodo para hacer push en la pila
    public void empujar(int elemento, Object objeto){
        NodoPilaDto nuevo = new NodoPilaDto(elemento, objeto);
        if(estaVacia()){
            cima = nuevo;
        }else{
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }

    public void listar(List<Object> nodos){
        NodoPilaDto aux = cima;
        while(aux != null){
            nodos.add(aux.getObjeto());
            aux = aux.getSiguiente();
        }
    }

}
