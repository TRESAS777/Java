package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    static Connection objConnection = null;

    public static Connection getObjConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/gestion_operaciones";
            String user = "root";
            String password = "";

            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Successful connection");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error -> " + e.getMessage());
            throw new RuntimeException(e);
        }
        return objConnection;
    }

    public static void  closeConnection() {
        try {
            if (objConnection != null){
                objConnection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
