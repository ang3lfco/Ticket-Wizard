/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;


import interfaces.IEventoService;
import dao.EventoDAO;
import interfaces.IEventoDAO;
import java.sql.SQLException;
import java.util.List;
import models.Evento;

/**
 *
 * @author martinez
 */
public class EventoService implements IEventoService{
    private final IEventoDAO eventoDAO;

    public EventoService() throws SQLException {
        this.eventoDAO = new EventoDAO();
    }
    
    @Override
    public int CrearEvento(Evento evento) throws SQLException{
        return eventoDAO.insertarEvento(evento);
    }
    
    @Override
    public List<Evento> getTodosLosEventos() throws SQLException {
        return eventoDAO.getEventos();
    }
    
    @Override
    public Evento getEventoPorId(int id) throws SQLException {
        return eventoDAO.getEventoPorId(id);
    }
}
