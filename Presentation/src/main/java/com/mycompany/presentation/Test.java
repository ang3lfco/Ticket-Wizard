/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.presentation;

import dao.BoletoDAO;
import dao.HistorialCompraVentasDAO;
import dao.TransaccionDAO;
import java.sql.SQLException;
import services.BoletoService;

/**
 *
 * @author martinez
 */
public class Test {
    public static void main(String[] args) {
        try {
            BoletoDAO boletoDAO = new BoletoDAO();
            TransaccionDAO transaccionDAO = new TransaccionDAO();
            HistorialCompraVentasDAO historialDAO = new HistorialCompraVentasDAO();
            BoletoService compraBoletoService = new BoletoService();

            // Parámetros de ejemplo
            String numeroSerie = "A1B2C3D1"; 
            int idComprador = 1; 
            int idVendedor = 2; 
            double monto = 500.00;
            double comision = 50.00;

            try {
                compraBoletoService.comprarBoleto(numeroSerie, idComprador, idVendedor, monto, comision);
                System.out.println("Compra realizada con exito.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }
}
