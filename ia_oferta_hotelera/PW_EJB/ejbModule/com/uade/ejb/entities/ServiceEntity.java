package com.uade.ejb.entities;

import javax.persistence.*;

@Table(name = "service")
public class ServiceEntity {
	@Column(name = "idservice")
	public int idService;
	
	public ServiceEntity(int id)
	{
		this.idService = id;
	}
	
	public void setidService(int id)
	{
		this.idService = id;
	}
	
	public int getIdService()
	{
		return this.idService;
	}
	
	public boolean serviceValidation(int idService)
	{
		return this.idService == idService;
	}
}
