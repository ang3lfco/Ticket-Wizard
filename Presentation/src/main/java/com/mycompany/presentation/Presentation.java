/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.presentation;

import java.sql.SQLException;
import ui.frmLogin;

/**
 *
 * @author martinez
 */
public class Presentation {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");
        frmLogin login = new frmLogin();
        login.setVisible(true);
    }
}
