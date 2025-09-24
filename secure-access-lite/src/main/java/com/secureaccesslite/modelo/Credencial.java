package com.secureaccesslite.modelo;

public class Credencial {

    private String nombreUsuario;
    private String claveCifrada;

    public Credencial(String nombreUsuario, String claveCifrada) {
        this.nombreUsuario = nombreUsuario;
        this.claveCifrada = claveCifrada;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getClaveCifrada() {
        return claveCifrada;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setClaveCifrada(String claveCifrada) {
        this.claveCifrada = claveCifrada;
    }
}
