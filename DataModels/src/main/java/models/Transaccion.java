/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author martinez
 */
public class Transaccion {
    private int id;
    private int idComprador;
    private int idVendedor;
    private Double monto;
    private Double comision;
    private Date adquisicion;
    private boolean pagado;
    private String tipo; // 'Compra' o 'Reventa'

    public Transaccion(){}
    
    public Transaccion(int idComprador, int idVendedor, Double monto, Double comision, Date adquisicion, boolean pagado, String tipo) {
        this.idComprador = idComprador;
        this.idVendedor = idVendedor;
        this.monto = monto;
        this.comision = comision;
        this.adquisicion = adquisicion;
        this.pagado = pagado;
        this.tipo = tipo;
    }

    public Transaccion(int id, int idComprador, int idVendedor, Double monto, Double comision, Date adquisicion, boolean pagado, String tipo) {
        this.id = id;
        this.idComprador = idComprador;
        this.idVendedor = idVendedor;
        this.monto = monto;
        this.comision = comision;
        this.adquisicion = adquisicion;
        this.pagado = pagado;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Date getAdquisicion() {
        return adquisicion;
    }

    public void setAdquisicion(Date adquisicion) {
        this.adquisicion = adquisicion;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
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
        final Transaccion other = (Transaccion) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "id=" + id + ", idComprador=" + idComprador + ", idVendedor=" + idVendedor + ", monto=" + monto + ", comision=" + comision + ", adquisicion=" + adquisicion + ", pagado=" + pagado + ", tipo=" + tipo + '}';
    }
}
