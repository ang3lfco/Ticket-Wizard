/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.ReventaDAO;
import interfaces.IReventaDAO;
import interfaces.IReventaService;
import java.sql.SQLException;
import java.util.List;
import models.Reventa;

/**
 *
 * @author martinez
 */
public class ReventaService implements IReventaService{
    private IReventaDAO reventaDAO;
    
    public ReventaService() throws SQLException{
        this.reventaDAO = new ReventaDAO();
    }
    
    @Override
    public int Revender(int _idBoleto, int _idVendedor) throws SQLException{
        return reventaDAO.InsertarReventa(_idBoleto, _idVendedor);
    }
    
    @Override
    public List<Reventa> getReventas() throws SQLException{
        return reventaDAO.getReventas();
    }
}
