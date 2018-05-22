package hotel.model;

import java.util.Collection;
import java.util.Date;

public class Offer {
	public Establishment establishment;
	public String name;
	public Date dateFrom;
	public Date dateEnd;
	public int quota;
	public int quantity;
	public int status;
	public Collection<Service> service;
	
	public Offer(Establishment establishment, String name, Date dateFrom, Date dateEnd, 
			int quota, int quantity, Collection<Service> service, int status)
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

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
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

	public Collection<Service> getService() {
		return service;
	}

	public void setService(Collection<Service> service) {
		this.service = service;
	}
	
	public Collection<Offer> getAllOffers()
	{
		return null;
	}
}
