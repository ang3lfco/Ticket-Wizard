/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author martinez
 */
public class Reventa {
    private int _id;
    private int _idBoleto;
    private int _idVendedor;
    
    public Reventa(){}
    
    public Reventa(int _idBoleto, int _idVendedor){
        this._idBoleto = _idBoleto;
        this._idVendedor = _idVendedor;
    }
    
    public Reventa(int _id, int _idBoleto, int _idVendedor){
        this._id = _id;
        this._idBoleto = _idBoleto;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getIdBoleto() {
        return _idBoleto;
    }

    public void setIdBoleto(int _idBoleto) {
        this._idBoleto = _idBoleto;
    }

    public int getIdVendedor() {
        return _idVendedor;
    }

    public void setIdVendedor(int _idVendedor) {
        this._idVendedor = _idVendedor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this._id;
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
        final Reventa other = (Reventa) obj;
        return this._id == other._id;
    }

    @Override
    public String toString() {
        return "Reventa{" + "_id=" + _id + ", _idBoleto=" + _idBoleto + ", _idVendedor=" + _idVendedor + '}';
    }
}