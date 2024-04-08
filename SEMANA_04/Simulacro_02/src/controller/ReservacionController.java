package controller;

import entity.Pasajero;
import entity.Vuelo;
import model.ReservacionModel;
import entity.Reservacion;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.util.List;

public class ReservacionController {
    private ReservacionModel reservacionModel;

    public ReservacionController() {
        this.reservacionModel = new ReservacionModel();
    }

    public Reservacion agregarReservacion() {
        try {
            // Listar pasajeros y obtener el ID del pasajero seleccionado
            PasajeroController pasajeroController = new PasajeroController();
            List<Object> pasajeros = pasajeroController.listarPasajeros();
            int idPasajero = obtenerIdDesdeLista("Seleccione el ID del pasajero:", pasajeros);
            if (idPasajero == -1) {
                JOptionPane.showMessageDialog(null, "No se seleccionó ningún pasajero.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            // Listar vuelos y obtener el ID del vuelo seleccionado
            VueloController vueloController = new VueloController();
            List<Object> vuelos = vueloController.listarVuelos();
            int idVuelo = obtenerIdDesdeLista("Seleccione el ID del vuelo:", vuelos);
            if (idVuelo == -1) {
                JOptionPane.showMessageDialog(null, "No se seleccionó ningún vuelo.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            // Solicitar y validar la fecha de reservación
            java.sql.Date fechaReservacion = validarFechaReservacion();

            // Solicitar el asiento
            String asiento = JOptionPane.showInputDialog(null, "Ingrese el asiento:", "Agregar Reservación", JOptionPane.QUESTION_MESSAGE);
            if (idPasajero <= 0 || idVuelo <= 0 || fechaReservacion == null || asiento.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son requeridos para agregar una reservación.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            // Crear y guardar la reservación
            Reservacion reservacion = new Reservacion(0, idPasajero, idVuelo, fechaReservacion, asiento);
            return (Reservacion) reservacionModel.insert(reservacion);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID de pasajero o ID de vuelo inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Fecha de reservación en formato incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private int obtenerIdDesdeLista(String mensaje, List<Object> lista) {
        StringBuilder sb = new StringBuilder(mensaje).append("\n");
        for (Object obj : lista) {
            if (obj instanceof Pasajero) {
                Pasajero pasajero = (Pasajero) obj;
                sb.append("ID: ").append(pasajero.getIdPasajero()).append(", Nombre: ").append(pasajero.getNombre()).append(" ").append(pasajero.getApellido()).append("\n");
            } else if (obj instanceof Vuelo) {
                Vuelo vuelo = (Vuelo) obj;
                sb.append("ID: ").append(vuelo.getIdVuelo()).append(", Destino: ").append(vuelo.getDestino()).append(", Fecha: ").append(vuelo.getFechaSalida()).append("\n");
            }
        }
        sb.append("Ingrese el ID:");
        String input = JOptionPane.showInputDialog(null, sb.toString(), "Selección", JOptionPane.QUESTION_MESSAGE);
        if (input == null || input.isEmpty()) return -1;
        return Integer.parseInt(input);
    }

    private java.sql.Date validarFechaReservacion() {
        while (true) {
            try {
                String fechaStr = JOptionPane.showInputDialog(null, "Ingrese la fecha de la reservación (AAAA-MM-DD):", "Agregar Reservación", JOptionPane.QUESTION_MESSAGE);
                if (fechaStr == null || fechaStr.isEmpty()) return null;
                return java.sql.Date.valueOf(fechaStr);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Fecha de reservación en formato incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public boolean actualizarReservacion() {
        try {
            int idReservacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID de la reservación a actualizar:", "Actualizar Reservación", JOptionPane.QUESTION_MESSAGE));
            int idPasajero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del pasajero:", "Actualizar Reservación", JOptionPane.QUESTION_MESSAGE));
            int idVuelo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del vuelo:", "Actualizar Reservación", JOptionPane.QUESTION_MESSAGE));
            Date fechaReservacion = Date.valueOf(JOptionPane.showInputDialog(null, "Ingrese la fecha de la reservación (AAAA-MM-DD):", "Actualizar Reservación", JOptionPane.QUESTION_MESSAGE));
            String asiento = JOptionPane.showInputDialog(null, "Ingrese el asiento:", "Actualizar Reservación", JOptionPane.QUESTION_MESSAGE);
            if (idPasajero <= 0 || idVuelo <= 0 || fechaReservacion == null || asiento.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son requeridos para actualizar una reservación.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            Reservacion reservacion = new Reservacion(idReservacion, idPasajero, idVuelo, fechaReservacion, asiento);
            return reservacionModel.update(reservacion);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID de pasajero, ID de vuelo o ID de reservación inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Fecha de reservación en formato incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean eliminarReservacion() {
        try {
            int idReservacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID de la reservación a eliminar:", "Eliminar Reservación", JOptionPane.QUESTION_MESSAGE));
            if (reservacionModel.findById(idReservacion) == null) {
                JOptionPane.showMessageDialog(null, "La reservación con ID " + idReservacion + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return reservacionModel.delete(new Reservacion(idReservacion, 0, 0, null, ""));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID de reservación inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Object> listarReservaciones() {
        return reservacionModel.findAll();
    }
}
