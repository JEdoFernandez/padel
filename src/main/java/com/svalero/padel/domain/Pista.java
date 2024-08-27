package com.svalero.padel.domain;

public class Pista {
    private String nombre;
    private String cubierta;
    private String material;

    public Pista(String nombre,String cubierta, String material){
        this.nombre = nombre;
        this.cubierta = cubierta;
        this.material = material;
    }

    public Pista() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCubierta() {
        return cubierta;
    }

    public void setCubierta(String cubierta) {
        this.cubierta = cubierta;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
