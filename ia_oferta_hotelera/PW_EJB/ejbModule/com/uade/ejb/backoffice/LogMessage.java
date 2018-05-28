package com.uade.ejb.backoffice;

public class LogMessage {

    private String plataformaEnvia;
    private String plataformaRecibe;
    private String servicio;
    private String observacion;

    public String getPlataformaEnvia() {
        return plataformaEnvia;
    }

    public void setPlataformaEnvia(String plataformaEnvia) {
        this.plataformaEnvia = plataformaEnvia;
    }

    public String getPlataformaRecibe() {
        return plataformaRecibe;
    }

    public void setPlataformaRecibe(String plataformaRecibe) {
        this.plataformaRecibe = plataformaRecibe;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
