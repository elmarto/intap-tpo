package com.uade.ejb.dto.reserva;

import java.io.Serializable;

public class ReservaPaquete implements Serializable {

    private static final long serialVersionUID = -554477243070739909L;

    private int idOferta;
    private int cantidad;
    private int medioPago;
    private String mail;

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(int medioPago) {
        this.medioPago = medioPago;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
