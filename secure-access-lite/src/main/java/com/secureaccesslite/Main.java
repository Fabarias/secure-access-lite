package com.secureaccesslite;

import com.secureaccesslite.nucleo.AutenticacionDeServicio;

public class Main {
    public static void main(String[] args) {
        AutenticacionDeServicio auntenticacion = new AutenticacionDeServicio();
        System.out.println("******************");
        System.out.println("Iniciando Sesion");
        auntenticacion.inicioSesion("amorales","12345");
        System.out.println("Registrando Nuevo Usuario");
        auntenticacion.registro("Jonathan","33939","Jonathan123","123");
        System.out.println("Iniciando Sesion con nuevo Usuario");
        auntenticacion.inicioSesion("Jonathan123","123");

    }
}
