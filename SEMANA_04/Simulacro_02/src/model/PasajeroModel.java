package model;

import database.CRUD;
import database.ConfigDB;
import entity.Pasajero;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasajeroModel implements CRUD {
    private final Connection connection;

    public PasajeroModel() {
        this.connection = ConfigDB.getObjConnection();
    }

    @Override
    public Object insert(Object object) {
        Pasajero pasajero = (Pasajero) object;
        String query = "INSERT INTO Pasajeros(nombre, apellido, documento_identidad) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, pasajero.getNombre());
            statement.setString(2, pasajero.getApellido());
            statement.setString(3, pasajero.getDocumentoIdentidad());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    pasajero.setIdPasajero(generatedKeys.getInt(1));
                    return pasajero;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar" + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean update(Object object) {
        Pasajero pasajero = (Pasajero) object;
        String query = "UPDATE Pasajeros SET nombre = ?, apellido = ?, documento_identidad = ? WHERE id_pasajero = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, pasajero.getNombre());
            statement.setString(2, pasajero.getApellido());
            statement.setString(3, pasajero.getDocumentoIdentidad());
            statement.setInt(4, pasajero.getIdPasajero());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Object object) {
        Pasajero pasajero = (Pasajero) object;
        String query = "DELETE FROM Pasajeros WHERE id_pasajero = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, pasajero.getIdPasajero());
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e.getMessage());
        }
        return false;
    }

    @Override
    public List<Object> findAll() {
        List<Object> pasajeros = new ArrayList<>();
        String query = "SELECT * FROM Pasajeros";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int idPasajero = resultSet.getInt("id_pasajero");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String documentoIdentidad = resultSet.getString("documento_identidad");
                Pasajero pasajero = new Pasajero(idPasajero, nombre, apellido, documentoIdentidad);
                pasajeros.add(pasajero);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar" + e.getMessage());

        }
        return pasajeros;
    }

    @Override
    public Object findById(int id) {
        String query = "SELECT * FROM Pasajeros WHERE id_pasajero = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int idPasajero = resultSet.getInt("id_pasajero");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    String documentoIdentidad = resultSet.getString("documento_identidad");
                    return new Pasajero(idPasajero, nombre, apellido, documentoIdentidad);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar" + e.getMessage());
        }
        return null;
    }
}
