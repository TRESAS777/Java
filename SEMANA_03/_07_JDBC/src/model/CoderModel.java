package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD {

    @Override
    public Object insert(Object object) {
//        Abrir conexión
        Connection objConnection = ConfigDB.openConnection();
//        Cast el código
        Coder objCoder = (Coder) object;

        try {
//            Crear SQL
            String sql = "INSERT INTO coder(name,age,clan) VALUES(?,?,?)";
//            PREPARAR STATEMENT
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
//            Asignar los signos de interrogación
            objPrepare.setString(1,objCoder.getName());
            objPrepare.setInt(2,objCoder.getAge());
            objPrepare.setString(3,objCoder.getClan());
//            Ejecutamos el Query
            objPrepare.execute();
//            Obtener resultado
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objCoder.setId(objResult.getInt(1));
            }
            objPrepare.close();
            JOptionPane.showMessageDialog(null," Coder insertion was successful ");

        } catch (Exception e){
            JOptionPane.showMessageDialog(null, " Error adding Coder " + e.getMessage());
        }
//        Cerramos la conexión
        ConfigDB.closeConnection();
        return objCoder;
    }

    @Override
    public boolean update(Object object) {
//        Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();
//        convertir el objeto
        Coder objCoder = (Coder)object;
//        Variable bandera para saber si e actualizo
        boolean idUpdate = false;
        try {
//            Creamos la sentencia sql
            String sql = "UPDATE coder  SET name = ?, age = ?, clan = ? WHERE id = ?;";
//            Preparar el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//            dar valor a los ? parámetros de Query
            objPrepare.setString(1,objCoder.getName());
            objPrepare.setInt(2,objCoder.getAge());
            objPrepare.setString(3,objCoder.getClan());
            objPrepare.setInt(4,objCoder.getId());

//            ejecutamos el query
            int rowAffected = objPrepare.executeUpdate();
            if (rowAffected > 0){
                idUpdate = true;
                JOptionPane.showMessageDialog(null,"Update was successful");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
//        Cerrar conexión
            ConfigDB.closeConnection();
        }
        return idUpdate;
    }

    @Override
    public boolean delete(Object object) {
//        Convertir el objeto a la entidad
        Coder objCoder = (Coder) object;
//        Variable booleana para definir el estado de la eliminación
        boolean isDelete = false;
//        abrir la conexión
        Connection objConnection = ConfigDB.openConnection();
        try {
//            Escribir la sentencia sql
            String sql = " DELETE FROM coder WHERE id = ?; ";
//            Preparar el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
//            Asignamos el valor al ?
            objPrepare.setInt(1,objCoder.getId());
//            ExecuteUpdate devuelve la cantidad de filas afectadas por la sentencia ejecutada
            int totalAffectedRows = objPrepare.executeUpdate();
            if (totalAffectedRows > 0){
                isDelete = true;
                JOptionPane.showMessageDialog(null, "The deletion was successful");
            }
//            Cerramos la conexión
            ConfigDB.closeConnection();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return isDelete;
    }
    @Override
    public List<Object> findAll() {
//        1. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();
//        Inicializar la lista donde se guardaran los registros que devuelve la base de datos
        List<Object> listCoders = new ArrayList<>();
        try {
//            Escribir la sentencia SQL
            String sql = "SELECT * FROM coder ORDER BY coder.id ASC;";
//            Utilizar PrepareStatement
            PreparedStatement objPreparedStatement = (PreparedStatement) objConnection.prepareStatement(sql);
//            Ejecutar el Query o el Prepared
            ResultSet objResult = (ResultSet) objPreparedStatement.executeQuery();
//            Obtener los resultados
            while (objResult.next()){
                Coder objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));
//                Agregamos el coder a la lista
                listCoders.add(objCoder);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Data acquisition Error");
        }
//        Cerramos la conexión
        ConfigDB.closeConnection();
        return listCoders;
    }

    @Override
    public Object findById(int id) {
//        Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = null;
        try {
            String sql = " SELECT * FROM coder WHERE id = ?; ";
//            Preparar statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
//            Dar valor al ?
            objPrepare.setInt(1,id);
            ResultSet objResult = objPrepare.executeQuery();
//            Mientras haya un registro siguiente entonces
            while (objResult.next()){
                objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setClan(objResult.getString("clan"));
                objCoder.setAge(objResult.getInt("age"));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
//        Cerrar la conexión
        ConfigDB.closeConnection();
        return objCoder;
    }
}
