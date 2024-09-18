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
import models.Transaccion;

/**
 *
 * @author martinez
 */
public class TransaccionDAO {
    private Connection connection;
    public TransaccionDAO() throws SQLException {
        this.connection = mysqlConn.abrirConn();
    }
    
    public int insertarTransaccion(Transaccion transaccion) throws SQLException {
        String query = "INSERT INTO Transacciones (_idComprador, _idVendedor, monto, comision, adquisicion, pagado, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, transaccion.getIdComprador());
            stmt.setInt(2, transaccion.getIdVendedor());
            stmt.setDouble(3, transaccion.getMonto());
            stmt.setDouble(4, transaccion.getComision());
            stmt.setTimestamp(5, new Timestamp(transaccion.getAdquisicion().getTime()));
            stmt.setBoolean(6, transaccion.isPagado());
            stmt.setString(7, transaccion.getTipo());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Error al insertar la transaccion, no se creo ninguna fila.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Error al insertar la transaccion, no se obtuvo el ID.");
                }
            }
        }
    }
}
