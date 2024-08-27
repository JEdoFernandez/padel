package com.svalero.padel.domain;

public class ClubPadel {

    private String nombre_club;
    private String direccion;
    private String telefono;
    private String web;
    private String federacion;

    public ClubPadel( String nombre_club,String direccion,String telefono,String web,String federacion){
        this.nombre_club= nombre_club;
        this.direccion=direccion;
        this.telefono=telefono;
        this.web=web;
        this.federacion=federacion;
    }
    public ClubPadel(){}

    public String getNombre_club() {
        return nombre_club;
    }

    public void setNombre_club(String nombre_club) {
        this.nombre_club = nombre_club;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getFederacion() {
        return federacion;
    }

    public void setFederacion(String federacion) {
        this.federacion = federacion;
    }
}
