package com.secureaccesslite;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("/fxml/login_view.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root, 350, 400);

            primaryStage.setTitle("SecureAccess Lite - Login");
            primaryStage.setScene(scene);

            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();

            primaryStage.show();
        } catch (Exception e) {
            System.err.println("Error al carga la aplicación:");
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) {
        launch(args);
    }
}
