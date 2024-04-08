package model;

import database.CRUD;
import database.ConfigDB;
import entity.Compra;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraModel implements CRUD {
    @Override
    public Object insert(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Compra objCompra = (Compra) object;
        try {
            String sql = "INSERT INTO Compra (fecha_compra, cantidad, id_cliente, id_producto) VALUES (?,?,?,?);";
            PreparedStatement objPrepare = (PreparedStatement)
                    objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setTimestamp(1, objCompra.getFecha_compra());
            objPrepare.setInt(2, objCompra.getCantidad());
            objPrepare.setInt(3, objCompra.getId_cliente());
            objPrepare.setInt(4, objCompra.getId_producto());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objCompra.setId_compra(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Se agregó con éxito ");
            objPrepare.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar: "+ e.getMessage());
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return objCompra;
    }

    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Compra objCompra = (Compra) object;
        boolean isUpdate = false;
        try {
            String sql = "UPDATE Compra SET fecha_compra = ?, cantidad = ?, id_cliente = ?, id_producto = ? WHERE id_compra = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setTimestamp(1, objCompra.getFecha_compra());
            objPrepare.setInt(2, objCompra.getCantidad());
            objPrepare.setInt(3, objCompra.getId_cliente());
            objPrepare.setInt(4, objCompra.getId_producto());
            objPrepare.setInt(5, objCompra.getId_compra());
            int rowAffected = objPrepare.executeUpdate();
            if ( rowAffected > 0) {
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
        Compra objCompra = (Compra) object;
        boolean isDelete = false;
        try {
            String sql = "DELETE FROM Compra WHERE id_compra = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1, objCompra.getId_compra());
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
            String sql = "SELECT * FROM Compra ORDER BY Compra.id_compra ASC;";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);
            ResultSet objResult = (ResultSet) objPrepare.executeQuery();
            while (objResult.next()) {
                Compra objCompra = new Compra();
                objCompra.setId_compra(objResult.getInt("id_compra"));
                objCompra.setFecha_compra(objResult.getTimestamp("fecha_compra"));
                objCompra.setCantidad(objResult.getInt("cantidad"));
                objCompra.setId_cliente(objResult.getInt("id_cliente"));
                objCompra.setId_producto(objResult.getInt("id_producto"));
                objectList.add(objCompra);
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
        Compra objCompra = null;
        try {
            String sql = "SELECT * FROM Compra WHERE id_compra = ?;";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                objCompra = new Compra();
                objCompra.setId_compra(objResult.getInt("id_compra"));
                objCompra.setFecha_compra(objResult.getTimestamp("fecha_compra"));
                objCompra.setCantidad(objResult.getInt("cantidad"));
                objCompra.setId_cliente(objResult.getInt("id_cliente"));
                objCompra.setId_producto(objResult.getInt("id_producto"));
            }
            objPrepare.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener: "+ e.getMessage());
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return objCompra;
    }



}