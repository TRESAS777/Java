package controller;

import entity.Paciente;
import model.PacienteModel;

import javax.swing.*;
import java.sql.Date;
import java.util.List;

public class PacienteController {

    PacienteModel objPacienteModel;

    public PacienteController() {
        this.objPacienteModel = new PacienteModel();
    }

    public void insertPaciente(Paciente paciente){
        Paciente objPaciente = new Paciente();
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del paciente");
        String nacimiento = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del paciente YYYY-MM-DD");
        String dni = JOptionPane.showInputDialog("Ingrese el documento de identidad del paciente");
        System.out.println(nacimiento);
        if (nombre != null && !nombre.isEmpty() && apellido != null && !apellido.isEmpty() && nacimiento != null && !nacimiento.isEmpty() && dni != null && !dni.isEmpty() ){
            objPaciente.setNombre(nombre);
            objPaciente.setApellido(apellido);
            objPaciente.setFechaNacimiento(Date.valueOf(nacimiento));
            objPaciente.setDni(dni);
            objPaciente = (Paciente) this.objPacienteModel.insert(objPaciente);
            JOptionPane.showMessageDialog(null, objPaciente.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Ningún campo puede estar vacío");
        }
    }

    public void updatePaciente(Paciente paciente){
        List<Object> Pacientes = objPacienteModel.findAll();
        if (!Pacientes.isEmpty()){
            String listPacientes = getAll(Pacientes);
            int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del paciente a actualizar:\n " + listPacientes));
            Paciente objPaciente = (Paciente) this.objPacienteModel.findById(idUpdate);
            if (objPaciente == null){
                JOptionPane.showMessageDialog(null, "No se encontró");
            } else {
                String nombre = JOptionPane.showInputDialog("Nuevo nombre del paciente", objPaciente.getNombre());
                String apellido = JOptionPane.showInputDialog("Nuevo apellido del paciente", objPaciente.getApellido());
                String nacimiento = JOptionPane.showInputDialog("Nueva fecha de nacimiento del paciente", objPaciente.getFechaNacimiento());
                String dni = JOptionPane.showInputDialog("Nuevo documento de identidad del paciente", objPaciente.getDni());
                objPaciente.setNombre(nombre);
                objPaciente.setApellido(apellido);
                objPaciente.setFechaNacimiento(Date.valueOf(nacimiento));
                objPaciente.setDni(dni);
                this.objPacienteModel.update(objPaciente);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
    }

    public void deletePaciente(Paciente paciente){
        String listPacientesSting = this.getAll(this.objPacienteModel.findAll());
        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listPacientesSting + "Ingrese el id del paciente a eliminar"));
        Paciente objPaciente = (Paciente) this.objPacienteModel.findById(idDelete);
        if (objPaciente == null){
            JOptionPane.showMessageDialog(null, "No se encontró");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el paciente: \n" + objPaciente.toString());
            if (confirm == 0) {
                this.objPacienteModel.delete(objPaciente);
            }
        }
    }

    public void getAll(){
        List<Object> pacientes = this.objPacienteModel.findAll();
        if (!pacientes.isEmpty()){
            String list = this.getAll(pacientes);
            JOptionPane.showMessageDialog(null, list);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
    }

    public String getAll(List<Object> listObject){
        if (!listObject.isEmpty()){
            String list = " Lista de Pacientes \n" ;
            for (Object obj : listObject){
                Paciente objPaciente = (Paciente) obj;
                list += objPaciente.toString() + "\n";
            }
            return list;
        } else {
            return "No se encontró";
        }
    }

    public Paciente getEspecialidadById (int id){
        return (Paciente) objPacienteModel.findById(id);
    }

}
