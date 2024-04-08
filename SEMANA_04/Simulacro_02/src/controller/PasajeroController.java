package controller;

import model.PasajeroModel;
import entity.Pasajero;
import javax.swing.JOptionPane;
import java.util.List;

public class PasajeroController {
    private PasajeroModel pasajeroModel;

    public PasajeroController() {
        this.pasajeroModel = new PasajeroModel();
    }

    public Pasajero agregarPasajero() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del pasajero:", "Agregar Pasajero", JOptionPane.QUESTION_MESSAGE);
        if (nombre == null || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre es requerido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        String apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del pasajero:", "Agregar Pasajero", JOptionPane.QUESTION_MESSAGE);
        if (apellido == null || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El apellido es requerido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        String documentoIdentidad = JOptionPane.showInputDialog(null, "Ingrese el documento de identidad del pasajero:", "Agregar Pasajero", JOptionPane.QUESTION_MESSAGE);
        if (documentoIdentidad == null || documentoIdentidad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El documento de identidad es requerido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return (Pasajero) pasajeroModel.insert(new Pasajero(0, nombre, apellido, documentoIdentidad));
    }

    public boolean actualizarPasajero(int idPasajero) {
        Pasajero pasajero = (Pasajero) pasajeroModel.findById(idPasajero);
        if (pasajero == null) {
            JOptionPane.showMessageDialog(null, "El pasajero no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del pasajero (Deje en blanco para mantener el actual):", "Actualizar Pasajero", JOptionPane.QUESTION_MESSAGE);
        if (nombre != null && !nombre.isEmpty()) {
            pasajero.setNombre(nombre);
        }

        String apellido = JOptionPane.showInputDialog(null, "Ingrese el nuevo apellido del pasajero (Deje en blanco para mantener el actual):", "Actualizar Pasajero", JOptionPane.QUESTION_MESSAGE);
        if (apellido != null && !apellido.isEmpty()) {
            pasajero.setApellido(apellido);
        }

        String documentoIdentidad = JOptionPane.showInputDialog(null, "Ingrese el nuevo documento de identidad del pasajero (Deje en blanco para mantener el actual):", "Actualizar Pasajero", JOptionPane.QUESTION_MESSAGE);
        if (documentoIdentidad != null && !documentoIdentidad.isEmpty()) {
            pasajero.setDocumentoIdentidad(documentoIdentidad);
        }

        return pasajeroModel.update(pasajero);
    }

    public boolean eliminarPasajero(int idPasajero) {
        Pasajero pasajero = (Pasajero) pasajeroModel.findById(idPasajero);
        if (pasajero == null) {
            JOptionPane.showMessageDialog(null, "El pasajero no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el pasajero?", "Eliminar Pasajero", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            return pasajeroModel.delete(pasajero);
        }
        return false;
    }

    public List<Object> listarPasajeros() {
        return pasajeroModel.findAll();
    }
}
