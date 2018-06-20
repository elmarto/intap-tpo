package com.uade.ejb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.uade.ejb.dto.CiudadDto;

@Entity
@Table(name = "ciudades")
public class CiudadEntity {
	@Id
	private int id;
	private String nombre;
	
	public CiudadEntity() {}
	
	public CiudadEntity(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	public CiudadEntity(CiudadDto ciudad) {
		this.id = ciudad.id;
		this.nombre = ciudad.nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public CiudadDto getDto() {
		CiudadDto dto = new CiudadDto();
		dto.id = this.id;
		dto.nombre = this.nombre;
		return dto;
	}
}
