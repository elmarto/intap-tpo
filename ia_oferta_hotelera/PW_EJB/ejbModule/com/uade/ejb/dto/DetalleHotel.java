package com.uade.ejb.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DetalleHotel implements Serializable {

    private static final long serialVersionUID = 7721625493495033670L;

    private int codigo;
    private String destino;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    private Date fechaDesde;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    private Date fechaHasta;
    private int personas;
    private String nombreHotel;
    private String fotoHabitacion;
    private String descripcionHabitacion;
    private List<String> serviciosHotel;
    private List<String> serviciosHabitacion;
    private float precio;
    private String latitud;
    private String longitud;
    private String politicaCancelacion;
    private List<MedioPago> mediosPago;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public int getPersonas() {
        return personas;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getFotoHabitacion() {
        return fotoHabitacion;
    }

    public void setFotoHabitacion(String fotoHabitacion) {
        this.fotoHabitacion = fotoHabitacion;
    }

    public String getDescripcionHabitacion() {
        return descripcionHabitacion;
    }

    public void setDescripcionHabitacion(String descripcionHabitacion) {
        this.descripcionHabitacion = descripcionHabitacion;
    }

    public List<String> getServiciosHotel() {
        return serviciosHotel;
    }

    public void setServiciosHotel(List<String> serviciosHotel) {
        this.serviciosHotel = serviciosHotel;
    }

    public List<String> getServiciosHabitacion() {
        return serviciosHabitacion;
    }

    public void setServiciosHabitacion(List<String> serviciosHabitacion) {
        this.serviciosHabitacion = serviciosHabitacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getPoliticaCancelacion() {
        return politicaCancelacion;
    }

    public void setPoliticaCancelacion(String politicaCancelacion) {
        this.politicaCancelacion = politicaCancelacion;
    }

    public List<MedioPago> getMediosPago() {
        return mediosPago;
    }

    public void setMediosPago(List<MedioPago> mediosPago) {
        this.mediosPago = mediosPago;
    }
}
