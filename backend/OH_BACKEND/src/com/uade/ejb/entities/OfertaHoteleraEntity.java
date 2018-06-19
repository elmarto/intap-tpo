package com.uade.ejb.entities;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.uade.ejb.dto.OfertaHoteleraDto;

//@Entity
//@Table(name = "ofertas_hoteleras")
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
	//public EstablishmentEntity establecimiento;
	public Date fechaDesde;
	public Date fechaHasta;
	public String politicas;
	public String servicios;
	
	public OfertaHoteleraEntity(OfertaHoteleraDto ofertaDto)
	{
		this.nombre = ofertaDto.nombre;
		this.precio = ofertaDto.precio;
		this.cupo = ofertaDto.cupo;
		this.mediosDePago = ofertaDto.mediosDePago;
		this.tipoHabitacion = ofertaDto.tipoHabitacion;
		//this.establecimiento = ofertaDto.establecimiento;
		this.fechaDesde = ofertaDto.fechaDesde;
		this.fechaHasta = ofertaDto.fechaHasta;
		this.politicas = ofertaDto.politicas;
		this.servicios = ofertaDto.servicios;
	}
	
//	public String getServicesString() {
//		String result = "";
//		for (Iterator<OfferServiceEntity> i = this.service.iterator(); i.hasNext();) {
//			OfferServiceEntity item = i.next();
//			result = result + " " + item.serviceName;
//		}
//		
//		return result;
//	}
	
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

	public OfertaHoteleraDto getDto() {
		OfertaHoteleraDto oferta = new OfertaHoteleraDto();
		oferta.nombre = this.nombre;
		oferta.cupo = this.cupo;
		// completar campos
		return oferta;
	}
}
