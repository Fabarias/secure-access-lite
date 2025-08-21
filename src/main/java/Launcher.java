import com.secureaccesslite.App;

public class Launcher {
    public static void main(String[] args) {

        // Comando para correr la aplicación (En Terminal): mvn clean compile exec:java -Dexec.mainClass="Launcher"

        System.out.println("Iniciando SecureAccess Lite...");
        System.out.println("Verificando entorno JavaFX...");

        // Estas propiedades pueden ayudar con la detección automática de JavaFX
        System.setProperty("java.awt.headless", "false");
        System.setProperty("file.encoding", "UTF-8");


        // En algunos sistemas, esto ayuda con la detección de librerías gráficas
        try {
            // Verificar si JavaFX está disponible intentando cargar una clase básica
            Class.forName("javafx.application.Application");
            System.out.println("JavaFX detectado correctamente");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: JavaFX no está disponible en el classpath");
            System.err.println("Sugerencia: Verifica que las dependencias de JavaFX estén en tu pom.xml");
            System.err.println("Sugerencia: Verifica que estés ejecutando con Java 11 o superior");
            return;
        }

        // Paso 4: Lanzar la aplicación JavaFX
        try {
            System.out.println("Ejecutando aplicación...");
            // Ahora JavaFX ya debería estar correctamente configurado
            App.main(args);

        } catch (Exception e) {
            System.err.println("Error: No podemos iniciar la aplicación");
            e.printStackTrace();

            // Información de diagnóstico útil
            System.err.println("\n Información de diagnóstico:");
            System.err.println("Java Version: " + System.getProperty("java.version"));
            System.err.println("Java Home: " + System.getProperty("java.home"));
            System.err.println("OS: " + System.getProperty("os.name"));
            System.err.println("Classpath: " + System.getProperty("java.class.path"));
        }
    }
}
