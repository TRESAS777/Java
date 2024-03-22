package model;

import database.CRUD;
import database.ConfigDB;
import entity.Author;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorModel implements CRUD {

    @Override
    public Object insert(Object object) {
        Connection objConnection = ConfigDB.openConnection();
        Author objAuthor = (Author) object;
        try {
            String sql = "INSERT INTO Autores (name, nationality) VALUES (?, ?);";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1,objAuthor.getName());
            objPrepare.setString(2,objAuthor.getNationality());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objAuthor.setId(objResult.getInt(1));
            }
            objPrepare.close();
            JOptionPane.showMessageDialog(null," Author insertion was successful ");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, " Error adding Author " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objAuthor;
    }

    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.openConnection();
        Author objAuthor = (Author) object;
        boolean idUpdate = false;
        try {
            String sql = "UPDATE Autores SET name = ?, nationality = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1,objAuthor.getName());
            objPrepare.setString(2,objAuthor.getNationality());
            objPrepare.setInt(3,objAuthor.getId());

            int rowAffected = objPrepare.executeUpdate();
            if (rowAffected > 0){
                idUpdate = true;
                JOptionPane.showMessageDialog(null,"Update was successful");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return idUpdate;
    }

    @Override
    public boolean delete(Object object) {
        Author objAuthor = (Author) object;
        boolean isDelete = false;
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = " DELETE FROM Autores WHERE id = ?; ";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1,objAuthor.getId());
            int totalAffectedRows = objPrepare.executeUpdate();
            if (totalAffectedRows > 0){
                isDelete = true;
                JOptionPane.showMessageDialog(null, "The deletion was successful");
            }
            ConfigDB.closeConnection();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return isDelete;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listAuthors = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Autores ORDER BY Autores.id ASC;";
            PreparedStatement objPreparedStatement = (PreparedStatement) objConnection.prepareStatement(sql);
            ResultSet objResult = (ResultSet) objPreparedStatement.executeQuery();
            while (objResult.next()){
                Author objAuthor = new Author();
                objAuthor.setId(objResult.getInt("id"));
                objAuthor.setName(objResult.getString("name"));
                objAuthor.setNationality(objResult.getString("nationality"));
                listAuthors.add(objAuthor);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Data acquisition Error");
        }
        ConfigDB.closeConnection();
        return listAuthors;
    }

    @Override
    public Object findById(int id) {
        Connection objConnection = ConfigDB.openConnection();
        Author objAuthor = null;
        try {
            String sql = " SELECT * FROM Autores WHERE id = ?; ";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,id);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                objAuthor = new Author();
                objAuthor.setId(objResult.getInt("id"));
                objAuthor.setName(objResult.getString("name"));
                objAuthor.setNationality(objResult.getString("nationality"));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objAuthor;
    }
}
