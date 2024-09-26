/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.sql.SQLException;

/**
 *
 * @author martinez
 */
public interface IHistorialCompraVentasDAO {
    void insertarHistorial(int idBoleto, int idTransaccion) throws SQLException;
}
