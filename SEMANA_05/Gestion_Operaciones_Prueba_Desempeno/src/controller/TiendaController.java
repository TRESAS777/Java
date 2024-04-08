package controller;

import entity.Tienda;
import model.TiendaModel;

import javax.swing.*;
import java.util.List;

public class TiendaController {

    TiendaModel objTiendaModel;
    public List<Object> getAll(){
        List<Object> Tienda = this.objTiendaModel.findAll();
        if (!Tienda.isEmpty()){
            String list = this.getAll(Tienda);
            JOptionPane.showMessageDialog(null, list);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
        return Tienda;
    }

    public String getAll(List<Object> listObject){
        String list = " Lista de tiendas: \n" ;
        for (Object obj : listObject){
            Tienda objTienda = (Tienda) obj;
            list += objTienda.toString() + "\n";
        }
        return list;
    }
}
