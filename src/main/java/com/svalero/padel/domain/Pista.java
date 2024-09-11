package com.svalero.padel.domain;

public class Pista {
    private String nombre_pista;
    private String cubierta;
    private String material;

    public Pista(String nombre_pista,String cubierta, String material){
        this.nombre_pista = nombre_pista;
        this.cubierta = cubierta;
        this.material = material;
    }

    public Pista() {}

    public String getNombre_pista() {
        return nombre_pista;
    }

    public void setNombre_pista(String nombre_pista) {
        this.nombre_pista = nombre_pista;
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
