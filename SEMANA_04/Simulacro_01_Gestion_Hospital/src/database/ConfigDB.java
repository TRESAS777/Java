package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    static Connection objConnection = null;

    public static Connection getObjConnection() {
        try {//la bd externa no me dejo hacer mas conexiones por lo que me toco hacerlo local
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/gestion_hospital";
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
 CREATE DATABASE gestion_hospital;

USE gestion_hospital;

CREATE TABLE Especialidades(
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(255) NOT NULL,
descripcion TEXT
);

CREATE TABLE Medicos(
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(45) NOT NULL,
apellido VARCHAR(45) NOT NULL,
idEspecialidad INT,
FOREIGN KEY (idEspecialidad) REFERENCES Especialidades(id)
ON DELETE CASCADE
);

CREATE TABLE Pacientes (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(45) NOT NULL,
apellido VARCHAR(45) NOT NULL,
nacimiento DATE NOT NULL UNIQUE,
dni VARCHAR(11)
);

CREATE TABLE Citas (
id INT AUTO_INCREMENT PRIMARY KEY,
idPaciente INT,
FOREIGN KEY (idPaciente) REFERENCES Pacientes(id)
ON DELETE CASCADE,
idMedico INT,
FOREIGN KEY (idMedico) REFERENCES Medicos(id)
ON DELETE SET NULL,
fecha_cita DATE NOT NULL,
hora_cita TIME NOT NULL,
motivo VARCHAR(255)
);
 */
