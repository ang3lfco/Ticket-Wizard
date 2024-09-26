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
public interface IBoletoDAO {
    Boleto getBoletoPorId(int id) throws SQLException;
    List<Boleto> getBoletosPorEvento(int idEvento) throws SQLException;
    Boleto getBoletoPorSerie(String nSerie) throws SQLException;
    void actualizarBoleto(Boleto boleto) throws SQLException;
    List<Boleto> getBoletosPorPersona(int idUsuario) throws SQLException;
}