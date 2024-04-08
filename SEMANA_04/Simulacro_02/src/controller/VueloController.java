package controller;

import model.AvionModel;
import model.VueloModel;
import entity.Vuelo;
import entity.Avion;
import java.util.List;
import javax.swing.JOptionPane;

public class VueloController {
    private VueloModel vueloModel;

    public VueloController() {
        this.vueloModel = new VueloModel();
    }

    public Vuelo agregarVuelo() {
        String destino = JOptionPane.showInputDialog(null, "Ingrese el destino del vuelo:", "Agregar Vuelo", JOptionPane.QUESTION_MESSAGE);
        if (destino == null || destino.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El destino es requerido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        java.sql.Date fechaSalida = obtenerFecha("Fecha de Salida");
        if (fechaSalida == null) return null;
        java.sql.Time horaSalida = obtenerHora("Hora de Salida");
        if (horaSalida == null) return null;
        Avion avion = obtenerAvion();
        Vuelo vuelo = new Vuelo(0, destino, fechaSalida, horaSalida, avion);
        return (Vuelo) vueloModel.insert(vuelo);
    }

    public boolean actualizarVuelo(int idVuelo) {
        Vuelo vuelo = (Vuelo) vueloModel.findById(idVuelo);
        if (vuelo == null) {
            JOptionPane.showMessageDialog(null, "El vuelo no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String nuevoDestino = JOptionPane.showInputDialog(null, "Ingrese el nuevo destino:", "Actualizar Vuelo", JOptionPane.QUESTION_MESSAGE);
        if (nuevoDestino == null || nuevoDestino.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El destino es requerido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        java.sql.Date nuevaFechaSalida = obtenerFecha("Nueva Fecha de Salida");
        if (nuevaFechaSalida == null) return false;
        java.sql.Time nuevaHoraSalida = obtenerHora("Nueva Hora de Salida");
        if (nuevaHoraSalida == null) return false;
        Avion nuevoAvion = obtenerAvion();
        vuelo.setDestino(nuevoDestino);
        vuelo.setFechaSalida(nuevaFechaSalida);
        vuelo.setHoraSalida(nuevaHoraSalida);
        vuelo.setAvion(nuevoAvion);

        return vueloModel.update(vuelo);
    }

    public boolean eliminarVuelo(int idVuelo) {
        Vuelo vuelo = (Vuelo) vueloModel.findById(idVuelo);
        if (vuelo == null) {
            JOptionPane.showMessageDialog(null, "El vuelo no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el vuelo?", "Eliminar Vuelo", JOptionPane.YES_NO_OPTION);
        if (confirmacion != JOptionPane.YES_OPTION) {
            return false;
        }
        return vueloModel.delete(vuelo);
    }

    public List<Object> listarVuelos() {
        return vueloModel.findAll();
    }

    public Vuelo buscarVueloPorId(int idVuelo) {
        return (Vuelo) vueloModel.findById(idVuelo);
    }

    private java.sql.Date obtenerFecha(String mensaje) {
        while (true) {
            try {
                String fechaStr = JOptionPane.showInputDialog(null, "Ingrese la " + mensaje + " (AAAA-MM-DD):", mensaje, JOptionPane.QUESTION_MESSAGE);
                if (fechaStr == null) return null;
                java.sql.Date fecha = java.sql.Date.valueOf(fechaStr);
                return fecha;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private java.sql.Time obtenerHora(String mensaje) {
        while (true) {
            try {
                String horaStr = JOptionPane.showInputDialog(null, "Ingrese la " + mensaje + " (HH:MM):", mensaje, JOptionPane.QUESTION_MESSAGE);
                if (horaStr == null) return null;
                java.sql.Time hora = java.sql.Time.valueOf(horaStr + ":00");
                return hora;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Formato de hora inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Avion obtenerAvion() {
        while (true) {
            List<Object> aviones = new AvionModel().findAll();
            StringBuilder avionesStr = new StringBuilder("Aviones Disponibles:\n");
            for (Object obj : aviones) {
                Avion avion = (Avion) obj;
                avionesStr.append(avion.getIdAvion()).append(": ").append(avion.getModelo()).append("\n");
            }
            JOptionPane.showMessageDialog(null, avionesStr.toString(), "Aviones Disponibles", JOptionPane.INFORMATION_MESSAGE);
            try {
                int idAvion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del avión:", "Agregar Vuelo", JOptionPane.QUESTION_MESSAGE));
                Avion avionSeleccionado = null;
                for (Object obj : aviones) {
                    Avion avion = (Avion) obj;
                    if (avion.getIdAvion() == idAvion) {
                        avionSeleccionado = avion;
                        break;
                    }
                }
                if (avionSeleccionado != null) {
                    return avionSeleccionado;
                } else {
                    JOptionPane.showMessageDialog(null, "El avión con el ID especificado no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID de avión inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
