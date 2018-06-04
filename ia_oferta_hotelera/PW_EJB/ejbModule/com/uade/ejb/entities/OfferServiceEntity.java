package com.uade.ejb.entities;

import javax.persistence.*;

@Table(name = "offer_service")
public class OfferServiceEntity {
	@Column(name = "id_service")
	private int idService;
	
	@Column(name = "id_type_service")
	private int idServiceType;
	private ServiceTypeEntity serviceTypeEntity; 
	
	public ServiceEntity(int id, int idServiceType, ServiceTypeEntity serviceTypeEntity)
	{
		this.idService = id;
		this.idServiceType = idServiceType;
		this.serviceTypeEntity = serviceTypeEntity;
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
