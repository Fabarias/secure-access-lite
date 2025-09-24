package com.secureaccesslite.nucleo;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.secureaccesslite.modelo.Usuario;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class ServicioSeguridad {

    public boolean comprobandoPatronDDesplazamiento(Usuario usuario, List<String> rutaActual) {
        List<String> puntosClaveEsperados = usuario.getDisplacementPattern().getPuntosClave();
        for (String puntosClave: puntosClaveEsperados) {
            if (!rutaActual.contains(puntosClave)) {
                return false;
            }
        }
        return true;
    }


    public boolean listaDeBusquedaDelUsuario(Usuario usuario) {
        try {
            String ArchivoConPersonasBuscadas = "/data/wanted_list.json";

            InputStream archivoEncontrado = ServicioSeguridad.class.getResourceAsStream(ArchivoConPersonasBuscadas);
            if (archivoEncontrado == null) {
                System.err.println("No se pudo encontrar el archivo de lista de buscados: " + ArchivoConPersonasBuscadas);
                return false;
            }
            Reader archivoLeido = new InputStreamReader(archivoEncontrado);
            Gson gson = new Gson();

            JsonObject objetoRaiz = gson.fromJson(archivoLeido, JsonObject.class);

            JsonArray arregloPersonasBuscadas = objetoRaiz.getAsJsonArray("personasBuscadas");

            for (int i = 0; i < arregloPersonasBuscadas.size(); i++) {

                JsonObject person = arregloPersonasBuscadas.get(i).getAsJsonObject();
                String dniBuscado = person.get("dni").getAsString();

                if (usuario.getDni().equals(dniBuscado)) {
                    return true;
                }
            }
            return false;
        } catch (JsonSyntaxException e) {
            System.err.println("Error: El archivo wanted_list.json contiene JSON inválido");
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            System.err.println("Error: Fallo en la lectura o procesamiento del archivo de lista de buscados");
            e.printStackTrace();
            return false;
        }

    }
}
