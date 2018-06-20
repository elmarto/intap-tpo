package com.uade.ejb.entities;

import javax.persistence.*;

import com.uade.ejb.dto.EstablecimientoDto;

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
//	public CiudadEntity ciudad;
//	public MapaEntity mapa;
//	public ArrayList<FotoEntity> fotosEstablecimiento;
	
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "hotel_id")
	public HotelEntity hotel;
	
	
	
    public EstablecimientoEntity() {}
	
	public EstablecimientoEntity(EstablecimientoDto dto)
	{
		this.nombre = dto.nombre;
		this.direccion = dto.direccion;
		if (dto.hotel != null) {
			this.hotel = new HotelEntity(dto.hotel);			
		}
		// this.establishmentPhoto = establecimiento.fotosEstablecimiento;
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

//	public CiudadEntity getCiudad() {
//		return ciudad;
//	}
//
//	public void setCiudad(CiudadEntity ciudad) {
//		this.ciudad = ciudad;
//	}

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

//	public MapaEntity getMapa() {
//		return mapa;
//	}
//
//	public void setMapa(MapaEntity mapa) {
//		this.mapa = mapa;
//	}
//
//	public ArrayList<FotoEntity> getFotosEstablecimiento() {
//		return fotosEstablecimiento;
//	}
//
//	public void setFotosEstablecimiento(ArrayList<FotoEntity> fotosEstablecimiento) {
//		this.fotosEstablecimiento = fotosEstablecimiento;
//	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public EstablecimientoDto getDto() {
		EstablecimientoDto establecimiento = new EstablecimientoDto();
		establecimiento.direccion = this.direccion;
		establecimiento.nombre = this.nombre;
		establecimiento.uid = this.uid;
		establecimiento.hotel = this.hotel.getDto();
		return establecimiento;
	}
}
