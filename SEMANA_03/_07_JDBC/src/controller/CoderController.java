package controller;

import entity.Coder;
import model.CoderModel;

import javax.swing.*;
import java.util.List;

public class CoderController {

    CoderModel objCoderModel;
    public CoderController(){
//        Crear una instancia del model
        this.objCoderModel = new CoderModel();
    }

    public void update(){
//        Listamos
        String listCoder = this.getAll(this.objCoderModel.findAll());
//        Pedimos id
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Enter id at coder to change"));
//        Verificar el id
        Coder objCoder = (Coder) this.objCoderModel.findById(idUpdate);
        if (objCoder == null){
            JOptionPane.showMessageDialog(null, "Not found");
        } else {
            String name = JOptionPane.showInputDialog(null,"New  name:",objCoder.getName());
            String clan = JOptionPane.showInputDialog(null,"New clan:",objCoder.getClan());
            int age = Integer.parseInt(JOptionPane.showInputDialog(null,"New age:",String.valueOf(objCoder.getAge())));

            objCoder.setAge(age);
            objCoder.setClan(clan);
            objCoder.setName(name);
            this.objCoderModel.update(objCoder);
        }

    }

//    Método para eliminar un coder
    public void delete(){
//        Listar coders
        String listCoderString = this.getAll(this.objCoderModel.findAll());

        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listCoderString + "Enter the ID of the coder to delete"));
        Coder objCoder = (Coder) this.objCoderModel.findById(idDelete);
        if (objCoder == null ){
            JOptionPane.showMessageDialog(null,"Coder not found");
        } else {
            confirm = JOptionPane.showConfirmDialog(null,"Are you sure want to delete the coder: \n" + objCoder.toString());
//            si el usuario escogió que sí entonces eliminamos
            if (confirm == 0){
                this.objCoderModel.delete(objCoder);
            }
        }
    }

//    Método para listar todos los coders
    public void getAll(){
//        Se aplica sobre escritura o sobre carga
        String list = this.getAll(this.objCoderModel.findAll());
//        Mostramos toda la lista
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List<Object> listObject){
        String list = " List Coders \n";
//        Iteramos sobre la lista que devuelve el método find ALl
        for (Object obj : listObject ){
//            Convertimos con cast el objeto tipo Object a un Coder
            Coder objCoder = (Coder) obj;
//            Concatenamos la información
            list += objCoder.toString()+ "\n";
        }
        return list;
    }

//    Método para crear un coder
    public void create(){
        Coder objCoder = new Coder();

        String name = JOptionPane.showInputDialog("Insert name: ");
        int age =Integer.parseInt(JOptionPane.showInputDialog("Insert age: "));
        String clan = JOptionPane.showInputDialog("Insert clan: ");

        objCoder.setName(name);
        objCoder.setAge(age);
        objCoder.setClan(clan);

        objCoder = (Coder) this.objCoderModel.insert(objCoder);

        JOptionPane.showMessageDialog(null, objCoder.toString());
    }

}
// clever cloud"