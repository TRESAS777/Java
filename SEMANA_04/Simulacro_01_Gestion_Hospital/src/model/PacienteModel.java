package model;

import database.CRUD;
import database.ConfigDB;
import entity.Paciente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacienteModel implements CRUD {

    @Override
    public Object insert(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Paciente objPaciente = (Paciente) object;
        try {
            String sql = "INSERT INTO Pacientes (nombre, apellido, nacimiento, dni) VALUES (?, ?, ?, ?);";
            PreparedStatement objPrepare = (PreparedStatement)
                    objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objPaciente.getNombre());
            objPrepare.setString(2, objPaciente.getApellido());
            objPrepare.setDate(3, objPaciente.getFechaNacimiento());
            objPrepare.setString(4, objPaciente.getDni());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objPaciente.setId_Paciente(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Se agregó con éxito ");
            objPrepare.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al agregar " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return objPaciente;
    }

    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Paciente objPaciente = (Paciente) object;
        boolean isUpdate = false;
        try {
            String sql = "UPDATE Pacientes SET nombre = ?, apellido = ?, nacimiento = ?, dni = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objPaciente.getNombre());
            objPrepare.setString(2, objPaciente.getApellido());
            objPrepare.setDate(3, objPaciente.getFechaNacimiento());
            objPrepare.setString(4, objPaciente.getDni());
            objPrepare.setInt(5, objPaciente.getId_Paciente());
            int rowAffected = objPrepare.executeUpdate();
            if ( rowAffected > 0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "Actualización exitosa");
            }
        }  catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return isUpdate;
    }

    @Override
    public boolean delete(Object object) {
        Paciente objPaciente = (Paciente) object;
        boolean isDelete = false;
        Connection objConnection = ConfigDB.getObjConnection();
        try {
            String sql = "DELETE FROM Pacientes WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1, objPaciente.getId_Paciente());
            int totalAffectedRows = objPrepare.executeUpdate();
            if (totalAffectedRows > 0){
                isDelete = true;
                JOptionPane.showMessageDialog(null, "Borrado exitoso");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return isDelete;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.getObjConnection();
        List<Object> objectList = new ArrayList<>();
        try {
           String sql = "SELECT * FROM Pacientes ORDER BY Pacientes.id ASC;";
           PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);
           ResultSet objResult = (ResultSet) objPrepare.executeQuery();
           while (objResult.next()){
               Paciente objPaciente = new Paciente();
               objPaciente.setId_Paciente(objResult.getInt("id"));
               objPaciente.setNombre(objResult.getString("nombre"));
               objPaciente.setApellido(objResult.getString("apellido"));
               objPaciente.setFechaNacimiento(objResult.getDate("nacimiento"));
               objPaciente.setDni(objResult.getString("dni"));
               objectList.add(objPaciente);
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
        Paciente objPaciente = null;
        try {
            String sql = "SELECT * FROM Pacientes WHERE id = ?;";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                objPaciente = new Paciente();
                objPaciente.setId_Paciente(objResult.getInt("id"));
                objPaciente.setNombre(objResult.getString("nombre"));
                objPaciente.setApellido(objResult.getString("apellido"));
                objPaciente.setFechaNacimiento(objResult.getDate("nacimiento"));
                objPaciente.setDni(objResult.getString("dni"));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return objPaciente;
    }
}
