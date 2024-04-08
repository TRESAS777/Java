package controller;

import entity.Compra;
import model.ClienteModel;
import model.CompraModel;
import model.ProductoModel;

import javax.swing.*;
import java.sql.Timestamp;
import java.util.List;

public class CompraController {

    CompraModel objCompraModel;

    public CompraController(){
        this.objCompraModel = new CompraModel();
    }

    public void insertCompra(Compra compra){
        Compra objCompra = new Compra();
        Timestamp fecha = objCompra.getFecha_compra();
        ProductoController productoController = new ProductoController();
        List<Object> listProductos = productoController.getAll();
        int producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del producto: "));
        ClienteController clienteController = new ClienteController();
        List<Object> listClientes = clienteController.getAll();
        int cliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del cliente que compra: "));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a comprar del producto: "));
        int stock = objCompra.getStock();
        if (cantidad > stock && stock > 0){
            JOptionPane.showMessageDialog(null, "Su compra excede la cantidad disponible");
        } else if (producto > 0 && cliente > 0){
            objCompra.setFecha_compra(fecha);
            objCompra.setCantidad(cantidad);
            objCompra.setId_cliente(cliente);
            objCompra.setId_producto(producto);
            objCompra.setStock(stock);
            objCompra = (Compra) this.objCompraModel.insert(objCompra);
            JOptionPane.showMessageDialog(null, objCompra.toString());
            int idUpdate = objCompra.getId_producto();
            productoController.updateStock(idUpdate, cantidad);
            JOptionPane.showMessageDialog(null, objCompra.toString());
            Compra Compra = new Compra();
            JOptionPane.showMessageDialog(null, factura(Compra));
        } else {
            JOptionPane.showMessageDialog(null, "Ingresa valores existentes.");
        }
    }

    public void updateCompra(Compra compra){
        List<Object> Compras = this.objCompraModel.findAll();
        if (!Compras.isEmpty()){
            String listCompras = getAll(Compras);
            int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la compra a actualizar:\n " + listCompras));
            Compra objCompras = (Compra) this.objCompraModel.findById(idUpdate);
            if (objCompras == null){
                JOptionPane.showMessageDialog(null, "No se encontró");
            } else {
                int producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo id del producto: ", objCompras.getId_producto()));
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad a comprar del producto: ", objCompras.getCantidad()));
                int cliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo id del cliente que compra: ", objCompras.getId_cliente()));
                objCompras.setCantidad(cantidad);
                objCompras.setId_cliente(cliente);
                objCompras.setId_producto(producto);
                this.objCompraModel.update(objCompras);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
    }

    public void deleteCompra(Compra compra){
        String listProductoString = this.getAll(this.objCompraModel.findAll());
        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listProductoString + "Ingrese el id de la compra a eliminar"));
        Compra objCompra = (Compra) this.objCompraModel.findById(idDelete);
        if (objCompra == null){
            JOptionPane.showMessageDialog(null, "No se encontró");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar la compra: \n" + objCompra.toString());
            if (confirm == 0) {
                this.objCompraModel.delete(objCompra);
            }
        }
    }

    public Object factura(Compra compra){
        objCompraModel.findAll();
        int id_compra = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la compra pra realizar la factura: "));
        objCompraModel.findById(id_compra);
        ProductoModel productoModel = new ProductoModel();
        productoModel.findById(compra.getId_producto());
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.findById(compra.getId_cliente());
        return "Datos compra: " + objCompraModel.findById(id_compra) + "Datos Producto: " +  productoModel.findById(compra.getId_producto()) + "Datos Cliente: " + clienteModel.findById(compra.getId_cliente());
    }

    public void getAll(){
        List<Object> compras = this.objCompraModel.findAll();
        if (!compras.isEmpty()){
            String list = this.getAll(compras);
            JOptionPane.showMessageDialog(null, list);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
    }

    public String getAll(List<Object> listObject){
        if (!listObject.isEmpty()){
            String list = " Lista de compras: \n" ;
            for (Object obj : listObject){
                Compra objCompra = (Compra) obj;
                list += objCompra.toString() + "\n";
            }
            return list;
        } else {
            return "No se encontró";
        }
    }

    public Compra getCompraById (int id){
        return (Compra) objCompraModel.findById(id);
    }

}
