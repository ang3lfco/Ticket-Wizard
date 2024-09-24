/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.PersonaDAO;
import java.sql.SQLException;
import java.util.Date;
import models.Persona;

/**
 *
 * @author martinez
 */
public class PersonaService {
    private PersonaDAO personaDAO;
    
    public PersonaService() throws SQLException{
        this.personaDAO = new PersonaDAO();
    }
    
    public void Registrar(String nombre, String correo, String domicilio, Date fechaNacimiento, double saldo, String contrasena) throws SQLException{
        Persona persona = new Persona(nombre, correo, domicilio, fechaNacimiento, saldo, contrasena);
        int idGenerado = personaDAO.Insertar(persona);
        System.out.println("ID Generado: " + idGenerado);
    }
    
    public Persona getInformacion(int id) throws SQLException{
        return personaDAO.getPersonaPorId(id);
    }
}
