/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.ITransaccionService;
import dao.TransaccionDAO;
import interfaces.ITransaccionDAO;
import java.sql.SQLException;
import java.util.List;
import models.Transaccion;

/**
 *
 * @author martinez
 */
public class TransaccionService implements ITransaccionService{
    private final ITransaccionDAO transaccionDAO;
    
    public TransaccionService() throws SQLException{
        this.transaccionDAO = new TransaccionDAO();
    }
    
    @Override
    public List<Transaccion> getHistorial(int idUsuario) throws SQLException{
        return transaccionDAO.getHistorialPorPersona(idUsuario);
    }
}
