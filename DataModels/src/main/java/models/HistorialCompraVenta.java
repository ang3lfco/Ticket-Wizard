/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author martinez
 */
public class HistorialCompraVenta {
    private int id;
    private int boletoId;
    private int transaccionId;

    public HistorialCompraVenta(int id, int boletoId, int transaccionId) {
        this.id = id;
        this.boletoId = boletoId;
        this.transaccionId = transaccionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoletoId() {
        return boletoId;
    }

    public void setBoletoId(int boletoId) {
        this.boletoId = boletoId;
    }

    public int getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(int transaccionId) {
        this.transaccionId = transaccionId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.id;
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
        final HistorialCompraVenta other = (HistorialCompraVenta) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "HistorialCompraVenta{" + "id=" + id + ", boletoId=" + boletoId + ", transaccionId=" + transaccionId + '}';
    }
}
