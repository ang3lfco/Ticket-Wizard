/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.IBoletoService;
import dao.BoletoDAO;
import dao.HistorialCompraVentasDAO;
import dao.TransaccionDAO;
import interfaces.IBoletoDAO;
import interfaces.IHistorialCompraVentasDAO;
import interfaces.ITransaccionDAO;
import java.sql.SQLException;
import java.util.List;
import models.Boleto;
import models.Transaccion;

/**
 *
 * @author martinez
 */
public class BoletoService implements IBoletoService{
    private final IBoletoDAO boletoDAO;
    private final ITransaccionDAO transaccionDAO;
    private final IHistorialCompraVentasDAO historialDAO;
    
    public BoletoService() throws SQLException {
        this.boletoDAO = new BoletoDAO();
        this.transaccionDAO = new TransaccionDAO();
        this.historialDAO = new HistorialCompraVentasDAO();
    }
    
    @Override
    public Boleto getBoletoPorId(int id) throws SQLException {
        return boletoDAO.getBoletoPorId(id);
    }
    
    @Override
    public List<Boleto> obtenerBoletosPorEvento(int idEvento) throws SQLException {
        return boletoDAO.getBoletosPorEvento(idEvento);
    }
    
    @Override
    public void comprarBoleto(String nSerie, int idComprador, int idVendedor, double monto, double comision) throws SQLException {
        Boleto boleto = boletoDAO.getBoletoPorSerie(nSerie);
        if (boleto != null && boleto.getEstado().equals("Disponible")) {
            boleto.setEstado("Apartado");
            boletoDAO.actualizarBoleto(boleto);
            Transaccion transaccion = new Transaccion(idComprador, idVendedor, monto, comision, new java.util.Date(), true, "Compra");            
            int idTransaccion = transaccionDAO.insertarTransaccion(transaccion);
            historialDAO.insertarHistorial(boleto.getId(), idTransaccion);
        } 
        else {
            throw new IllegalArgumentException("El boleto no esta disponible.");
        }
    }
    
    @Override
    public List<Boleto> getMisBoletos(int idUsuario) throws SQLException{
        return boletoDAO.getBoletosPorPersona(idUsuario);
    }
}
