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
import models.Evento;

/**
 *
 * @author martinez
 */
public class EventoDAO {
    private Connection connection;

    public EventoDAO() throws SQLException {
        connection = mysqlConn.abrirConn();
    }
    
    public List<Evento> obtenerTodosLosEventos() throws SQLException {
        List<Evento> eventos = new ArrayList<>();
        String query = "SELECT * FROM Eventos";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Evento evento = new Evento();
                evento.setId(rs.getInt("_id"));
                evento.setNombre(rs.getString("nombre"));
                evento.setFecha(rs.getDate("fecha"));
                evento.setVenue(rs.getString("venue"));
                evento.setCiudad(rs.getString("ciudad"));
                evento.setEstado(rs.getString("estado"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setImagenPath(rs.getString("imagenPath"));
                eventos.add(evento);
            }
        }
        catch (SQLException e) {
            throw new SQLException("Error al obtener los eventos: " + e.getMessage());
        }
        return eventos;
    }
    
    public Evento obtenerEventoPorId(int id) throws SQLException {
        Evento evento = null;
        String query = "SELECT * FROM Eventos WHERE _id = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                evento = new Evento();
                evento.setId(rs.getInt("_id"));
                evento.setNombre(rs.getString("nombre"));
                evento.setFecha(rs.getDate("fecha"));
                evento.setVenue(rs.getString("venue"));
                evento.setCiudad(rs.getString("ciudad"));
                evento.setEstado(rs.getString("estado"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setImagenPath(rs.getString("imagenPath"));
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener el evento: " + e.getMessage());
        }
        
        return evento;
    }
}
