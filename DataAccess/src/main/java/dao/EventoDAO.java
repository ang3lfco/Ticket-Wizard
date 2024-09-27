/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.mysqlConn;
import interfaces.IEventoDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Evento;

/**
 *
 * @author martinez
 */
public class EventoDAO implements IEventoDAO{
    private mysqlConn mysqlConn;
    private Connection conexion;

    public EventoDAO() throws SQLException {
        this.mysqlConn = new mysqlConn();
        this.conexion = mysqlConn.abrirConn();
    }
    
    @Override
    public int insertarEvento(String nombre, Date fecha, String venue, String ciudad, String estado, String descripcion, String imagenPath) throws SQLException{
        Evento evento = new Evento(nombre, fecha, venue, ciudad, estado, descripcion, imagenPath);
        String query = "INSERT INTO Eventos (nombre, fecha, venue, ciudad, estado, descripcion, imagenPath) VALUES (?,?,?,?,?,?,?)";
        try(PreparedStatement pstm = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            pstm.setString(1, evento.getNombre());
            pstm.setDate(2, (Date) evento.getFecha());
            pstm.setString(3, evento.getVenue());
            pstm.setString(4, evento.getCiudad());
            pstm.setString(5, evento.getEstado());
            pstm.setString(6, evento.getDescripcion());
            pstm.setString(7, evento.getImagenPath());
            
            int affectedRows = pstm.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("Error al insertar Evento, no hubo filas creadas.");
            }
            else{
                try(ResultSet generatedKeys = pstm.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        return generatedKeys.getInt(1);
                    }
                    else{
                        throw new SQLException("Error al insertar Evento, no se obtuvo el ID.");
                    }
                }
            }
        }
    }
    
    @Override
    public List<Evento> getEventos() throws SQLException {
        List<Evento> eventos = new ArrayList<>();
        String query = "SELECT * FROM Eventos";
        
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
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
    
    @Override
    public Evento getEventoPorId(int id) throws SQLException {
        Evento evento = null;
        String query = "SELECT * FROM Eventos WHERE _id = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
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
