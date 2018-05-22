package hotel.model;

public class Establishment {
	public Hotel hotel;
	public int idHotel;
	public String name;
	public String address;
	public String establishmentPhoto;
	
	public Establishment(Hotel hotel, 
			String name, String address, 
			String establishmentPhoto)
	{
		this.hotel = hotel;
		this.name = name;
		this.address = address;
		this.establishmentPhoto = establishmentPhoto;
	}
	
	public void setHotel(Hotel hotel)
	{
		this.hotel = hotel;
		this.idHotel = hotel.getId();
	}
	
	public Hotel getHotel()
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
	
	public Establishment searchEstablishment(String name)
	{
		if(this.name == name)
		{
			return this;
		}
		return null;
	}
}
