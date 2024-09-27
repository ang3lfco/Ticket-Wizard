/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;


import interfaces.IEventoService;
import dao.EventoDAO;
import interfaces.IEventoDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
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
    public int CrearEvento(String nombre, Date fecha, String venue, String ciudad, String estado, String descripcion, String imagenPath) throws SQLException {
        String regex = "^[a-zA-ZÀ-ÿ\\s]+$";
        if (nombre == null || nombre.trim().isEmpty() || !nombre.matches(regex)){
            JOptionPane.showMessageDialog(null, "Ingrese un nombre valido.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (venue == null || venue.trim().isEmpty() || !venue.matches(regex)){
            JOptionPane.showMessageDialog(null, "Ingrese un Venue valido.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (ciudad == null || ciudad.trim().isEmpty() || !ciudad.matches(regex)){
            JOptionPane.showMessageDialog(null, "Ingrese una ciudad valida.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (estado == null || estado.trim().isEmpty() || !estado.matches(regex)){
            JOptionPane.showMessageDialog(null, "Ingrese un Estado  valido.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (descripcion == null || descripcion.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese una descripcion valida.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            return eventoDAO.insertarEvento(nombre, fecha, venue, ciudad, estado, descripcion, imagenPath);
        }
        return 0;
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
