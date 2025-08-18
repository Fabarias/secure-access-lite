package com.secureaccesslite;

import com.secureaccesslite.core.AuthService;
import com.secureaccesslite.core.SecurityService;
import com.secureaccesslite.model.User;
import com.secureaccesslite.processdata.UserRepository;

import java.util.Arrays;
import java.util.List;


public class App {
    public static void main( String[] args ) {

        AuthService authService = new AuthService();
        SecurityService securityService = new SecurityService();
        User userPrueba = new User("user-002", "Ana Lucía Ramírez", "87654321 ");
        boolean responseSecurity = securityService.isUserOnWantedList(userPrueba);
        System.out.println(responseSecurity);




    }
}
