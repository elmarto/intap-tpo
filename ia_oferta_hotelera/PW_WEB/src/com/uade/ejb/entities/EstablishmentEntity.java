package com.uade.ejb.entities;

import javax.persistence.*;

@Entity
@Table(name = "establishment")
public class EstablishmentEntity {
	@Id
	public int id;
	@Column(name = "id_hotel")    
	public int idHotel;
	public String uid;
	public String name;
	public String address;
	public int stars;
	@Column(name = "establishment_photo")   
	public String establishmentPhoto;
    // public String city;
	
	public EstablishmentEntity( 
			String name, String address, 
			String establishmentPhoto)
	{
		this.name = name;
		this.address = address;
		this.establishmentPhoto = establishmentPhoto;
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

//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
}
