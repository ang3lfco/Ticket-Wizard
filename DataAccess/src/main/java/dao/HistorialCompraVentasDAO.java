/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.mysqlConn;
import interfaces.IHistorialCompraVentasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author martinez
 */
public class HistorialCompraVentasDAO implements IHistorialCompraVentasDAO{
    private mysqlConn mysqlConn;
    private Connection conexion;

    public HistorialCompraVentasDAO() throws SQLException {
        this.mysqlConn = new mysqlConn();
        this.conexion = mysqlConn.abrirConn();
    }
    
    @Override
    public void insertarHistorial(int idBoleto, int idTransaccion) throws SQLException {
        String query = "INSERT INTO HistorialCompraVentas (_boleto, _transaccion) VALUES (?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, idBoleto);
            pstmt.setInt(2, idTransaccion);
            pstmt.executeUpdate();
        }
    }
}
