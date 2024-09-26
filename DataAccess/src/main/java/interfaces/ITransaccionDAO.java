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
public interface ITransaccionDAO {
    int insertarTransaccion(Transaccion transaccion) throws SQLException;
    List<Transaccion> getHistorialPorPersona(int idUsuario) throws SQLException;
}
