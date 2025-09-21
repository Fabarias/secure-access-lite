package com.secureaccesslite.nucleo;

import com.secureaccesslite.modelo.Credencial;
import com.secureaccesslite.modelo.Usuario;
import com.secureaccesslite.procesarinformacion.RepositorioDeUsuario;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;
import java.util.UUID;

public class AutenticacionDeServicio {

    private final RepositorioDeUsuario repositoripoUsuario = new RepositorioDeUsuario();

    public Usuario registro(String nombre, String dni, String nombreDeUsuario, String clave) {
        if (this.repositoripoUsuario.encontrarPorUsuario(nombreDeUsuario).isPresent()) {
            return null;
        }

        String claveCifrada = BCrypt.hashpw(clave, BCrypt.gensalt());
        String idsUsuario = UUID.randomUUID().toString();

        Usuario nuevoUsuario = new Usuario(idsUsuario, nombre, dni);

        Credencial credencial = new Credencial(nombreDeUsuario, claveCifrada);
        nuevoUsuario.setCredencial(credencial);

        nuevoUsuario.setPatronDeDesplazamiento(null);
        repositoripoUsuario.save(nuevoUsuario);

        return nuevoUsuario;
    }

    public Usuario inicioSesion(String nombreUsuario, String clave) {
        Optional<Usuario> usuarioOpcional = repositoripoUsuario.encontrarPorUsuario(nombreUsuario);


        if (usuarioOpcional.isEmpty()) {
            return null;
        }

        Usuario usuario = usuarioOpcional.get();
        String hashGuardado = usuario.getCredencial().getClaveCifrada();

        boolean claveValida = BCrypt.checkpw(clave, hashGuardado);

        if (claveValida) {
            System.out.println("Login exitoso: Bienvenido " + nombreUsuario);
            return usuario;
        } else {
            return null;
        }
    }
}
