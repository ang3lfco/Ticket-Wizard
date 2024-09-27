/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.sql.Date;
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
    int CrearEvento(String nombre, Date fecha, String venue, String ciudad, String estado, String descripcion, String imagenPath) throws SQLException;
}
