/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Interfaces.IPersonaService;
import dao.PersonaDAO;
import interfaces.IPersonaDAO;
import java.sql.SQLException;
import java.util.Date;
import models.Persona;

/**
 *
 * @author martinez
 */
public class PersonaService implements IPersonaService{
    private final IPersonaDAO personaDAO;
    
    public PersonaService() throws SQLException{
        this.personaDAO = new PersonaDAO();
    }
    
    @Override
    public void Registrar(String nombre, String correo, String domicilio, Date fechaNacimiento, double saldo, String contrasena) throws SQLException{
        Persona persona = new Persona(nombre, correo, domicilio, fechaNacimiento, saldo, contrasena);
        int idGenerado = personaDAO.insertarPersona(persona);
        System.out.println("ID Generado: " + idGenerado);
    }
    
    @Override
    public Persona getInformacion(int id) throws SQLException{
        return personaDAO.getPersonaPorId(id);
    }
    
    @Override
    public boolean Auth(int id, String pass) throws SQLException{
        return personaDAO.validarPersona(id, pass);
    }
}