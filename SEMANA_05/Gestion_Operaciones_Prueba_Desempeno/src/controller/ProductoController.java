package controller;

import entity.Producto;
import model.ProductoModel;

import javax.swing.*;
import java.util.List;

public class ProductoController {

    ProductoModel objProductoModel;

    public ProductoController(){
        this.objProductoModel = new ProductoModel();
    }

    public void insertProducto(Producto producto){
        Producto objProducto = new Producto();
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));
        int tienda = 1;
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto"));
        if (nombre != null && !nombre.isEmpty() && precio > 0 && stock > 0 && precio <= stock){
            objProducto.setNombre(nombre);
            objProducto.setPrecio(precio);
            objProducto.setId_tienda(tienda);
            objProducto.setStock(stock);
            objProducto = (Producto) this.objProductoModel.insert(objProducto);
            JOptionPane.showMessageDialog(null, objProducto.toString());
        } else {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío, además el precio y stock debe ser mayor a cero");
        }
    }

    public void updateProducto(Producto producto){
        List<Object> Productos = this.objProductoModel.findAll();
        if (!Productos.isEmpty()){
            String listProductos = getAll(Productos);
            int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del producto a actualizar:\n " + listProductos));
            Producto objProducto = (Producto) this.objProductoModel.findById(idUpdate);
            if (objProducto == null){
                JOptionPane.showMessageDialog(null, "No se encontró");
            } else {
                String nombre = JOptionPane.showInputDialog("Nuevo nombre del producto", objProducto.getNombre());
                double precio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio del producto: ", objProducto.getPrecio()));
                int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo stock del producto", objProducto.getStock()));
                objProducto.setNombre(nombre);
                objProducto.setPrecio(precio);
                objProducto.setStock(stock);
                this.objProductoModel.update(objProducto);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
    }

    public void updateStock(int idUpdate, int cantidad){
        List<Object> Productos = this.objProductoModel.findAll();
        if (!Productos.isEmpty()){
            Producto objProducto = (Producto) this.objProductoModel.findById(idUpdate);
            if (objProducto == null){
                JOptionPane.showMessageDialog(null, "No se encontró");
            } else {
                int stock = objProducto.getStock();
                stock = stock - cantidad;
                objProducto.setStock(stock);
                this.objProductoModel.update(objProducto);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
    }

    public void deleteProducto(Producto producto){
        String listProductoString = this.getAll(this.objProductoModel.findAll());
        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listProductoString + "Ingrese el id del producto a eliminar"));
        Producto objProducto = (Producto) this.objProductoModel.findById(idDelete);
        if (objProducto == null){
            JOptionPane.showMessageDialog(null, "No se encontró");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el producto: \n" + objProducto.toString());
            if (confirm == 0) {
                this.objProductoModel.delete(objProducto);
            }
        }
    }

    public List<Object> getAll(){
        List<Object> productos = this.objProductoModel.findAll();
        if (!productos.isEmpty()){
            String list = this.getAll(productos);
            JOptionPane.showMessageDialog(null, list);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
        return productos;
    }

    public String getAll(List<Object> listObject){
        if (!listObject.isEmpty()){
            String list = " Lista de productos: \n" ;
            for (Object obj : listObject){
                Producto objProducto = (Producto) obj;
                list += objProducto.toString() + "\n";
            }
            return list;
        } else {
            return "No se encontró";
        }
    }

    public Producto getProductoById (int id){
        return (Producto) objProductoModel.findById(id);
    }

}
