/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.mysqlConn;
import interfaces.IReventaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Reventa;

/**
 *
 * @author martinez
 */
public class ReventaDAO implements IReventaDAO{
    private mysqlConn mysqlConn;
    private Connection conexion;
    
    public ReventaDAO() throws SQLException {
        this.mysqlConn = new mysqlConn();
        this.conexion = mysqlConn.abrirConn();
    }
    
    @Override
    public int InsertarReventa(int _idBoleto, int _idVendedor) throws SQLException{
        Reventa reventa = new Reventa(_idBoleto, _idVendedor);
        String query = "INSERT INTO Reventas(_idBoleto, _idVendedor) VALUES (?,?)";
        try(PreparedStatement pstm = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            pstm.setInt(1, reventa.getIdBoleto());
            pstm.setInt(2, reventa.getIdVendedor());
            
            int affectedRows = pstm.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException ("Error al insertar Reventa, no hubo filas creadas.");
            }
            else{
                try(ResultSet generatedKeys = pstm.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        return generatedKeys.getInt(1);
                    }
                    else{
                        throw new SQLException("Error al insertar Reventa, no se obtuvo el ID.");
                    }
                }
            }
        }
    }
    
    @Override
    public List<Reventa> getReventas() throws SQLException {
        List<Reventa> reventas = new ArrayList<>();
        String query = "SELECT * FROM Reventas";
        
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Reventa reventa = new Reventa();
                reventa.setId(rs.getInt("_id"));
                reventa.setIdBoleto(rs.getInt("_idBoleto"));
                reventa.setIdVendedor(rs.getInt("_idVendedor"));
                reventas.add(reventa);
            }
        }
        catch (SQLException e) {
            throw new SQLException("Error al obtener los eventos: " + e.getMessage());
        }
        return reventas;
    }
}
