/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;
import models.Evento;

/**
 *
 * @author martinez
 */
public interface IEventoService {
    List<Evento> getTodosLosEventos() throws SQLException;
    Evento getEventoPorId(int id) throws SQLException;
    int CrearEvento(Evento evento) throws SQLException;
}
