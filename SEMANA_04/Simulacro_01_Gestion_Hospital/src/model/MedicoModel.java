package model;

import database.CRUD;
import database.ConfigDB;
import entity.Medico;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicoModel implements CRUD {

    @Override
    public Object insert(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Medico objMedico = (Medico) object;
        try {
            String sql = "INSERT INTO Medicos (nombre, apellido, idEspecialidad) VALUES (?, ?, ?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objMedico.getNombre());
            objPrepare.setString(2, objMedico.getApellido());
            objPrepare.setInt(3, objMedico.getId_Especialidad());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            if (objResult.next()) {
                objMedico.setId_Medico(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Se agregó con éxito");
            objPrepare.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return objMedico;
    }


    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Medico objMedico = (Medico) object;
        boolean isUpdate = false;
        try {
            String sql = "UPDATE Medicos SET nombre = ?, apellido = ?, idEspecialidad = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objMedico.getNombre());
            objPrepare.setString(2,objMedico.getApellido());
            objPrepare.setInt(3, objMedico.getId_Especialidad());
            objPrepare.setInt(4, objMedico.getId_Medico());
            int rowAffected = objPrepare.executeUpdate();
            if ( rowAffected > 0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "Actualización exitosa");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return isUpdate;
    }

    @Override
    public boolean delete(Object object) {
        Medico objMedico = (Medico) object;
        boolean isDelete = false;
        Connection objConnection = ConfigDB.getObjConnection();
        try {
            String sql = "DELETE FROM Medicos WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1, objMedico.getId_Medico());
            int totalAffectedRows = objPrepare.executeUpdate();
            if (totalAffectedRows > 0){
                isDelete = true;
                JOptionPane.showMessageDialog(null, "Borrado exitoso");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e.getMessage());
        }  finally {
            ConfigDB.closeConnection();
        }
        return isDelete;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.getObjConnection();
        List<Object> objectList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Medicos ORDER BY Medicos.id ASC;";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);
            ResultSet objResult = (ResultSet) objPrepare.executeQuery();
            while (objResult.next()) {
                Medico objMedico = new Medico();
                objMedico.setId_Medico(objResult.getInt("id"));
                objMedico.setNombre(objResult.getString("nombre"));
                objMedico.setApellido(objResult.getString("apellido"));
                objMedico.setId_Especialidad(objResult.getInt("idEspecialidad"));
                objectList.add(objMedico);
            }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error al recibir datos " + e.getMessage());
            } finally {
                ConfigDB.closeConnection();
            }
            return objectList;
    }

    @Override
    public Object findById(int id) {
        Connection objConnection  = ConfigDB.getObjConnection();
        Medico objMedico = null;
        try {
            String sql = "SELECT * FROM Medicos WHERE id = ?;";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                objMedico = new Medico();
                objMedico.setId_Medico(objResult.getInt("id"));
                objMedico.setNombre(objResult.getString("nombre"));
                objMedico.setApellido(objResult.getString("apellido"));
                objMedico.setId_Especialidad(objResult.getInt("idEspecialidad"));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return objMedico;
    }
}
