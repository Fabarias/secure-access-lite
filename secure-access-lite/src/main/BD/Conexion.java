package src.main.BD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
   private String url = "jdbc:mysql://localhost:3306/SecurityAccesLite";
   private String user = "root";
   private String password = "root";

   public Connection Connection (){
       Connection connection = null;
       try {
          connection = DriverManager.getConnection(url,user,password);
          //System.out.println("Conexion Exitosa");
       } catch (SQLException e){
          e.printStackTrace();
       }
       return connection;
   }

}
