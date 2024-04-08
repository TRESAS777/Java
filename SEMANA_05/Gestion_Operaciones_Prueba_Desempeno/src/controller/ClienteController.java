package controller;

import entity.Cliente;
import model.ClienteModel;

import javax.swing.*;
import java.util.List;

public class ClienteController {

    ClienteModel objClienteModel;

    public ClienteController() {
        this.objClienteModel = new ClienteModel();
    }

    public void insertCliente(Cliente cliente){
        Cliente objCliente = new Cliente();
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente");
        String email = JOptionPane.showInputDialog("Ingrese el email del cliente");
        if (nombre != null && !nombre.isEmpty() && apellido != null && !apellido.isEmpty() && email != null && !email.isEmpty()){
            objCliente.setNombre(nombre);
            objCliente.setApellido(apellido);
            objCliente.setEmail(email);
            objCliente = (Cliente) this.objClienteModel.insert(objCliente);
            JOptionPane.showMessageDialog(null, objCliente.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Ningún campo puede estar vacío");
        }
    }

    public void updateCliente(Cliente cliente){
        List<Object> Clientes = this.objClienteModel.findAll();
        if (!Clientes.isEmpty()){
            String listCliente = getAll(Clientes);
            int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del cliente a actualizar:\n " + listCliente));
            Cliente objCliente = (Cliente) this.objClienteModel.findById(idUpdate);
            if (objCliente == null){
                JOptionPane.showMessageDialog(null, "No se encontró");
            } else {
                String nombre = JOptionPane.showInputDialog("Nuevo nombre del cliente", objCliente.getNombre());
                String apellido = JOptionPane.showInputDialog("Nuevo apellido del cliente", objCliente.getApellido());
                String email = JOptionPane.showInputDialog("Nueva email del cliente", objCliente.getEmail());
                objCliente.setNombre(nombre);
                objCliente.setApellido(apellido);
                objCliente.setEmail(email);
                this.objClienteModel.update(objCliente);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
    }

    public void deleteCliente (Cliente cliente){
        String listClienteString = this.getAll(this.objClienteModel.findAll());
        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listClienteString + "Ingrese el id del cliente a eliminar"));
        Cliente objCliente = (Cliente) this.objClienteModel.findById(idDelete);
        if (objCliente == null){
            JOptionPane.showMessageDialog(null, "No se encontró");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el cliente: \n" + objCliente.toString());
            if (confirm == 0) {
                this.objClienteModel.delete(objCliente);
            }
        }
    }

    public List<Object> getAll(){
        List<Object> Cliente = this.objClienteModel.findAll();
        if (!Cliente.isEmpty()){
            String list = this.getAll(Cliente);
            JOptionPane.showMessageDialog(null, list);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
        return Cliente;
    }

    public String getAll(List<Object> listObject){
            String list = " Lista de clientes: \n" ;
            for (Object obj : listObject){
                Cliente objCliente = (Cliente) obj;
                list += objCliente.toString() + "\n";
            }
            return list;
    }

    public Cliente getClienteById (int id){
        return (Cliente) objClienteModel.findById(id);
    }

}
