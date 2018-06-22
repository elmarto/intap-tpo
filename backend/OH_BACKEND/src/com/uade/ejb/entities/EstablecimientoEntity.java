package com.uade.ejb.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.dto.FotoDto;

@Entity
@Table(name = "establecimientos")
public class EstablecimientoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	public int id;
	public String uid;
	public String nombre;
	public String direccion;
	public String descripcion;
	public int estrellas;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
	public Collection<FotoEntity> fotosEstablecimiento;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "mapa_id")
	public MapaEntity mapa;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "ciudad_id")
	public CiudadEntity ciudad;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "hotel_id")
	public HotelEntity hotel;
	
	
	
    public EstablecimientoEntity() {
    	this.fotosEstablecimiento = new ArrayList<FotoEntity>();
    }
	
	public EstablecimientoEntity(EstablecimientoDto dto)
	{
		this.id = dto.id;
		this.nombre = dto.nombre;
		this.direccion = dto.direccion;
		this.ciudad = new CiudadEntity(dto.ciudad);
		this.mapa = new MapaEntity(dto.mapa);
		
		this.fotosEstablecimiento = new ArrayList<FotoEntity>();
		dto.fotosEstablecimiento.forEach((foto) -> 
			this.fotosEstablecimiento.add(new FotoEntity(foto))
		);
		
		if (dto.hotel != null) {
			this.hotel = new HotelEntity(dto.hotel);			
		}
	}
	
	public EstablecimientoDto getDto() {
		EstablecimientoDto dto = new EstablecimientoDto();			
		dto.id = this.id;
		dto.direccion = this.direccion;
		dto.nombre = this.nombre;
		dto.uid = this.uid;
		dto.hotel = this.hotel.getDto();
		dto.ciudad = this.ciudad.getDto();
		dto.mapa = this.mapa.getDto();
		dto.fotosEstablecimiento = new ArrayList<FotoDto>();
		if (this.fotosEstablecimiento != null) {
			for (FotoEntity fotoEntity : this.fotosEstablecimiento) {
				dto.fotosEstablecimiento.add(fotoEntity.getDto());
			}	
		}
		 
		return dto;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public MapaEntity getMapa() {
		return mapa;
	}

	public void setMapa(MapaEntity mapa) {
		this.mapa = mapa;
	}

	public HotelEntity getHotel() {
		return hotel;
	}

	public void setHotel(HotelEntity hotel) {
		this.hotel = hotel;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public CiudadEntity getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadEntity ciudad) {
		this.ciudad = ciudad;
	}
	
	public Collection<FotoEntity> getFotosEstablecimiento() {
		return fotosEstablecimiento;
	}

	public void setFotosEstablecimiento(Collection<FotoEntity> fotosEstablecimiento) {
		this.fotosEstablecimiento = fotosEstablecimiento;
	}

	
}
