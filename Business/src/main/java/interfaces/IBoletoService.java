/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;
import models.Boleto;

/**
 *
 * @author martinez
 */
public interface IBoletoService {
    Boleto getBoletoPorId(int id) throws SQLException;
    List<Boleto> obtenerBoletosPorEvento(int idEvento) throws SQLException;
    void comprarBoleto(String nSerie, int idComprador, int idVendedor, double monto, double comision) throws SQLException;
    List<Boleto> getMisBoletos(int idUsuario) throws SQLException;
}