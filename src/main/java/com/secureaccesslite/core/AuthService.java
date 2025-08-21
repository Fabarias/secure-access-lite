package com.secureaccesslite.core;

import com.secureaccesslite.model.Credential;
import com.secureaccesslite.model.User;
import com.secureaccesslite.processdata.UserRepository;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;
import java.util.UUID;

public class AuthService {

    private final UserRepository userRepository = new UserRepository();

    public User register(String name, String dni, String username, String password) {
        if (this.userRepository.findByUsername(username).isPresent()) {
            return null;
        }

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        String userID = UUID.randomUUID().toString();

        User newUser = new User(userID, name, dni);

        Credential credential = new Credential(username, hashedPassword);
        newUser.setCredential(credential);

        newUser.setDisplacementPattern(null);
        userRepository.save(newUser);

        return newUser;
    }

    public User login(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);


        if (userOptional.isEmpty()) {
            return null;
        }

        User user = userOptional.get();
        String storedHash = user.getCredential().getHashedPassword();

        boolean passwordMatches = BCrypt.checkpw(password, storedHash);

        if (passwordMatches) {
            System.out.println("Login exitoso: Bienvenido " + username);
            return user;
        } else {
            return null;
        }
    }
}
