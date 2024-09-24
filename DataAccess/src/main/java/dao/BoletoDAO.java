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
import java.util.ArrayList;
import java.util.List;
import models.Boleto;

/**
 *
 * @author martinez
 */
public class BoletoDAO {
    private Connection conexion;
    
    public BoletoDAO() throws SQLException {
        this.conexion = mysqlConn.abrirConn();
    }
    
    public Boleto getBoletoPorId(int id) throws SQLException {
        Boleto boleto = null;
        String query = "SELECT * FROM Boletos WHERE _id = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                boleto = new Boleto(
                    rs.getInt("_id"),
                    rs.getString("nSerie"),
                    rs.getInt("_evento"),
                    rs.getString("fila"),
                    rs.getInt("asiento"),
                    rs.getDouble("precioOriginal"),
                    rs.getDouble("precioActual"),
                    rs.getString("nControl"),
                    rs.getString("estado")
                );
            }
        }
        return boleto;
    }
    
    public List<Boleto> obtenerBoletosPorEvento(int idEvento) throws SQLException {
        List<Boleto> boletos = new ArrayList<>();
        String sql = "SELECT * FROM Boletos WHERE _evento = ? AND estado = 'Disponible'";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idEvento);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Boleto boleto = new Boleto();
                    boleto.setId(resultSet.getInt("_id"));
                    boleto.setnSerie(resultSet.getString("nSerie"));
                    boleto.setEvento(resultSet.getInt("_evento"));
                    boleto.setFila(resultSet.getString("fila"));
                    boleto.setAsiento(resultSet.getInt("asiento"));
                    boleto.setPrecioOriginal(resultSet.getDouble("precioOriginal"));
                    boleto.setPrecioActual(resultSet.getDouble("precioActual"));
                    boleto.setnControl(resultSet.getString("nControl"));
                    boleto.setEstado(resultSet.getString("estado"));
                    boletos.add(boleto);
                }
            }
        }
        return boletos;
    }
    
    public Boleto getBoletoPorSerie(String nSerie) throws SQLException {
        Boleto boleto = null;
        String query = "SELECT * FROM Boletos WHERE nSerie = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, nSerie);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                boleto = new Boleto(
                        rs.getInt("_id"),
                        rs.getString("nSerie"),
                        rs.getInt("_evento"),
                        rs.getString("fila"),
                        rs.getInt("asiento"),
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
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, boleto.getEstado());
            pstmt.setInt(2, boleto.getEvento());
            pstmt.setString(3, boleto.getFila());
            pstmt.setInt(4, boleto.getAsiento());
            pstmt.setDouble(5, boleto.getPrecioOriginal());
            pstmt.setDouble(6, boleto.getPrecioActual());
            pstmt.setString(7, boleto.getnControl());
            pstmt.setString(8, boleto.getnSerie());
            pstmt.executeUpdate();
        }
    }
    
    public List<Boleto> getBoletosPorPersona(int idUsuario) throws SQLException{
        List<Boleto> boletos = new ArrayList<>();
        
        String sql = "SELECT b._id, b.nSerie, b._evento, b.fila, b.asiento, b.precioOriginal, b.precioActual, b.nControl, b.estado, t.adquisicion " +
                 "FROM Boletos b " +
                 "JOIN HistorialCompraVentas hcv ON b._id = hcv._boleto " +
                 "JOIN Transacciones t ON hcv._transaccion = t._id " +
                 "WHERE t._idComprador = ? " +
                 "AND t.adquisicion = ( " +
                 "    SELECT MAX(t2.adquisicion) " +
                 "    FROM Transacciones t2 " +
                 "    JOIN HistorialCompraVentas hcv2 ON t2._id = hcv2._transaccion " +
                 "    WHERE hcv2._boleto = b._id " +
                 ") " +
                 "ORDER BY t.adquisicion DESC";
        
        try(PreparedStatement pstm = conexion.prepareStatement(sql)){
            pstm.setInt(1, idUsuario);
            
            try(ResultSet rs = pstm.executeQuery()){
                while(rs.next()){
                    Boleto boleto = new Boleto();
                    boleto.setId(rs.getInt("_id"));
                    boleto.setnSerie(rs.getString("nSerie"));
                    boleto.setEvento(rs.getInt("_evento"));
                    boleto.setFila(rs.getString("fila"));
                    boleto.setAsiento(rs.getInt("asiento"));
                    boleto.setPrecioOriginal(rs.getDouble("precioOriginal"));
                    boleto.setPrecioActual(rs.getDouble("precioActual"));
                    boleto.setnControl(rs.getString("nControl"));
                    boleto.setEstado(rs.getString("estado"));
                    
                    boletos.add(boleto);
                }
            }
        }
        return boletos;
    }
}
