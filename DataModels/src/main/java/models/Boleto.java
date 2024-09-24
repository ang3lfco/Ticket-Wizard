/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author martinez
 */
public class Boleto {
    private int id;
    private String nSerie;
    private int _evento;
    private String fila;
    private int asiento;
    private Double precioOriginal;
    private Double precioActual;
    private String nControl;
    private String estado; // 'Disponible' o 'Apartado'

    public Boleto() {}
 
    public Boleto(int id, String nSerie, int _evento, String fila, int asiento, Double precioOriginal, Double precioActual, String nControl, String estado) {
        this.id = id;
        this.nSerie = nSerie;
        this._evento = _evento;
        this.fila = fila;
        this.asiento = asiento;
        this.precioOriginal = precioOriginal;
        this.precioActual = precioActual;
        this.nControl = nControl;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnSerie() {
        return nSerie;
    }

    public void setnSerie(String nSerie) {
        this.nSerie = nSerie;
    }

    public int getEvento() {
        return _evento;
    }

    public void setEvento(int _evento) {
        this._evento = _evento;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public Double getPrecioOriginal() {
        return precioOriginal;
    }

    public void setPrecioOriginal(Double precioOriginal) {
        this.precioOriginal = precioOriginal;
    }

    public Double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(Double precioActual) {
        this.precioActual = precioActual;
    }

    public String getnControl() {
        return nControl;
    }

    public void setnControl(String nControl) {
        this.nControl = nControl;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
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
        final Boleto other = (Boleto) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Boleto{" + "id=" + id + ", nSerie=" + nSerie + ", eventoId=" + _evento + ", fila=" + fila + ", asiento=" + asiento + ", precioOriginal=" + precioOriginal + ", precioActual=" + precioActual + ", nControl=" + nControl + ", estado=" + estado + '}';
    }
}
