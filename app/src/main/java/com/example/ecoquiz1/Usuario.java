package com.example.ecoquiz1;

import java.io.Serializable;

public class Usuario implements Serializable {

    String nombre, id;
    int acumulado;
    public Usuario(String nombre, String id , int acumulado){
        this.acumulado = acumulado;
        this.id= id;
        this.nombre= nombre;

    }

    public String represento(){
        String  info= ""+nombre+" "+acumulado+"\n";
     return    info;
    }
    //gets
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public int getAcumulado() {
        return acumulado;
    }

    //sets
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAcumulado(int acumulado) {
        this.acumulado = acumulado;
    }
}
