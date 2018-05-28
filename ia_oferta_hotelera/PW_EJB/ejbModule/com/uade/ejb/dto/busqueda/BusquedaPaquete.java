package com.uade.ejb.dto.busqueda;

import java.io.Serializable;
import java.util.Date;

public class BusquedaPaquete implements Serializable {

    private static final long serialVersionUID = 4891493174231656202L;

    private String destino;
    private Date fechaSalidaDesde;
    private Date fechaSalidaHasta;
    private int personas;

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalidaDesde() {
        return fechaSalidaDesde;
    }

    public void setFechaSalidaDesde(Date fechaSalidaDesde) {
        this.fechaSalidaDesde = fechaSalidaDesde;
    }

    public Date getFechaSalidaHasta() {
        return fechaSalidaHasta;
    }

    public void setFechaSalidaHasta(Date fechaSalidaHasta) {
        this.fechaSalidaHasta = fechaSalidaHasta;
    }

    public int getPersonas() {
        return personas;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }
}
