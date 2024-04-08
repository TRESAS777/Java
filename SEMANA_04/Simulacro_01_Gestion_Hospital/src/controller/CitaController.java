package controller;

import entity.Cita;
import entity.Medico;
import entity.Paciente;
import model.CitaModel;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class CitaController {

    CitaModel objCitaModel;

    public CitaController() {
        this.objCitaModel = new CitaModel();
    }

    public void insertCita(Cita paciente){
        Cita objCita = new Cita();
        int idPaciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente:\n" ));
        int idMedico = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del médico:\n" ));
        String fecha_cita = JOptionPane.showInputDialog("Ingrese la fecha de la cita YYYY-MM-DD: ");
        String hora_cita = JOptionPane.showInputDialog("Ingrese la hora de la cita HH:mm:ss: ");
        String motivo = JOptionPane.showInputDialog("Ingresa el motivo de la cita: ");
        objCita.setId_Paciente(idPaciente);
        objCita.setId_Medico(idMedico);
        objCita.setFecha_Cita(Date.valueOf(fecha_cita));
        objCita.setHora_Cita(Time.valueOf(hora_cita));
        objCita.setMotivo(motivo);
        objCita = (Cita) this.objCitaModel.insert(objCita);
        JOptionPane.showMessageDialog(null, objCita.toString());
    }

    public void update(Cita cita){
        List<Object> allCitas = objCitaModel.findAll();
        if (!allCitas.isEmpty()){
            String listCitas = getAll(allCitas);
            int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la cita a actualizar:\n" + listCitas));
            Cita objCitaActualizar = (Cita) this.objCitaModel.findById(idUpdate);
            if (objCitaActualizar == null){
                JOptionPane.showMessageDialog(null, "No se encontró la cita");
            } else {
                int idMedico = Integer.parseInt(JOptionPane.showInputDialog("Actualizar id del médico: ", objCitaActualizar.getId_Medico()));
                String fecha_cita = JOptionPane.showInputDialog("Actualizar fecha de la cita: ", objCitaActualizar.getFecha_Cita());
                String hora_cita = JOptionPane.showInputDialog("Actualizar hora de la cita: ", objCitaActualizar.getHora_Cita());
                String motivo = JOptionPane.showInputDialog("Actualizar motivo de la cita: ", objCitaActualizar.getMotivo());

                objCitaActualizar.setId_Medico(idMedico);
                objCitaActualizar.setFecha_Cita(Date.valueOf(fecha_cita));
                objCitaActualizar.setHora_Cita(Time.valueOf(hora_cita));
                objCitaActualizar.setMotivo(motivo);
                this.objCitaModel.update(objCitaActualizar);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna cita");
        }
    }



    public void deleteCita (Cita cita){
        String listCitaString = this.getAll(this.objCitaModel.findAll());
        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listCitaString + "Ingrese el id del Medico a eliminar"));
        Cita objCita = (Cita) this.objCitaModel.findById(idDelete);
        if (objCitaModel == null){
            JOptionPane.showMessageDialog(null,"No se encontró la cita");
        } else {
            confirm = JOptionPane.showConfirmDialog(null,"Está seguro de eliminar al Médico: \n" + objCita.toString());
            if (confirm == 0) {
                this.objCitaModel.delete(objCita);
            }
        }
    }

    public void getAll(){
        String list = this.getAll(this.objCitaModel.findAll());
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List<Object> listObject){
        String list = " Lista de Citas \n";
        for (Object obj : listObject ) {
            Cita objCita = (Cita) obj;
            list += objCita.toString() + "\n";
        }
        return list;
    }

    public Medico getMedicoById(int id){
        return (Medico) objCitaModel.findById(id);
    }
}
