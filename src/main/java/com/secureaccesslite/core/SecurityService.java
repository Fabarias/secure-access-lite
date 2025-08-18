package com.secureaccesslite.core;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.secureaccesslite.model.User;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class SecurityService {

    public boolean checkDisplacementPattern(User user, List<String> currentRoute) {
        List<String> expectedKeyPoints = user.getDisplacementPattern().getKeyPoints();
        for (String keyPoint: expectedKeyPoints) {
            if (!currentRoute.contains(keyPoint)) {
                return false;
            }
        }
        return true;
    }


    public boolean isUserOnWantedList(User user) {
        try {
            String WANTED_LIST_FILE = "/data/wanted_list.json";

            InputStream inputStream = SecurityService.class.getResourceAsStream(WANTED_LIST_FILE);
            if (inputStream == null) {
                System.err.println("No se pudo encontrar el archivo de lista de buscados: " + WANTED_LIST_FILE);
                return false;
            }
            Reader reader = new InputStreamReader(inputStream);
            Gson gson = new Gson();

            JsonObject rootObject = gson.fromJson(reader, JsonObject.class);

            JsonArray wantedPersonsArray = rootObject.getAsJsonArray("wantedPersons");

            for (int i = 0; i < wantedPersonsArray.size(); i++) {

                JsonObject person = wantedPersonsArray.get(i).getAsJsonObject();
                String wantedDni = person.get("dni").getAsString();

                if (user.getDni().equals(wantedDni)) {
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
