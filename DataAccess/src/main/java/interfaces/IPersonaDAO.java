/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.sql.SQLException;
import java.util.Date;
import models.Persona;

/**
 *
 * @author martinez
 */
public interface IPersonaDAO {
    int insertarPersona(String nombre, String correo, String domicilio, Date fechaNacimiento, double saldo, String contrasena) throws SQLException;
    Persona getPersonaPorId(int id) throws SQLException;
    boolean validarPersona(int id, String pass) throws SQLException;
}
