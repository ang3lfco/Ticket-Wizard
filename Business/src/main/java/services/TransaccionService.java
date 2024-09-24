/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.TransaccionDAO;
import java.sql.SQLException;
import java.util.List;
import models.Transaccion;

/**
 *
 * @author martinez
 */
public class TransaccionService {
    private TransaccionDAO transaccionDAO;
    
    public TransaccionService() throws SQLException{
        this.transaccionDAO = new TransaccionDAO();
    }
    
    public List<Transaccion> getHistorial(int idUsuario) throws SQLException{
        return transaccionDAO.getHistorialPorPersona(idUsuario);
    }
}
