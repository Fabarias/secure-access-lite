package com.secureaccesslite.ui;

import com.secureaccesslite.core.AuthService;
import com.secureaccesslite.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;


public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorMessageLabel;

    private final AuthService authService = new AuthService();

    @FXML
    public void handleLoginButtonAction(ActionEvent actionEvent) {
        String name = usernameField.getText();
        String password = passwordField.getText();

        errorMessageLabel.setVisible(false);
        errorMessageLabel.setText("");

        User user = authService.login(name, password);

        if (user != null) {
            System.out.println("Login successfully!");
        } else {
            errorMessageLabel.setText("Error: Nombre de usuario o contraseña incorrectas.");
            errorMessageLabel.setVisible(true);
        }
    }
    @FXML
    private void initialize() {
        if (errorMessageLabel != null) {
            errorMessageLabel.setVisible(false);
        }
    }
}
