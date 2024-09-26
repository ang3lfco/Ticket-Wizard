/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;
import models.Transaccion;

/**
 *
 * @author martinez
 */
public interface ITransaccionService {
    List<Transaccion> getHistorial(int idUsuario) throws SQLException;
}
