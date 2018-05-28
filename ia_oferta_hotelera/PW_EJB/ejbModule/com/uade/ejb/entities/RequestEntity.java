package com.uade.ejb.entities;

public class RequestEntity {
	public EstablishmentEntity establishment;
	public int status;
	
	public RequestEntity(EstablishmentEntity establishment, int status)
	{
		this.establishment = establishment;
		this.status = status;
	}
	
	public void setEstablishment(EstablishmentEntity establishment)
	{
		this.establishment = establishment;
	}
	
	public EstablishmentEntity getEstablishment()
	{
		return this.establishment;
	}
	
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	public int getStatus()
	{
		return this.status;
	}
	
	public void establishmentRequest(int id, int idEstablishment)
	{
		
	}
}
