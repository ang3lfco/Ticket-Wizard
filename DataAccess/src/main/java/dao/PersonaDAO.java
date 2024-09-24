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
import models.Persona;

/**
 * Clase PersonaDAO la cual gestiona las operaciones CRUD de la entidad Persona en la base de datos.
 * @author martinez
 */
public class PersonaDAO {
    private Connection conexion;
    
    /**
     * Constructor que inicializa la conexion con la base de datos.
     * 
     * @throws SQLException Si ocurre un error al abrir la conexión.
     */
    public PersonaDAO() throws SQLException{
        this.conexion = mysqlConn.abrirConn();
    }
    
    public int Insertar(Persona persona) throws SQLException{
        String query = "INSERT INTO Personas (nombre, correo, domicilio, fecha_nacimiento, saldo, contraseña) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement pstm = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            pstm.setString(1, persona.getNombre());
            pstm.setString(2, persona.getCorreo());
            pstm.setString(3, persona.getDomicilio());
            pstm.setDate(4, new java.sql.Date(persona.getFechaNacimiento().getTime()));
            pstm.setDouble(5, persona.getSaldo());
            pstm.setString(6, persona.getContrasena());
            
            int affectedRows = pstm.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("Error al insertar Persona, no hubo filas creadas.");
            }
            else{
                try(ResultSet generatedKeys = pstm.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        return generatedKeys.getInt(1);
                    }
                    else{
                        throw new SQLException("Error al insertar Persona, no se obtuvo el ID. ");
                    }
                }
            }
        }
    }
    
    public Persona getPersonaPorId(int id) throws SQLException{
        Persona persona = null;
        String query = "SELECT * FROM Personas WHERE _id = ? limit 1";
        try(PreparedStatement pstm = conexion.prepareStatement(query)){
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                persona = new Persona(rs.getInt("_id"), 
                        rs.getString("nombre"), 
                        rs.getString("correo"), 
                        rs.getString("domicilio"), 
                        rs.getDate("fecha_nacimiento"), 
                        rs.getDouble("saldo"), 
                        rs.getString("contraseña"));
            }
        }
        return persona;
    }
}
