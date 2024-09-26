/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import interfaces.IConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author martinez
 */
public class mysqlConn implements IConexion{
    private static final String URL = "jdbc:mysql://localhost:3306/ticketwizard";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql123";
    
    private static Connection conexion;
    
    @Override
    public Connection abrirConn() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new SQLException("Driver no encontrado.");
            }
        }
        return conexion;
    }
    
    @Override
    public void cerrarConn() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
