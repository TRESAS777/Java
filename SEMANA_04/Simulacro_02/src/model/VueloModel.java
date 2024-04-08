package model;

import database.CRUD;
import database.ConfigDB;
import entity.Vuelo;
import entity.Avion;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VueloModel implements CRUD {
    @Override
    public Object insert(Object object) {
        Vuelo vuelo = (Vuelo) object;
        String sql = "INSERT INTO Vuelos (destino, fecha_salida, hora_salida, id_avion) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConfigDB.getObjConnection();
             PreparedStatement prepareStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, vuelo.getDestino());
            prepareStatement.setDate(2, vuelo.getFechaSalida());
            prepareStatement.setTime(3, vuelo.getHoraSalida());
            prepareStatement.setInt(4, vuelo.getAvion().getIdAvion());
            int rowsAffected = prepareStatement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Failed to insert Vuelo.");
            }
            try (ResultSet generatedKeys = prepareStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    vuelo.setIdVuelo(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Failed to retrieve generated ID for Vuelo.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ingresado Vuelo: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return vuelo;
    }

    @Override
    public boolean update(Object object) {
        Vuelo vuelo = (Vuelo) object;
        String sql = "UPDATE Vuelos SET destino = ?, fecha_salida = ?, hora_salida = ?, id_avion = ? WHERE id_vuelo = ?";
        try (Connection conn = ConfigDB.getObjConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vuelo.getDestino());
            pstmt.setDate(2, vuelo.getFechaSalida());
            pstmt.setTime(3, vuelo.getHoraSalida());
            pstmt.setInt(4, vuelo.getAvion().getIdAvion());
            pstmt.setInt(5, vuelo.getIdVuelo());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando Vuelo: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Object object) {
        Vuelo vuelo = (Vuelo) object;
        String sql = "DELETE FROM Vuelos WHERE id_vuelo = ?";
        try (Connection conn = ConfigDB.getObjConnection();
             PreparedStatement prepareStatment = conn.prepareStatement(sql)) {
            prepareStatment.setInt(1, vuelo.getIdVuelo());
            int rowsAffected = prepareStatment.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error borrando Vuelo: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Object> findAll() {
        List<Object> vuelos = new ArrayList<>();
        String sql = "SELECT * FROM Vuelos";

        try (Connection conn = ConfigDB.getObjConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vuelo vuelo = extractVueloFromResultSet(rs);
                vuelos.add(vuelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error obteniendo Vuelos: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return vuelos;
    }

    @Override
    public Object findById(int id) {
        String sql = "SELECT * FROM Vuelos WHERE id_vuelo = ?";
        Vuelo vuelo = null;

        try (Connection conn = ConfigDB.getObjConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    vuelo = extractVueloFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error encontrando Vuelo por ID: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return vuelo;
    }

    private Vuelo extractVueloFromResultSet(ResultSet rs) throws SQLException {
        int idVuelo = rs.getInt("id_vuelo");
        String destino = rs.getString("destino");
        java.sql.Date fechaSalida = rs.getDate("fecha_salida");
        java.sql.Time horaSalida = rs.getTime("hora_salida");
        int idAvion = rs.getInt("id_avion");

        AvionModel avionModel = new AvionModel();
        Avion avion = (Avion) avionModel.findById(idAvion);

        return new Vuelo(idVuelo, destino, fechaSalida, horaSalida, avion);
    }
}
