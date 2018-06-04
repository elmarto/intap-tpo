package com.uade.ejb.entities;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "offer")
public class OfferEntity {
	
	public EstablishmentEntity establishment;
	@Column(name = "idestablishment")
	public int idEstablishment;
	@Column(name = "name")
	public String name;
	@Column(name = "datefrom")
	public Date dateFrom;
	@Column(name = "dateend")
	public Date dateEnd;
	@Column(name = "quota")
	public int quota;
	@Column(name = "quantity")
	public int quantity;
	@Column(name = "status")
	public int status;
	public HashSet<OfferServiceEntity> service;
	
	public OfferEntity(EstablishmentEntity establishment, String name, Date dateFrom, Date dateEnd, 
			int quota, int quantity, HashSet<OfferServiceEntity> service, int status)
	{
		this.establishment = establishment;
		this.name = name;
		this.dateFrom = dateFrom;
		this.dateEnd = dateEnd;
		this.quota = quota;
		this.quantity = quantity;
		this.service = service;
		this.status = status;
	}

	public EstablishmentEntity getEstablishment() {
		return establishment;
	}

	public void setEstablishment(EstablishmentEntity establishment) {
		this.establishment = establishment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public HashSet<OfferServiceEntity> getService() {
		return service;
	}

	public void setService(HashSet<OfferServiceEntity> service) {
		this.service = service;
	}
	
	public HashSet<OfferEntity> getAllOffers()
	{
		return null;
	}
}
