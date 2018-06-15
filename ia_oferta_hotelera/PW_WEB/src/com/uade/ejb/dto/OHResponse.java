package com.uade.ejb.dto;

public class OHResponse {
    private boolean estado;
    private Object respuesta;

    public OHResponse(boolean estado, Object respuesta) {
        this.estado = estado;
        this.respuesta = respuesta;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Object getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Object respuesta) {
        this.respuesta = respuesta;
    }
}
