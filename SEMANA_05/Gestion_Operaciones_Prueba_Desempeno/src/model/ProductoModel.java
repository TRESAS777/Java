package model;

import database.CRUD;
import database.ConfigDB;
import entity.Producto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoModel implements CRUD {
    @Override
    public Object insert(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Producto objProducto = (Producto) object;
        try {
            String sql = "INSERT INTO Producto (nombre, precio, id_tienda, stock) VALUES (?,?,?,?);";
            PreparedStatement objPrepare = (PreparedStatement)
                    objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objProducto.getNombre());
            objPrepare.setDouble(2, objProducto.getPrecio());
            objPrepare.setInt(3, objProducto.getId_tienda());
            objPrepare.setInt(4, objProducto.getStock());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
            objProducto.setId_producto(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Se agregó con éxito ");
            objPrepare.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar: "+ e.getMessage());
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return objProducto;
    }

    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Producto objProducto = (Producto) object;
        boolean isUpdate = false;
        try {
            String sql = "UPDATE Producto SET nombre = ?, precio = ?, id_tienda = ?, stock = ? WHERE id_producto = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objProducto.getNombre());
            objPrepare.setDouble(2, objProducto.getPrecio());
            objPrepare.setInt(3, objProducto.getId_tienda());
            objPrepare.setInt(4, objProducto.getStock());
            objPrepare.setInt(5, objProducto.getId_producto());
            int rowAffected = objPrepare.executeUpdate();
            if ( rowAffected > 0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "Actualización exitosa");
            }
            objPrepare.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: "+ e.getMessage());
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return isUpdate;
    }

    public boolean updateStock(Object object){
        Connection objConnection = ConfigDB.getObjConnection();
        Producto objProducto = (Producto) object;
        boolean isUpdate = false;
        try {
            String sql = "UPDATE Producto SET stock = ? WHERE id_producto = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, objProducto.getStock());
            objPrepare.setInt(2, objProducto.getId_producto());
            int rowAffected = objPrepare.executeUpdate();
            if ( rowAffected > 0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "Actualización exitosa");
            }
            objPrepare.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: "+ e.getMessage());
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return isUpdate;
    }

    @Override
    public boolean delete(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Producto objProducto = (Producto) object;
        boolean isDelete = false;
        try {
            String sql = "DELETE FROM Producto WHERE id_producto = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1, objProducto.getId_producto());
            int totalAffectedRows = objPrepare.executeUpdate();
            if (totalAffectedRows > 0){
                isDelete = true;
                JOptionPane.showMessageDialog(null, "Borrado exitoso");
            }
            objPrepare.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: "+ e.getMessage());
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return isDelete;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.getObjConnection();
        List<Object> objectList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Producto ORDER BY Producto.id_producto ASC;";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);
            ResultSet objResult = (ResultSet) objPrepare.executeQuery();
            while (objResult.next()) {
                Producto objProducto = new Producto();
                objProducto.setId_producto(objResult.getInt("id_producto"));
                objProducto.setNombre(objResult.getString("nombre"));
                objProducto.setPrecio(objResult.getDouble("precio"));
                objProducto.setId_tienda(objResult.getInt("id_tienda"));
                objProducto.setStock(objResult.getInt("stock"));
                objectList.add(objProducto);
            }
            objPrepare.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener: "+ e.getMessage());
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return objectList;
    }

    @Override
    public Object findById(int id) {
        Connection objConnection  = ConfigDB.getObjConnection();
        Producto objProducto = null;
        try {
            String sql = "SELECT * FROM Producto WHERE id_producto = ?;";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                objProducto = new Producto();
                objProducto.setId_producto(objResult.getInt("id_producto"));
                objProducto.setNombre(objResult.getString("nombre"));
                objProducto.setPrecio(objResult.getDouble("precio"));
                objProducto.setId_tienda(objResult.getInt("id_tienda"));
                objProducto.setStock(objResult.getInt("stock"));
            }
            objPrepare.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener: "+ e.getMessage());
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return objProducto;
    }
}
