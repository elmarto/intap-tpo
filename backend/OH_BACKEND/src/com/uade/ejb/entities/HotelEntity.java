package com.uade.ejb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.uade.ejb.dto.HotelDto;

@Entity
@Table(name = "hotel")
public class HotelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private String nombre;
	//private ArrayList<Foto> fotosHotel;
	
	public HotelEntity() {}
	
	public HotelEntity(HotelDto dto) {
		this.id = dto.id;
		this.nombre = dto.nombre;
	}
	
	public HotelEntity(String nombre) {
		this.nombre = nombre;
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
	
	public HotelDto getDto() {
		HotelDto hotel = new HotelDto();
		hotel.id = this.id;
		hotel.nombre = this.nombre;
		return hotel;
	}
}
