/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.IPersonaService;
import dao.PersonaDAO;
import interfaces.IPersonaDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
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
    public void Registrar(String nombre, String correo, String domicilio, Date fechaNacimiento, double saldo, String contrasena) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaStr = sdf.format(fechaNacimiento);
        
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (correo == null || !correo.matches("^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$") || correo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El correo debe ser un formato valido.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (domicilio == null || domicilio.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El domicilio no puede estar vacio.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (fechaNacimiento == null || fechaNacimiento.after(new Date()) || !fechaStr.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha de nacimiento valida.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (saldo < 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un saldo valido.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (contrasena == null || contrasena.length() < 6) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 6 caracteres.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            int idGenerado = personaDAO.insertarPersona(nombre, correo, domicilio, fechaNacimiento, saldo, contrasena);
        }
    }
    
    @Override
    public Persona getInformacion(int id) throws SQLException{
        return personaDAO.getPersonaPorId(id);
    }
    
    @Override
    public boolean Auth(int id, String pass) throws SQLException{
        if (id <= 0) {
        JOptionPane.showMessageDialog(null, "Ingrese un ID valido.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
        return false;
        }

        if (pass == null || pass.trim().isEmpty() || pass.length() < 6) {
            JOptionPane.showMessageDialog(null, "Ingrese una contraseña valida.", "Negocio:Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return personaDAO.validarPersona(id, pass);
    }
}