package com.secureaccesslite;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class App extends Application {

    @Override
    public void start(Stage primeraEtapa) {
        try {
            FXMLLoader cargarInterfaz = new FXMLLoader();

            cargarInterfaz.setLocation(getClass().getResource("/fxml/login_view.fxml"));

            Parent contenedorLogin = cargarInterfaz.load();

            Scene accesoEscena = new Scene(contenedorLogin, 350, 400);

            primeraEtapa.setTitle("SecureAccess Lite - Login");
            primeraEtapa.setScene(accesoEscena);

            primeraEtapa.setResizable(false);
            primeraEtapa.centerOnScreen();

            primeraEtapa.show();
        } catch (Exception e) {
            System.err.println("Error al carga la aplicación:");
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) {
        launch(args);
    }
}
