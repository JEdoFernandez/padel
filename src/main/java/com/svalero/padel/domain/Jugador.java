package com.svalero.padel.domain;

public class Jugador {

    private String id_jugador;
    private String nombre;
    private String genero;
    private String nivel;
    private int edad;
    private String posicion;

    public Jugador(String id_jugador,String nombre,String genero,String nivel,int edad,String posicion){
        this.id_jugador = id_jugador;
        this.nombre = nombre;
        this.genero = genero;
        this.nivel = nivel;
        this.edad = edad;
        this.posicion = posicion;
    }

    public Jugador(){}

    public String getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(String id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}
