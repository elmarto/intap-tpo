package com.uade.ejb.backoffice;

import java.util.Date;

public class LogMessage {

    public int modulo;
    public int accion;
    public Long fecha;
    
    public LogMessage(int accion) {
    	this.modulo = 1;
    	this.fecha = new Date().getTime();
    	this.accion = accion;
    }
}
