package com.secureaccesslite.interfazUsuario;

import com.secureaccesslite.nucleo.AutenticacionDeServicio;
import com.secureaccesslite.modelo.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;


public class LoginController {
    @FXML
    private TextField campoUsuario;
    @FXML
    private PasswordField claveCampo;
    @FXML
    private Label errorMensajeEtiqueta;

    private final AutenticacionDeServicio autenticacionDeServicio = new AutenticacionDeServicio();

    @FXML
    public void manejoDeInicioDeSesionConBotonAction(ActionEvent eventoAccion) {
        String nombre = campoUsuario.getText();
        String clave = claveCampo.getText();

        errorMensajeEtiqueta.setVisible(false);
        errorMensajeEtiqueta.setText("");

        Usuario usuario = autenticacionDeServicio.inicioSesion(nombre, clave);

        if (usuario != null) {
            System.out.println("Login successfully!");
        } else {
            errorMensajeEtiqueta.setText("Error: Nombre de usuario o contraseña incorrectas.");
            errorMensajeEtiqueta.setVisible(true);
        }
    }
    @FXML
    private void inicializar() {
        if (errorMensajeEtiqueta != null) {
            errorMensajeEtiqueta.setVisible(false);
        }
    }
}
