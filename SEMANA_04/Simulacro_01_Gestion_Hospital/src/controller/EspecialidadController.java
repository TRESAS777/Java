package controller;

import entity.Especialidad;
import model.EspecialidadModel;

import javax.swing.*;
import java.util.List;

public class EspecialidadController {

    EspecialidadModel objEspecialidadModel;

    public EspecialidadController() {
        this.objEspecialidadModel = new EspecialidadModel();
    }

    public void insertEspecialidad(Especialidad especialidad){
        Especialidad objEspecialidad = new Especialidad();
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la Especialidad: ");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la Especialidad: ");
        if (nombre != null && !nombre.isEmpty()){
            objEspecialidad.setNombre(nombre);
            objEspecialidad.setDescipcion(descripcion);
            objEspecialidad = (Especialidad) this.objEspecialidadModel.insert(objEspecialidad);
            JOptionPane.showMessageDialog(null, objEspecialidad.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Nombre no puede sel null o estar vacío");
        }
    }

    public void updateEspecialidad(Especialidad especialidad){
        List<Object> Especialidades = objEspecialidadModel.findAll();
        if (!Especialidades.isEmpty()){
            String listEspecialidades = getAll(Especialidades);
            int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la Especialidad a actualizar:\n " + listEspecialidades));
            Especialidad objEspecialidad = (Especialidad) objEspecialidadModel.findById(idUpdate);
            if (objEspecialidad == null){
                JOptionPane.showMessageDialog(null, "No se encontró");
            } else {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la Especialidad: ", objEspecialidad.getNombre());
                String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la Especialidad: ", objEspecialidad.getDescipcion());
                objEspecialidad.setNombre(nombre);
                objEspecialidad.setDescipcion(descripcion);
                this.objEspecialidadModel.update(objEspecialidad);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró Especialidades");
        }
    }

    public void deleteEspecialidad(Especialidad especialidad){
        String listEspecialidadString = this.getAll(this.objEspecialidadModel.findAll());
        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listEspecialidadString + "Ingrese el id de la Especialidad a eliminar"));
        Especialidad objEspecialidad = (Especialidad) this.objEspecialidadModel.findById(idDelete);
        if (objEspecialidad == null){
            JOptionPane.showMessageDialog(null, "No se encontró Especialidades");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar la Especialidad: \n" + objEspecialidad.toString());
            if (confirm == 0){
                this.objEspecialidadModel.delete(objEspecialidad);
            }
        }
    }

    public void getAll(){
        List<Object> especialidades = this.objEspecialidadModel.findAll();
        if (!especialidades.isEmpty()){
            String list = this.getAll(especialidades);
            JOptionPane.showMessageDialog(null, list);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
    }

    public String getAll(List<Object> listObject){
        if (!listObject.isEmpty()){
            String list = " Lista de Especialidades \n" ;
            for (Object obj : listObject){
                Especialidad objEspecialidad = (Especialidad) obj;
                list += objEspecialidad.toString() + "\n";
            }
            return list;
        } else {
            return "No se encontró";
        }
    }

    public Especialidad getEspecialidadById (int id){
        return (Especialidad) objEspecialidadModel.findById(id);
    }

}
