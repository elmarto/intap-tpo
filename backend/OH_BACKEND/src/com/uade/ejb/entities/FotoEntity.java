package com.uade.ejb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.uade.ejb.dto.FotoDto;

@Entity
@Table(name = "fotos")
public class FotoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	private String url;
	
	public FotoEntity() {}
	
	public FotoEntity(int id, String url) {
		this.id = id;
		this.url = url;
	}
	
	public FotoEntity(FotoDto dto) {
		this.id = dto.id;
		this.url = dto.url;
	}
	
	public FotoDto getDto() {
		FotoDto dto = new FotoDto();
		dto.id = this.id;
		dto.url = this.url;
		return dto;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
