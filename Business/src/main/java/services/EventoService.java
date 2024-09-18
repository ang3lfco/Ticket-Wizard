/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.EventoDAO;
import java.sql.SQLException;
import java.util.List;
import models.Evento;

/**
 *
 * @author martinez
 */
public class EventoService {
    private EventoDAO eventoDAO;

    public EventoService() throws SQLException {
        eventoDAO = new EventoDAO();
    }
    
    public List<Evento> obtenerTodosLosEventos() throws SQLException {
        return eventoDAO.obtenerTodosLosEventos();
    }

    public Evento obtenerEventoPorId(int id) throws SQLException {
        return eventoDAO.obtenerEventoPorId(id);
    }
}
