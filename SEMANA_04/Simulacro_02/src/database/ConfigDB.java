package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    static Connection objConnection = null;

    public static Connection getObjConnection() {
        try {//la bd externa no me dejo hacer mas conexiones por lo que me toco hacerlo local
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/reserva_vuelo";
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
/*
SQL:
CREATE DATABASE reserva_vuelo;

USE reserva_vuelo;

CREATE TABLE Aviones(
id_avion INT AUTO_INCREMENT PRIMARY KEY,
modelo VARCHAR(45) NOT NULL,
capacidad INT NOT NULL
);

CREATE TABLE Vuelos(
id_vuelo INT PRIMARY KEY AUTO_INCREMENT,
destino VARCHAR(45) NOT NULL,
fecha_salida DATE NOT NULL,
hora_salida TIME NOT NULL,
id_avion INT,
FOREIGN KEY (id_avion) REFERENCES Aviones(id_avion)
ON DELETE SET NULL
);

CREATE TABLE Pasajeros(
id_pasajero INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(45) NOT NULL,
apellido VARCHAR(45) NOT NULL,
documento_identidad VARCHAR(10)
);

CREATE TABLE Reservaciones(
id_reservacion INT PRIMARY KEY AUTO_INCREMENT,
id_pasajero INT,
FOREIGN KEY (id_pasajero) REFERENCES Pasajeros(id_pasajero)
ON DELETE CASCADE,
id_vuelo INT,
FOREIGN KEY (id_vuelo) REFERENCES Vuelos(id_vuelo)
ON DELETE SET NULL,
fecha_reserva DATE NOT NULL,
asiento VARCHAR(10)
);
 */