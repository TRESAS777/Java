import controller.AvionController;
import controller.VueloController;
import controller.PasajeroController;
import controller.ReservacionController;
import entity.Avion;
import entity.Vuelo;
import entity.Pasajero;
import entity.Reservacion;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        AvionController avionController = new AvionController();
        VueloController vueloController = new VueloController();
        PasajeroController pasajeroController = new PasajeroController();
        ReservacionController reservacionController = new ReservacionController();

        while (true) {
            String[] options = {"Avión", "Vuelo", "Pasajero", "Reservación", "Salir"};
            int valor = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú principal", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (valor) {
                case 0:
                    avionMenu(avionController);
                    break;
                case 1:
                    vueloMenu(vueloController);
                    break;
                case 2:
                    pasajeroMenu(pasajeroController);
                    break;
                case 3:
                    reservacionMenu(reservacionController);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    return;
            }
        }
    }

    public static void avionMenu(AvionController avionController) {
        String[] options = {"Insertar", "Actualizar", "Eliminar", "Mostrar Todos", "Atrás"};
        int valor = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú de Aviones", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (valor) {
            case 0:
                avionController.agregarAvion();
                break;
            case 1:
                avionController.actualizarAvion();
                break;
            case 2:
                avionController.eliminarAvion();
                break;
            case 3:
                avionController.listarAviones();
                break;
            case 4:
                break;
        }
    }

    public static void vueloMenu(VueloController vueloController) {
        String[] options = {"Insertar", "Actualizar", "Eliminar", "Mostrar Todos", "Atrás"};
        int valor = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú de Vuelos", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (valor) {
            case 0:
                vueloController.agregarVuelo();
                break;
            case 1:
                int idVueloActualizar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del vuelo a actualizar:"));
                vueloController.actualizarVuelo(idVueloActualizar);
                break;
            case 2:
                int idVueloEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del vuelo a eliminar:"));
                vueloController.eliminarVuelo(idVueloEliminar);
                break;
            case 3:
                vueloController.listarVuelos();
                break;
            case 4:
                break;
        }
    }

    public static void pasajeroMenu(PasajeroController pasajeroController) {
        String[] options = {"Insertar", "Actualizar", "Eliminar", "Mostrar Todos", "Atrás"};
        int valor = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú de Pasajeros", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (valor) {
            case 0:
                pasajeroController.agregarPasajero();
                break;
            case 1:
                int idPasajeroActualizar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del pasajero a actualizar:"));
                pasajeroController.actualizarPasajero(idPasajeroActualizar);
                break;
            case 2:
                int idPasajeroEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del pasajero a eliminar:"));
                pasajeroController.eliminarPasajero(idPasajeroEliminar);
                break;
            case 3:
                pasajeroController.listarPasajeros();
                break;
            case 4:
                break;
        }
    }


    public static void reservacionMenu(ReservacionController reservacionController) {
        String[] options = {"Agregar", "Actualizar", "Eliminar", "Listar", "Atrás"};
        int valor = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú de Reservaciones", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (valor) {
            case 0:
                reservacionController.agregarReservacion();
                break;
            case 1:
                reservacionController.actualizarReservacion();
                break;
            case 2:
                reservacionController.eliminarReservacion();
                break;
            case 3:
                reservacionController.listarReservaciones();
                break;
            case 4:
                break;
        }
    }
}
