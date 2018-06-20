package com.uade.ejb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.uade.ejb.dto.MapaDto;

@Entity
@Table(name = "mapas")
public class MapaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	private String lat;
	private String lon;
	
	public MapaEntity() {}
	
	public MapaEntity(int id, String lat, String lon) {
		this.id = id;
		this.lat = lat;
		this.lon = lon;
	}
	
	public MapaEntity(MapaDto dto) {
		this.id = dto.id;
		this.lat = dto.lat;
		this.lon = dto.lon;
	}
	
	public MapaDto getDto() {
		MapaDto dto = new MapaDto();
		dto.id = this.id;
		dto.lat = this.lat;
		dto.lon = this.lon;
		return dto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}
}
