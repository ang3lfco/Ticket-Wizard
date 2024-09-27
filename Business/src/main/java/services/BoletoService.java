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
import javax.swing.JOptionPane;
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
    public int añadirBoleto(String nSerie, int _evento, String fila, int asiento, Double precioOriginal, Double precioActual, String nControl, String estado) throws SQLException {
        if (!nSerie.matches("^[a-zA-Z0-9]{4,}$") || !nControl.matches("^[a-zA-Z0-9]{4,}$") || nSerie.trim().isEmpty() || nControl.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El número de serie y de control solo debe contener letras, numeros, no espacios y al menos 4 caracteres.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else if (fila == null || fila.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una fila valida.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else if (asiento <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un asiento valido.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else if (precioOriginal == null || precioOriginal <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un precio valido.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else{
            return boletoDAO.InsertarBoleto(nSerie, _evento, fila, asiento, precioOriginal, precioActual, nControl, estado);
        }
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
        boletoDAO.comprarBoleto(nSerie, idComprador, idVendedor, monto, comision);
    }
    
    @Override
    public List<Boleto> getMisBoletos(int idUsuario) throws SQLException{
        return boletoDAO.getBoletosPorPersona(idUsuario);
    }
}
