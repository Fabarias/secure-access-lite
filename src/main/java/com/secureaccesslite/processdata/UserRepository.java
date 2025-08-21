package com.secureaccesslite.processdata;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.secureaccesslite.model.User;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserRepository {

    String DATA_FILE = "/data/users.json";
    private final List<User> userCache;

    public UserRepository() {
        this.userCache = loadUsersFromFile();
    }

    private List<User> loadUsersFromFile() {
        try {
            InputStream inputStream = UserRepository.class.getResourceAsStream(DATA_FILE);
            if (inputStream == null) {
                System.err.println("No pudimos obtener el archivo de datos: " + DATA_FILE);
                return new ArrayList<>();
            }

            Reader reader = new InputStreamReader(inputStream);
            Type userListType = new TypeToken<ArrayList<User>>(){}.getType();

            return new Gson().fromJson(reader, userListType);

        } catch (Exception e) {
            System.err.println("Error: Fallo en la lectura o procesamiento del archivo");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Optional<User> findByUsername(String username) {
        return this.userCache.stream()
                .filter(user -> user.getCredential() != null && user.getCredential().getUsername().equals(username))
                .findFirst();
    }

    public List<User> findAll() {
        return new ArrayList<>(this.userCache);
    }

    public void save(User user) {

        if (findByUsername(user.getCredential().getUsername()).isEmpty()) {
            this.userCache.add(user);
            System.out.println("Usuario guardado: " + user.getName());
        } else {
            System.out.println("El usuario " + user.getCredential().getUsername() + " ya existe.");
        }
    }
}
