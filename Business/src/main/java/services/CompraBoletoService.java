/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.BoletoDAO;
import dao.HistorialCompraVentasDAO;
import dao.TransaccionDAO;
import java.sql.SQLException;
import models.Boleto;
import models.Transaccion;

/**
 *
 * @author martinez
 */
public class CompraBoletoService {
    private BoletoDAO boletoDAO;
    private TransaccionDAO transaccionDAO;
    private HistorialCompraVentasDAO historialDAO;

    public CompraBoletoService() throws SQLException {
        this.boletoDAO = new BoletoDAO();
        this.transaccionDAO = new TransaccionDAO();
        this.historialDAO = new HistorialCompraVentasDAO();
    }
    
    public void comprarBoleto(String nSerie, int idComprador, int idVendedor, double monto, double comision) throws SQLException {
        Boleto boleto = boletoDAO.getBoletoPorSerie(nSerie);
        if (boleto != null && boleto.getEstado().equals("Disponible")) {
            boleto.setEstado("Apartado");
            boletoDAO.actualizarBoleto(boleto);
            Transaccion transaccion = new Transaccion(idComprador, idVendedor, monto, comision, new java.util.Date(), true, "Compra");            
            int idTransaccion = transaccionDAO.insertarTransaccion(transaccion);
            historialDAO.insertarHistorial(boleto.getId(), idTransaccion);
        } else {
            throw new IllegalArgumentException("El boleto no esta disponible.");
        }
    }
}
