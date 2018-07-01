package com.uade.ejb.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.uade.ejb.dto.OfertaHoteleraDto;

@Entity
@Table(name = "ofertas")
public class OfertaHoteleraEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	public int id;
	public String nombre;
	public float precio;
	public int cupo;
	public String mediosDePago;
	public String tipoHabitacion;
	public Date fechaDesde;
	public Date fechaHasta;
	public String politicas;
	public String servicios;
	
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "establecimiento_id")
	public EstablecimientoEntity establecimiento;
	
	public OfertaHoteleraEntity(){}
	
	public OfertaHoteleraEntity(OfertaHoteleraDto ofertaDto)
	{
		this.nombre = ofertaDto.nombre;
		this.precio = ofertaDto.precio;
		this.cupo = ofertaDto.cupo;
		this.mediosDePago = ofertaDto.mediosDePago;
		this.tipoHabitacion = ofertaDto.tipoHabitacion;
		this.establecimiento = new EstablecimientoEntity(ofertaDto.establecimiento);
		this.fechaDesde = ofertaDto.fechaDesde;
		this.fechaHasta = ofertaDto.fechaHasta;
		this.politicas = ofertaDto.politicas;
		this.servicios = ofertaDto.servicios;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public String getMediosDePago() {
		return mediosDePago;
	}

	public void setMediosDePago(String mediosDePago) {
		this.mediosDePago = mediosDePago;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
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

	public String getPoliticas() {
		return politicas;
	}

	public void setPoliticas(String politicas) {
		this.politicas = politicas;
	}

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}
	
	public EstablecimientoEntity getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(EstablecimientoEntity establecimiento) {
		this.establecimiento = establecimiento;
	}

	public OfertaHoteleraDto getDto() {
		OfertaHoteleraDto oferta = new OfertaHoteleraDto();
		oferta.id = this.id;
		oferta.nombre = this.nombre;
		oferta.precio = this.precio;
		oferta.cupo = this.cupo;
		oferta.mediosDePago = this.mediosDePago;
		oferta.tipoHabitacion = this.tipoHabitacion;
		oferta.fechaDesde = this.fechaDesde;
		oferta.fechaHasta = this.fechaHasta;
		oferta.politicas = this.politicas;
		oferta.servicios = this.servicios;
		oferta.establecimiento = this.establecimiento.getDto();
		return oferta;
	}
}
