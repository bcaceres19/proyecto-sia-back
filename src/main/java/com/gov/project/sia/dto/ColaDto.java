package com.gov.project.sia.dto;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Data
@Log4j2
public class ColaDto {

    private NodoColaDto inicio;
    private NodoColaDto fin;

    public ColaDto(){
        inicio = null;
        fin = null;
    }

    public boolean esVacia(){
        return inicio == null;
    }

    public void insertar(int ele, Object objeto){
        NodoColaDto nuevo = new NodoColaDto(ele, objeto);
        if(esVacia()){
            inicio = nuevo;
        }else{
            this.fin.setSiguiente(nuevo);
        }
        fin = nuevo;
    }

    //Metodo toString
    public void mostrar(List<Object> listado)
    {
        NodoColaDto c=this.inicio;
        while(c!=null)
        {
            listado.add(c.getObjeto());
            c=c.getSiguiente();
        }
    }

}
