import controller.CitaController;
import controller.EspecialidadController;
import controller.MedicoController;
import controller.PacienteController;
import entity.Cita;
import entity.Especialidad;
import entity.Medico;
import entity.Paciente;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        CitaController citaController = new CitaController();
        EspecialidadController especialidadController = new EspecialidadController();
        MedicoController medicoController = new MedicoController();
        PacienteController pacienteController = new PacienteController();

        while (true){
            String[] options = {"Cita", "Especialidad", "Médico", "Paciente", "Back"};
            int valor = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú principal", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (valor){
                case 0:
                    citaMenu(citaController);
                    break;
                case 1:
                    especialidadMenu(especialidadController);
                    break;
                case 2:
                    medicoMenu(medicoController);
                    break;
                case 3:
                    pacienteMenu(pacienteController);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Exiting program...");
                    return;
            }
        }

    }

    public static void citaMenu(CitaController citaController){
        String[] options = {"Insert", "Update", "Delete", "Show All", "Back"};
        int valor = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Cita Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (valor){
            case 0:
                citaController.insertCita(new Cita());
                break;
            case 1:
                citaController.update(new Cita());
                break;
            case 2:
                citaController.deleteCita(new Cita());
                break;
            case 3:
                citaController.getAll();
                break;
            case 4:
                break;
        }
    }

    public static void especialidadMenu(EspecialidadController especialidadController){
        String[] options = {"Insert", "Update", "Delete", "Show All", "Back"};
        int valor = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Especialidad Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (valor){
            case 0:
                especialidadController.insertEspecialidad(new Especialidad());
                break;
            case 1:
                especialidadController.updateEspecialidad(new Especialidad());
                break;
            case 2:
                especialidadController.deleteEspecialidad(new Especialidad());
                break;
            case 3:
                especialidadController.getAll();
                break;
            case 4:
                break;
        }
    }

    public static void medicoMenu(MedicoController medicoController){
        String[] options = {"Insert", "Update", "Delete", "Show All", "Back"};
        int valor = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Médico Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (valor){
            case 0:
                medicoController.insertMedico(new Medico());
                break;
            case 1:
                medicoController.updateMedico(new Medico());
                break;
            case 2:
                medicoController.deleteMedico(new Medico());
            case 3:
                medicoController.getAll();
                break;
            case 4:
                break;
        }
    }

    public static void pacienteMenu(PacienteController pacienteController){
        String[] options = {"Insert", "Update", "Delete", "Show All", "Back"};
        int valor = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Especialidad Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (valor){
            case 0:
                pacienteController.insertPaciente(new Paciente());
                break;
            case 1:
                pacienteController.updatePaciente(new Paciente());
                break;
            case 2:
                pacienteController.deletePaciente(new Paciente());
                break;
            case 3:
                pacienteController.getAll();
                break;
            case 4:
                break;
        }
    }

}