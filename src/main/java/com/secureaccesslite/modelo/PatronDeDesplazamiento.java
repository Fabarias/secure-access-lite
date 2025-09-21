package com.secureaccesslite.modelo;

import java.util.List;

public class PatronDeDesplazamiento {

    private String patronId;
    private String descripcion;
    private List<String> puntosClave;

    public PatronDeDesplazamiento(String patronId, String descripcion, List<String> puntosClave) {
        this.patronId = patronId;
        this.descripcion = descripcion;
        this.puntosClave = puntosClave;
    }

    public String getPatronId() {
        return patronId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<String> getPuntosClave() {
        return puntosClave;
    }

    public void setPatronId(String patronId) {
        this.patronId = patronId;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPuntosClave(List<String> puntosClave) {
        this.puntosClave = puntosClave;
    }
}
