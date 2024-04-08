package model;

import database.CRUD;
import database.ConfigDB;
import entity.Avion;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvionModel implements CRUD {
    @Override
    public Object insert(Object object) {
        Avion avion = (Avion) object;
        try (Connection connection = ConfigDB.getObjConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Aviones(modelo, capacidad) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, avion.getModelo());
            preparedStatement.setInt(2, avion.getCapacidad());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                avion.setIdAvion(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar avión: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return avion;
    }

    @Override
    public boolean update(Object object) {
        Avion avion = (Avion) object;
        try (Connection connection = ConfigDB.getObjConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Aviones SET modelo = ?, capacidad = ? WHERE id_avion = ?")) {
            preparedStatement.setString(1, avion.getModelo());
            preparedStatement.setInt(2, avion.getCapacidad());
            preparedStatement.setInt(3, avion.getIdAvion());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar avión: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Object object) {
        Avion avion = (Avion) object;
        try (Connection connection = ConfigDB.getObjConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Aviones WHERE id_avion = ?")) {
            preparedStatement.setInt(1, avion.getIdAvion());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar avión: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Object> findAll() {
        List<Object> aviones = new ArrayList<>();
        try (Connection connection = ConfigDB.getObjConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Aviones")) {
            while (resultSet.next()) {
                Avion avion = new Avion(
                        resultSet.getInt("id_avion"),
                        resultSet.getString("modelo"),
                        resultSet.getInt("capacidad")
                );
                aviones.add(avion);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al obtener aviones: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return aviones;
    }

    @Override
    public Object findById(int id) {
        Avion avion = null;
        try (Connection connection = ConfigDB.getObjConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Aviones WHERE id_avion = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                avion = new Avion(
                        resultSet.getInt("id_avion"),
                        resultSet.getString("modelo"),
                        resultSet.getInt("capacidad")
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener avión por ID: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return avion;
    }
}
