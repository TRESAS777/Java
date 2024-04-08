package model;

import database.CRUD;
import database.ConfigDB;
import entity.Avion;
import entity.Reservacion;
import entity.Vuelo;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservacionModel implements CRUD {
    private final Connection connection;

    public ReservacionModel() {
        this.connection = ConfigDB.getObjConnection();
    }

    @Override
    public Object insert(Object object) {
        Reservacion reservacion = (Reservacion) object;
        if (!validarCapacidadAvion(reservacion.getIdVuelo())) {
            JOptionPane.showMessageDialog(null, "La capacidad ya está alcanzada para este vuelo.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (asientoYaReservado(reservacion.getIdVuelo(), reservacion.getAsiento())) {
            JOptionPane.showMessageDialog(null, "El asiento ya está reservado para este vuelo.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String query = "INSERT INTO Reservaciones(id_pasajero, id_vuelo, fecha_reservacion, asiento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, reservacion.getIdPasajero());
            statement.setInt(2, reservacion.getIdVuelo());
            statement.setDate(3, reservacion.getFechaReservacion());
            statement.setString(4, reservacion.getAsiento());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    reservacion.setIdReservacion(generatedKeys.getInt(1));
                    return reservacion;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el vuelo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    @Override
    public boolean update(Object object) {
        Reservacion reservacion = (Reservacion) object;
        if (findById(reservacion.getIdReservacion()) == null) {
            JOptionPane.showMessageDialog(null, "La reservación con ID " + reservacion.getIdReservacion() + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (asientoYaReservado(reservacion.getIdVuelo(), reservacion.getAsiento())) {
            JOptionPane.showMessageDialog(null, "El asiento ya está reservado para este vuelo.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String query = "UPDATE Reservaciones SET id_pasajero = ?, id_vuelo = ?, fecha_reservacion = ?, asiento = ? WHERE id_reservacion = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reservacion.getIdPasajero());
            statement.setInt(2, reservacion.getIdVuelo());
            statement.setDate(3, reservacion.getFechaReservacion());
            statement.setString(4, reservacion.getAsiento());
            statement.setInt(5, reservacion.getIdReservacion());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Reservación actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        JOptionPane.showMessageDialog(null, "Error al actualizar la reservación.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }


    @Override
    public boolean delete(Object object) {
        Reservacion reservacion = (Reservacion) object;
        String query = "DELETE FROM Reservaciones WHERE id_reservacion = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reservacion.getIdReservacion());
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: "+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public List<Object> findAll() {
        List<Object> reservaciones = new ArrayList<>();
        String query = "SELECT * FROM Reservaciones";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Reservacion reservacion = new Reservacion(
                        resultSet.getInt("id_reservacion"),
                        resultSet.getInt("id_pasajero"),
                        resultSet.getInt("id_vuelo"),
                        resultSet.getDate("fecha_reservacion"),
                        resultSet.getString("asiento")
                );
                reservaciones.add(reservacion);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return reservaciones;
    }

    @Override
    public Object findById(int id) {
        String query = "SELECT * FROM Reservaciones WHERE id_reservacion = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Reservacion reservacion = new Reservacion(
                            resultSet.getInt("id_reservacion"),
                            resultSet.getInt("id_pasajero"),
                            resultSet.getInt("id_vuelo"),
                            resultSet.getDate("fecha_reservacion"),
                            resultSet.getString("asiento")
                    );
                    return reservacion;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al encontrar por id: "+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    private boolean validarCapacidadAvion(int idVuelo) {
        AvionModel avionModel = new AvionModel();
        VueloModel vueloModel = new VueloModel();
        Vuelo vuelo = (Vuelo) vueloModel.findById(idVuelo);
        Avion avion = vuelo.getAvion();
        List<Object> reservaciones = findAllByVueloId(idVuelo);
        int cantidadReservaciones = reservaciones.size();
        if (cantidadReservaciones >= avion.getCapacidad()) {
            JOptionPane.showMessageDialog(null, "La capacidad del avión ha sido excedida.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private boolean asientoYaReservado(int idVuelo, String asiento) {
        List<Object> reservaciones = findAllByVueloId(idVuelo);
        for (Object obj : reservaciones) {
            Reservacion reservacion = (Reservacion) obj;
            if (reservacion.getAsiento().equals(asiento)) {
                JOptionPane.showMessageDialog(null, "El asiento ya está reservado en este vuelo.", "Error", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }

    private List<Object> findAllByVueloId(int idVuelo) {
        List<Object> reservaciones = new ArrayList<>();
        String query = "SELECT * FROM Reservaciones WHERE id_vuelo = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idVuelo);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int idReservacion = resultSet.getInt("id_reservacion");
                    int idPasajero = resultSet.getInt("id_pasajero");
                    java.sql.Date fechaReservacion = resultSet.getDate("fecha_reservacion");
                    String asiento = resultSet.getString("asiento");
                    reservaciones.add(new Reservacion(idReservacion, idPasajero, idVuelo, fechaReservacion, asiento));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return reservaciones;
    }

}
