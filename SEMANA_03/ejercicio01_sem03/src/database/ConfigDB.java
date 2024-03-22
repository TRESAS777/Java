package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
  static Connection objConnection = null;

  public static Connection openConnection(){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

      String url = "jdbc:mysql://bnz0m9rgiruqd6gdemyx-mysql.services.clever-cloud.com:3306/bnz0m9rgiruqd6gdemyx";
      String user = "uvuxnnogwk1vy6fw";
      String password = "6gZIouQB9XaSZM8L8957";

      objConnection = (Connection) DriverManager.getConnection(url,user,password);
      System.out.println("Connection made successfully!");

    } catch (SQLException e){
      System.out.println("Error -> not connection" + e.getMessage());

    } catch (ClassNotFoundException e) {
      System.out.println("Error -> Driver not installed>>  " + e.getMessage());
    }
    return objConnection;
  }

  public static void  closeConnection(){
    try{
      if (objConnection != null){
        objConnection.close();
      }
    }catch (SQLException e){
      System.out.println("Error >> " + e.getMessage());
    }
  }


}
