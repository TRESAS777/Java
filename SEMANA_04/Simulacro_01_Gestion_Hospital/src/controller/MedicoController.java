package controller;

import entity.Medico;
import model.MedicoModel;

import javax.swing.*;
import java.util.List;

public class MedicoController {

    MedicoModel objMedicoModel;

    public MedicoController() {
        this.objMedicoModel = new MedicoModel();
    }

    public void insertMedico(Medico especialidad){
        Medico objMedico = new Medico();
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre: ");
        String apellido = JOptionPane.showInputDialog("Ingresa el apellido: ");
        int idEspecialidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la Especialidad: "));
        objMedico.setNombre(nombre);
        objMedico.setApellido(apellido);
        objMedico.setId_Especialidad(idEspecialidad);
        objMedico = (Medico) this.objMedicoModel.insert(objMedico);
        JOptionPane.showMessageDialog(null, objMedico.toString());
    }

    public void updateMedico(Medico medico){
        List<Object> allMedicos = objMedicoModel.findAll();
        if (!allMedicos.isEmpty()){
            String listMedicos = getAll(allMedicos);
            int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del Médico a actualizar:\n" + listMedicos));
            Medico objMedicoActualizar = (Medico) objMedicoModel.findById(idUpdate);
            if (objMedicoActualizar == null){
                JOptionPane.showMessageDialog(null, "No se encontró");
            } else {
                String nombre = JOptionPane.showInputDialog("Nuevo nombre: ", objMedicoActualizar.getNombre());
                String apellido = JOptionPane.showInputDialog("Nuevo apellido: ", objMedicoActualizar.getApellido());

                objMedicoActualizar.setNombre(nombre);
                objMedicoActualizar.setApellido(apellido);

                this.objMedicoModel.update(objMedicoActualizar);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró Médicos");
        }
    }

    public void deleteMedico(Medico medico){
        String listMedicoString = this.getAll(this.objMedicoModel.findAll());
        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listMedicoString + "Ingrese el id del Medico a eliminar"));
        Medico objMedico = (Medico) this.objMedicoModel.findById(idDelete);
        if (objMedico == null){
            JOptionPane.showMessageDialog(null,"No se encontró el Médico");
        } else {
            confirm = JOptionPane.showConfirmDialog(null,"Está seguro de eliminar al Médico: \n" + objMedico.toString());
            if (confirm == 0){
                this.objMedicoModel.delete(objMedico);
            }
        }
    }

    public void getAll(){
        String list = this.getAll(this.objMedicoModel.findAll());
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List<Object> listObject){
        String list = " Lista de Médicos \n";
        for (Object obj : listObject ) {
            Medico objMedico = (Medico) obj;
            list += objMedico.toString() + "\n";
        }
        return list;
    }

    public Medico getMedicoById(int id){
        return (Medico) objMedicoModel.findById(id);
    }
}
