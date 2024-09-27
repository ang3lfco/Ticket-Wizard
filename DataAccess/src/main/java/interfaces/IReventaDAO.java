/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;
import models.Reventa;

/**
 *
 * @author martinez
 */
public interface IReventaDAO {
    int InsertarReventa(int _idBoleto, int _idVendedor) throws SQLException;
    List<Reventa> getReventas() throws SQLException;
}
