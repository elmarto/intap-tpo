package com.uade.ejb.mdb.messages;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;

public class OfertaPaqueteMessage {

    private int codigoPrestador;
    private String emailAgencia;
    private String destino;
    private String latitud;
    private String longitud;
    private String descripcion;
    private String foto;
    private List<String> servicios;
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

    public String getEmailAgencia() {
        return emailAgencia;
    }

    @JsonSetter("mail_agencia")
    public void setEmailAgencia(String emailAgencia) {
        this.emailAgencia = emailAgencia;
    }

    public String getDestino() {
        return destino;
    }

    @JsonSetter("destino")
    public void setDestino(String destino) {
        this.destino = destino;
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

    public String getDescripcion() {
        return descripcion;
    }

    @JsonSetter("descripcion_paquete")
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    @JsonSetter("foto_paquete")
    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<String> getServicios() {
        return servicios;
    }

    @JsonSetter("servicios_paquete")
    public void setServicios(List<String> servicios) {
        this.servicios = servicios;
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

    @JsonSetter("cantidad_personas_paquete")
    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public float getPrecio() {
        return precio;
    }

    @JsonSetter("precio")
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

    @JsonSetter("medio_pago_paquete")
    public void setMediosPago(List<Integer> mediosPago) {
        this.mediosPago = mediosPago;
    }

    public int getCupo() {
        return cupo;
    }

    @JsonSetter("cupo_paquete")
    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    @Override
    public String toString() {
        return "OfertaPaqueteMessage [codigoPrestador=" + codigoPrestador + ", emailAgencia=" + emailAgencia + ", destino=" + destino + ", latitud=" + latitud + ", longitud=" + longitud + ", descripcion=" + descripcion + ", foto=" + foto + ", servicios="
                + servicios + ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + ", cantidadPersonas=" + cantidadPersonas + ", precio=" + precio + ", politicaCancelacion=" + politicaCancelacion + ", mediosPago=" + mediosPago + ", cupo=" + cupo
                + "]";
    }
}
