/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.mysqlConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Boleto;

/**
 *
 * @author martinez
 */
public class BoletoDAO {
    private Connection connection;
    
    public BoletoDAO() throws SQLException {
        this.connection = mysqlConn.abrirConn();
    }
    
    public Boleto getBoletoPorSerie(String nSerie) throws SQLException {
        Boleto boleto = null;
        String query = "SELECT * FROM Boletos WHERE nSerie = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, nSerie);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                boleto = new Boleto(
                    rs.getInt("_id"),
                    rs.getString("nSerie"),
                    rs.getInt("_evento"),
                    rs.getString("fila"),
                    rs.getString("asiento"),
                    rs.getDouble("precioOriginal"),
                    rs.getDouble("precioActual"),
                    rs.getString("nControl"),
                    rs.getString("estado")
                );
            }
        }
        return boleto;
    }
    
    public void actualizarBoleto(Boleto boleto) throws SQLException {
        String query = "UPDATE Boletos SET estado = ?, _evento = ?, fila = ?, asiento = ?, precioOriginal = ?, precioActual = ?, nControl = ? WHERE nSerie = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, boleto.getEstado());
            pstmt.setInt(2, boleto.getEventoId());
            pstmt.setString(3, boleto.getFila());
            pstmt.setString(4, boleto.getAsiento());
            pstmt.setDouble(5, boleto.getPrecioOriginal());
            pstmt.setDouble(6, boleto.getPrecioActual());
            pstmt.setString(7, boleto.getnControl());
            pstmt.setString(8, boleto.getnSerie());
            pstmt.executeUpdate();
        }
    }
}
