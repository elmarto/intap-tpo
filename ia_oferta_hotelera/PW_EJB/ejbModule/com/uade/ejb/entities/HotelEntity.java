package com.uade.ejb.entities;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class HotelEntity {

	@Column(name = "id")
	private int id;
	
    @Column(name = "user")
    private String user;

    @Column(name = "pass")
    private String pass;

    @Column(name = "email")
    private String email;
    
    @Column(name = "photo")
    private String photo;
    
    @Column(name = "photo")
    private HashSet<EstablishmentEntity> establishment;

    public HotelEntity() {
        super();
    }

    public void setUser(String user)
	{
		this.user = user;
	}
	
	public String getUser()
	{
		return this.user;
	}
	
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	
	public String getPass()
	{
		return this.pass;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setPhoto(String photo)
	{
		this.photo = photo;
	}
	
	public String getPhoto()
	{
		return this.photo;
	}
	
	public void setEstablishment(HashSet<EstablishmentEntity> establishment)
	{
		this.establishment = establishment;
	}
	
	public HashSet<EstablishmentEntity> getEstablishment()
	{
		return this.establishment;
	}
	
	public HotelEntity searchUserHotel(String email, String pass)
	{
		return null;
	}
	
	public boolean userVerification(String email, String pass)
	{
		return this.email.equals(email) && this.pass.equals(pass);
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return this.id;
	}
}
