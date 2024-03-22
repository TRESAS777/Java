package model;

import database.CRUD;
import database.ConfigDB;
import entity.Book;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookModel implements CRUD {
    @Override
    public Object insert(Object object) {
        Connection objConnection = ConfigDB.openConnection();
        Book objBook = (Book) object;
        try {
            String sql = "INSERT INTO Libros (title, yearPublication, price, idAuthor) VALUES (?, ?, ?, ?);";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objBook.getTitle());
            objPrepare.setInt(2, objBook.getYearPublication());
            objPrepare.setDouble(3, objBook.getPrice());
            objPrepare.setInt(4, objBook.getIdAuthor());
            objPrepare.executeUpdate();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objBook.setId(objResult.getInt(1));
            }
            objPrepare.close();
            JOptionPane.showMessageDialog(null," Author insertion was successful ");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, " Error adding Book " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objBook;
    }

    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.openConnection();
        Book objBook = (Book) object;
        boolean idUpdate = false;
        try {
            String sql = "UPDATE Libros SET title = ?, yearPublication = ?, price = ?, idAuthor = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objBook.getTitle());
            objPrepare.setInt(2, objBook.getYearPublication());
            objPrepare.setDouble(3, objBook.getPrice());
            objPrepare.setInt(4, objBook.getIdAuthor());
            objPrepare.setInt(5, objBook.getId());

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
        Book objBook = (Book) object;
        boolean isDelete = false;
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = " DELETE FROM Libros WHERE id = ?; ";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1,objBook.getId());
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
        List<Object> listBooks = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Libros ORDER BY Libros.id ASC;";
            PreparedStatement objPreparedStatement = (PreparedStatement) objConnection.prepareStatement(sql);
            ResultSet objResult = (ResultSet) objPreparedStatement.executeQuery();
            while (objResult.next()){
                Book objBook = new Book();
                objBook.setId(objResult.getInt("id"));
                objBook.setTitle(objResult.getString("title"));
                objBook.setYearPublication(objResult.getInt("yearPublication"));
                objBook.setPrice(objResult.getDouble("price"));
                objBook.setIdAuthor(objResult.getInt("idAuthor"));
                listBooks.add(objBook);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Data acquisition Error");
        }
        ConfigDB.closeConnection();
        return listBooks;
    }

    @Override
    public Object findById(int id) {
        Connection objConnection = ConfigDB.openConnection();
        Book objBook = null;
        try {
            String sql = " SELECT * FROM Libros WHERE id = ?; ";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,id);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                objBook = new Book();
                objBook.setId(objResult.getInt("id"));
                objBook.setTitle(objResult.getString("title"));
                objBook.setYearPublication(objResult.getInt("yearPublication"));
                objBook.setPrice(objResult.getDouble("price"));
                objBook.setIdAuthor(objResult.getInt("idAuthor"));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objBook;
    }
}
