package model;

import database.CRUD;
import database.ConfigDB;
import entity.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteModel implements CRUD {
    @Override
    public Object insert(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Cliente objCliente = (Cliente) object;
        try {
            String sql = "INSERT INTO Cliente (nombre, apellido, email) VALUES (?,?,?);";
            PreparedStatement objPrepare = (PreparedStatement)
                    objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objCliente.getNombre());
            objPrepare.setString(2, objCliente.getApellido());
            objPrepare.setString(3, objCliente.getEmail());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objCliente.setId_cliente(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Se agregó con éxito ");
            objPrepare.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar: "+ e.getMessage());
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return objCliente;
    }

    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Cliente objCliente = (Cliente) object;
        boolean isUpdate = false;
        try {
            String sql = "UPDATE Cliente SET nombre = ?, apellido = ?, email = ? WHERE id_cliente = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objCliente.getNombre());
            objPrepare.setString(2, objCliente.getApellido());
            objPrepare.setString(3, objCliente.getEmail());
            objPrepare.setInt(4, objCliente.getId_cliente());
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
        Cliente objCliente = (Cliente) object;
        boolean isDelete = false;
        try {
            String sql = "DELETE FROM Cliente WHERE id_cliente = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1, objCliente.getId_cliente());
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
            String sql = "SELECT * FROM Cliente ORDER BY Cliente.id_cliente ASC;";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);
            ResultSet objResult = (ResultSet) objPrepare.executeQuery();
            while (objResult.next()) {
                Cliente objCliente = new Cliente();
                objCliente.setId_cliente(objResult.getInt("id_cliente"));
                objCliente.setNombre(objResult.getString("nombre"));
                objCliente.setApellido(objResult.getString("apellido"));
                objCliente.setEmail(objResult.getString("email"));
                objectList.add(objCliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener: "+ e.getMessage());
        }
        ConfigDB.closeConnection();
        return objectList;
    }

    @Override
    public Object findById(int id) {
        Connection objConnection  = ConfigDB.getObjConnection();
        Cliente objCliente = null;
        try {
            String sql = "SELECT * FROM Cliente WHERE id_cliente = ?;";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                objCliente = new Cliente();
                objCliente.setId_cliente(objResult.getInt("id_cliente"));
                objCliente.setNombre(objResult.getString("nombre"));
                objCliente.setApellido(objResult.getString("apellido"));
                objCliente.setEmail(objResult.getString("email"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener: "+ e.getMessage());
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return objCliente;
    }
}
