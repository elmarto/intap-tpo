package test.backoffice;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Log {
    private String plataformaEnvia;
    private String plataformaRecibe;
    private String servicio;
    private String observacion;

    public Log(String plataformaEnvia, String plataformaRecibe, String servicio, String observacion) {
        super();
        this.plataformaEnvia = plataformaEnvia;
        this.plataformaRecibe = plataformaRecibe;
        this.servicio = servicio;
        this.observacion = observacion;
    }

    public String getPlataformaEnvia() {
        return plataformaEnvia;
    }

    @JsonSetter("plataformaEnvia")
    public void setPlataformaEnvia(String plataformaEnvia) {
        this.plataformaEnvia = plataformaEnvia;
    }

    public String getPlataformaRecibe() {
        return plataformaRecibe;
    }

    @JsonSetter("plataformaRecibe")
    public void setPlataformaRecibe(String plataformaRecibe) {
        this.plataformaRecibe = plataformaRecibe;
    }

    public String getServicio() {
        return servicio;
    }

    @JsonSetter("servicio")
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getObservacion() {
        return observacion;
    }

    @JsonSetter("observacion")
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}