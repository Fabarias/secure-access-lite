package src.main;

import org.mindrot.jbcrypt.BCrypt;
import src.main.modelo.Usuario;
import src.main.modelo.UsuarioAdministrador;
import src.main.nucleo.AutenticacionDeServicio;

import java.util.Optional;
import java.util.Scanner;
//12345
public class Main {
    public static void main(String[] args) {
        Scanner lec = new Scanner(System.in);
        AutenticacionDeServicio auth = new AutenticacionDeServicio();
    // Optional <UsuarioAdministrador> admin = auth.iniciarSesion(UsuarioAdministrador.class,"Admin","Jonathantl");
     // admin.get().crearPolicia();
     auth.registro("Kevin", "Jara", "K92","1234AOA");
      }
    }

