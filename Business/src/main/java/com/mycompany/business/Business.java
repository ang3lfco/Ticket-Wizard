/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.business;

import java.sql.SQLException;
import java.util.Date;
import services.PersonaService;

/**
 *
 * @author martinez
 */
public class Business {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");
        PersonaService ps = new PersonaService();
        ps.Registrar("testing", "testing3@example.com", "Av. Testing 234, Test", java.sql.Date.valueOf("1992-07-23"), 345.00, "testing123");
    }
}
