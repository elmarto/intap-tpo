package com.uade.ejb.entities;

import javax.persistence.*;

@Entity
@Table(name = "establishment")
public class EstablishmentEntity {
    
    public HotelEntity hotel;
    @Column(name = "idhotel")    
	public int idHotel;
    @Column(name = "name")
	public String name;
    @Column(name = "address")
	public String address;
    @Column(name = "establishmentphoto")
	public String establishmentPhoto;
    @Column(name = "uid")
    public String uid;
    @Column(name = "city")
    public String city;
    @Column(name = "status")
    public String status;
	
	public EstablishmentEntity(HotelEntity hotel, 
			String name, String address, 
			String establishmentPhoto)
	{
		this.hotel = hotel;
		this.name = name;
		this.address = address;
		this.establishmentPhoto = establishmentPhoto;
	}
	
	public void setHotel(HotelEntity hotel)
	{
		this.hotel = hotel;
		this.idHotel = hotel.getId();
	}
	
	public HotelEntity getHotel()
	{
		return this.hotel;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public void setEstablishmentPhoto(String establishmentPhoto)
	{
		this.establishmentPhoto = establishmentPhoto;
	}
	
	public String getEstablishmentPhoto()
	{
		return this.establishmentPhoto;
	}
	
	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
