package model;

import database.CRUD;
import database.ConfigDB;
import entity.Especialidad;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadModel implements CRUD {


    @Override
    public Object insert(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Especialidad objEspecialidad = (Especialidad) object;
        try {
            String sql = "INSERT INTO Especialidades (nombre, descripcion) VALUES (?, ?);";
            PreparedStatement objPrepare = (PreparedStatement)
                    objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objEspecialidad.getNombre());
            objPrepare.setString(2, objEspecialidad.getDescipcion());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objEspecialidad.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Se agregó con éxito");
            objPrepare.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar" + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConfigDB.closeConnection();
        }
        return objEspecialidad;
    }

    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.getObjConnection();
        Especialidad objEspecialidad = (Especialidad) object;
        boolean idUpdate = false;
        try {
            String sql = "UPDATE Especialidades SET nombre = ?, descripcion = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objEspecialidad.getNombre());
            objPrepare.setString(2, objEspecialidad.getDescipcion());
            objPrepare.setInt(3, objEspecialidad.getId());
            int rowAffected = objPrepare.executeUpdate();
            if ( rowAffected > 0 ){
                idUpdate = true;
                JOptionPane.showMessageDialog(null, "Se actualizó correctamente");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return idUpdate;
    }

    @Override
    public boolean delete(Object object) {
        Especialidad objEspecialidad = (Especialidad) object;
        boolean isDelete = false;
        Connection objConnection = ConfigDB.getObjConnection();
        try {
            String sql = "DELETE FROM Especialidades WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1, objEspecialidad.getId());
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
        List<Object> listEspecialidades = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Especialidades ORDER BY Especialidades.id ASC;";
            PreparedStatement objPrepared = (PreparedStatement) objConnection.prepareStatement(sql);
            ResultSet objResult = (ResultSet) objPrepared.executeQuery();
            while (objResult.next()){
                Especialidad objEspecialidad = new Especialidad();
                objEspecialidad.setId(objResult.getInt("id"));
                objEspecialidad.setNombre(objResult.getString("nombre"));
                objEspecialidad.setDescipcion(objResult.getString("descripcion"));
                listEspecialidades.add(objEspecialidad);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al recibir lo datos " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return listEspecialidades;
    }

    @Override
    public Object findById(int id) {
        Connection objConnection = ConfigDB.getObjConnection();
        Especialidad objEspecialidad = null;
        try {
            String sql = "SELECT * FROM Especialidades WHERE id = ?;";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setInt(1, id);
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()){
                objEspecialidad = new Especialidad();
                objEspecialidad.setId(objResult.getInt("id"));
                objEspecialidad.setNombre(objResult.getString("nombre"));
                objEspecialidad.setDescipcion(objResult.getString("descripcion"));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener datos" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return objEspecialidad;
    }
}
