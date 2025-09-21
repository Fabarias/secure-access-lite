package com.secureaccesslite.procesarinformacion;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.secureaccesslite.modelo.Usuario;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class RepositorioDeUsuario {

    String ArchivoConUsuarios = "/data/users.json";
    private final List<Usuario> usuarioCache;

    public RepositorioDeUsuario() {
        this.usuarioCache = cargarArchivoConUsuarios();
    }

    private List<Usuario> cargarArchivoConUsuarios() {
        try {
            InputStream encontrarArchivosConUsuarios = RepositorioDeUsuario.class.getResourceAsStream(ArchivoConUsuarios);
            if (encontrarArchivosConUsuarios == null) {
                System.err.println("No pudimos obtener el archivo de datos: " + ArchivoConUsuarios);
                return new ArrayList<>();
            }

            Reader leerArchivo = new InputStreamReader(encontrarArchivosConUsuarios);
            Type listaTipoUsuario = new TypeToken<ArrayList<Usuario>>(){}.getType();

            return new Gson().fromJson(leerArchivo, listaTipoUsuario);

        } catch (Exception e) {
            System.err.println("Error: Fallo en la lectura o procesamiento del archivo");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Optional<Usuario> encontrarPorUsuario(String nombreUsuario) {
        return this.usuarioCache.stream()
                .filter(usuario -> usuario.getCredencial() != null && usuario.getCredencial().getNombreUsuario().equals(nombreUsuario))
                .findFirst();
    }

    public List<Usuario> encontrarTodo() {
        return new ArrayList<>(this.usuarioCache);
    }

    public void save(Usuario usuario) {

        if (encontrarPorUsuario(usuario.getCredencial().getNombreUsuario()).isEmpty()) {
            this.usuarioCache.add(usuario);
            System.out.println("Usuario guardado: " + usuario.getNombre());
        } else {
            System.out.println("El usuario " + usuario.getCredencial().getNombreUsuario() + " ya existe.");
        }
    }
}
