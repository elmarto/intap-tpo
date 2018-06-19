package com.uade.ejb.entities;

import javax.persistence.*;

//@Entity
//@Table(name = "servicios")
public class ServicioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	public String nombre;
	private TipoServicioEntity tipoServicio;
	
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
	public TipoServicioEntity getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(TipoServicioEntity tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	
}
