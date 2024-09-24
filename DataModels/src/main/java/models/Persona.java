/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author martinez
 */
public class Persona {
    private int id;
    private String nombre;
    private String correo;
    private String domicilio;
    private Date fechaNacimiento;
    private Double saldo;
    private String contrasena;
    
    public Persona(){}
    
    public Persona(String nombre, String correo, String domicilio, Date fechaNacimiento, Double saldo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
        this.saldo = saldo;
        this.contrasena = contrasena;
    }

    public Persona(int id, String nombre, String correo, String domicilio, Date fechaNacimiento, Double saldo, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
        this.saldo = saldo;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", domicilio=" + domicilio + ", fechaNacimiento=" + fechaNacimiento + ", saldo=" + saldo + ", contrasena=" + contrasena + '}';
    }
}
