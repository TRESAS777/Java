package controller;

import model.AvionModel;
import entity.Avion;
import java.util.List;
import javax.swing.JOptionPane;

public class AvionController {
    private AvionModel avionModel;

    public AvionController() {
        this.avionModel = new AvionModel();
    }

    public Avion agregarAvion() {
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del avión:");
        if (modelo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El modelo del avión no puede estar vacío.");
            return null;
        }
        String capacidadStr = JOptionPane.showInputDialog("Ingrese la capacidad del avión:");
        if (capacidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La capacidad del avión no puede estar vacía.");
            return null;
        }
        int capacidad = Integer.parseInt(capacidadStr);
        Avion avion = new Avion(0, modelo, capacidad);
        avionModel.insert(avion);
        JOptionPane.showMessageDialog(null, "Avión agregado correctamente.");
        return avion;
    }

    public void actualizarAvion() {
        List<Object> aviones = avionModel.findAll();
        if (aviones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay aviones disponibles para actualizar.");
            return;
        }
        String mensaje = "Lista de aviones:\n";
        for (Object obj : aviones) {
            Avion avion = (Avion) obj;
            mensaje += avion.getIdAvion() + " - " + avion.getModelo() + " (Capacidad: " + avion.getCapacidad() + ")\n";
        }
        int idAvion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del avión a actualizar:\n" + mensaje));
        Avion avionSeleccionado = (Avion) avionModel.findById(idAvion);
        if (avionSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el avión con el ID especificado.");
            return;
        }
        String modelo = JOptionPane.showInputDialog("Ingrese el nuevo modelo del avión:", avionSeleccionado.getModelo());
        if (modelo == null || modelo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El modelo del avión no puede estar vacío.");
            return;
        }
        String capacidadStr = JOptionPane.showInputDialog("Ingrese la nueva capacidad del avión:", avionSeleccionado.getCapacidad());
        if (capacidadStr == null || capacidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La capacidad del avión no puede estar vacía.");
            return;
        }
        int capacidad = Integer.parseInt(capacidadStr);
        Avion avion = new Avion(idAvion, modelo, capacidad);
        avionModel.update(avion);
        JOptionPane.showMessageDialog(null, "Avión actualizado correctamente.");
    }



    public void eliminarAvion() {
        List<Object> aviones = avionModel.findAll();
        if (aviones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay aviones disponibles para eliminar.");
            return;
        }
        StringBuilder mensaje = new StringBuilder("Lista de aviones:\n");
        for (Object obj : aviones) {
            Avion avion = (Avion) obj;
            mensaje.append(avion.getIdAvion()).append(" - ").append(avion.getModelo()).append(" (Capacidad: ").append(avion.getCapacidad()).append(")\n");
        }
        int idAvion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del avión a eliminar:\n" + mensaje));
        Avion avion = new Avion(idAvion, null, 0);
        avionModel.delete(avion);
        JOptionPane.showMessageDialog(null, "Avión eliminado correctamente.");
    }

    public void listarAviones() {
        List<Object> aviones = avionModel.findAll();
        if (aviones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay aviones disponibles.");
            return;
        }
        StringBuilder mensaje = new StringBuilder("Lista de aviones:\n");
        for (Object obj : aviones) {
            Avion avion = (Avion) obj;
            mensaje.append(avion.getIdAvion()).append(" - ").append(avion.getModelo()).append(" (Capacidad: ").append(avion.getCapacidad()).append(")\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    public void buscarAvionPorId() {
        int idAvion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del avión a buscar:"));
        Avion avion = (Avion) avionModel.findById(idAvion);
        if (avion != null) {
            JOptionPane.showMessageDialog(null, "Avión encontrado:\nID: " + avion.getIdAvion() + "\nModelo: " + avion.getModelo() + "\nCapacidad: " + avion.getCapacidad());
        } else {
            JOptionPane.showMessageDialog(null, "Avión no encontrado.");
        }
    }
}
