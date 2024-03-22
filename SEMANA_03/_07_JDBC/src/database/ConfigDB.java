package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    // Variable que va a contener el estado de la conexión
    static Connection objConnection = null;
    // Método para abrir la conexión entre java y la base de datos
    public static Connection openConnection(){
        try {
//            Class.forName() permite obtener o implementar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Creamos variables con nuestras credenciales de la BD
            String url = "jdbc:mysql://localhost:3306/_01_jdbc";
            String user = "root";
            String password = "";
//            Establecemos la conexion
            objConnection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Me conecté exitosamente!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error >> Driver no Instalado.");
        } catch (SQLException e){
            System.out.println("Error >> No se pudo establecer una conexión con la base de datos.");
        }
        return objConnection;
    }

    public static void closeConnection(){
        try {
//            Sí hay una conexión activa la cerramos
            if (objConnection != null) objConnection.close();

        } catch (SQLException e){
            System.out.println("ERROR: "+e.getMessage());
        }

    }
}
