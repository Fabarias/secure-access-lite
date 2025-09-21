package com.secureaccesslite.modelo;

public class Usuario {

    private String id;
    private String nombre;
    private String dni;
    private String imagenDeRuta;
    private Credencial credencial;
    private PatronDeDesplazamiento patronDeDesplazamiento;


    public Usuario(String id, String nombre, String dni, String imagenDeRuta) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.imagenDeRuta = imagenDeRuta;
    }

    public Usuario(String id, String nombre, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.imagenDeRuta = "/images/default_avatar.png";
    }


    public PatronDeDesplazamiento getDisplacementPattern() {
        return patronDeDesplazamiento;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getImagenDeRuta() {
        return imagenDeRuta;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    public void setPatronDeDesplazamiento(PatronDeDesplazamiento patronDeDesplazamiento) {
        this.patronDeDesplazamiento = patronDeDesplazamiento;
    }

    public void setImagenDeRuta(String imagenDeRuta) {
        this.imagenDeRuta = imagenDeRuta;
    }
}
