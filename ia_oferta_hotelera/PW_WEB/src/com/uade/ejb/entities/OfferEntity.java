package com.uade.ejb.entities;

import java.sql.Date;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Table;

import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.dto.OfertaDto;

//@Table(name = "offer")
public class OfferEntity {
	@Column(name ="id")
	public int id;
	
	public EstablishmentEntity establishment;
	
	@Column(name = "idestablishment")
	public int idEstablishment;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "datefrom")
	public Date dateFrom;
	
	@Column(name = "dateend")
	public Date dateEnd;
	
	@Column(name = "quantity")
	public int quantity;
	
	//@Column(name = "status")
	//public int status;
	
	public Collection<OfferServiceEntity> service;
	
	@Column(name = "price")
	public float price;
	
	@Column(name = "paymentMethods")
	public String paymentMethods;
	
	@Column(name = "policies")
	public String policies;
	
	@Column(name ="roomType")
	public String roomType;
	
	public OfferEntity(EstablishmentEntity establishment, String name, Date dateFrom, Date dateEnd, 
			int quantity, Collection<OfferServiceEntity> service/*, int status*/)
	{
		this.establishment = establishment;
		this.name = name;
		this.dateFrom = dateFrom;
		this.dateEnd = dateEnd;
		this.quantity = quantity;
		this.service = service;
		//this.status = status;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/*public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}*/

	public Collection<OfferServiceEntity> getService() {
		return service;
	}

	public void setService(Collection<OfferServiceEntity> service) {
		this.service = service;
	}
	
	public String getServicesString() {
		String result = "";
		for (Iterator<OfferServiceEntity> i = this.service.iterator(); i.hasNext();) {
			OfferServiceEntity item = i.next();
			result = result + " " + item.serviceName;
		}
		
		return result;
	}
}
