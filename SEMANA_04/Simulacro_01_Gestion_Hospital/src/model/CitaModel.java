package model;

import database.CRUD;
import database.ConfigDB;
import entity.Cita;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CitaModel implements CRUD {
    @Override
    public Object insert(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Cita objCita = (Cita) object;
        try {
            String sql = "INSERT INTO Citas (idPaciente, idMedico, fecha_cita, hora_cita, motivo) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement objPrepare = (PreparedStatement)
                    objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1, objCita.getId_Paciente());
            objPrepare.setInt(2, objCita.getId_Medico());
            objPrepare.setDate(3, objCita.getFecha_Cita());
            objPrepare.setTime(4, objCita.getHora_Cita());
            objPrepare.setString(5, objCita.getMotivo());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objCita.setId_Cita(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Se agregó con éxito");
            objPrepare.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }  finally {
            ConfigDB.closeConnection();
        }
        return objCita;
    }

    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Cita objCita = (Cita) object;
        boolean isUpdate = false;
        try {
            String sql = "UPDATE Citas SET idPaciente = ?, idMedico = ?, fecha_cita = ?, hora_cita = ?, motivo = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, objCita.getId_Paciente());
            objPrepare.setInt(2, objCita.getId_Medico());
            objPrepare.setDate(3, objCita.getFecha_Cita());
            objPrepare.setTime(4, objCita.getHora_Cita());
            objPrepare.setString(5, objCita.getMotivo());
            objPrepare.setInt(6, objCita.getId_Cita());
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
        boolean isDelete = false;
        Connection objConnection = ConfigDB.getObjConnection();
        Cita objCita = (Cita) object;
        try {
            String sql = "DELETE FROM Citas WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1, objCita.getId_Cita());
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
            String sql = "SELECT * FROM Citas ORDER BY Citas.id ASC;";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);
            ResultSet objResult = (ResultSet) objPrepare.executeQuery();
            while (objResult.next()) {
                Cita objCita = new Cita();
                objCita.setId_Cita(objResult.getInt("id"));
                objCita.setId_Paciente(objResult.getInt("idPaciente"));
                objCita.setId_Medico(objResult.getInt("idMedico"));
                objCita.setFecha_Cita(objResult.getDate("fecha_cita"));
                objCita.setHora_Cita(objResult.getTime("hora_cita"));
                objCita.setMotivo(objResult.getString("motivo"));
                objectList.add(objCita);
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
        Cita objCita = null;
        try {
            String sql = "SELECT * FROM Citas WHERE id = ?;";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                objCita = new Cita();
                objCita.setId_Cita(objResult.getInt("id"));
                objCita.setId_Paciente(objResult.getInt("idPaciente"));
                objCita.setId_Medico(objResult.getInt("idMedico"));
                objCita.setFecha_Cita(objResult.getDate("fecha_cita"));
                objCita.setHora_Cita(objResult.getTime("hora_cita"));
                objCita.setMotivo(objResult.getString("motivo"));
            }
        }  catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return objCita;
    }
}
