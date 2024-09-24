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
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import models.Transaccion;

/**
 *
 * @author martinez
 */
public class TransaccionDAO {
    private Connection conexion;
    
    public TransaccionDAO() throws SQLException {
        this.conexion = mysqlConn.abrirConn();
    }
    
    public int insertarTransaccion(Transaccion transaccion) throws SQLException {
        String query = "INSERT INTO Transacciones (_idComprador, _idVendedor, monto, comision, adquisicion, pagado, tipo) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, transaccion.getIdComprador());
            stmt.setInt(2, transaccion.getIdVendedor());
            stmt.setDouble(3, transaccion.getMonto());
            stmt.setDouble(4, transaccion.getComision());
            stmt.setTimestamp(5, new Timestamp(transaccion.getAdquisicion().getTime()));
            stmt.setBoolean(6, transaccion.isPagado());
            stmt.setString(7, transaccion.getTipo());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Error al insertar Transaccion, no hubo filas creadas.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()){
                    return generatedKeys.getInt(1);
                } 
                else {
                    throw new SQLException("Error al insertar Transaccion, no se obtuvo el ID.");
                }
            }
        }
    }
    
    public List<Transaccion> getHistorialPorPersona(int idUsuario) throws SQLException{
        List<Transaccion> historialTransacciones = new ArrayList<>();
        String query = "SELECT * FROM Transacciones WHERE _idComprador = ?";
        try(PreparedStatement pstm = conexion.prepareStatement(query)){
            pstm.setInt(1, idUsuario);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Transaccion transaccion = new Transaccion(
                        rs.getInt("_id"),
                        rs.getInt("_idComprador"),
                        rs.getInt("_idVendedor"),
                        rs.getDouble("monto"),
                        rs.getDouble("comision"),
                        new java.util.Date(rs.getTimestamp("adquisicion").getTime()),
                        rs.getBoolean("pagado"),
                        rs.getString("tipo")
                );
                historialTransacciones.add(transaccion);
            }
        }
        return historialTransacciones;
    }
}
