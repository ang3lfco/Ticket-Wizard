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
public interface IEventoDAO {
    List<Evento> getEventos() throws SQLException;
    Evento getEventoPorId(int id) throws SQLException;
    int insertarEvento(Evento evento) throws SQLException;
}
