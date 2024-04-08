package model;

import database.CRUD;
import database.ConfigDB;
import entity.Tienda;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TiendaModel implements CRUD {
    @Override
    public Object insert(Object object) {
        return null;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.getObjConnection();
        List<Object> objectList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Tienda ORDER BY Tienda.id_tienda ASC;";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);
            ResultSet objResult = (ResultSet) objPrepare.executeQuery();
            while (objResult.next()) {
                Tienda objTienda = new Tienda();
                objTienda.setId_tienda(objResult.getInt("id_tienda"));
                objTienda.setNombre(objResult.getString("nombre"));
                objTienda.setUbicacion(objResult.getString("ubicacion"));
                objectList.add(objTienda);
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
        return null;
    }
}
