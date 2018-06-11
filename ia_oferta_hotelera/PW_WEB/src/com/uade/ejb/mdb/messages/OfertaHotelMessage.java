package com.uade.ejb.mdb.messages;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;

public class OfertaHotelMessage {

    private int codigoPrestador;
    private String destino;
    private String nombreHotel;
    private String descripcionHotel;
    private String fotoHotel;
    private List<String> serviciosHotel;
    private String emailHotel;
    private String latitud;
    private String longitud;
    private String descripcionHabitacion;
    private String fotoHabitacion;
    private List<String> serviciosHabitacion;
    private String fechaDesde;
    private String fechaHasta;
    private int cantidadPersonas;
    private float precio;
    private String politicaCancelacion;
    private List<Integer> mediosPago;
    private int cupo;

    public int getCodigoPrestador() {
        return codigoPrestador;
    }

    @JsonSetter("codigo_prestador")
    public void setCodigoPrestador(int codigoPrestador) {
        this.codigoPrestador = codigoPrestador;
    }

    public String getDestino() {
        return destino;
    }

    @JsonSetter("destino")
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    @JsonSetter("nombre")
    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getDescripcionHotel() {
        return descripcionHotel;
    }

    @JsonSetter("descripcion_hotel")
    public void setDescripcionHotel(String descripcionHotel) {
        this.descripcionHotel = descripcionHotel;
    }

    public String getFotoHotel() {
        return fotoHotel;
    }

    @JsonSetter("foto_hotel")
    public void setFotoHotel(String fotoHotel) {
        this.fotoHotel = fotoHotel;
    }

    public List<String> getServiciosHotel() {
        return serviciosHotel;
    }

    @JsonSetter("lista_servicios")
    public void setServiciosHotel(List<String> serviciosHotel) {
        this.serviciosHotel = serviciosHotel;
    }

    public String getEmailHotel() {
        return emailHotel;
    }

    @JsonSetter("email_hotel")
    public void setEmailHotel(String emailHotel) {
        this.emailHotel = emailHotel;
    }

    public String getLatitud() {
        return latitud;
    }

    @JsonSetter("latitud")
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    @JsonSetter("longitud")
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDescripcionHabitacion() {
        return descripcionHabitacion;
    }

    @JsonSetter("descripcion_habitacion")
    public void setDescripcionHabitacion(String descripcionHabitacion) {
        this.descripcionHabitacion = descripcionHabitacion;
    }

    public String getFotoHabitacion() {
        return fotoHabitacion;
    }

    @JsonSetter("foto_habitacion")
    public void setFotoHabitacion(String fotoHabitacion) {
        this.fotoHabitacion = fotoHabitacion;
    }

    public List<String> getServiciosHabitacion() {
        return serviciosHabitacion;
    }

    @JsonSetter("lista_servicios_habitacion")
    public void setServiciosHabitacion(List<String> serviciosHabitacion) {
        this.serviciosHabitacion = serviciosHabitacion;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    @JsonSetter("fecha_desde")
    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    @JsonSetter("fecha_hasta")
    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    @JsonSetter("cantidad_personas")
    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public float getPrecio() {
        return precio;
    }

    @JsonSetter("precio_habitacion")
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getPoliticaCancelacion() {
        return politicaCancelacion;
    }

    @JsonSetter("politica_cancelacion")
    public void setPoliticaCancelacion(String politicaCancelacion) {
        this.politicaCancelacion = politicaCancelacion;
    }

    public List<Integer> getMediosPago() {
        return mediosPago;
    }

    @JsonSetter("medio_pago_hotel")
    public void setMediosPago(List<Integer> mediosPago) {
        this.mediosPago = mediosPago;
    }

    public int getCupo() {
        return cupo;
    }

    @JsonSetter("cupo")
    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    @Override
    public String toString() {
        return "OfertaHotelMessage [codigoPrestador=" + codigoPrestador + ", destino=" + destino + ", nombreHotel=" + nombreHotel + ", descripcionHotel=" + descripcionHotel + ", fotoHotel=" + fotoHotel + ", serviciosHotel=" + serviciosHotel
                + ", emailHotel=" + emailHotel + ", latitud=" + latitud + ", longitud=" + longitud + ", descripcionHabitacion=" + descripcionHabitacion + ", fotoHabitacion=" + fotoHabitacion + ", serviciosHabitacion=" + serviciosHabitacion
                + ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + ", cantidadPersonas=" + cantidadPersonas + ", precio=" + precio + ", politicaCancelacion=" + politicaCancelacion + ", mediosPago=" + mediosPago + ", cupo=" + cupo + "]";
    }
}
