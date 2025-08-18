package com.secureaccesslite.model;

public class User {

    private String id;
    private String name;
    private String dni;
    private String photoPath;
    private Credential credential;
    private DisplacementPattern displacementPattern;


    public User(String id, String name, String dni, String photoPath) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.photoPath = photoPath;
    }

    public User(String id, String name, String dni) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.photoPath = "/images/default_avatar.png";
    }


    public DisplacementPattern getDisplacementPattern() {
        return displacementPattern;
    }

    public Credential getCredential() {
        return credential;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public void setDisplacementPattern(DisplacementPattern displacementPattern) {
        this.displacementPattern = displacementPattern;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
